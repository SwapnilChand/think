package com.example.think;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class QuestionsActivity extends AppCompatActivity {

    private TextView question = findViewById(R.id.question), count = findViewById(R.id.count);
    private FloatingActionButton exitBtn;
    private LinearLayout optionsContainer;
    private Button nextBtn,backBtn;
    private int cnt =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        count = findViewById(R.id.count);
        exitBtn = findViewById(R.id.floatingExit);
        optionsContainer = findViewById(R.id.optionsContainer);
        nextBtn = findViewById(R.id.next);
        backBtn = findViewById(R.id.back);
        nextBtn.
    }

    private void playAnimation(View view, int val){
        view.animate().alpha(val).scaleX(val).scaleY(val).setDuration(500).setStartDelay(100).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (val == 0 && cnt < 4){
                    playAnimation(optionsContainer.getChildAt(cnt),0);
                    cnt++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
              //cahnging data value
                if(val == 0){
                    playAnimation(view,1);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
}