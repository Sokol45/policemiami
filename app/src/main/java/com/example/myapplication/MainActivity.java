package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<user> Users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Users = new ArrayList<>();

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("Users.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (login TEXT, password TEXT)");
        Cursor query = db.rawQuery("SELECT * FROM users;", null);

        while(query.moveToNext()){
            String login = query.getString(0);
            String password = query.getString(1);
            Users.add(new user(login, password));

        }
        query.close();
        db.close();

    }
    public void vxod(View view){
        Intent intent = new Intent(MainActivity.this,menu.class);
        EditText log = findViewById(R.id.editTextTextPersonName);
        EditText pas = findViewById(R.id.editTextTextPassword);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        boolean found = false;
        for(user item:MainActivity.Users){
            if(log.getText().toString().equals(item.login)){
                found = true;
                if (item.getPassword().equals(pas.getText().toString())){
                    user.lastuser=item.login;
                    log.setText("");
                    pas.setText("");
                    startActivity(intent);
                    break;

                }
                else
                {
                    alert.setTitle("Неверно");
                    alert.setMessage("Пароль неверен");
                    alert.show();
                }
            }
        }
        if (!found)
        {
            alert.setTitle("Не найдено");
            alert.setMessage("Пользователь не найден");
            alert.show();
        }


    }

    public void SignUpClick (View view){
        Intent sign = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(sign);
        EditText logT = findViewById(R.id.editTextTextPersonName);
        EditText passT = findViewById(R.id.editTextTextPassword);
        logT.setText("");
        passT.setText("");
    }

}