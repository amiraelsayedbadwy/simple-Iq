package com.example.amira.thinkmore.Myth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amira.thinkmore.MainPage.Main2Activity;
import com.example.amira.thinkmore.Math.Result;
import com.example.amira.thinkmore.Question_database.QuizHelper;
import com.example.amira.thinkmore.Question_database.question;
import com.example.amira.thinkmore.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class Myth_questionactivity extends AppCompatActivity {

    public CounterClass c;
    List<question> quesList;
    public long millis;
    int score = 0;
    int qid = 0;
    Boolean check=false;
    question currentQ;
    TextView txtQuestion, times, scored;
    Button button1, button2;
    FloatingActionButton fab;
    CounterClass timer = new CounterClass(30000,1000);
    MediaPlayer mp;
    MediaPlayer mp1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myth_questionactivity);

        QuizHelper db = new QuizHelper(this);  // my question bank class
        quesList = db.getAllQuestions3();  // this will fetch all quetonall questions
        currentQ = quesList.get(qid); // the current question
        mp=MediaPlayer.create(getApplicationContext(),R.raw.clapping2);//sound effect
        mp1=MediaPlayer.create(getApplicationContext(),R.raw.falure2);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        fab = (FloatingActionButton) findViewById(R.id.info);


        // the textview in which score will be displayed
        scored = (TextView) findViewById(R.id.score);

        // the timer
        times = (TextView) findViewById(R.id.timers);

        // method which will set the things up for our game
        setQuestionView();
        times.setText("00:02:00");

        // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        // timer = new CounterClass(millis, 1000);
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
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {////mesh mazbot fe resume
                timer.cancel();
                // Click action
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                        Myth_questionactivity.this);
                // Setting Dialog Title
                alertDialog.setTitle("Explaination !!!");
                // Setting Dialog Message
                alertDialog.setMessage(currentQ.getOPTC());
                // Setting Icon to Dialog
                alertDialog.setIcon(R.drawable.ic_action_name);
                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("Got It ",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                ;
                                timer=new CounterClass(millis,1000);
                                timer.start();///////////////mesh sha8la sa7 bet3ml time men awoul wa geded

                            }
                        });
                alertDialog.show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
    public void play()
    {
        mp.start();
    }

    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER().equals(AnswerString)) {

            // if conditions matches increase the int (score) by 1
            // and set the text of the score view
            score++;
            scored.setText("Score : " + score);

            // Toast.makeText(getApplicationContext(),"good job my friend",Toast.LENGTH_SHORT).show();
            play();
        }
        else {

            // if unlucky start activity and finish the game
            ///hena 3yza badele ma ya3ml finish yageb next question
            /////////done i make it  go to next uestion and decrease score if answer is wrong
            score--;
            scored.setText("Score : " + score);
            mp1.start();

           currentQ = quesList.get(qid);
           /* mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    currentQ = quesList.get(qid);
                    Toast.makeText(getApplicationContext(), "Media Completed with Success", Toast.LENGTH_SHORT).show();
                }
            });
*/
            // setQuestionView();
            // explain.setVisibility(View.INVISIBLE);

        }
        if (qid < 10) {

            // if questions are not over then do this

           currentQ = quesList.get(qid);
            setQuestionView();
        }
        else {
            check=true;
            // if over do this
            Intent intent = new Intent(Myth_questionactivity.this,
                    Myth_result.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            timer.cancel();
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
            if(!check)
            {
                times.setText("Time is up");
                Intent intent = new Intent(Myth_questionactivity.this,                 ///atzbat 3yaza a8yer el 7ta de
                        Myth_result.class);
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
        // explain.setText(currentQ.getOPTC());


        qid++;
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
                Myth_questionactivity.this);
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



