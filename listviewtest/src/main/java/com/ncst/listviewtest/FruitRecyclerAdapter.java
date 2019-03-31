package com.ncst.listviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FruitRecyclerAdapter extends RecyclerView.Adapter<FruitRecyclerAdapter.ViewHolder>{
    List<Fruit>  fruits;

    public FruitRecyclerAdapter(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int i) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,
                parent,false);
        Log.d("du", "onCreateViewHolder: "+i);
        final ViewHolder holder=new ViewHolder(view);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position=holder.getAdapterPosition();
//                Toast.makeText(parent.getContext(),fruits.get(position).getName(),Toast.LENGTH_LONG).show();
//
//            }
//        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Fruit fruit=fruits.get(i);
        final ViewHolder holder=viewHolder;
        final int pos=holder.getAdapterPosition();
        viewHolder.fruitName.setText(fruit.getName());
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(holder.itemView.getContext(),"onClick  "+fruit.getName(),Toast.LENGTH_LONG).show();

            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(holder.itemView.getContext(),"onLongClick  "+fruit.getName()+pos,Toast.LENGTH_LONG).show();
                deleteItem(pos);
                return false;
            }
        });
        viewHolder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(holder.itemView.getContext(),fruit.getName()+"image",Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView fruitImage;
        private TextView fruitName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitImage=itemView.findViewById(R.id.image);
            fruitName=itemView.findViewById(R.id.name);
        }
    }
//插入到末尾，返回插入元素的位置
    public int addItem(){
        if(fruits==null){
            fruits=new ArrayList<Fruit>();
        }
        Fruit fruit=new Fruit("New Fruit",R.drawable.apple_pic);
        fruits.add(fruit);
        int position=fruits.size()-1;
        notifyItemInserted(position);
        return position;
    }
    //删除指定元素，返回删除位置
    public int deleteItem(int position){
        if(fruits==null || fruits.size()==0){
            return 0;
        }
        fruits.remove(position);
        notifyItemRemoved(position);
        return position;
    }
}



