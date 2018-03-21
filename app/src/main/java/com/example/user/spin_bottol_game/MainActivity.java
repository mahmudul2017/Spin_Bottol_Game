package com.example.user.spin_bottol_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    private View main;
    private ImageView buttol;
    private int lastAngel = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main);
        buttol = findViewById(R.id.button);

        buttol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinTheBottol();
            }
        });
    }

    private void spinTheBottol() {
        int angle = RANDOM.nextInt(3600-360)+360;
        float pivotx = buttol.getWidth() / 2;
        float pivoty = buttol.getHeight() / 2;

        final Animation rotateanimation = new RotateAnimation(lastAngel == -1 ? 0 : lastAngel, angle, pivotx, pivoty);
        lastAngel = angle;
        rotateanimation.setDuration(2500);
        rotateanimation.setFillAfter(true);

        buttol.startAnimation(rotateanimation);

     }
}
