package com.ogd.citizenapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //Variables
    Animation topAnim, bottomAnim;
    ImageView imageTop, imageBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        //imageTop = findViewById(R.id.ui_top);
        imageBottom = findViewById(R.id.ui_bottom);

        //imageTop.setAnimation(topAnim);
        //logo.setAnimation(bottomAnim);
        imageBottom.setAnimation(bottomAnim);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 5000ms
                startActivity(new Intent(MainActivity.this, WebviewActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.fade_out);
                finish();
            }
        }, 4000);
    }
}
