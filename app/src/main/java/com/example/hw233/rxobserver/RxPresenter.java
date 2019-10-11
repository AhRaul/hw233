package com.example.hw233.rxobserver;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class RxPresenter {

    private static final String TAG = "RxPresenter";

    public Observable<String> getMessage() {

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    for (int i = 0; i < 5;i++) {
                        TimeUnit.SECONDS.sleep(1);
                        String mess = "SMS: " + i;
                        Log.d(TAG, "get my message:" + Thread.currentThread().getName() + ": " + mess);
                        emitter.onNext(mess);
                    }

                    emitter.onComplete();

                } catch (InterruptedException e) {
                    Log.d(TAG, "getMessage: not disposed");
                }
            }
        }).subscribeOn(Schedulers.io());

        return observable;
    }
}
