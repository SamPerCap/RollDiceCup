package com.example.rolldicecup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.rolldicecup.Model.ModelHistory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String TAG = "Developer";
    ModelHistory modelHistory;
    Intent intent;
    int minimunAmountOfDecies = 1
    int maxAmountOfdecies = 6;
    ArrayList<ImageView>  imageViews;



    int[] images = {R.drawable.dice_side_1
            , R.drawable.dice_side_2
            , R.drawable.dice_side_3
            , R.drawable.dice_side_4
            , R.drawable.dice_side_5
            , R.drawable.dice_side_6};
    TableRow tableRow;
    TableLayout ll;
    int dicePaddingLeft = 177;
    int dicePaddingTop = 50;
    NumberPicker number;
    int amountOfDices = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        modelHistory = ModelHistory.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_view);
        number = findViewById(R.id.amountOfdices);
        intent = new Intent(this, MainActivity.class);
        number.setMinValue(minimunAmountOfDecies);
        number.setMaxValue(maxAmountOfdecies);
        findViewById(R.id.roll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            AddImage();
            }
        });
    }


    private void AddImage() {
        imageViews = new ArrayList<ImageView>();
        amountOfDices = number.getValue();
        Log.d(TAG, "Dice number" + amountOfDices);
        ll = (TableLayout) findViewById(R.id.table);
        ll.removeAllViews();

        for (int i = 0; i < amountOfDices; i++) {
           if (i % 2 == 0)
               {
                tableRow = createNewTableROw();
               }
           else
               {
                ll.removeView(tableRow);
               }

            ImageView image = new ImageView(this);
            int ran = randomNumber();
            image.setId(ran);
            image.setImageResource(images[ran]);
            image.setPadding(dicePaddingLeft, dicePaddingTop, 0, 0);
            imageViews.add(image);

            tableRow.addView(image);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ll.addView(tableRow, lp);
        }

        Calendar cal = Calendar.getInstance();
        modelHistory.AddHistory(new History(cal.getTime(),imageViews));
    }

    private TableRow createNewTableROw() {
        return new TableRow(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    private int randomNumber() {
        Log.d(TAG, "Do random number");
        Random random = new Random();
        return random.nextInt(6);
    }

    public void exitApp(MenuItem item) {
        Log.d(TAG, "The app will close now");
        this.finish();
    }


    public void changeViewToHistory(MenuItem item) {
        Log.d(TAG, "Changing view to history view");
        setContentView(R.layout.roll_history);
        ListView lstView = (ListView) findViewById(R.id.lstView);
        Adapter adapter = new Adapter(this,
                R.layout.roll_history_adapter
                , modelHistory.getHistoryList());
        lstView.setAdapter(adapter);
        finishActivity(0);
    }

    public void ReturnView(View view) {
        Log.d(TAG, "Chaing view back");
        startActivity(intent);
    }
}
