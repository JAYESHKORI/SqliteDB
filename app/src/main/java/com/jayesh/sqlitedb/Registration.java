package com.jayesh.sqlitedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    private Button signup;
    private EditText et_name, et_uname, et_pwd;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        et_name = (EditText)findViewById(R.id.et_name);
        et_uname = (EditText)findViewById(R.id.et_username);
        et_pwd = (EditText)findViewById(R.id.et_pwd);
        signup = (Button)findViewById(R.id.btn_signup);

        db = new DatabaseHelper(getBaseContext(),null,null,0);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_name.getText().toString().equals(null))
                    Toast.makeText(getApplicationContext(),"Name is Empty",Toast.LENGTH_SHORT).show();
                else if(et_uname.getText().toString().equals(null))
                    Toast.makeText(getApplicationContext(),"Username is Empty",Toast.LENGTH_SHORT).show();
                else if(et_pwd.getText().toString().equals(null))
                    Toast.makeText(getApplicationContext(),"Password is Empty",Toast.LENGTH_SHORT).show();
                else
                {
                    try
                    {
                        db.register(et_name.getText().toString(),et_uname.getText().toString(),et_pwd.getText().toString());
                        Toast.makeText(getApplicationContext(), "DATA SAVED!!!!", Toast.LENGTH_SHORT).show();
                        String msg = "Registerd Successfull\n\n"+"Hi "+et_name.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), Welcome.class );
                        intent.putExtra ( "msg", msg);
                        startActivity(intent);
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
