package com.hb.androidcontrols.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.adapter.ControlsAdapter;
import com.hb.androidcontrols.core.BaseFragment;
import com.hb.androidcontrols.model.ControlsModelView;

import java.util.List;

public class FragmentControlsList extends BaseFragment implements ControlsAdapter.OnItemClickListener {

    private ControlsModelView mControlsModelView;
    private List<ControlsModelView> mControlsModelViewArrayList;

    private View mainView;

    private RecyclerView controlsRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mainView == null) {
            mainView = LayoutInflater.from(mActivity).inflate(R.layout.frament_controls_list, container, false);
        } else {
            container.removeView(mainView);
        }
        return mainView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (controlsRecyclerView == null) {

            // get data from bundle
            mControlsModelView = (ControlsModelView) getArguments().getSerializable("ControlData");
            mControlsModelViewArrayList = mControlsModelView.data;

            // Initialize views and set data
            TextView txtScreenTitle = mainView.findViewById(R.id.txtScreenTitle);
            txtScreenTitle.setText(mControlsModelView.title);

            ImageButton btnBack = mainView.findViewById(R.id.btnBack);
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mActivity.pop();
                }
            });

            if (mControlsModelView.title.equalsIgnoreCase("Controls")) {
                btnBack.setVisibility(View.GONE);
            } else {
                btnBack.setVisibility(View.VISIBLE);
            }

            // set adapter
            controlsRecyclerView = mainView.findViewById(R.id.controlsRecyclerView);
            controlsRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
            ControlsAdapter mControlsAdapter = new ControlsAdapter(mActivity, mControlsModelViewArrayList, this);
            controlsRecyclerView.setAdapter(mControlsAdapter);
        }
    }

    @Override
    public void onItemClick(int position) {

        ControlsModelView mControlsModelView = mControlsModelViewArrayList.get(position);

        if (mControlsModelView.data != null && mControlsModelView.data.size() > 0) {
            FragmentControlsList mFragmentControlsList = new FragmentControlsList();
            Bundle mBundle = new Bundle();
            mBundle.putSerializable("ControlData", mControlsModelView);
            mFragmentControlsList.setArguments(mBundle);
            push(mFragmentControlsList, true, true);
        } else {

            try {
                Class activityClass = Class.forName("com.hb.androidcontrols.view.activity." + mControlsModelView.screenName);
                Intent mIntent = new Intent(mActivity, activityClass);
                mIntent.putExtra("ControlData", mControlsModelView);
                startActivity(mIntent);
                mActivity.overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

    }

}
