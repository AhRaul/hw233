package com.example.hw233.spam;

import android.util.Log;

import java.util.ArrayList;

public class Spamer implements Observable{

    private static final String TAG = "Spamer";

    private ArrayList<Observer> arrayList;
    private String spamMessage;

    public Spamer() {
        this.arrayList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        Log.d(TAG, "registerObserver: ");
        arrayList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        Log.d(TAG, "unregisterObserver: ");
        arrayList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        Log.d(TAG, "notifyAllObservers: ");
        for (int i = 0; i < arrayList.size(); i++) {
            Observer observer = arrayList.get(i);
            observer.updateData(this.spamMessage);
        }
    }

    public void newMessage(String s) {
        this.spamMessage = s;
        notifyAllObservers();
    }
}
