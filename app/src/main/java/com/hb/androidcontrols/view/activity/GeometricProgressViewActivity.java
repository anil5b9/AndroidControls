package com.hb.androidcontrols.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.core.BaseActivity;
import com.hb.androidcontrols.model.ControlsModelView;

/**
 * Created by Jack Wang on 2016/8/5.
 */

public class GeometricProgressViewActivity extends BaseActivity {

    private ControlsModelView controlsModelView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geometric_progress_view_activity);

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        controlsModelView = (ControlsModelView) getIntent().getSerializableExtra("ControlData");

        TextView txtScreenTitle = findViewById(R.id.txtScreenTitle);
        txtScreenTitle.setText(controlsModelView.title);
    }

}