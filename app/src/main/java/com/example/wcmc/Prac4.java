package com.example.wcmc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Prac4 extends AppCompatActivity {

    static boolean unit = true;
    float c = 0, f = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac4);
    }

    public void changeTemp(View view){
        ToggleButton temp = (ToggleButton) view;
        unit = temp.isChecked();
    }
    public float convertFtoC(float fe) {
        float ce = (float) ((5.0/9.0)*(fe-32.0));
        return ce;
    }

    public float convertCtoF(float ce) {
        float fe = (float) (ce*(9.0/5.0)+32.0);
        return fe;
    }
    public void convert(View view){
        EditText temp = findViewById(R.id.temprature);
        TextView tempPrint = findViewById(R.id.tempPrint);
        if(unit){
            //c to f
            c = Float.parseFloat(temp.getText().toString());
            tempPrint.setText("Fahrenheit : " + String.format("%.2f", convertCtoF(c)) + (char) 0x00B0);
        }
        else {
            //f to c
            f = Float.parseFloat(temp.getText().toString());
            tempPrint.setText("Celcius : " + String.format("%.2f", convertFtoC(f)) + (char) 0x00B0);
        }
    }
}
