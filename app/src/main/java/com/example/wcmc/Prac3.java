package com.example.wcmc;

import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Prac3 extends AppCompatActivity {

    Chronometer c;
    EditText et;
    int i=0;
    int duration=5;
    public void timeToast(View view)
    {
        et = (EditText) findViewById(R.id.msg);
        c=(Chronometer)findViewById(R.id.cnm);
        c.start();
        c.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer arg0) {

                i++;
                if (i >= duration)
                {
                    String ett = et.getText().toString();
                    Toast.makeText(getApplicationContext(), ett, Toast.LENGTH_SHORT).show();
                    duration=duration+5;
                }

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac3);
    }
}
