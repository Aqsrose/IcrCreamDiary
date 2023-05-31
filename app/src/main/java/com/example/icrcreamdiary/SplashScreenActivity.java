package com.example.icrcreamdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME_OUT = 4000;
    Animation topAnim, bottomAnim;
    ImageView imageLogo;
    TextView tvDiary, tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageLogo = findViewById(R.id.imageLogo);
        tvDiary = findViewById(R.id.tvDiary);
        tvMsg = findViewById(R.id.tvMsg);

        //Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        imageLogo.setAnimation(topAnim);
        tvDiary.setAnimation(bottomAnim);
        tvMsg.setAnimation(bottomAnim);


    Handler h = new Handler();
    long delayMillis;
        h.postDelayed(new

    Runnable() {
        @Override
        public void run () {
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    },SPLASH_SCREEN_TIME_OUT);

}
}