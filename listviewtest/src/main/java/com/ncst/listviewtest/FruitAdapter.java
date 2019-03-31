package com.ncst.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(@android.support.annotation.NonNull Context context, int resource,
                        @android.support.annotation.NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @android.support.annotation.NonNull
    @Override
    public View getView(final int position, @android.support.annotation.NonNull View convertView,
                        @android.support.annotation.NonNull ViewGroup parent) {
        Fruit fruit=getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView=(ImageView)view.findViewById(R.id.image);
            viewHolder.textView=(TextView)view.findViewById(R.id.name);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(),"image clicked"+position,Toast.LENGTH_LONG).show();
    }
});
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
