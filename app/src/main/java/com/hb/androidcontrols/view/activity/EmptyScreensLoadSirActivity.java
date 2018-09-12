package com.hb.androidcontrols.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.core.BaseActivity;
import com.hb.androidcontrols.model.ControlsModelView;
import com.hb.androidcontrols.view.loadsir.callback.CustomCallback;
import com.hb.androidcontrols.view.loadsir.callback.EmptyCallback;
import com.hb.androidcontrols.view.loadsir.callback.ErrorCallback;
import com.hb.androidcontrols.view.loadsir.callback.LoadingCallback;
import com.hb.androidcontrols.view.loadsir.callback.TimeoutCallback;
import com.hb.androidcontrols.view.loadsir.target.ConvertorActivity;
import com.hb.androidcontrols.view.loadsir.target.FragmentSingleActivity;
import com.hb.androidcontrols.view.loadsir.target.MultiFragmentActivity;
import com.hb.androidcontrols.view.loadsir.target.MultiFragmentWithViewPagerActivity;
import com.hb.androidcontrols.view.loadsir.target.NormalActivity;
import com.hb.androidcontrols.view.loadsir.target.PlaceholderActivity;
import com.hb.androidcontrols.view.loadsir.target.ViewTargetActivity;
import com.kingja.loadsir.core.LoadSir;

public class EmptyScreensLoadSirActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_screens_load_sir_activity_main);
        updateTabBar();

        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }

    private void updateTabBar() {
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ControlsModelView controlsModelView = (ControlsModelView) getIntent().getSerializableExtra("ControlData");

        TextView txtScreenTitle = findViewById(R.id.txtScreenTitle);
        txtScreenTitle.setText(controlsModelView.title);
    }

    public void inActivity(View view) {
        startActivity(new Intent(this, NormalActivity.class));
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
    }

    public void inActivityWithConvertor(View view) {
        startActivity(new Intent(this, ConvertorActivity.class));
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
    }

    public void inFragment(View view) {
        startActivity(new Intent(this, FragmentSingleActivity.class));
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
    }

    public void inView(View view) {
        startActivity(new Intent(this, ViewTargetActivity.class));
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
    }

    public void inFragmentViewSirPager(View view) {
        startActivity(new Intent(this, MultiFragmentWithViewPagerActivity.class));
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
    }


    public void inFragmentMutil(View view) {
        startActivity(new Intent(this, MultiFragmentActivity.class));
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
    }

    public void showPlaceholder(View view) {
        startActivity(new Intent(this, PlaceholderActivity.class));
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
    }
}
