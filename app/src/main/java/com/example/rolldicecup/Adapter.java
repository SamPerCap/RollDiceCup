package com.example.rolldicecup;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Adapter extends ArrayAdapter<History> {

    private Context _context;
    private int _resource;
    String TAG = "Developer";

    public Adapter(@NonNull Context context, int resource) {
        super(context, resource);
        Log.d(TAG,"Initializating the adapter");
        _context = context;
        _resource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "Starting getting View");
        SimpleDateFormat hour = getItem(position).get_Time();
        ArrayList<ImageView> diceImages = getItem(position).get_diceSide();

        LayoutInflater inflater = LayoutInflater.from(_context);
        convertView = inflater.inflate(_resource, parent, false);

        TextView hourTv = (TextView) convertView.findViewById(R.id.hourTimeTv);
        ImageView diceIv = (ImageView) convertView.findViewById(R.id.diceImageTv);

        //This will change the background color to light gray.
        if (position % 2 == 0) {
            Log.d(TAG,"Setting different background");
            convertView.setBackgroundColor(Color.rgb(222, 222, 222));
        }

        hourTv.setText("" + hour);
        for (ImageView image : diceImages) {
            Log.d(TAG,"Filling the image view with images from the array");
            diceIv.setImageDrawable(image.getDrawable());
        }

        Log.d(TAG,"Getting the view has ended");
        return convertView;
    }
}
