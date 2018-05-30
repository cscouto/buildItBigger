package com.cs.tiago.customlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LibActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib);

        TextView textView = findViewById(R.id.textView);
        Intent intent = getIntent();

        if (intent.hasExtra(Constants.EXTRA_KEY_JOKE)){
            textView.setText(intent.getStringExtra(Constants.EXTRA_KEY_JOKE));
        }
    }
}
