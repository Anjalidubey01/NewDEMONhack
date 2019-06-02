package com.example.android.demonhack;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private EditText cv;
    private TextView tt,te,lm,re;
    private Button btn;
    int d_age,actualAge;
    int no_of_tries = 0;
    int optimal_tries = 20;
     int won = 0;
    View view;
    int lose = 0;
    SharedPreferences myPrefs;
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
        re = (TextView)findViewById(R.id.textView10) ;
        actualAge = Integer.parseInt(getIntent().getExtras().getString("value"));

        myPrefs = getSharedPreferences("prefID",Activity.MODE_PRIVATE);
        won = myPrefs.getInt("wi",0);
        lose = myPrefs.getInt("lo",0);
        lm.setText(Integer.toString(won));

        re.setText(Integer.toString(lose));
        btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {no_of_tries++;
           if(no_of_tries>optimal_tries){Toast.makeText(getBaseContext(),"TRIALS OVER....",Toast.LENGTH_LONG).show();btn.setEnabled(false); }
           else{
               d_age = Integer.parseInt(cv.getText().toString());
               if(d_age>actualAge){lose++;tt.setText("higher age");te.setText("cool......try again");
                   myPrefs = getSharedPreferences("prefID",Activity.MODE_PRIVATE);
                   SharedPreferences.Editor editor = myPrefs.edit();
                   editor.putInt("lo",lose);
                   editor.apply();
                   lose = myPrefs.getInt("lo",0);

                   re.setText(Integer.toString(lose));

                   if(d_age-actualAge<=8){view.setBackgroundColor(Color.rgb(50,205,50));
                   }
                   else if(d_age-actualAge<=16){view.setBackgroundColor(Color.rgb(0,255,0));}
                   else if(d_age-actualAge<=24){view.setBackgroundColor(Color.rgb(144,238,144));}
                   else if(d_age-actualAge<=32){view.setBackgroundColor(Color.rgb(255,160,122));}
                   else if(d_age-actualAge<=48){view.setBackgroundColor(Color.rgb(255,127,80));}
                   else {view.setBackgroundColor(Color.rgb(255,0,0));}}
               else if(d_age == actualAge){won++;tt.setText("CONGRATS!!!! you won");
                   te.setText("WOAHH");
                   myPrefs = getSharedPreferences("prefID",Activity.MODE_PRIVATE);
                   SharedPreferences.Editor editor = myPrefs.edit();editor.putInt("wi",won);
                   editor.apply();
                   won = myPrefs.getInt("wi",0);
                   lm.setText(Integer.toString(won));

                   view.setBackgroundColor(Color.rgb(50,205,50));
               }
                   else
                   {lose++;tt.setText("lower age");
                       te.setText("go ahead and try again......");
                       myPrefs = getSharedPreferences("prefID",Activity.MODE_PRIVATE);
                       SharedPreferences.Editor editor = myPrefs.edit();
                       editor.putInt("lo",lose);
                       editor.apply();

                       lose = myPrefs.getInt("lo",0);

                       re.setText(Integer.toString(lose));

                       if(actualAge-d_age<=8){view.setBackgroundColor(Color.rgb(50,205,50));
                   }
                   else if(actualAge-d_age<=16){view.setBackgroundColor(Color.rgb(0,255,0));}
                   else if(actualAge-d_age<=24){view.setBackgroundColor(Color.rgb(144,238,144));}
                   else if(actualAge-d_age<=32){view.setBackgroundColor(Color.rgb(255,160,122));}
                   else if(actualAge-d_age<=48){view.setBackgroundColor(Color.rgb(255,127,80));}
                   else {view.setBackgroundColor(Color.rgb(255,0,0));}}

               } }
        }); }}
