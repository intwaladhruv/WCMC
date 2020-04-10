package com.example.wcmc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

public class Prac7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac7);

        final RelativeLayout relativeLayout = findViewById(R.id.rl);
        final SeekBar colorBar = findViewById(R.id.colorbar);
        colorBar.setMax(256*7-1);
        colorBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    int r = 0;
                    int g = 0;
                    int b = 0;

                    if(progress < 256){
                        b = progress;               //blue
                    }else if (progress  < 256*2){
                        g = progress%256;           //green
                        b = 256 - progress % 256;
                    } else if(progress < 256*3) {
                        g = 255;
                        b = progress%256;           //light blue
                    } else if(progress < 256*4) {
                        r = progress%256;
                        g = 256 - progress%256;
                        b = 256 - progress%256;     //red
                    } else if(progress < 256*5) {
                        r = 255;
                        g = 0;                      //pink
                        b = progress%256;
                    } else if(progress < 256*6) {
                        r = 255;
                        g = progress%256;           //yellow
                        b = 256 - progress%256;
                    } else if(progress < 256*7) {
                        r = 255;
                        g = 255;                    //white
                        b = progress%256;
                    }
                    relativeLayout.setBackgroundColor(Color.argb(255, r, g, b));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
