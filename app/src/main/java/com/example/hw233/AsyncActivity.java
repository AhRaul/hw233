package com.example.hw233;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class AsyncActivity extends AppCompatActivity {

    private static final String TAG = "AsyncActivity";

    private Button button;
    private MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute();
                Log.d(TAG, "onClickButton: " + Thread.currentThread().getName() + " Метод, вызвавший AsyncTask, заверщён");
            }
        });
    }

    private static class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: " + Thread.currentThread().getName());
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                for (int i = 0; i <5; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    Log.d(TAG, "doInBackground: " + Thread.currentThread().getName() + ": " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "onPostExecute: " + Thread.currentThread().getName());
        }
    }
}
