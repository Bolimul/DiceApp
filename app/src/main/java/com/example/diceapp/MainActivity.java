package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button diceButton;
    TypedArray dices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceButton = findViewById(R.id.diceButton);
        diceButton.setOnClickListener(this);

        dices = getResources().obtainTypedArray(R.array.diceList);
    }

    @Override
    public void onClick(View v)
    {
        ImageView firstDice = findViewById(R.id.firstDice);
        ImageView secondDice = findViewById(R.id.secondDice);
        Random rand = new Random();
        int firstRandomNum = rand.nextInt(dices.length()-1) + 1;
        int secondRandomNum = rand.nextInt(dices.length()-1) + 1;
        firstDice.setImageDrawable(AppCompatResources.getDrawable(this, dices.getResourceId(firstRandomNum, 0)));
        secondDice.setImageDrawable(AppCompatResources.getDrawable(this, dices.getResourceId(secondRandomNum, 0)));
    }


}