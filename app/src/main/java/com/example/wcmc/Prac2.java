package com.example.wcmc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Prac2 extends AppCompatActivity {

    int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac2);
    }
    public void sendToast(View view){
        EditText et1 = (EditText) findViewById(R.id.et1);
        EditText et2 = (EditText) findViewById(R.id.et2);
        num = Integer.parseInt(et1.getEditableText().toString()) + Integer.parseInt(et2.getEditableText().toString());
        String number = "Sum : " + String.valueOf(num);

        LayoutInflater layoutInflater = getLayoutInflater();

        View view1=layoutInflater.inflate(R.layout.customtoast,(ViewGroup)findViewById(R.id.ct));

        TextView textView=view1.findViewById(R.id.ctv);
        textView.setText(number);

        Toast t=new Toast(getApplicationContext());
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(view1);
        t.show();
    }
}
