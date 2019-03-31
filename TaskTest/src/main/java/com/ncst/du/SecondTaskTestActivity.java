package com.ncst.du;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondTaskTestActivity extends AppCompatActivity {
    private static final String TAG = "TASK_TEST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task_test);
        Log.d(TAG, "onCreate: "+toString()+"  "+getTaskId());
    }
    public void startFirst(View view){
        Intent intent =new Intent(this,FirstTaskTestActivity.class);
        startActivity(intent);
    }
    public  void startThird(View view){
        Intent intent=new Intent(this,ThirdTaskTestActivity.class);
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
