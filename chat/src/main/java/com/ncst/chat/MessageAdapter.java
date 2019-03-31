package com.ncst.chat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    ArrayList<Message> msgList;

    public MessageAdapter(ArrayList<Message> msgList) {
        this.msgList = msgList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.msg_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Message msg=msgList.get(position);
        if(msg.getType()==Message.TYPE_RECEIVED){
            viewHolder.msgRight.setText(msg.getContent());
            viewHolder.layoutRight.setVisibility(View.VISIBLE);
            viewHolder.layoutLeft.setVisibility(View.GONE);
        }else if(msg.getType()==Message.TYPE_SEND){
            viewHolder.msgLeft.setText(msg.getContent());
            viewHolder.layoutLeft.setVisibility(View.VISIBLE);
            viewHolder.layoutRight.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout layoutLeft;
        LinearLayout layoutRight;
        TextView msgLeft;
        TextView msgRight;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutLeft=itemView.findViewById(R.id.left);
            layoutRight=itemView.findViewById(R.id.right);
            msgLeft=itemView.findViewById(R.id.msg_left);
            msgRight=itemView.findViewById(R.id.msg_right);
        }
    }
}
