package com.ncst.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            String str=savedInstanceState.getString("key");//得到数据
            Log.d("MainActivity", "活动恢复，数据为："+str);
        } else {
            Log.d("MainActivity", "这是活动正常启动");
        }

        Button btnNormal= ((Button) findViewById(R.id.btn_normal));
        Button btnDialog= ((Button) findViewById(R.id.btn_dialog));
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("key","data");
        Log.d(TAG, "onSaveInstanceState: ");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        String str=savedInstanceState.getString("key");
        Log.d(TAG, "onRestoreInstanceState:   "+str);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"add clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_item:
                Toast.makeText(this,"delete clicked",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;

    }
}
