package com.example.runescapecalc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AboutAuthor extends AppCompatActivity {

    private Button btnBackToMain;
    private Button btnChangeAuthorData;
    private TextView authorName;
    private TextView  authorSurname;
    private TextView authorAge ;
    private TextView authorGame ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_author);
        btnBackToMain=findViewById(R.id.btnBackToMain);
        btnChangeAuthorData=findViewById(R.id.btnChangeAuthorData);
        btnBackToMain.setOnClickListener(backMainActivityListner);
        btnChangeAuthorData.setOnClickListener(toAuthorDataActivityListener);

        authorName=findViewById(R.id.txtAuthorName);
        authorSurname=findViewById(R.id.txtAuthorSurname);
        authorAge=findViewById(R.id.txtAuthorAge);
        authorGame=findViewById(R.id.txtAuthorGame);

    }

    private View.OnClickListener backMainActivityListner=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            backActivityToMain();
        }
    };

    private void backActivityToMain(){
        Intent backToMainActivity=new Intent(this,MainActivity.class);
        startActivity(backToMainActivity);
    }


    private View.OnClickListener toAuthorDataActivityListener= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        changeAuthorDataActivity();
        }
    };


    private void changeAuthorDataActivity(){
        Intent intent=new Intent(this,AuthorChangeData.class);
        intent.putExtra("name",authorName.getText().toString());
        intent.putExtra("surname",authorSurname.getText().toString());
        intent.putExtra("age",authorAge.getText().toString());
        intent.putExtra("game",authorGame.getText().toString());
        startActivityForResult(intent,2022);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2022){
            authorName.setText(data.getStringExtra("backname"));
            authorSurname.setText(data.getStringExtra("backsurname"));
            authorAge.setText(data.getStringExtra("backage"));
            authorGame.setText(data.getStringExtra("backgame"));
            Toast.makeText(AboutAuthor.this, "Pozytywnie Zmieniono dane o Autorze", Toast.LENGTH_SHORT).show();
        }
    }
}