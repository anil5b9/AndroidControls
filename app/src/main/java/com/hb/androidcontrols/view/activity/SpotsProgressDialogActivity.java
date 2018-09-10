package com.hb.androidcontrols.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.core.BaseActivity;
import com.hb.androidcontrols.model.ControlsModelView;

import dmax.dialog.SpotsDialog;

/**
 * Created by Jack Wang on 2016/8/5.
 */

public class SpotsProgressDialogActivity extends BaseActivity implements View.OnClickListener {

    private ControlsModelView controlsModelView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spots_progress_dialog_activity);

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        controlsModelView = (ControlsModelView) getIntent().getSerializableExtra("ControlData");

        TextView txtScreenTitle = findViewById(R.id.txtScreenTitle);
        txtScreenTitle.setText(controlsModelView.title);

        findViewById(android.R.id.button1).setOnClickListener(this);
        findViewById(android.R.id.button2).setOnClickListener(this);
        findViewById(android.R.id.button3).setOnClickListener(this);
        findViewById(android.R.id.closeButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case android.R.id.button1:
                new SpotsDialog.Builder()
                        .setContext(this)
                        .build()
                        .show();
                break;

            case android.R.id.button2:
                new SpotsDialog.Builder()
                        .setContext(this)
                        .setTheme(R.style.Custom)
                        .build()
                        .show();
                break;

            case android.R.id.button3:
                new SpotsDialog.Builder()
                        .setContext(this)
                        .setMessage("Custom message")
                        .build()
                        .show();
                break;

            case android.R.id.closeButton:
                new SpotsDialog.Builder()
                        .setContext(this)
                        .setTheme(R.style.Custom)
                        .setMessage(R.string.app_name)
                        .build()
                        .show();
                break;

        }

    }

}