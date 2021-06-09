package com.example.think;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity {

    private TextView question = findViewById(R.id.question), count = findViewById(R.id.count);
    private FloatingActionButton exitBtn = findViewById(R.id.floatingExit);
    ;
    private LinearLayout optionsContainer = findViewById(R.id.optionsContainer);
    ;
    private Button nextBtn = findViewById(R.id.next), backBtn = findViewById(R.id.back);
    private int cnt = 0;
    private Button op1 = findViewById(R.id.option1), op2 = findViewById(R.id.option2), op3 = findViewById(R.id.option3), op4 = findViewById(R.id.option4);
    private List<QuestionModel> list;
    private int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nextBtn.setOnClickListener(v -> {
            cnt = 0;
            playAnimation(question, 0, list.get(position).getQues());
        });
        backBtn.setOnClickListener(v -> {

        });
        exitBtn.setOnClickListener(v -> System.exit(0));


        op1.setOnClickListener(v -> {

        });
        op2.setOnClickListener(v -> {

        });
        op3.setOnClickListener(v -> {

        });
        op4.setOnClickListener(v -> {

        });
        list = new ArrayList<>();
        list.add(new QuestionModel("ques","opt1","opt2","op3","op4","crtanswer"));
        list.add(new QuestionModel("ques","opt1","opt2","op3","op4","crtanswer"));
        list.add(new QuestionModel("ques","opt1","opt2","op3","op4","crtanswer"));
        list.add(new QuestionModel("ques","opt1","opt2","op3","op4","crtanswer"));
        list.add(new QuestionModel("ques","opt1","opt2","op3","op4","crtanswer"));
        list.add(new QuestionModel("ques","opt1","opt2","op3","op4","crtanswer"));
        list.add(new QuestionModel("ques","opt1","opt2","op3","op4","crtanswer"));
        list.add(new QuestionModel("ques","opt1","opt2","op3","op4","crtanswer"));
        list.add(new QuestionModel("ques","opt1","opt2","op3","op4","crtanswer"));
        list.add(new QuestionModel("ques","opt1","opt2","op3","op4","crtanswer"));
        list.add(new QuestionModel("ques","opt1","opt2","op3","op4","crtanswer"));
        //option buttons configurations
        for (int i = 0; i < 4; i++){
            optionsContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer((Button) v);
                }
            });
        }
    }



    private void playAnimation(final View view, final int val, String data) {
        view.animate().alpha(val).scaleX(val).scaleY(val).setDuration(500).setStartDelay(100).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (val == 0 && cnt < 4) {
                    String option = null;
                    if(cnt == 0){
                        option = list.get(position).getOp1();
                    }
                    else if(cnt == 1){
                        option = list.get(position).getOp2();

                    }
                    else if(cnt == 2){
                        option = list.get(position).getOp3();

                    }
                    else if(cnt == 3){
                        option = list.get(position).getOp4();

                    }

                    playAnimation(optionsContainer.getChildAt(cnt), 0, option);
                    cnt++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //changing data value
                ((TextView)view).setText(data);
                if (val == 0) {
                    playAnimation(view, 1, data);
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


    //check answer
    private void checkAnswer(Button selectedOption){
        enableOption(false);
        if(selectedOption.getText().toString().equals(list.get(position).getCrtop())){
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#87C1DC")));
        }
//        else if{
        //            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#87C1DC")));
//            ///partially correct
//        }
//        else if{
        //            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#87C1DC")));
//
//        }
//        else if{
//            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#87C1DC")));
//
//        }
//        else{
//            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#87C1DC")));
//
//        }

    }
    private void enableOption(boolean enable){
        for (int i = 0; i < 4; i++){
            optionsContainer.getChildAt(i).setEnabled(enable);
        }
    }

}