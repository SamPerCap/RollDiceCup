package com.example.rolldicecup;

import android.util.Log;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class History {
    private SimpleDateFormat _Time = new SimpleDateFormat("HH:mm:ss");
    private ArrayList<ImageView> _diceSide = new ArrayList<>();
    String TAG = "Developer";

    public History(SimpleDateFormat Time, ArrayList<ImageView> diceSide) {
        Log.d(TAG,"Initializating the HistoryBE constructor");
        this._diceSide = diceSide;
        this._Time = Time;
    }

    public SimpleDateFormat get_Time() {
        Log.d(TAG,"Getting the time");
        return _Time;
    }

    public void set_Time(SimpleDateFormat _Time) {
        Log.d(TAG,"Setting the time");
        this._Time = _Time;
    }

    public ArrayList<ImageView> get_diceSide() {
        Log.d(TAG,"Getting the array of dices");
        return _diceSide;
    }

    public void set_diceSide(ArrayList<ImageView> _diceSide) {
        Log.d(TAG,"Setting the array of dices");
        this._diceSide = _diceSide;
    }
}
