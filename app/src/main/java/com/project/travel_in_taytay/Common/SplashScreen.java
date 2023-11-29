package com.project.travel_in_taytay.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.travel_in_taytay.R;
import com.project.travel_in_taytay.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
   private static int SPLASH_TIMER = 5000;
    //Variables
    ImageView background_image;
    TextView welcome;
    //Animation
    Animation sideAnim, bottomAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        //Hooks
        background_image = findViewById(R.id.background_image);
        welcome = findViewById(R.id.welcome);
        //Animations
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        //set Animation
        background_image.setAnimation(sideAnim);
        welcome.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);




    }
}