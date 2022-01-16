package com.example.runescapecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnToAuthor;
    private Button btnToCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToAuthor=findViewById(R.id.btnChangeActivityToAuthor);
        btnToCalc=findViewById(R.id.btnChangeActivityToSmithCalc);
        btnToAuthor.setOnClickListener(changeAuthorActivityListner);
        btnToCalc.setOnClickListener(changeActivityToDataForCalcListner);
    }

    private View.OnClickListener changeAuthorActivityListner=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            changeActivityToAuthor();
        }
    };

    private View.OnClickListener changeActivityToDataForCalcListner=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        changeActivityToDataForCalc();
        }
    };


    private void changeActivityToAuthor(){
        Intent changeToAuthorActivity=new Intent(this,AboutAuthor.class);
        startActivity(changeToAuthorActivity);
    }

    private void changeActivityToDataForCalc(){
        Intent changeToDataCalcActivity=new Intent(this,DataForCalc.class);
        startActivity(changeToDataCalcActivity);
    }



}