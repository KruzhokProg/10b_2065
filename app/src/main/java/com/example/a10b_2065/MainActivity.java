package com.example.a10b_2065;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;

    // метод
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
    }

    public void checkUser(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if(email.equals("admin") && password.equals("admin")){
            Toast.makeText(this, "Все верно!", Toast.LENGTH_SHORT).show();
        }
        else if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT).show();
        }
    }
}
