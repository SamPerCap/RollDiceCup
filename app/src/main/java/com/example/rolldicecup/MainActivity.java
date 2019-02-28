package com.example.rolldicecup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String TAG = "Logs";

    int[] images = {  R.drawable.dice_side_1
            , R.drawable.dice_side_2
            , R.drawable.dice_side_3
            , R.drawable.dice_side_4
            , R.drawable.dice_side_5
            , R.drawable.dice_side_6};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "It boots up");
    }

    public void rollDice(View view)
    {
        int dice1 = randomNumber(0,5);
        int dice2 = randomNumber(0,5);
        int dice3 = randomNumber(0,5);
        int dice4 = randomNumber(0,5);
        int dice5 = randomNumber(0,5);
        int dice6 = randomNumber(0,5);

        Log.e(TAG, "I Hit the rollDice()");

        ImageView imgLayout1 = findViewById(R.id.imageView);
        ImageView imgLayout2 = findViewById(R.id.imageView2);

        Log.e(TAG, "Gets the images");

        int n = new Random().nextInt(1);

        Log.e(TAG, "Random Numbers calculator");

        ImageView fl = findViewById(R.id.imageView);
        ImageView fl2 = findViewById(R.id.imageView2);
        ImageView fl3 = findViewById(R.id.imageView3);
        ImageView fl4 = findViewById(R.id.imageView4);
        ImageView fl5 = findViewById(R.id.imageView5);
        ImageView fl6 = findViewById(R.id.imageView6);
        fl.setImageResource(images[dice1]);
        fl2.setImageResource(images[dice2]);
        fl3.setImageResource(images[dice3]);
        fl4.setImageResource(images[dice4]);
        fl5.setImageResource(images[dice5]);
        fl6.setImageResource(images[dice6]);

        Log.e(TAG, "image array and then adding images");

    }

    private int randomNumber(int min, int max)
    {
        Random random = new Random();
        return random.nextInt(max - min + 1)+min;
    }
}
