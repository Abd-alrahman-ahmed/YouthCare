package com.youthcare.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.youthcare.R;

public class StartActivity extends AppCompatActivity {


    private Button registerBtn;
    private Button loginBtn;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //toolbar
        mToolbar = (Toolbar) findViewById(R.id.main_tool_bar);

        //buttons
        registerBtn = findViewById(R.id.registerBtn);
        loginBtn = findViewById(R.id.loginBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(registerActivity);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(loginActivity);
            }
        });
    }
}
