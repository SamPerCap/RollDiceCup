package com.example.rolldicecup.Model;

import com.example.rolldicecup.History;

import java.util.ArrayList;

public class ModelHistory {
    private ArrayList<History> historyList = new ArrayList<>();
    public ModelHistory() {

    }
    public void AddHistory(History history)
    {
        historyList.add(history);

    }
    public void clear()
    {
        historyList.clear();

    }



}