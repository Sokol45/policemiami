package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }
    public void back(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void aboutass(View view){
        Intent intent = new Intent(this,aboutass.class);
        startActivity(intent);
        finish();
    }
    public void wanted(View view){
        Intent intent = new Intent(this,wanted.class);
        startActivity(intent);
        finish();
    }
    public void departaments(View view){
        Intent intent = new Intent(this,departaments.class);
        startActivity(intent);
        finish();
    }
    public void paint(View view){
        Intent intent = new Intent(this,paint.class);
        startActivity(intent);
        finish();
    }
    public void photorobot(View view){
        Intent intent = new Intent(this,photorobot.class);
        startActivity(intent);
        finish();
    }
}
