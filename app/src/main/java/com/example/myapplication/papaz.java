package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class papaz extends AppCompatActivity
{
    EditText name;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.papaz);
    }
    public void back(View view){
        Intent intent = new Intent(this,wanted.class);
        startActivity(intent);
        finish();
    }
    public void papazsave (){
        name = findViewById(R.id.Name123);

    }
}
