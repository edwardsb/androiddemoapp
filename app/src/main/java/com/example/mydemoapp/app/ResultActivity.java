package com.example.mydemoapp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultActivity extends Activity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView = (TextView) findViewById(R.id.result_text);
        Intent intent = getIntent();
        float result = intent.getFloatExtra(MainActivity.RESULT, 0);
        Log.d("RESULT PASSED", String.valueOf(result));
        textView.setText(String.valueOf(result));

    }
}
