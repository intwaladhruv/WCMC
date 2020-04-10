package com.example.wcmc;

import android.app.PictureInPictureParams;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Prac13 extends AppCompatActivity {

    ActionBar actionBar = getSupportActionBar();
    Button pip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac13);
        pip = findViewById(R.id.pip);
        pip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Display display = getWindowManager().getDefaultDisplay();
                    Point size = new Point();
                    display.getSize(size);
                    int width = size.x;
                    int height = size.y;

                    Rational aspectRatio = new Rational(width, height);
                    PictureInPictureParams.Builder mPictureInPictureParams = new PictureInPictureParams.Builder();
                    mPictureInPictureParams.setAspectRatio(aspectRatio).build();
                    enterPictureInPictureMode(mPictureInPictureParams.build());
                }
            }
        });
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        if (isInPictureInPictureMode)
        {
            actionBar.hide();
        }
        else
        {
            actionBar.show();
        }
    }
}
