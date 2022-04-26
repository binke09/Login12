package com.example.login12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Rgeister extends AppCompatActivity implements View.OnClickListener {


    Button bRegister,bLogout;
    EditText etName, etUsername, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgeister);


        etName = (EditText) findViewById(R.id.etName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        bLogout = (Button) findViewById(R.id.bLogout);

        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);
        bLogout.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bRegister:
                break;
            case R.id.bLogout:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }

    }
}