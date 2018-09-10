package com.hb.androidcontrols.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.core.BaseActivity;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Jack Wang on 2016/8/5.
 */

public class AVLoadingIndicatorActivity extends BaseActivity {

    private AVLoadingIndicatorView avi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avl_loading_indicator_details_activity);

        String indicator = getIntent().getStringExtra("indicator");
        avi = findViewById(R.id.avi);
        avi.setIndicator(indicator);
    }

    public void hideClick(View view) {
        avi.hide();
    }

    public void showClick(View view) {
        avi.show();
    }
}