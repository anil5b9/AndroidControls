package com.hb.androidcontrols.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.core.BaseActivity;
import com.hb.androidcontrols.model.ControlsModelView;

import java.util.ArrayList;
import java.util.Random;

import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;

public class WaveSwipeRefreshActivity extends BaseActivity implements WaveSwipeRefreshLayout.OnRefreshListener {

    private ListView mListview;

    private WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;

    private ControlsModelView controlsModelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wave_swipe_refresh_activity);
        initView();
        setSampleData();
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

        mWaveSwipeRefreshLayout = findViewById(R.id.main_swipe);
        mWaveSwipeRefreshLayout.setColorSchemeColors(Color.WHITE, Color.WHITE);
        mWaveSwipeRefreshLayout.setOnRefreshListener(this);
        mWaveSwipeRefreshLayout.setWaveColor(Color.argb(100, 255, 0, 0));

        mListview = findViewById(R.id.main_list);

        findViewById(R.id.button_of_wave_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWaveSwipeRefreshLayout.setWaveColor(0xFF000000 + new Random().nextInt(0xFFFFFF)); // Random assign
            }
        });

        ((SeekBar) findViewById(R.id.seekbar_of_drop_height)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float scale = (seekBar.getProgress() / 100f);
                mWaveSwipeRefreshLayout.setMaxDropHeight((int) (mWaveSwipeRefreshLayout.getHeight() * scale));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // ignore
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float scale = (seekBar.getProgress() / 100f);
                mWaveSwipeRefreshLayout.setMaxDropHeight((int) (mWaveSwipeRefreshLayout.getHeight() * scale));
            }
        });
    }

    private void setSampleData() {
        ArrayList<String> sampleArrayStr = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            sampleArrayStr.add("");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, sampleArrayStr);
        mListview.setAdapter(adapter);
    }

    private void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mWaveSwipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }

    @Override
    protected void onResume() {
        //mWaveSwipeRefreshLayout.setRefreshing(true);
        refresh();
        super.onResume();
    }

    @Override
    public void onRefresh() {
        refresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.wave_swipe_refresh_menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mWaveSwipeRefreshLayout.setRefreshing(true);
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
