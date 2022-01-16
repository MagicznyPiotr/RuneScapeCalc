package com.example.runescapecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class StartActivity extends AppCompatActivity {

    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnStart=findViewById(R.id.btnStart);
        btnStart.setOnClickListener(changeActivityListener);

    }


    private View.OnClickListener changeActivityListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
      changeActivity();
        }
    };



    private void changeActivity(){
        Intent changeToMainActivity= new Intent(this,MainActivity.class);
        startActivity(changeToMainActivity);
    }


}


