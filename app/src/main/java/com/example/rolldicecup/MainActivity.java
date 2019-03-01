package com.example.rolldicecup;

import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.rolldicecup.Model.ModelHistory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String TAG = "Developer";
   ModelHistory modelHistory;
   Calendar cal = Calendar.getInstance();

    int[] images = {R.drawable.dice_side_1
            , R.drawable.dice_side_2
            , R.drawable.dice_side_3
            , R.drawable.dice_side_4
            , R.drawable.dice_side_5
            , R.drawable.dice_side_6};
    TableRow tableRow;
    TableLayout ll ;
    int dicePaddingLeft = 177;
    int dicePaddingTop = 50;
    NumberPicker number;
    int amountOfDices=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
modelHistory=ModelHistory.getInstance();
       super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_view);
        number = findViewById(R.id.amountOfdices);
        number.setMinValue(1);
        number.setMaxValue(6);
        findViewById(R.id.roll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                AddImage();
                SaveToHistory();
            }
        });


    }
    private void SaveToHistory() {
        ArrayList<ImageView>  imageViews = new ArrayList<ImageView>();
        for (int i = 0; i < amountOfDices; i++) {

            imageViews.add((ImageView)findViewById(i));
        }
        // The preferred idiom for iterating over collections and arrays
 modelHistory.AddHistory(new History(cal.getTime(),imageViews));

    }

    private void AddImage() {
                amountOfDices = number.getValue();
                Log.d(TAG, "Dice number" +amountOfDices);
                ll =(TableLayout)findViewById(R.id.table);
                ll.removeAllViews();
                for (int i = 0; i <amountOfDices ; i++) {

                    Log.d(TAG, "Dice i" +i);

        if ( i%2 == 0) {

             tableRow = createNewTableROw();
         }
         else
        {
            ll.removeView(tableRow);
        }

                ImageView image = new ImageView(this);
                image.setId(i);
                image.setImageResource(images[randomNumber()]);
                image.setPadding(dicePaddingLeft,dicePaddingTop,0,0);
                tableRow.addView(image);

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                ll.addView(tableRow, lp);


            }
    }

    private TableRow createNewTableROw() {
        return new TableRow(this);

    }
    

/*    public void rollDice(View view)
    {
        int dice1 = randomNumber(0,5);
        int dice2 = randomNumber(0,5);
        int dice3 = randomNumber(0,5);
        int dice4 = randomNumber(0,5);
        int dice5 = randomNumber(0,5);
        int dice6 = randomNumber(0,5);

        Log.d(TAG, "I Hit the rollDice()");

        ImageView imgLayout1 = findViewById(R.id.imageView);
        ImageView imgLayout2 = findViewById(R.id.imageView2);

        Log.d(TAG, "Gets the images");

        int n = new Random().nextInt(1);

        Log.d(TAG, "Random Numbers calculator");

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

        Log.d(TAG, "image array and then adding images");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "It boots up");
        LocateItems();
    }
*/
/*
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

    }*/

    private int randomNumber() {
        Random random = new Random();
        return random.nextInt(6);
    }

}
