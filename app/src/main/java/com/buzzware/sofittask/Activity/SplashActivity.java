package com.buzzware.sofittask.Activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.buzzware.sofittask.R;
public class SplashActivity extends AppCompatActivity {
    private int STORAGE_PERMISSION_CODE = 1;
    public static final int RequestPermissionCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashHandler();
    }
    //todo splash func !!!
    public void splashHandler()
    {
        runTimePermission();
        enableRuntimePermission();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
           startActivity(new Intent(SplashActivity.this,BaseActivity.class));
                finish(); }
        }, 3000);
    }
    public void runTimePermission()
    {
        if (ContextCompat.checkSelfPermission(SplashActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
          //todo toast or alert here if want to show again if permisson access !!!
        } else {
            requestStoragePermission();
        }
    }
    //todo Permission code here !!!
    public void enableRuntimePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,
                Manifest.permission.CAMERA)) {
            Toast.makeText(getApplicationContext(), "CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(SplashActivity.this, new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);
        }
    }
    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission needed!!")
                    .setMessage("This permission is needed because of Storage Access!!")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(SplashActivity.this,
                                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE)  {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}