package com.example.marine.katabowlingandroid;

//import android.support.design.widget.FloatingActionButton;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Bowling_Score_GUI extends AppCompatActivity {

    // create two string: one for storing the line of roll (rollLine) and one for storing the score (scoreText)
    String rollLine = "Enter your line of rolls";
    String scoreText= "";

    // instantiate the class for calculating score
    final Score scoreCal = new Score();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bowling_score__gui);

        // create a TextView to display the roll line and the score
        final TextView rollLineView = (TextView)findViewById(R.id.rollLineText);
        // create a toast message to display when the maximum number of rolls has already been added
        Context context = getApplicationContext();
        CharSequence text = "Maximum Number Of Rolls Reached";
        int duration = Toast.LENGTH_SHORT;
        final Toast toast = Toast.makeText(context, text, duration);

        //region attach buttons clickListeners to methods
        // for each adding roll button, click Listener is assRollToRollLine method
        for(int i=1;i<13;i++) {
            int resId = getResources().getIdentifier("button_" + i, "id", getPackageName());
            Button button = (Button) findViewById(resId);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    addRollToRollLine(rollLineView,(String)v.getTag(), toast);
                }
            });
        }

        // for the clean button, click listener is the cleanRoll method
        Button buttonClean = (Button) findViewById(R.id.button_clean);
        buttonClean.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cleanRollLine(rollLineView);
            }
        });

        // for the cancel button, click lister is the cancelAddRollToLine method
        Button buttonCancel = (Button) findViewById(R.id.button_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cancelAddRollToLine(rollLineView);
            }
        });

        Button buttonComputeScore = (Button) findViewById(R.id.button_calculateScore);
        buttonComputeScore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                computeScore(rollLineView);
            }
        });
        //endregion
    }

    // method called when using buttons for adding rolls to line
    protected void addRollToRollLine(TextView view, String roll, Toast msg)
    {
        // clean the initiate text displayed in the text view or clean the score textView if some score is displayed
        if(rollLine.equals("Enter your line of rolls") || !(scoreText.equals("")))
        {
            cleanRollLine(view);
        }
        // add roll to the line is rolls number is under 21
        if(rollLine.length()<21) {
            rollLine = rollLine + roll;
            setTextView(view);
        }
        // use toast message to notify : maximum number of rolls reached
        else{
            msg.show();
        }
    }

    // method clean the two textView
    protected void cleanRollLine(TextView view)
    {
        rollLine = "";
        scoreText = "";
        setTextView(view);
    }

    // method for canceling last roll addition
    protected void cancelAddRollToLine(TextView view)
    {
        // clean the initiate text displayed in the text view or clean the score textView if some score is displayed
        if(rollLine.equals("Enter your line of rolls"))
        {
            cleanRollLine(view);
        }
        if(!(scoreText.equals("")))
        {
            scoreText="";
            setTextView(view);
        }
        // drop the last char of the rollLine if not already emppty or null
        if(rollLine!=null && rollLine.length()>0) {
            // drop last char
            rollLine = rollLine.substring(0, rollLine.length() - 1);
            setTextView(view);
        }
    }

    // method for calculating score when pressing the equal button
    protected void computeScore(TextView view)
    {
        // set the cal object roll line attribute and calculate score if there are at least twelve rolls (minimum number of rolls when all strikes)
        if(rollLine.length()>=12){
            scoreCal.setLine(rollLine);
            // calculate score and set score TextView text
            scoreText = "\n=\n"+Integer.toString(scoreCal.getScore());
            setTextView(view);
        }
        // if not enough roll, set score TextView to incorrect format
        else{
            scoreText = "\n=\nincorrect format";
            setTextView(view);
        }


    }

    protected void setTextView(TextView view){
        view.setText(rollLine+scoreText);
    }

}
