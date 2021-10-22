package com.example.myapplication;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteOpenHelper;

public class RegistrationActivity extends AppCompatActivity {

    public String name;
    public String pass;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
    }

    public void SignUpClick (View view){
        EditText logT = findViewById(R.id.editTextTextPersonName);
        EditText passT = findViewById(R.id.editTextTextPassword);
        String Log = logT.getText().toString();
        String Pass = passT.getText().toString();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        if (Log.equals("") || Pass.equals(""))
        {
            alert.setTitle("Не заполнено");
            alert.setMessage("Вы должны заполнить все поля");
            alert.show();
            return;
        }

        boolean found = false;

        for (user item: MainActivity.Users) {
            if (Log.equals(item.login))
            {
                found = true;
                alert.setTitle("Уже существует");
                alert.setMessage("Пользователь существует");
                alert.show();
            }
        }
        if (!found)
        {
            Save(Log, Pass);
            alert.setMessage("Успешно зарегистирован пользователь");
            alert.setTitle("OK");
            alert.setPositiveButton("Вернуться в меню", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    RegistrationActivity.this.finish();
                }
            });
            alert.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    RegistrationActivity.this.finish();
                }
            });
            alert.show();
        }
    }
    public void Save(String login, String password)
    {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("Users.db", MODE_PRIVATE, null);
        ContentValues cv = new ContentValues();
        cv.put("login", login);
        cv.put("password", password);

        db.insert("users", null, cv);
        db.close();
        MainActivity.Users.add(new user(login, password));
    }

}
