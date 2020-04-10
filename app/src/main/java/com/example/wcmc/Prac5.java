package com.example.wcmc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Prac5 extends AppCompatActivity {

    public void exit(View view){
        System.exit(0);
    }

    public void login(View view){
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        TextView info = findViewById(R.id.info);
        String uname = username.getText().toString();
        String pass = password.getText().toString();

        info.setVisibility(View.VISIBLE);
        if(uname.equals("Dhruv") && pass.equals("dhruv@123")){
            info.setText("Login Successful!");
            info.setBackgroundColor(getResources().getColor(R.color.loginSuccess));
        }else {
            info.setText("Login Failed!!");
            info.setBackgroundColor(getResources().getColor(R.color.loginFail));
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac5);
    }
}
