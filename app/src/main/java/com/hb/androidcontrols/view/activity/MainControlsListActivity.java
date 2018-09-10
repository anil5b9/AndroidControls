package com.hb.androidcontrols.view.activity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hb.androidcontrols.R;
import com.hb.androidcontrols.Utils.CommonUtils;
import com.hb.androidcontrols.core.BaseActivity;
import com.hb.androidcontrols.model.ControlsModelView;
import com.hb.androidcontrols.view.fragments.FragmentControlsList;

public class MainControlsListActivity extends BaseActivity {

    private ControlsModelView mControlsModelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mControlsModelView = new Gson().fromJson(CommonUtils.loadJSONFromAsset(this), new TypeToken<ControlsModelView>() {
        }.getType());

        FragmentControlsList mFragmentControlsList = new FragmentControlsList();
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("ControlData", mControlsModelView);
        mFragmentControlsList.setArguments(mBundle);
        push(mFragmentControlsList, false, false);

    }

}