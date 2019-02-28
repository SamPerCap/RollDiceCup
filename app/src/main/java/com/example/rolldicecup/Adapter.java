package com.example.rolldicecup;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
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

    public Adapter(@NonNull Context context, int resource) {
        super(context, resource);
        _context = context;
        _resource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        SimpleDateFormat hour = getItem(position).get_Time();
        ArrayList<ImageView> diceImages = getItem(position).get_diceSide();

        LayoutInflater inflater = LayoutInflater.from(_context);
        convertView = inflater.inflate(_resource, parent, false);

        TextView hourTv = (TextView) convertView.findViewById(R.id.hourTimeTv);
        TextView diceTv = (TextView) convertView.findViewById(R.id.diceImageTv);

        //This will change the background color to light gray.
        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.rgb(222, 222, 222));
        }

        hourTv.setText("" + hour);
        for (ImageView image : diceImages) {
            diceTv.setText("" + image);
        }

        return convertView;
    }
}
