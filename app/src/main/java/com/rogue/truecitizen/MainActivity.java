package com.rogue.truecitizen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.rogue.truecitizen.databinding.ActivityMainBinding;
import com.rogue.truecitizen.model.Question;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
//    private ImageView imageView;
//    private TextView textView;
//    private Button answerTrue,answerFalse,prev,next;
    private int questionIdx=0;
    Question[] questionBank=new Question[]{
            new Question(R.string.question_amendments, false), //correct: 27
            new Question(R.string.question_constitution, true),
            new Question(R.string.question_declaration, true),
            new Question(R.string.question_independence_rights, true),
            new Question(R.string.question_religion, true),
            new Question(R.string.question_government, false),
            new Question(R.string.question_government_feds, false),
            new Question(R.string.question_government_senators, true),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.nextButtonId.setOnClickListener(view -> {
            questionIdx =(questionIdx+1)%questionBank.length;
            showQuestion();
        });
        binding.prevButtonId.setOnClickListener(view -> {
            if(questionIdx>0){
                questionIdx=questionIdx-1;
                showQuestion();
            }
        });
        binding.trueButtonId.setOnClickListener(view -> checkAnswer(true));
        binding.falseButtonId.setOnClickListener(view -> checkAnswer(false));

    }

    private void showQuestion() {
        binding.textView.setText(questionBank[questionIdx].getQuesResId());
    }
    private void checkAnswer(boolean choice){
        String message;
        if(questionBank[questionIdx].isAnswer()==choice){
            message=getString(R.string.correct_answer);
        }
        else message=getString(R.string.wrong_answer);
        Snackbar.make(binding.trueButtonId, message,Snackbar.LENGTH_SHORT)
                .show();
    }
}