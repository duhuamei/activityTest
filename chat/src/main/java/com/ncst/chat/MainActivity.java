package com.ncst.chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Message> msgList=new ArrayList<Message>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        String userName=intent.getStringExtra("username");

        initData();
        msgList.add(new Message(userName+"你好",Message.TYPE_RECEIVED));
        final RecyclerView msgRecyclerView = findViewById(R.id.msg_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);
        final MessageAdapter adapter=new MessageAdapter(msgList);
        msgRecyclerView.setLayoutManager(layoutManager);
        msgRecyclerView.setAdapter(adapter);
        msgRecyclerView.scrollToPosition(msgList.size()-1);

        Button sendButton=(Button) findViewById(R.id.btn_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView=(TextView) findViewById(R.id.msg_text);
                Message msg=new Message(textView.getText().toString(),Message.TYPE_SEND);
                msgList.add(msg);
                adapter.notifyItemInserted(msgList.size()-1);
                msgRecyclerView.scrollToPosition(msgList.size()-1);
                textView.setText("");
            }
        });
    }

    private void initData() {
        msgList.add(new Message("ni hao", Message.TYPE_RECEIVED));
        msgList.add(new Message("ni hao ni hao", Message.TYPE_SEND));
        msgList.add(new Message("How are you today?", Message.TYPE_RECEIVED));
    }
}
