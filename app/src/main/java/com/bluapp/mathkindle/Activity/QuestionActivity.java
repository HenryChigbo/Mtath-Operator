package com.bluapp.mathkindle.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bluapp.mathkindle.Database.AppDatabase;
import com.bluapp.mathkindle.R;
import com.bluapp.mathkindle.Utils.AppConstants;
import com.bluapp.mathkindle.Utils.History;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class QuestionActivity extends AppCompatActivity {
    private TextView scoreTxt;
    private TextView questionTxt;
    private String arithmeticOperation, attemptedDate;
    private int arithmeticValue1, arithmeticValue2;
    private List<Integer> answerOption;
    private Button answer1Btn, answer2Btn, answer3Btn, answer4Btn;
    private Button skipBtn, finishBtn;
    private int arithmeticAnswer;
    private int score, totalquestion, correctquestion, wrongquestion, skippedquestion = 0;
    private AppDatabase appDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        scoreTxt = (TextView)findViewById(R.id.scoreTxt);
        questionTxt = (TextView)findViewById(R.id.questionTxt);
        answer1Btn = (Button)findViewById(R.id.answer1Btn);
        answer2Btn = (Button)findViewById(R.id.answer2Btn);
        answer3Btn = (Button)findViewById(R.id.answer3Btn);
        answer4Btn = (Button)findViewById(R.id.answer4Btn);
        skipBtn = (Button)findViewById(R.id.skipBtn);
        finishBtn = (Button)findViewById(R.id.finishBtn);
        appDatabase = AppDatabase.getInstance(this);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss", Locale.getDefault());
        attemptedDate = sdf.format(new Date());
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            arithmeticOperation = bundle.getString(AppConstants.ARITHMETIC_OPERATOR);
            generateNewQuestion();
        }
    }

    public void generateNewQuestion(){
        arithmeticValue1 = randomWithRange(999,999);
        arithmeticValue2 = randomWithRange(999,999);
        totalquestion = totalquestion+1;
        if(arithmeticOperation.equals(AppConstants.ADDITION)){
            questionTxt.setText(new StringBuilder(AppConstants.QUESTION_TAG).append(arithmeticValue1).append(" + ").append(arithmeticValue2).append(" ?"));
            arithmeticAnswer = arithmeticValue1+arithmeticValue2;
            answerOption = setoptionAnswer(arithmeticAnswer);
        }else if(arithmeticOperation.equals(AppConstants.SUBTRACTION)){
            questionTxt.setText(new StringBuilder(AppConstants.QUESTION_TAG).append(arithmeticValue1).append(" - ").append(arithmeticValue2).append(" ?"));
            arithmeticAnswer = arithmeticValue1-arithmeticValue2;
            answerOption = setoptionAnswer(arithmeticAnswer);
        }else if(arithmeticOperation.equals(AppConstants.MULTIPLICATION)){
            questionTxt.setText(new StringBuilder(AppConstants.QUESTION_TAG).append(arithmeticValue1).append(" * ").append(arithmeticValue2).append(" ?"));
            arithmeticAnswer = arithmeticValue1*arithmeticValue2;
            answerOption = setoptionAnswer(arithmeticAnswer);
        }else{
            questionTxt.setText(new StringBuilder(AppConstants.QUESTION_TAG).append(arithmeticValue1).append(" ÷ ").append(arithmeticValue2).append(" ?"));
            arithmeticAnswer = arithmeticValue1/arithmeticValue2;
            answerOption = setoptionAnswer(arithmeticAnswer);
        }
        answer1Btn.setText(answerOption.get(0).toString());
        answer2Btn.setText(answerOption.get(1).toString());
        answer3Btn.setText(answerOption.get(2).toString());
        answer4Btn.setText(answerOption.get(3).toString());
    }

    private int randomWithRange(int min, int max){
        return -min+(int)(Math.random()*((max-(-min))+1));
     }

    public void correctAnswer(View view){
        if(view.getId() == R.id.answer1Btn){
           if(Integer.parseInt(answer1Btn.getText().toString())==arithmeticAnswer){
               score = score+1;
               scoreTxt.setText("Score: "+String.valueOf(score));
               correctquestion = correctquestion+1;
               Toast.makeText(QuestionActivity.this, "Correct", Toast.LENGTH_SHORT).show();
           }else{
               wrongquestion = wrongquestion+1;
               Toast.makeText(QuestionActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
           }
        }else if(view.getId() == R.id.answer2Btn){
            if(Integer.parseInt(answer2Btn.getText().toString())==arithmeticAnswer){
                score = score+1;
                scoreTxt.setText("Score: "+String.valueOf(score));
                correctquestion = correctquestion+1;
                Toast.makeText(QuestionActivity.this, "Correct", Toast.LENGTH_SHORT).show();
            }else{
                wrongquestion = wrongquestion+1;
                Toast.makeText(QuestionActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
            }
        }else if(view.getId() == R.id.answer3Btn){
            if(Integer.parseInt(answer3Btn.getText().toString())==arithmeticAnswer){
                score = score+1;
                scoreTxt.setText("Score: "+String.valueOf(score));
                correctquestion = correctquestion+1;
                Toast.makeText(QuestionActivity.this, "Correct", Toast.LENGTH_SHORT).show();
            }else{
                wrongquestion = wrongquestion+1;
                Toast.makeText(QuestionActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
            }
        }else{
            if(Integer.parseInt(answer4Btn.getText().toString())==arithmeticAnswer){
                score = score+1;
                scoreTxt.setText("Score: "+String.valueOf(score));
                correctquestion = correctquestion+1;
                Toast.makeText(QuestionActivity.this, "Correct", Toast.LENGTH_SHORT).show();
            }else{
                wrongquestion = wrongquestion+1;
                Toast.makeText(QuestionActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
            }
        }
        generateNewQuestion();
    }

    public List<Integer> setoptionAnswer(int answer) {
        List<Integer> option = new ArrayList<>();
        option.add(randomWithRange(999,999));
        option.add(randomWithRange(999,999));
        option.add(answer);
        option.add(randomWithRange(999,999));
        Collections.sort(option);
        return option;
    }

    public void bottomBtnOnclick(View view){
        if(view.getId() == R.id.skipBtn){
            generateNewQuestion();
            skippedquestion = skippedquestion+1;
            Toast.makeText(QuestionActivity.this, "Question skip", Toast.LENGTH_SHORT).show();
        }else{
            String attemptname = arithmeticOperation+" "+attemptedDate;
            History history = new History(attemptname, String.valueOf(totalquestion-1), String.valueOf(correctquestion), String.valueOf(wrongquestion), attemptedDate, arithmeticOperation, String.valueOf(skippedquestion));
            appDatabase.appDAO().insert(history);
            Intent intent = new Intent(QuestionActivity.this, SummaryActivity.class);
            intent.putExtra(AppConstants.TOTALQUESTION, String.valueOf(totalquestion-1));
            intent.putExtra(AppConstants.CORRECTQUESTION, String.valueOf(correctquestion));
            intent.putExtra(AppConstants.WRONGQUESTION, String.valueOf(wrongquestion));
            intent.putExtra(AppConstants.ATTEMPTEDDATE, attemptedDate);
            intent.putExtra(AppConstants.ARITHMETIC_OPERATOR, arithmeticOperation);
            intent.putExtra(AppConstants.SKIPPEDQUESTION, String.valueOf(skippedquestion));
            startActivity(intent);
            finish();
        }
    }

}
