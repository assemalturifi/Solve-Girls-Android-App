package com.example.assemalturifi.solveallgirls;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    private Button true_button;
    private Button false_button;
    private TextView stringTextView;
    private ProgressBar progressBar;

    private TextView score;
    private int numForScore;


    private int numberForArray;




    private TrueFalse[] arrayQuestions = new TrueFalse[]{
            new TrueFalse(R.string.question1,true),
            new TrueFalse(R.string.question2,true),
            new TrueFalse(R.string.question3,true),
            new TrueFalse(R.string.question4,false),
            new TrueFalse(R.string.question5,false),
            new TrueFalse(R.string.question6,true),
            new TrueFalse(R.string.question7,false),
            new TrueFalse(R.string.question8,true),
            new TrueFalse(R.string.question9,true),
            new TrueFalse(R.string.question10,true),
            new TrueFalse(R.string.question11,false),
            new TrueFalse(R.string.question12,true),
            new TrueFalse(R.string.question13,false),
            new TrueFalse(R.string.question14,true),
            new TrueFalse(R.string.question15,false),
            new TrueFalse(R.string.question16,true),
            new TrueFalse(R.string.question17,false),
            new TrueFalse(R.string.question18,true),
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            numForScore = savedInstanceState.getInt("ScoreKey");
            numberForArray = savedInstanceState.getInt("IndexKey");
        }
        else{
            numForScore=0;
            numberForArray=0;

        }

        upView();



        true_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateQuestion();


            }
        });

        false_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateQuestion();

            }
        });



    }
    public void upView(){
        true_button = findViewById(R.id.true_button);
        false_button = findViewById(R.id.false_button);
        stringTextView = findViewById(R.id.question_text_view);
        score = findViewById(R.id.score);

        score.setText("Score "+numForScore+"/"+arrayQuestions.length);
        stringTextView.setText(arrayQuestions[numberForArray].getmQuestionID());

        progressBar = findViewById(R.id.progress_bar);

    }

    public void updateQuestion(){
        numberForArray+=1;

        if(numberForArray<arrayQuestions.length) {

            stringTextView.setText(arrayQuestions[numberForArray].getmQuestionID());

            score.setText("Score "+numForScore+"/"+arrayQuestions.length);
        }

        else{
            score.setText("Score "+numForScore+"/"+arrayQuestions.length);
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game over!");
            alert.setCancelable(false);
            alert.setMessage("You scored " + numForScore + " points!");
            alert.setPositiveButton("Closed Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            alert.show();
        }

    }
    public void checkAnswer(boolean userSelection){
        boolean correctAnswer=arrayQuestions[numberForArray].ismAnswer();

        if(userSelection==correctAnswer){
            numForScore+=1;

            progressBar.incrementProgressBy((100/arrayQuestions.length));
        }
        else{


        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("ScoreKey",numForScore);
        outState.putInt("IndexKey",numberForArray);
    }
}
