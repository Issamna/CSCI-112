package CSCI112.additiongame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019

 */


public class MainActivity extends AppCompatActivity {
    private TextView Num1;
    private TextView Num2;
    private TextView Num3;
    private EditText userInput;
    private TextView results;
    private TextView rightAnswer;
    private ConstraintLayout mConstraintLayout;

    //onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set variables to run functions
        Num1 = findViewById(R.id.numberBox1);
        Num2 = findViewById(R.id.numberBox2);
        Num3 = findViewById(R.id.numberBox3);
        userInput = findViewById(R.id.guessEditText);
        results = findViewById(R.id.result);
        rightAnswer = findViewById(R.id.rightAnswer);
        mConstraintLayout = findViewById(R.id.answerBox);
        //randomize the 3 text field integers
        randomize();
    }
    //Guess button
    public void guessClick(View view){

        //User input test
        String sUsername = userInput.getText().toString();

        //Check if a blank input
        if (sUsername.matches("")) {
            //Error Message for blank
            Toast.makeText(this, "You did not enter a number", Toast.LENGTH_SHORT).show();
            return;
        }
        //Check if number is too long for integer. This case more than 5.
        if (sUsername.length()>5){
            //Error Message for long input
            Toast.makeText(this, "Number is too long.", Toast.LENGTH_SHORT).show();
            return;
        }

        //variable for win conditions
        int userGuess = Integer.parseInt(userInput.getText().toString());

        int randomNum1 = Integer.parseInt(Num1.getText().toString());
        int randomNum2 = Integer.parseInt(Num2.getText().toString());
        int randomNum3 = Integer.parseInt(Num3.getText().toString());
        int sum = randomNum1+randomNum2+randomNum3;
        //win condition test
        if(sum == userGuess){
            //if right
            results.setText("RIGHT!!!");
            mConstraintLayout.setBackgroundColor(Color.GREEN);

        }
        else{
            //if wrong
            results.setText("WRONG!!!");
            mConstraintLayout.setBackgroundColor(Color.RED);
        }
        //answer for both cases
        rightAnswer.setText("Answer: "+sum);
        //randomize the numbers for next round
        randomize();
    }
    //Method to randomize the numbers in text fields.
    public void randomize(){
        Num1.setText(""+((int) (Math.random() * 10 + 1)));
        Num2.setText(""+((int) (Math.random() * 10 + 1)));
        Num3.setText(""+((int) (Math.random() * 10 + 1)));
    }

}
