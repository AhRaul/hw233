package com.example.hw233.rxobserver;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hw233.R;

public class RxObserverActivity extends AppCompatActivity {

    private static final String TAG = "RxObserverActivity";

    private RxPresenter rxPresenter;
    private Observable<String> observable;
    private Disposable disposable;

    private Button bsubscribe2;
    private Button bunsubscribe2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_observer);

        bsubscribe2 = findViewById(R.id.bSubscribe2);
        bunsubscribe2 = findViewById(R.id.bUnsubscribe2);

        rxPresenter = new RxPresenter();
        observable = rxPresenter.getMessage();

        bsubscribe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                        RxObserverActivity.this.disposable = d;
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
                Log.d(TAG, "subscribe: end " + Thread.currentThread().getName());
            }
        });

        bunsubscribe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disposable.dispose();
            }
        });
    }
}
