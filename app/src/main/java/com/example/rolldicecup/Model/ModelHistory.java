package com.example.rolldicecup.Model;

import com.example.rolldicecup.History;

import java.util.ArrayList;

public class ModelHistory {
    private ArrayList<History> historyList = new ArrayList<>();
    private static volatile ModelHistory instance;


    public static ModelHistory getInstance() {
        if (instance == null) {
            synchronized (ModelHistory.class) {
                if (instance == null) {
                    instance = new ModelHistory();
                }
            }
        }
        return instance;
    }
    public void AddHistory(History history)
    {
        historyList.add(history);

    }
    public ArrayList<History> getHistoryList()
    {
        return historyList;
    }
    public void clear()
    {
        historyList.clear();

    }



}