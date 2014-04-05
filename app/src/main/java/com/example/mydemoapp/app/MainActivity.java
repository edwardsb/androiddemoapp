package com.example.mydemoapp.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends Activity {

    private EditText text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText1);
        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
                        RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
                        if (text.getText().length() == 0) {
                            Toast.makeText(getApplicationContext(), "Please enter a valid number",
                                    Toast.LENGTH_LONG).show();
                            return;
                        }

                        float inputValue = Float.parseFloat(text.getText().toString());
                        //
                        // user input a celsius value and would like it converted to Fahrenheit
                        if (celsiusButton.isChecked()) {
                            text.setText(String
                                    .valueOf(ConvertUtils.convertFtoC(inputValue)));
                            celsiusButton.setChecked(false);
                            fahrenheitButton.setChecked(true);
                            //
                            // user input a fahrenheit value and would like it converted to celsius
                        } else {
                            text.setText(String
                                    .valueOf(ConvertUtils.convertCtoF(inputValue)));
                            fahrenheitButton.setChecked(false);
                            celsiusButton.setChecked(true);
                        }
                        break;
                }
            }
        });
    }

//    public void onClick(View view){
//        switch (view.getId()) {
//            case R.id.button1:
//                RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
//                RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
//                if (text.getText().length() == 0) {
//                    Toast.makeText(this, "Please enter a valid number",
//                            Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//                float inputValue = Float.parseFloat(text.getText().toString());
//                //
//                // user input a celsius value and would like it converted to Fahrenheit
//                if (celsiusButton.isChecked()) {
//                    text.setText(String
//                            .valueOf(ConvertUtils.convertFtoC(inputValue)));
//                    celsiusButton.setChecked(false);
//                    fahrenheitButton.setChecked(true);
//                //
//                // user input a fahrenheit value and would like it converted to celsius
//                } else {
//                    text.setText(String
//                            .valueOf(ConvertUtils.convertCtoF(inputValue)));
//                    fahrenheitButton.setChecked(false);
//                    celsiusButton.setChecked(true);
//                }
//                break;
//        }
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
