package faiz.example1.practice;

import android.opengl.Visibility;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Subtraction extends AppCompatActivity {

    int[] array =new int[4];
    int a=0,b=0;
    int totalQuestionsAttempted=0, answeredRight=0;
    TextView timer;
    TextView points;
    TextView question;
    TextView result;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button playAgainButton;
    GridLayout gridLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition);

        question=findViewById(R.id.textView);
        points=findViewById(R.id.points);
        points.setText(answeredRight+"/"+totalQuestionsAttempted);
        timer=findViewById(R.id.timer);
        result=findViewById(R.id.result);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        playAgainButton=findViewById(R.id.playAgainButton);
        gridLayout=findViewById(R.id.gridLayout);

        function();

    }

    public void function()
    {
        new CountDownTimer(31000,1000) {
            @Override
            public void onTick(long l) {
                timer.setText(Long.toString(l/1000));
                Log.i("Time left",String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                timer.setText("0");
                Log.i("time left","0");
                gridLayout.setVisibility(View.INVISIBLE);
                result.setVisibility(View.INVISIBLE);
                playAgainButton.setVisibility(View.VISIBLE);
                question.setVisibility(View.INVISIBLE);
                result.setText(null);
            }
        }.start();


        Random random=new Random();
        a=random.nextInt(100);
        b=random.nextInt(100);

        int positonOfRightAnswer=random.nextInt(4);
        for(int i=0;i<4;i++)
        {
            int wrongAnswer;
            if(i==positonOfRightAnswer)
                array[i]=a-b;
            else {
                wrongAnswer=random.nextInt(100) ;
                while (wrongAnswer==a-b)
                    wrongAnswer=random.nextInt(100);
                array[i]=wrongAnswer;
            }
        }
        button1.setText(String.valueOf(array[0]));
        button2.setText(String.valueOf(array[1]));
        button3.setText(String.valueOf(array[2]));
        button4.setText(String.valueOf(array[3]));

        question.setText(String.valueOf(a+" - "+b));

    }

    public void onClick(View view)
    {
        totalQuestionsAttempted++;
        Button clickedButton = (Button) view;
        Log.i("Answer pressed",String.valueOf(clickedButton.getText()));
        if(Integer.parseInt((String) clickedButton.getText())==(a-b))
        {
            Log.i("Right answer selected", String.valueOf(a-b));
            result.setText("Correct!");
            answeredRight++;
        }
        else
        {
            Log.i("wrong answer selected",(String)clickedButton.getText());
            result.setText("Wrong :(");
        }

        points.setText(answeredRight+"/"+totalQuestionsAttempted);

        Random random=new Random();
        a=random.nextInt(100);
        b=random.nextInt(100);

        int positonOfRightAnswer=random.nextInt(4);
        for(int i=0;i<4;i++)
        {
            int wrongAnswer;
            if(i==positonOfRightAnswer)
                array[i]=a-b;
            else {
                wrongAnswer=random.nextInt(100) ;
                while (wrongAnswer==a-b)
                    wrongAnswer=random.nextInt(100);
                array[i]=wrongAnswer;
            }
        }
        button1.setText(String.valueOf(array[0]));
        button2.setText(String.valueOf(array[1]));
        button3.setText(String.valueOf(array[2]));
        button4.setText(String.valueOf(array[3]));

        question.setText(String.valueOf(a+" - "+b));

    }

    public void playAgain(View view)
    {
        timer.setVisibility(View.VISIBLE);
        points.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        totalQuestionsAttempted=answeredRight=0;
        points.setText("0/0");
        function();
    }


}
