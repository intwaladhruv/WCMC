package com.example.wcmc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Prac8 extends AppCompatActivity {

    Button button;
    boolean status = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac8);

        button = findViewById(R.id.frags);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                if (!status)
                {
                    FragmentA fragmentA = new FragmentA();
                    transaction.replace(R.id.frag, fragmentA);
                    transaction.commit();
                    button.setText("Load fragment Two");
                    status = true;
                }
                else
                {
                    FragmentB fragmentB = new FragmentB();
                    transaction.replace(R.id.frag, fragmentB);
                    transaction.commit();
                    button.setText("Load fragment One");
                    status = false;
                }
            }
        });

    }
}
