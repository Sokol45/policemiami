package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class departaments extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.departaments);
    }
    public void back(View view){
        Intent intent = new Intent(this,menu.class);
        startActivity(intent);
        finish();
    }
}
