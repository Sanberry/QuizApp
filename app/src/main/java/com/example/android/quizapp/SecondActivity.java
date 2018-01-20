package com.example.android.quizapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        ArrayList<String> answers = new ArrayList<String>();

        //RadioButton Answers
        answers.add("Fruit");
        answers.add("Veggie");        //correct answers for question 1

        answers.add("Fruit");         //correct answers for question 2
        answers.add("Veggie");

        //Checkbox answers
        answers.add("avocado");
        answers.add("broccoli");
        answers.add("bell pepper");
        answers.add("cabbage");



        RadioButton answerView1 = (RadioButton) findViewById(R.id.radioButton1);
        answerView1.setText(answers.get(0));

        RadioButton answerView2 = (RadioButton) findViewById(R.id.radioButton2);
        answerView2.setText(answers.get(1));

        RadioButton answerView3 = (RadioButton) findViewById(R.id.radioButton3);
        answerView3.setText(answers.get(2));

        RadioButton answerView4 = (RadioButton) findViewById(R.id.radioButton4);
        answerView4.setText(answers.get(3));

        CheckBox answerView5 = (CheckBox) findViewById(R.id.checkBoxButton1);
        answerView5.setText(answers.get(4));

        CheckBox answerView6 = (CheckBox) findViewById(R.id.checkBoxButton2);
        answerView6.setText(answers.get(5));

        CheckBox answerView7 = (CheckBox) findViewById(R.id.checkBoxButton3);
        answerView7.setText(answers.get(6));

        CheckBox answerView8 = (CheckBox) findViewById(R.id.checkBoxButton4);
        answerView8.setText(answers.get(7));

    }
    int score = 0;

    public void onRadioButtonClicked(View view) {
        //Calling the name of the user to use within the toast message
        EditText userName = (EditText) findViewById(R.id.user_name);
        String name = userName.getText().toString();
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked and display a toast message for 6 number of question
        switch (view.getId()) {
            case R.id.radioButton1:

                if (checked)
                    Toast.makeText(this, name + ", you are wrong!" + "Your overall score is " + score + " out of 4", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radioButton2:
                if (checked)
                    score = score + 1;
                Toast.makeText(this, name + ", you are correct!" + "Your overall score is " + score + " out of 4", Toast.LENGTH_SHORT).show();

                break;
            case R.id.radioButton3:
                if (checked)
                    score = score + 1;
                Toast.makeText(this, name + ", you are correct!" + "Your overall score is " + score + " out of 4", Toast.LENGTH_SHORT).show();

                break;

            case R.id.radioButton4:
                if (checked)
                    Toast.makeText(this, name + ", you are wrong!" + "Your overall score is " + score + " out of 4", Toast.LENGTH_SHORT).show();
                break;


        }

    }
    public void checkBoxClicked(View view) {
        EditText userName = (EditText) findViewById(R.id.user_name);
        String name = userName.getText().toString();

        CheckBox answerView5 = (CheckBox) findViewById(R.id.checkBoxButton1);
        CheckBox answerView7 = (CheckBox) findViewById(R.id.checkBoxButton3);
        CheckBox answerView6 = (CheckBox) findViewById(R.id.checkBoxButton2);
        CheckBox answerView8 = (CheckBox) findViewById(R.id.checkBoxButton4);

        if(answerView5.isChecked() && answerView7.isChecked()
                && !answerView6.isChecked() && !answerView8.isChecked()){
            score = score+ 1;
            Toast.makeText(this, name + ", you are correct!" + "Your overall score is " + score + " out of 4", Toast.LENGTH_SHORT).show();

        }  else {
            Toast.makeText(this, name + ", you are wrong!" + "Your overall score is " + score + " out of 4", Toast.LENGTH_SHORT).show();

        }
    }

    public void submitWrittenAnswer(View view) {
        EditText userName = (EditText) findViewById(R.id.user_name);
        String name = userName.getText().toString();
        EditText editText= (EditText) findViewById(R.id.writtenAnswer);
        String userEntry = editText.getText().toString();


        if(userEntry.matches("pumpkin")) {
            score = score +1;
            Toast.makeText(this, name + ", you are correct!" + "Your overall score is " + score + " out of 4", Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(this, name + ", you are wrong!" + "Your overall score is " + score + " out of 4", Toast.LENGTH_SHORT).show();

        }

    }

    public void displayScore(View view) {
        EditText userName = (EditText) findViewById(R.id.user_name);
        String name = userName.getText().toString();

        String message = "\nHello, " + name + "!";
        message += "\nYour overall score is " + score;

        if (score == 6) {
            message += "\nYou are amazing! You really know what is fruit or vegetable!\nThank you for doing this short quiz and proving your skills";

            display(message);

        } else {
            message +="\n Correct answers:\n";
            message +="Potato is a vegetable!\n";
            message +="Tomato is a fruit!\n";
            message +="Avocado and Bell pepper are fruits!\n";
            message +="Lastly, pumpkin is a fruit!\n";
            message += "\nYou didn't reach the full score, but it is good!! ";
            message += "Because now, you are an expert on some of the fruit or vegetables that you didn't know before :).\n Thank you for doing this short quiz!";

            display(message);
        }
    }

    //Displays the score on the screen

    private void display(String message) {
        TextView displayScore = (TextView) findViewById(R.id.display);
        displayScore.setText(message);
    }
}









