package com.example.rolldicecup;

import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class History {
    private SimpleDateFormat _Time = new SimpleDateFormat("HH:mm:ss");
    private ArrayList<ImageView> _diceSide = new ArrayList<>();

    public History(SimpleDateFormat Time, ArrayList<ImageView> diceSide) {
        this._diceSide = diceSide;
        this._Time = Time;
    }

    public SimpleDateFormat get_Time() {
        return _Time;
    }

    public void set_Time(SimpleDateFormat _Time) {
        this._Time = _Time;
    }

    public ArrayList<ImageView> get_diceSide() {
        return _diceSide;
    }

    public void set_diceSide(ArrayList<ImageView> _diceSide) {
        this._diceSide = _diceSide;
    }
}
