package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button diceButton;
    TypedArray dicesTypes;
    TypedArray dices;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceButton = findViewById(R.id.diceButton);
        diceButton.setOnClickListener(this);


        dicesTypes = getResources().obtainTypedArray(R.array.diceTypeList);
        dices = getResources().obtainTypedArray(R.array.dicesImageViews);
        mp = MediaPlayer.create(this, R.raw.dice_sound);
    }

    @Override
    public void onClick(View v)
    {
        Random rand = new Random();
        for (int i = 0; i < dices.length(); ++i)
        {
            ImageView dice = findViewById(dices.getResourceId(i,0));
            dice.setImageResource(dicesTypes.getResourceId(rand.nextInt(6), 0));
            YoYo.with(Techniques.Shake).duration(500).repeat(1).playOn(dice);
        }
        mp.start();
    }
}