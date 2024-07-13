package com.bmicalculator;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        llMain=findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
              int wt= Integer.parseInt(edtWeight.getText().toString());
              int ft=  Integer.parseInt(edtHeightFt.getText().toString());
              int in=  Integer.parseInt(edtHeightIn.getText().toString());

              int totalIn=ft*12+in;

              double totalCm=totalIn*2.54;

              double totalM=totalCm/100;

              double bmi=wt/(totalM*totalM);

              if(bmi>=25)
              {
                  txtResult.setText("You're Overweight");

                  llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorOW));

              }

              else if(bmi >= 18.5 && bmi < 25)
              {
                  txtResult.setText("You're Normal");
                  llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorN));

              }

              else
              {
                  txtResult.setText("You're Underweight");
                  llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorUW));


              }
            }

        });

    }
}