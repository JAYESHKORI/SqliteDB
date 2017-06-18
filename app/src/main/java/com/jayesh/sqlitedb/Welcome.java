package com.jayesh.sqlitedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView tv_user = (TextView)findViewById(R.id.tv_user);
        Intent i = getIntent();
        String text = i.getStringExtra("msg");
        tv_user.setText(text);
    }
}
