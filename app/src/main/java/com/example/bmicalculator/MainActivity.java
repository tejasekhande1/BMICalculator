package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView resid;
        EditText inpt1,inpt2,inpt3;
        Button btnid;
        LinearLayout llmain;

        resid = findViewById(R.id.resid);
        inpt1 = findViewById(R.id.inpt1);
        inpt2 = findViewById(R.id.inpt2);
        inpt3 = findViewById(R.id.inpt3);
        btnid = findViewById(R.id.btnid);
        llmain = findViewById(R.id.llmain);

        btnid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(inpt2.getText().toString());
                int ft = Integer.parseInt(inpt1.getText().toString());
                int in = Integer.parseInt(inpt3.getText().toString());

                int totalInch = ft*12 + in;
                double totalCm = totalInch * 2.53;
                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi > 25){
                    resid.setText("You are overweight "+bmi);
                    llmain.setBackgroundColor(getResources().getColor(R.color.pur));
                }else if(bmi < 18){
                    resid.setText("You are Underweight "+bmi);
                    llmain.setBackgroundColor(getResources().getColor(R.color.bluish));
                }else{
                    resid.setText("You are Healthy " +bmi);
                    llmain.setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
        });
    }
}