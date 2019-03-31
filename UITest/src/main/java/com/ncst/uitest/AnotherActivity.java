package com.ncst.uitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AnotherActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button btn01;
    private Button btn02;

    private TimePicker timePicker;
    private DatePicker datePicker;
    private TextView tv_content;
    private int Year, Month, Day, Hour, Minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        initView();
        getCurrentTime();
        setPicker();

        ((SeekBar) findViewById(R.id.seek_bar)).setMax(50);
        ((SeekBar) findViewById(R.id.seek_bar)).setProgress(20);
        ((SeekBar) findViewById(R.id.seek_bar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("progress", "onProgressChanged: " + seekBar.getMax() + "  " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("progress", "onStartTrackingTouch: ");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("progress", "onStopTrackingTouch: ");
            }
        });

        progressBar = ((ProgressBar) findViewById(R.id.progress_bar));
        btn01 = (Button) findViewById(R.id.btn_01);
        btn02 = (Button) findViewById(R.id.btn_02);
        ButtonClickListener buttonClickListener=new ButtonClickListener();
        btn01.setOnClickListener(buttonClickListener);
        btn02.setOnClickListener(buttonClickListener);

        ((RatingBar) findViewById(R.id.rating_bar)).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d("ratingbar", "onRatingChanged: "+rating+fromUser+ratingBar.getStepSize());
            }
        });
    }
    private void getCurrentTime() {
        // 获取系统当前时间
        Calendar calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);
        Hour = calendar.get(Calendar.HOUR);
        Minute = calendar.get(Calendar.MINUTE);
    }

    private void setPicker() {
        // 设置时间选择器为24小时制
        timePicker.setIs24HourView(true);
        // 设置时间选择器的当前时间
        timePicker.setCurrentHour(Hour);
        timePicker.setCurrentMinute(Minute);
        //为时间选择器添加监听器
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // 当时间选择器发生改变时，触发
                System.out.println("From TimePicker : " + hourOfDay + " :"
                        + minute);
            }
        });
        //为日期选择器添加监听器
        datePicker.init(Year, Month, Day, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                // 当日期选择器发生改变时，触发
                System.out.println("From DatePicker : " + year + "/"
                        + (monthOfYear + 1) + "/" + dayOfMonth);
                setTitle("From DatePicker : " + year + "/" + (monthOfYear + 1)
                        + "/" + dayOfMonth);
            }
        });
        //将当前日期+时间显示到指定的TextView中
        tv_content.setText("当前日期+时间：" + Year + "/" + (Month+1) + "/" + Day + " "
                + Hour + " : " + Minute);
    }

    private void initView() {
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        tv_content = (TextView) findViewById(R.id.tv_content);
    }
    class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_01:
                    progressBar.incrementProgressBy(10);
                    break;
                case R.id.btn_02:
                    progressBar.incrementSecondaryProgressBy(20);
                    break;
            }
        }
    }
}
