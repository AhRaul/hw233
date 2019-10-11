package com.example.hw233.spam;

import android.util.Log;

public class Iam implements Observer {

    private static final String TAG = "Iam";

    @Override
    public void updateData(String message) {
        Log.d(TAG, "display: " + message);
    }

}
