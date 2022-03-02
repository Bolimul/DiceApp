package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

Button logOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logOutput = findViewById(R.id.logOutput);
        logOutput.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        EditText number = findViewById(R.id.phoneNumber);
        Toast.makeText(this, number.getText().toString(), Toast.LENGTH_SHORT).show();
    }


}