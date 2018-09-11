package com.hb.androidcontrols.view.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.TextView;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.core.BaseActivity;
import com.hb.androidcontrols.model.ControlsModelView;
import com.santalu.emptyview.EmptyView;

/**
 * Created by santalu on 09/08/2017.
 */

public class EmptyViewActivity extends BaseActivity {

    private SwipeRefreshLayout refreshLayout;
    private EmptyView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_view_activity);
        refreshLayout = findViewById(R.id.refresh_layout);
        emptyView = findViewById(R.id.empty_view);
        updateTabBar();
        showLoading();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                showLoading();
            }
        });
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

    private void showError() {
        emptyView.error()
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showLoading();
                    }
                })
                .show();
    }

    private void showLoading() {
        refreshLayout.setRefreshing(false);
        emptyView.showLoading();
        emptyView.postDelayed(new Runnable() {
            @Override
            public void run() {
                showError();
            }
        }, 2000);
    }

}
