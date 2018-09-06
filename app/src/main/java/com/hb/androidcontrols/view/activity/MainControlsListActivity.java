package com.hb.androidcontrols.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hb.androidcontrols.R;
import com.hb.androidcontrols.Utils.CommonUtils;
import com.hb.androidcontrols.adapter.ControlsAdapter;
import com.hb.androidcontrols.core.BaseActivity;
import com.hb.androidcontrols.model.ControlsModelView;

import java.util.List;

public class MainControlsListActivity extends BaseActivity implements ControlsAdapter.OnItemClickListener {

    private List<ControlsModelView> mControlsModelViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mControlsModelViewList = new Gson().fromJson(CommonUtils.loadJSONFromAsset(this), new TypeToken<List<ControlsModelView>>() {
        }.getType());

        RecyclerView controlsRecyclerView = findViewById(R.id.controlsRecyclerView);
        controlsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ControlsAdapter mControlsAdapter = new ControlsAdapter(this, mControlsModelViewList, this);
        controlsRecyclerView.setAdapter(mControlsAdapter);

    }

    @Override
    public void onItemClick(int position) {

        ControlsModelView mControlsModelView = mControlsModelViewList.get(position);

        if (mControlsModelView.data != null && mControlsModelView.data.size() > 0) {
            Intent mIntent = new Intent(MainControlsListActivity.this, CategoryListActivity.class);
            mIntent.putExtra("ControlData", mControlsModelViewList.get(position));
            startActivity(mIntent);
        } else {

        }

    }

}
