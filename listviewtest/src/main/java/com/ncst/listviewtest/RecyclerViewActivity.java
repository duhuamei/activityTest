package com.ncst.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {
    private ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    private FruitRecyclerAdapter fruitAdpt;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initData();
        RecyclerView fruitsRecyclerView = (RecyclerView) findViewById(R.id.fruits);
        fruitAdpt = new FruitRecyclerAdapter(fruits);

        layoutManager=new LinearLayoutManager(this);
//        ((LinearLayoutManager)layoutManager).setOrientation(LinearLayout.HORIZONTAL);

        //GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        fruitsRecyclerView.setAdapter(fruitAdpt);
        fruitsRecyclerView.setLayoutManager(layoutManager);
        //fruitsRecyclerView.setItemAnimator(new DefaultItemAnimator());  //这是默认动画
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
       private void initRandomData() {
        fruits.add(new Fruit(getRandomLengthName("apple"), R.drawable.apple_pic));
        fruits.add(new Fruit(getRandomLengthName("banana"), R.drawable.banana_pic));
        fruits.add(new Fruit(getRandomLengthName("orange"), R.drawable.orange_pic));
        fruits.add(new Fruit(getRandomLengthName("watermelon"), R.drawable.watermelon_pic));
        fruits.add(new Fruit(getRandomLengthName("pear"), R.drawable.pear_pic));
        fruits.add(new Fruit(getRandomLengthName("grape"), R.drawable.grape_pic));
        fruits.add(new Fruit(getRandomLengthName("pineapple"), R.drawable.pineapple_pic));
        fruits.add(new Fruit(getRandomLengthName("strawberry"), R.drawable.strawberry_pic));
        fruits.add(new Fruit(getRandomLengthName("cherry"), R.drawable.cherry_pic));
        fruits.add(new Fruit(getRandomLengthName("mango"), R.drawable.mango_pic));

        fruits.add(new Fruit(getRandomLengthName("apple"), R.drawable.apple_pic));
        fruits.add(new Fruit(getRandomLengthName("banana"), R.drawable.banana_pic));
        fruits.add(new Fruit(getRandomLengthName("orange"), R.drawable.orange_pic));
        fruits.add(new Fruit(getRandomLengthName("watermelon"), R.drawable.watermelon_pic));
        fruits.add(new Fruit(getRandomLengthName("pear"), R.drawable.pear_pic));
        fruits.add(new Fruit(getRandomLengthName("grape"), R.drawable.grape_pic));
        fruits.add(new Fruit(getRandomLengthName("pineapple"), R.drawable.pineapple_pic));
        fruits.add(new Fruit(getRandomLengthName("strawberry"), R.drawable.strawberry_pic));
        fruits.add(new Fruit(getRandomLengthName("cherry"), R.drawable.cherry_pic));
        fruits.add(new Fruit(getRandomLengthName("mango"), R.drawable.mango_pic));
    }

    //invoked by initRandomData
    private String getRandomLengthName(String name) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        int n = random.nextInt(10);
        for (int i = 0; i < n; i++) {
            str.append(name);
        }
        return  str.toString();
    }

    public void onClick(View view){
        int position=0;
        switch (view.getId()){
            case R.id.add_item:
                position=fruitAdpt.addItem();
                break;
            case R.id.delete_item:
                //删除第一个元素
                position=fruitAdpt.deleteItem(0);
                break;
        }
        layoutManager.scrollToPosition(position);
    }
}
