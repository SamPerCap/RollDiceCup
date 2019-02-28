package com.example.rolldicecup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String TAG = "Developer";
    ImageView Iv1, Iv2, Iv3, Iv4, Iv5, Iv6;

    int[] images = {R.drawable.dice_side_1
            , R.drawable.dice_side_2
            , R.drawable.dice_side_3
            , R.drawable.dice_side_4
            , R.drawable.dice_side_5
            , R.drawable.dice_side_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "It boots up");
        LocateItems();
    }

    public void rollDice(View view) {
        Log.d(TAG, "I Hit the rollDice() and random number is generating. Also set image");
        Iv1.setImageResource(images[randomNumber()]);
        Iv2.setImageResource(images[randomNumber()]);
        Iv3.setImageResource(images[randomNumber()]);
        Iv4.setImageResource(images[randomNumber()]);
        Iv5.setImageResource(images[randomNumber()]);
        Iv6.setImageResource(images[randomNumber()]);

    }

    private void LocateItems() {
        Log.d(TAG, "Locate items");
        Iv1 = findViewById(R.id.imageView);
        Iv2 = findViewById(R.id.imageView2);
        Iv3 = findViewById(R.id.imageView3);
        Iv4 = findViewById(R.id.imageView4);
        Iv5 = findViewById(R.id.imageView5);
        Iv6 = findViewById(R.id.imageView6);

    }

    private int randomNumber() {
        Random random = new Random();
        return random.nextInt(6);
    }
}
