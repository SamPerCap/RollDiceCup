package com.example.rolldicecup;

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

public class MainActivity extends AppCompatActivity {
    String TAG = "Developer";
    TableRow tableRow;
    TableLayout ll ;
    int dicePaddingLeft = 177;
    int dicePaddingTop = 50;
    NumberPicker number;
int amountOfDices=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_view);
        number = findViewById(R.id.amountOfdices);
        number.setMinValue(1);
        number.setMaxValue(6);
        findViewById(R.id.roll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                AddImage();
            }
        });
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
                image.setImageResource(R.drawable.dice_side_1);
                image.setPadding(dicePaddingLeft,dicePaddingTop,0,0);
                tableRow.addView(image);

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                ll.addView(tableRow, lp);


            }
    }

    private TableRow createNewTableROw() {
        return  new TableRow(this);
    }

}
