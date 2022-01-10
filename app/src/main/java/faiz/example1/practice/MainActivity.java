package faiz.example1.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button addButton,subButton,mulButton,divButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton= findViewById(R.id.addButton);
        addButton.setOnClickListener(this);
        subButton= findViewById(R.id.subButton);
        subButton.setOnClickListener(this);
        divButton= findViewById(R.id.divButton);
        divButton.setOnClickListener(this);
        mulButton= findViewById(R.id.mulButton);
        mulButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        if(view==addButton)
        {
            Intent i= new Intent(this,Addition.class);
            startActivity(i);
        }
        else if(view==subButton)
        {
            Intent i=new Intent(this,Subtraction.class);
            startActivity(i);
        }
        else if(view==mulButton)
        {
            Intent i=new Intent(this,Multiplication.class);
            startActivity(i);
        }
        else
        {
            Intent i=new Intent(this,Division.class);
            startActivity(i);
        }
    }
}
