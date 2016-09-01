package com.danielniebles.punto3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bCalc;
    RadioGroup rdgGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgGroup = (RadioGroup)findViewById(R.id.rdgGroup);
        bCalc = (Button)findViewById(R.id.bCalc);

        rdgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rCuadro:
                        Intent intent = new Intent(getApplicationContext(), Activity_Cuadro.class);
                        startActivity(intent);
                        break;
                    case R.id.rCirculo:
                        Intent intent2 = new Intent(getApplicationContext(), Activity_Circulo.class);
                        startActivity(intent2);
                        break;
                    case R.id.rRectangulo:
                        Intent intent3 = new Intent(getApplicationContext(), Activity_Rectangulo.class);
                        startActivity(intent3);
                        break;
                    case R.id.rTriangulo:
                        Intent intent4 = new Intent(getApplicationContext(), Activity_Triangulo.class);
                        startActivity(intent4);
                        break;
                    default:
                        break;

                }
            }
        });
    }
}
