package com.example.wcmc;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Prac6 extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 123;
    boolean hasCameraFlash = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac6);
        final ToggleButton led = findViewById(R.id.tourch);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);

        hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        led.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                final boolean status = led.isChecked();
                if (hasCameraFlash)
                {
                    if (!status)
                    {
                        flashLightOff();
                    } else {
                        flashLightOn();
                    }
                } else {
                    Toast.makeText(Prac6.this, "No flash available on your device", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        ToggleButton led = findViewById(R.id.tourch);

        switch (requestCode)
        {
            case CAMERA_REQUEST :
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
                }
                else {
                    led.setEnabled(false);
                    Toast.makeText(Prac6.this, "Permission Denied for the Camera", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void flashLightOff()
    {
        CameraManager cameraManager;
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId,false);
        } catch (CameraAccessException e) {
        }
    }

    private void flashLightOn()
    {
        CameraManager cameraManager;
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId,true);
        } catch (CameraAccessException e) {
        }
    }
}
