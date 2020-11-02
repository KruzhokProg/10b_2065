package com.example.a10b_2065;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    TextView tv_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        tv_out = findViewById(R.id.tv_out);
        String info = getIntent().getExtras().getString("myExtra");
        tv_out.append("\n" + info);
    }
}
