package com.danielniebles.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Circulo extends AppCompatActivity {

    EditText eRadio;
    Button bCalc;
    TextView tResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        eRadio = (EditText)findViewById(R.id.eRadio);
        bCalc = (Button)findViewById(R.id.bCalc);
        tResult = (TextView)findViewById(R.id.tResult);

        bCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double area, radio;
                String r = eRadio.getText().toString();
                if(TextUtils.isEmpty(r)){
                    Toast.makeText(getApplicationContext(), "Hay campos vacíos!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    radio = Double.parseDouble(r);
                    area = (3.1459)*radio*radio;
                    tResult.setText(Double.toString(area));
                }
            }
        });
    }
}
