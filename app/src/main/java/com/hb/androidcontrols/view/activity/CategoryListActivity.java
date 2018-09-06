package com.hb.androidcontrols.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.adapter.ControlsAdapter;
import com.hb.androidcontrols.core.BaseActivity;
import com.hb.androidcontrols.model.ControlsModelView;

import java.util.List;

public class CategoryListActivity extends BaseActivity implements ControlsAdapter.OnItemClickListener {

    private ControlsModelView controlsModelView;
    private List<ControlsModelView> mControlsModelViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controlsModelView = (ControlsModelView) getIntent().getSerializableExtra("ControlData");

        TextView txtScreenTitle = findViewById(R.id.txtScreenTitle);
        txtScreenTitle.setText(controlsModelView.title);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setVisibility(View.VISIBLE);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mControlsModelViewList = controlsModelView.data;

        RecyclerView controlsRecyclerView = findViewById(R.id.controlsRecyclerView);
        controlsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ControlsAdapter mControlsAdapter = new ControlsAdapter(this, mControlsModelViewList, this);
        controlsRecyclerView.setAdapter(mControlsAdapter);

    }

    @Override
    public void onItemClick(int position) {
        ControlsModelView mControlsModelView = mControlsModelViewList.get(position);

        if (mControlsModelView.data != null && mControlsModelView.data.size() > 0) {
            Intent mIntent = new Intent(CategoryListActivity.this, CategoryListActivity.class);
            mIntent.putExtra("ControlData", mControlsModelViewList.get(position));
            startActivity(mIntent);
        } else {

            switch (mControlsModelView.screenName) {

                case "NVActivityIndicatorVc":
                    Intent mIntent = new Intent(CategoryListActivity.this, AVLoadingIndicatorViewActivity.class);
                    mIntent.putExtra("ControlData", mControlsModelViewList.get(position));
                    startActivity(mIntent);
                    break;

            }

        }

    }

}
