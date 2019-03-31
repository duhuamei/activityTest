package com.ncst.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BasicListViewActivity extends AppCompatActivity {
    private String[] fruits={"apple","banana","orange","watermelon",
            "pear","grape","pineapple","strawberry","cherry","mango"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list_view);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,fruits);
        ListView listView=(ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

}
