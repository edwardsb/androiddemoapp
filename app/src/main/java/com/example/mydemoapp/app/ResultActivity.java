package com.example.mydemoapp.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView = (TextView) findViewById(R.id.result_text);
        button = (Button) findViewById(R.id.google_web_button);
        Intent intent = getIntent();
        float result = intent.getFloatExtra(MainActivity.RESULT, 0);
        Log.d("RESULT PASSED", String.valueOf(result));
        textView.setText(String.valueOf(result));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.google.com")));
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        float result = intent.getFloatExtra(MainActivity.RESULT, 0);
        textView = (TextView) findViewById(R.id.result_text);
        textView.setText(String.valueOf(result));
    }
}
