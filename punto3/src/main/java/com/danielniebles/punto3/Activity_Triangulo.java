package com.danielniebles.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Triangulo extends AppCompatActivity {

    EditText eBase, eAltura;
    TextView tResult;
    Button bCalc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        eBase = (EditText)findViewById(R.id.eBase);
        eAltura = (EditText)findViewById(R.id.eAltura);
        bCalc = (Button)findViewById(R.id.bCalc);
        tResult = (TextView)findViewById(R.id.tResult);

        bCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double base, altura, area;

                String a = eAltura.getText().toString();
                String b = eBase.getText().toString();

                if(TextUtils.isEmpty(a) || TextUtils.isEmpty(b)){
                    Toast.makeText(getApplicationContext(), "Hay campos vacíos!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    base = Double.parseDouble(a);
                    altura = Double.parseDouble(b);
                    area = (base*altura)/2;
                    tResult.setText(Double.toString(area));
                }
            }
        });
    }
}
