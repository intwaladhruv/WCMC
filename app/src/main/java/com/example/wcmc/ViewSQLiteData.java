package com.example.wcmc;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewSQLiteData extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.view_sqlite_data);

        TextView textView = findViewById(R.id.viewData);
        DbHelper db = new DbHelper(this);

        String data = db.getData();
        textView.setText(data);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
