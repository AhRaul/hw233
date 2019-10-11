package com.example.hw233.spam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hw233.R;

public class SpamActivity extends AppCompatActivity {

    private Spamer spamer = new Spamer();
    private Iam iam = new Iam();

    private Button subscribe;
    private Button unsubscribe;
    private Button spam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spam);

        subscribe = findViewById(R.id.bSubscribe);
        unsubscribe = findViewById(R.id.bUnsubscribe);
        spam = findViewById(R.id.bSpam);

        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spamer.registerObserver(iam);
            }
        });

        unsubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spamer.unregisterObserver(iam);
            }
        });

        spam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spamer.newMessage("SALE!!! SALE!!! SALE!!!" + Thread.currentThread().getName());
            }
        });
    }
}
