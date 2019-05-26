package com.example.android.demonhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button bb;
    private EditText tt;
    String kk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tt = (EditText)findViewById(R.id.editText);
        bb = (Button)findViewById(R.id.button);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),Main2Activity.class);
                kk = tt.getText().toString();
                i.putExtra("value",kk);

                startActivity(i);
            }});
    }}