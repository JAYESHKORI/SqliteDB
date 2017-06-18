package com.jayesh.sqlitedb;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv_newuser;
    private Button btn_login;
    private EditText et_uname, et_pwd;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(getBaseContext(),null,null,0);

        et_uname = (EditText)findViewById(R.id.et_username);
        et_pwd = (EditText)findViewById(R.id.et_pwd);

        tv_newuser = (TextView)findViewById(R.id.tv_newuser);
        tv_newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Registration.class);
                startActivity(i);
            }
        });

        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                if(db!=null)
                {
                    Cursor data = db.getData("JAYESH");
                    Toast.makeText(getApplicationContext(),"Data Found",Toast.LENGTH_SHORT).show();
                }

//                if(data.getCount() == 0)
//                {
//                    Toast.makeText(getApplicationContext(),"No Data Found",Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    String pwd = data.getString(2);
//                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
//                }
            }
        });

    }
}
