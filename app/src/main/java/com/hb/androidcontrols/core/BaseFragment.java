package com.hb.androidcontrols.core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public class BaseFragment extends Fragment {

    public BaseActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (BaseActivity) activity;
    }

    public void push(BaseFragment fragment, Boolean addBackStack, Boolean animation) {
        mActivity.push(fragment, addBackStack, animation);
    }

    public void popAll() {
        mActivity.popAll();
    }

    public void popUpTo(String className) {
        mActivity.popUpTo(className);
    }

    public void pop() {
        mActivity.pop();
    }

    @Override
    public void onResume() {
        super.onResume();
        mActivity.setCurrentFragment(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity.setCurrentFragment(this);
    }

}
