package com.danielniebles.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Cuadro extends AppCompatActivity {

    Button bCalc;
    EditText eLado;
    TextView tResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadro);

        eLado = (EditText)findViewById(R.id.eLado);
        bCalc = (Button)findViewById(R.id.bCalc);
        tResult = (TextView)findViewById(R.id.tResult);

        bCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lado, area;
                String l = eLado.getText().toString();
                if(TextUtils.isEmpty(l)){
                    Toast.makeText(getApplicationContext(), "Hay campos vacíos!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    lado = Double.parseDouble(l);
                    area = lado*lado;
                    tResult.setText(Double.toString(area));
                }
            }
        });
    }
}
