package com.example.android.demonhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class Main2Activity extends AppCompatActivity {
    private EditText cv;
    private TextView tt,te,lm;
    private Button bt,btn;
    int d_age,actualAge;
    int no_of_tries = 0;
    int optimal_tries = 20;
    int won = 0;
    View view;
    Random r = new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        view = this.getWindow().getDecorView();
        cv = (EditText)findViewById(R.id.editText3);
        tt = (TextView)findViewById(R.id.textView5);
        te = (TextView)findViewById(R.id.textView6);
        btn = (Button)findViewById(R.id.button4);
        lm = (TextView)findViewById(R.id.textView7) ;
        bt = (Button)findViewById(R.id.button2) ;
        actualAge = Integer.parseInt(getIntent().getExtras().getString("value"));

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {no_of_tries++;
           if(no_of_tries>optimal_tries){btn.setEnabled(false);}
           else{
               d_age = Integer.parseInt(cv.getText().toString());


               if(d_age>actualAge){tt.setText("higher age");
               te.setText("cool......try again");if(d_age-actualAge<=8){view.setBackgroundResource(R.color.green);
                   }
                   else if(d_age-actualAge<=16){view.setBackgroundResource(R.color.lightG);}
                   else if(d_age-actualAge<=24){view.setBackgroundResource(R.color.veryLR);}
                   else if(d_age-actualAge<=32){view.setBackgroundResource(R.color.verLR);}
                   else if(d_age-actualAge<=48){view.setBackgroundResource(R.color.lightR);}
                   else {view.setBackgroundResource(R.color.red);}}
               else if(d_age == actualAge){won++;
                   actualAge = r.nextInt(100);
                   tt.setText("CONGRATS!!!!!!!you guessed it correctly");
                   te.setText("WOAHH");
               view.setBackgroundResource(R.color.green);}
                   else
                   {tt.setText("lower age");
                   te.setText("go ahead and try again......");if(actualAge-d_age<=8){view.setBackgroundResource(R.color.green);
                   }
                   else if(actualAge-d_age<16){view.setBackgroundResource(R.color.lightG);}
                   else if(actualAge-d_age<24){view.setBackgroundResource(R.color.veryLR);}
                   else if(actualAge-d_age<32){view.setBackgroundResource(R.color.verLR);}
                   else if(actualAge-d_age<48){view.setBackgroundResource(R.color.lightR);}
                   else {view.setBackgroundResource(R.color.red);}}


               }}

       });bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {lm.setText(Integer.toString(won));


            }
        });

}}
