package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    AnimatedVectorDrawableCompat avd;
    AnimatedVectorDrawable avd2;

    int switchNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switchNumber == 0){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.avd_play_to_pause));
                    Drawable drawable = imageView.getDrawable();

                    if (drawable instanceof AnimatedVectorDrawableCompat){
                        avd = (AnimatedVectorDrawableCompat) drawable;
                        avd.start();
                    }else if (drawable instanceof AnimatedVectorDrawable){
                        avd2 = (AnimatedVectorDrawable) drawable;
                        avd2.start();
                    }

                    switchNumber++;
                }else {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.avd_pause_to_play));
                    Drawable drawable = imageView.getDrawable();

                    if (drawable instanceof AnimatedVectorDrawableCompat){
                        avd = (AnimatedVectorDrawableCompat) drawable;
                        avd.start();
                    }else if (drawable instanceof AnimatedVectorDrawable){
                        avd2 = (AnimatedVectorDrawable) drawable;
                        avd2.start();
                    }
                    switchNumber--;
                }
            }
        });
    }
}