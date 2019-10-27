package com.bluapp.mathkindle.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bluapp.mathkindle.R;
import com.bluapp.mathkindle.Utils.AppConstants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void generateQuestion(View view){
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        if(view.getId() == R.id.additionBtn){
            intent.putExtra(AppConstants.ARITHMETIC_OPERATOR, AppConstants.ADDITION);
        }else if(view.getId() == R.id.subtractionBtn){
            intent.putExtra(AppConstants.ARITHMETIC_OPERATOR, AppConstants.SUBTRACTION);
        }else if(view.getId() == R.id.multiplicationBtn){
            intent.putExtra(AppConstants.ARITHMETIC_OPERATOR, AppConstants.MULTIPLICATION);
        }else{
            intent.putExtra(AppConstants.ARITHMETIC_OPERATOR, AppConstants.DIVISION);
        }
        startActivity(intent);
    }

    public void actionHistory(View view){
        startActivity(new Intent(MainActivity.this, HistoryActivity.class));
    }
}
