package com.danielniebles.punto4;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    Button bSave;
    Calendar calendar;
    Spinner sCity;
    EditText eMail, ePass, eRepeat, eUser;
    int año, mes, dia;
    String usuario, email, pass, rpass, ciudad,sexo;
    StringBuilder fecha = new StringBuilder();
    StringBuilder hobbie = new StringBuilder();
    RadioGroup rdgGroup1;
    TextView tResult;
    CheckBox cCine, cTeatro, cInternet, cTelevision;
    ArrayList<user> usuarios = new ArrayList<user>();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eUser = (EditText)findViewById(R.id.eUser);
        eMail = (EditText)findViewById(R.id.eMail);
        ePass = (EditText)findViewById(R.id.ePass);
        eRepeat = (EditText)findViewById(R.id.eRepeat);
        sCity = (Spinner)findViewById(R.id.sCity);
        calendar = Calendar.getInstance();
        rdgGroup1 = (RadioGroup)findViewById(R.id.rdgGroup1);
        cCine = (CheckBox)findViewById(R.id.cCine);
        cTelevision = (CheckBox)findViewById(R.id.cTelevision);
        cTeatro = (CheckBox)findViewById(R.id.cTeatro);
        cInternet = (CheckBox)findViewById(R.id.cInternet);
        bSave = (Button)findViewById(R.id.bSave);
        tResult = (TextView)findViewById(R.id.tResult);

        //Obtener de fecha
        año = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);

        //Spinner
        List list = new ArrayList();
        list.add("Seleccione...");
        list.add("Medellín");
        list.add("Bogotá");
        list.add("Bmanga");
        list.add("Bquilla");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,list);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sCity.setAdapter(arrayAdapter);

        sCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ciudad = sCity.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Verificación y guardado
        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuario = eUser.getText().toString();
                email = eMail.getText().toString();
                pass = ePass.getText().toString();
                rpass = eRepeat.getText().toString();


                if(TextUtils.isEmpty(usuario)||TextUtils.isEmpty(email)||TextUtils.isEmpty(pass)||
                        TextUtils.isEmpty(rpass)){
                    Toast.makeText(getApplicationContext(), "Hay campos vacíos!",
                            Toast.LENGTH_SHORT).show();
                }else if(pass.equals(rpass)!=true){
                    Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden!",
                            Toast.LENGTH_SHORT).show();
                }else if(rdgGroup1.getCheckedRadioButtonId()== -1){
                    Toast.makeText(getApplicationContext(), "Seleccione el Sexo",
                            Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(fecha)) {
                    Toast.makeText(getApplicationContext(), "Seleccione la Fecha!",
                            Toast.LENGTH_SHORT).show();
                }else if(ciudad.equals("Seleccione...")){
                    Toast.makeText(getApplicationContext(), "Seleccione una Ciudad!",
                            Toast.LENGTH_SHORT).show();
                }else{

                    user usuario1 = new user();
                    int a = rdgGroup1.getCheckedRadioButtonId();
                    switch (a){
                        case R.id.rFem:
                            sexo = "Femenino";
                            break;
                        case R.id.rMas:
                            sexo = "Masculino";
                            break;
                    }

                    usuario1.setUsuario(usuario);
                    usuario1.setEmail(email);
                    usuario1.setSexo(sexo);
                    usuario1.setFecha(fecha);
                    usuario1.setCiudad(ciudad);
                    if(TextUtils.isEmpty(hobbie)){
                        hobbie.append("Ninguno");
                    }
                    usuario1.setHobbie(hobbie);
                    usuarios.add(i,usuario1);
                    user muestra = new user();
                    muestra = usuarios.get(i);
                    tResult.append(new StringBuilder().append("\n").append("Usuario: ").append(muestra.getUsuario()).append("\n")
                            .append("E-mail: ").append(muestra.getEmail()).append("\n").append("Ciudad de nacimiento: ")
                            .append(muestra.getCiudad()).append("\n").append("Sexo: ").append(muestra.getSexo())
                            .append("\n").append("Fecha de nacimiento: ").append(muestra.getFecha())
                            .append("\n").append("Hobbies: ").append(muestra.getHobbie()).append("\n"));
                    i++;

                    eUser.setText("");
                    eMail.setText("");
                    ePass.setText("");
                    eRepeat.setText("");
                    cCine.setChecked(false);
                    cInternet.setChecked(false);
                    cTeatro.setChecked(false);
                    cTelevision.setChecked(false);
                    hobbie.setLength(0);
                }
            }
        });
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view){
        showDialog(999);
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if(id == 999){
            return new DatePickerDialog(this,myDateListener,año,mes,dia);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3){
            showDate(arg1,arg2+1,arg3);
        }
    };

    private void showDate(int año, int mes, int dia){
        fecha = new StringBuilder().append(dia).append("/").append(mes).append("/")
        .append(año);
    }

    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.cCine:
                if(checked) {
                    hobbie.append("Cine ");
                }
                break;
            case R.id.cInternet:
                if(checked) {
                    hobbie.append("Internet ");
                }
                break;
            case R.id.cTeatro:
                if(checked){
                    hobbie.append("Teatro ");
                }
                break;
            case R.id.cTelevision:
                if(checked) {
                    hobbie.append("Television ");
                }
                break;
            default:
                hobbie.append("Ninguno");
                break;
        }
    }
}
