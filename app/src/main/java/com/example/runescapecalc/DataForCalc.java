package com.example.runescapecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataForCalc extends AppCompatActivity {

    private Button btnBack;
    private Button btnCalc;
    private EditText oldExp;
    private EditText newExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_for_calc);
        btnBack=findViewById(R.id.btnBackExpToMain);
        btnCalc=findViewById(R.id.btnLetsCalc);
        oldExp=findViewById(R.id.editTxtOldExp);
        newExp=findViewById(R.id.editTxtNewExp);

        btnBack.setOnClickListener(backToMainActivityListener);
        btnCalc.setOnClickListener(goToNextActivityWithDataListener);
    }


    private View.OnClickListener backToMainActivityListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        backToMainActivity();
        }
    };

    private View.OnClickListener goToNextActivityWithDataListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        goToNextActivityWithData();
        }
    };


   private void backToMainActivity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }



    private void goToNextActivityWithData(){
        Intent intentWithExtras=new Intent(this,CalculatorActivity.class);
        intentWithExtras.putExtra("old",oldExp.getText().toString());
        intentWithExtras.putExtra("new",newExp.getText().toString());
        startActivity(intentWithExtras);
    }

}