package com.example.amira.thinkmore.Cities;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amira.thinkmore.MainPage.Main2Activity;
import com.example.amira.thinkmore.Math.Result;
import com.example.amira.thinkmore.Question_database.QuizHelper;
import com.example.amira.thinkmore.Question_database.question;
import com.example.amira.thinkmore.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class City_questionactivity extends AppCompatActivity {
    long millis;
    List<question> quesList;
    int score = 0;
    int qid = 0;
    MediaPlayer clap,failure;
    Boolean check=false;
    question currentQ;
    TextView txtQuestion, times, scored;
    Button button1, button2, button3,button4;
    CounterClass timer = new CounterClass(30000, 1000);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_questionactivity);

        QuizHelper db = new QuizHelper(this);  // my question bank class
        quesList = db.getAllQuestions4();  // this will fetch all quetonall questions
        currentQ = quesList.get(qid); // the current question

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        // the textview in which the question will be displayed

        // the three buttons,
        // the idea is to set the text of three buttons with the options from question bank
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        clap=MediaPlayer.create(getApplicationContext(),R.raw.clapping2);
        failure=MediaPlayer.create(getApplicationContext(),R.raw.falure2);
        // the textview in which score will be displayed
        scored = (TextView) findViewById(R.id.score);

        // the timer
        times = (TextView) findViewById(R.id.timers);

        // method which will set the things up for our game
        setQuestionView();
        times.setText("00:02:00");

        // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)

        timer.start();

        // button click listeners
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // passing the button text to other method
                // to check whether the anser is correct or not
                // same for all three buttons
                getAnswer(button1.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button4.getText().toString());
            }
        });
    }

    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER().equals(AnswerString)) {

            // if conditions matches increase the int (score) by 1
            // and set the text of the score view
            score++;
            scored.setText("Score : " + score);
            clap.start();
            // Toast.makeText(getApplicationContext(),"good job my friend",Toast.LENGTH_SHORT).show();
        }
        else {

            // if unlucky start activity and finish the game
            ///hena 3yza badele ma ya3ml finish yageb next question
            /////////done i make it  go to next uestion and decrease score if answer is wrong
            score--;
            scored.setText("Score : " + score);
            failure.start();
            // Toast.makeText(getApplicationContext(),"concentrate more in order not to lose points",Toast.LENGTH_SHORT).show();
            currentQ = quesList.get(qid);
            // setQuestionView();

        }
        if (qid < 10) {

            // if questions are not over then do this
            currentQ = quesList.get(qid);
            Toast.makeText(this,qid+"",Toast.LENGTH_SHORT).show();
            setQuestionView();
        }
        else {
            check=true;
            // if over do this
            Intent intent = new Intent(City_questionactivity.this,
                    City_result.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }

    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")////////////////classtime
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onFinish() {
            if(!check) {
                times.setText("Time is up");
                Intent intent = new Intent(City_questionactivity.this,                 ///fe mashakal fe goz da lama 3mlt test
                        City_result.class);
                Bundle b = new Bundle();
                b.putInt("score", score); // Your score
                intent.putExtras(b); // Put your score to your next
                startActivity(intent);
                finish();
            }
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            millis = millisUntilFinished;/////haksm 3la 2 hena 3shan taba 30
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }

    }

    private void setQuestionView() {

        // the method which will put all things together
        txtQuestion.setText(currentQ.getQUESTION());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());
        button4.setText(currentQ.getOPTD());

        qid++;
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        //Display alert message when back button has been pressed
        backButtonHandler();
        timer.cancel();
        return;
    }

    public void backButtonHandler() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                City_questionactivity.this);
        // Setting Dialog Title
        alertDialog.setTitle("Leave application?");
        // Setting Dialog Message
        alertDialog.setMessage("Are you sure you want to leave the application?");
        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.ic_action_name);
        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                        startActivity(intent);
                        timer.cancel();
                        onStop();
                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        timer=new CounterClass(millis,1000);
                        timer.start();
                        dialog.cancel();
                    }
                });
        // Showing Alert Message
        alertDialog.show();
    }

}




