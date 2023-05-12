package com.example.myproject.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myproject.MainActivity;
import com.example.myproject.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.button_login_index).setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this,ReleaseActivity.class));
        });

        findViewById(R.id.button_regis).setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        });
    }
}