package com.ncst.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends AppCompatActivity {

    private String[] names = {"图灵", "爱因斯坦", "爱迪生", "居里夫人", "钱学森"};
    private String[] descs = {
            "数学家，逻辑学家，密码学家",
            "创立狭义相对论",
            "发明的留声机、电影摄影机、电灯对世界有极大影响",
            "对放射性的研究而获得诺贝尔物理学奖 ",
            "空气动力学家，中国载人航天奠基人"};
    private int[] resourceIds = {R.drawable.turing, R.drawable.einstein,
            R.drawable.edison, R.drawable.curie, R.drawable.qianxuesen};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 5; i++) {
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("image",resourceIds[i]);
            item.put("name",names[i]);
            item.put("desc",descs[i]);
            list.add(item);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,
                list,R.layout.simple_adapter_item,
                new String[]{"image","name","desc"},
                new int[]{R.id.image,R.id.name,R.id.desc});
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(simpleAdapter);

    }
}
