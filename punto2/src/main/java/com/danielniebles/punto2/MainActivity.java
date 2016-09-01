package com.danielniebles.punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eN1, eN2;
    Button bSend;
    RadioGroup rdgGroup;
    TextView tResult;
    double res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eN1 = (EditText)findViewById(R.id.eN1);
        eN2 = (EditText)findViewById(R.id.eN2);
        bSend = (Button)findViewById(R.id.bSend);
        rdgGroup = (RadioGroup)findViewById(R.id.rdgGroup);
        tResult = (TextView)findViewById(R.id.tResult);

        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double N1, N2;
                String n1 = eN1.getText().toString();
                String n2 = eN2.getText().toString();

                if (TextUtils.isEmpty(n1) || TextUtils.isEmpty(n2)) {
                    Toast.makeText(getApplicationContext(), "Hay campos vacíos!",
                            Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    N1 = Double.parseDouble(n1);
                    N2 = Double.parseDouble(n2);

                    int a = rdgGroup.getCheckedRadioButtonId();

                    switch (a) {
                        case R.id.rSuma:
                            res = N1 + N2;
                            tResult.setText(Double.toString(res));
                            break;

                        case R.id.rResta:
                            res = N1 - N2;
                            tResult.setText(Double.toString(res));
                            break;

                        case R.id.rMulti:
                            res = N1 * N2;
                            tResult.setText(Double.toString(res));
                            break;

                        case R.id.rDiv:
                            if(N2 == 0){
                                Toast.makeText(getApplicationContext(), "No se puede dividir por cero!",
                                        Toast.LENGTH_SHORT).show();
                                return;
                            }else {
                                res = N1 / N2;
                                tResult.setText(Double.toString(res));
                            }
                            break;
                        default:
                            Toast.makeText(getApplicationContext(), "No ha seleccionado operación",
                                    Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        });
    }
}
