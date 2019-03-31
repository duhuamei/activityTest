package com.ncst.chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin=(Button) findViewById(R.id.btn_login);
        final EditText username=(EditText)findViewById(R.id.user_name);
        final EditText passwd=(EditText)findViewById(R.id.passwd);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LoginActivity", "onClick: ");
                if(username.getText().toString().equals("du")  && passwd.getText().toString().equals("123")){
                    Log.d("LoginActivity", "onClick:OK ");
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("username",username.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
