package com.example.runescapecalc;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalculatorActivity extends AppCompatActivity {

    private Button backBtn;
    private TextView needExp;
    private TextView needBronzeBar;
    private TextView needIronBar;
    private TextView needSteelBar;
    private TextView needMithrilBar;
    private TextView needAdamantBar;
    private TextView needRuneBar;
    private float newExp;
    private float oldExp;
    private float placeholder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        backBtn=findViewById(R.id.btnBackTODataForCalc);
        needExp=findViewById(R.id.txtNeedExp);
        needBronzeBar=findViewById(R.id.txtBronzeNeed);
        needIronBar=findViewById(R.id.txtIronNeed);
        needSteelBar=findViewById(R.id.txtSteelNeed);
        needMithrilBar=findViewById(R.id.txtMithrilNeed);
        needAdamantBar=findViewById(R.id.txtAdamantNeed);
        needRuneBar=findViewById(R.id.txtRuneNeed);
        Intent intent=getIntent();
        newExp=Float.valueOf(intent.getStringExtra("new"));
        oldExp=Float.valueOf(intent.getStringExtra("old"));
        if(newExp<=oldExp){
            needExp.setText("Wrong Value");
        }
        else{
            placeholder=newExp-oldExp;
            needExp.setText(String.valueOf(placeholder));
            needBronzeBar.setText(new DecimalFormat("##.##").format(placeholder/1000));
            needIronBar.setText(new DecimalFormat("##.##").format(placeholder/2000));
            needSteelBar.setText(new DecimalFormat("##.##").format(placeholder/4000));
            needMithrilBar.setText(new DecimalFormat("##.##").format(placeholder/6000));
            needAdamantBar.setText(new DecimalFormat("##.##").format(placeholder/8000));
            needRuneBar.setText(new DecimalFormat("##.##").format(placeholder/10000));
        }


        backBtn.setOnClickListener(backListener);
    }


    private View.OnClickListener backListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        back();
        }
    };

    private void back(){
        Intent backIntent=new Intent(this,DataForCalc.class);
        startActivity(backIntent);
    }

}