package com.hb.androidcontrols.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.core.BaseActivity;
import com.hb.androidcontrols.model.ControlsModelView;
import com.yinglan.circleviewlibrary.CircleAlarmTimerView;


public class CircleAlarmTimerViewActivity extends BaseActivity {

    private ControlsModelView controlsModelView;

    private TextView textView1;
    private TextView textView2;
    private CircleAlarmTimerView circleAlarmTimerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_alarm_timer_view_activity);
        initView();
    }

    private void initView() {


        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        controlsModelView = (ControlsModelView) getIntent().getSerializableExtra("ControlData");

        TextView txtScreenTitle = findViewById(R.id.txtScreenTitle);
        txtScreenTitle.setText(controlsModelView.title);

        textView1 = findViewById(R.id.start);
        textView2 = findViewById(R.id.end);

        circleAlarmTimerView = findViewById(R.id.circletimerview);
        circleAlarmTimerView.setOnTimeChangedListener(new CircleAlarmTimerView.OnTimeChangedListener() {
            @Override
            public void start(String starting) {
                textView1.setText(starting);
            }

            @Override
            public void end(String ending) {
                textView2.setText(ending);
            }
        });

    }

}