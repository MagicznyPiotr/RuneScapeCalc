package com.example.runescapecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthorChangeData extends AppCompatActivity {


    private EditText name;
    private EditText surname;
    private EditText age;
    private EditText game;
    private Button btnBack;
    private Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_change_data);
        name=findViewById(R.id.editTxtName);
        surname=findViewById(R.id.editTxtSurname);
        age=findViewById(R.id.editTxtAge);
        game=findViewById(R.id.editTxtGame);

        btnBack=findViewById(R.id.btnBackToAboutAouthor);
        btnChange=findViewById(R.id.btnBackToAboutAouthorWithNewData);


        Intent intent=getIntent();
        name.setText(intent.getStringExtra("name"));
        surname.setText(intent.getStringExtra("surname"));
        age.setText(intent.getStringExtra("age"));
        game.setText(intent.getStringExtra("game"));

        btnBack.setOnClickListener(backWithOutChangeListener);
        btnChange.setOnClickListener(backWithChangeListener);
    }


    private View.OnClickListener backWithOutChangeListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
      backWithOutChange();
        }
    };

    private View.OnClickListener backWithChangeListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
              backWithChange();
        }
    };



    private void backWithOutChange(){
        Intent back=new Intent(this,AboutAuthor.class);
        startActivity(back);
    }

    private void backWithChange(){
        Intent backIntent=new Intent();
        backIntent.putExtra("backname",name.getText().toString());
        backIntent.putExtra("backsurname",surname.getText().toString());
        backIntent.putExtra("backage",age.getText().toString());
        backIntent.putExtra("backgame",game.getText().toString());
        setResult(RESULT_OK,backIntent);
        finish();
    }

}