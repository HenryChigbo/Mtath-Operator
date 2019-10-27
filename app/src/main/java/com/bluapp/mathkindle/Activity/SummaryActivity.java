package com.bluapp.mathkindle.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bluapp.mathkindle.R;
import com.bluapp.mathkindle.Utils.AppConstants;

public class SummaryActivity extends AppCompatActivity {
    private TextView totalQuestion;
    private TextView correctQuestion;
    private TextView wrongQuestion;
    private TextView attemptedDate;
    private TextView arithmeticOperator;
    private TextView skippedQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        totalQuestion = (TextView)findViewById(R.id.totalQuestion);
        correctQuestion = (TextView)findViewById(R.id.correctQuestion);
        wrongQuestion = (TextView)findViewById(R.id.wrongQuestion);
        attemptedDate = (TextView)findViewById(R.id.attemptedDate);
        arithmeticOperator = (TextView)findViewById(R.id.arithmeticOperator);
        skippedQuestion = (TextView)findViewById(R.id.skippedQuestion);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            totalQuestion.setText("No of questions attempted: "+bundle.getString(AppConstants.TOTALQUESTION));
            correctQuestion.setText("No of correct question: "+bundle.getString(AppConstants.CORRECTQUESTION));
            wrongQuestion.setText("No of wrong question: "+bundle.getString(AppConstants.WRONGQUESTION));
            attemptedDate.setText("Attempted date: "+bundle.getString(AppConstants.ATTEMPTEDDATE));
            arithmeticOperator.setText("Arithmetic operator: "+bundle.getString(AppConstants.ARITHMETIC_OPERATOR));
            skippedQuestion.setText("No of skipped questions: "+bundle.getString(AppConstants.SKIPPEDQUESTION));
        }
    }
}
