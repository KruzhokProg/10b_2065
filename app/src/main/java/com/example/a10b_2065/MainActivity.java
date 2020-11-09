package com.example.a10b_2065;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public void checkUser(View view) throws NoSuchAlgorithmException {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();


        MessageDigest d = java.security.MessageDigest.getInstance("MD5");
        d.update(password.getBytes());
        byte messageDigest[] = d.digest();
        StringBuilder hexString = new StringBuilder();

        for (byte aMessageDigest : messageDigest) {
            String h = Integer.toHexString(0xFF & aMessageDigest);
            while (h.length() < 2)
                h = "0" + h;
            hexString.append(h);
        }



        if(email.equals("admin") && hexString.toString().equals("21232f297a57a5a743894a0e4a801fc3")){
//            Toast.makeText(this, "Все верно!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, UserActivity.class);
            intent.putExtra("myExtra", "admin");
            startActivity(intent);
        }
        else if(email.equals("wsr123") && password.equals("123")){
            Intent intent = new Intent(this, UserActivity.class);
            intent.putExtra("myExtra", "wsr123");
            startActivity(intent);
        }
        else if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT).show();
        }
    }
}
