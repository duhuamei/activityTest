package com.ncst.uitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CheckBox cbRead;
    private CheckBox cbRun;
    private CheckBox cbTravel;
    private Button btnAll;
    private Button btnNotAll;
    private List<String> hobbiesList = new ArrayList<String>();
    private TextView showList;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private RadioGroup rgSex;
    private ImageView imageHappy;
    private ToggleButton tbHappy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void setListener() {
        OnCheckChanged onCheckChanged = new OnCheckChanged();
        cbRead.setOnCheckedChangeListener(onCheckChanged);
        cbTravel.setOnCheckedChangeListener(onCheckChanged);
        cbRun.setOnCheckedChangeListener(onCheckChanged);
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbRead.setChecked(true);
                cbRun.setChecked(true);
                cbTravel.setChecked(true);
            }
        });
        btnNotAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbRead.setChecked(false);
                cbRun.setChecked(false);
                cbTravel.setChecked(false);
            }
        });

        rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_female:
                    Log.d("TAG", "onCheckedChanged: female");
                    break;
                    case R.id.rb_male:
                    Log.d("TAG", "onCheckedChanged: male");
                    break;
                }
            }
        });
        tbHappy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imageHappy.setImageResource(R.drawable.happy);
                }else{
                    imageHappy.setImageResource(R.drawable.unhappy);
                }

            }
        });


    }

    private void initView() {
        cbRead = (CheckBox) findViewById(R.id.cb_read);
        cbRun = (CheckBox) findViewById(R.id.cb_run);
        cbTravel = (CheckBox) findViewById(R.id.cb_travel);
        btnAll = (Button) findViewById(R.id.btn_all);
        btnNotAll = (Button)findViewById(R.id.btn_notall);
        showList=(TextView)findViewById(R.id.show_checked);
        rbMale=(RadioButton)findViewById(R.id.rb_male);
        rbFemale=(RadioButton)findViewById(R.id.rb_female);
        rgSex= ((RadioGroup) findViewById(R.id.rg_sex));
        imageHappy=(ImageView) findViewById(R.id.image_happy);
        tbHappy=(ToggleButton) findViewById(R.id.tb_happy);
    }

    class OnCheckChanged implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            switch (buttonView.getId()) {
                case R.id.cb_read:
                    if (buttonView.isChecked()) {
                        Toast.makeText(MainActivity.this, "阅读  被选中", Toast.LENGTH_LONG).show();
                        hobbiesList.add("read");

                    } else
                        Toast.makeText(MainActivity.this, "阅读  被取消", Toast.LENGTH_LONG).show();
                    break;
                case R.id.cb_run:
                    if (buttonView.isChecked())
                        Toast.makeText(MainActivity.this, "跑步  被选中", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this, "跑步  被取消", Toast.LENGTH_LONG).show();
                    break;
                case R.id.cb_travel:
                    if (buttonView.isChecked())
                        Toast.makeText(MainActivity.this, "旅游  被选中", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this, "旅游  被取消", Toast.LENGTH_LONG).show();
                    break;
            }
            showList.setText(hobbiesList.toString());
        }
    }
}
