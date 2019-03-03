package com.example.rolldicecup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Adapter extends ArrayAdapter<History> {
    int[] imagesDraw = {R.drawable.dice_side_1
            , R.drawable.dice_side_2
            , R.drawable.dice_side_3
            , R.drawable.dice_side_4
            , R.drawable.dice_side_5
            , R.drawable.dice_side_6};
   int widthImage = 100;
   int heightImage = 100;
    public SimpleDateFormat _Time = new SimpleDateFormat("HH:mm:ss");
    private Context _context;
    private int _resource;
    String TAG = "Developer";

    public Adapter(@NonNull Context context,
                   int resource
    ,@NonNull List<History> objects) {
        super(context, resource,objects);
        Log.d(TAG,"Initializating the adapter");
        _context = context;
        _resource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "Starting getting View");
        Date date = getItem(position).getDate();
        ArrayList<ImageView> diceImages = getItem(position).get_diceSide();

        LayoutInflater inflater = LayoutInflater.from(_context);
        convertView = inflater.inflate(_resource, parent, false);

        TextView hourTv = new TextView(_context);

        TableLayout diceIv = (TableLayout) convertView.findViewById(R.id.tablehistory);
        diceIv.removeAllViews();
        TableRow tableRow = new TableRow(_context);
        //This will change the background color to light gray.
        if (position % 2 == 0) {
            Log.d(TAG,"Setting different background");
            convertView.setBackgroundColor(Color.rgb(222, 222, 222));
        }
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        _Time.setTimeZone(TimeZone.getTimeZone("GMT+1"));
        hourTv.setText("" + _Time.format(date));
        tableRow.addView(hourTv);
        

        for (ImageView image : diceImages) {
            Log.d(TAG,"Filling the image view with images from the array");
            Log.d(TAG, "getView: " +diceImages.get(0).getId());
            ImageView imageView = new ImageView(_context);
            imageView.setImageResource(imagesDraw[image.getId()]);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxWidth(widthImage);
            imageView.setMaxHeight(heightImage);

          /*  ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
         layoutParams.height = 20;
         layoutParams.width = 20; */
            //   imageView.setLayoutParams(layoutParams);
            tableRow.addView(imageView);

        }

       diceIv.addView(tableRow, lp);

        Log.d(TAG,"Getting the view has ended");
        return convertView;
    }

}
