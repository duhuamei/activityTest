package com.ncst.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    ArrayList<Fruit> fruits = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        initData();
        FruitAdapter fruitAdapter = new FruitAdapter(this, R.layout.fruit_item, fruits);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(fruitAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruits.get(position);
                Toast.makeText(CustomListViewActivity.this,
                        "onItemClick: " + position + "  " + id + fruit.getName(),
                        Toast.LENGTH_LONG).show();

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruits.get(position);
                Toast.makeText(CustomListViewActivity.this,
                        "setOnItemLongClickListener: " + position + "  " + id + fruit.getName(),
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    private void initData() {
        fruits.add(new Fruit("apple", R.drawable.apple_pic));
        fruits.add(new Fruit("banana", R.drawable.banana_pic));
        fruits.add(new Fruit("orange", R.drawable.orange_pic));
        fruits.add(new Fruit("watermelon", R.drawable.watermelon_pic));
        fruits.add(new Fruit("pear", R.drawable.pear_pic));
        fruits.add(new Fruit("grape", R.drawable.grape_pic));
        fruits.add(new Fruit("pineapple", R.drawable.pineapple_pic));
        fruits.add(new Fruit("strawberry", R.drawable.strawberry_pic));
        fruits.add(new Fruit("cherry", R.drawable.cherry_pic));
        fruits.add(new Fruit("mango", R.drawable.mango_pic));

        fruits.add(new Fruit("apple", R.drawable.apple_pic));
        fruits.add(new Fruit("banana", R.drawable.banana_pic));
        fruits.add(new Fruit("orange", R.drawable.orange_pic));
        fruits.add(new Fruit("watermelon", R.drawable.watermelon_pic));
        fruits.add(new Fruit("pear", R.drawable.pear_pic));
        fruits.add(new Fruit("grape", R.drawable.grape_pic));
        fruits.add(new Fruit("pineapple", R.drawable.pineapple_pic));
        fruits.add(new Fruit("strawberry", R.drawable.strawberry_pic));
        fruits.add(new Fruit("cherry", R.drawable.cherry_pic));
        fruits.add(new Fruit("mango", R.drawable.mango_pic));

    }
}
