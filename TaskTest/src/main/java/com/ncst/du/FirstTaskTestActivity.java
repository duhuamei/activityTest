package com.ncst.du;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public class FirstTaskTestActivity extends AppCompatActivity {


    private static final String TAG = "TASK_TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_task_test);

        Log.d(TAG, "onCreate: "+toString()+"  "+getTaskId());
    }
    public void startSecond(View v){
        Intent intent=new Intent(FirstTaskTestActivity.this,SecondTaskTestActivity.class);
        startActivity(intent);
    }
    public void startFirst(View view){
        Intent intent =new Intent(this,FirstTaskTestActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: "+toString());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: "+toString());
    }

}
