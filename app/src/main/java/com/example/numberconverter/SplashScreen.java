package com.example.numberconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    private static Context context;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        context = this;

        icon = findViewById(R.id.Icon);
        launchConverter();
    }

    private void launchConverter(){
        Handler handler = new Handler(Looper.getMainLooper());
        ObjectAnimator.ofFloat(icon, View.ALPHA, 0f, 1f).setDuration(1500).start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(context, Converter.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}