package com.hb.androidcontrols.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.view.loadsir.target.ConvertorActivity;
import com.hb.androidcontrols.view.loadsir.target.FragmentSingleActivity;
import com.hb.androidcontrols.view.loadsir.target.MultiFragmentActivity;
import com.hb.androidcontrols.view.loadsir.target.MultiFragmentWithViewPagerActivity;
import com.hb.androidcontrols.view.loadsir.target.NormalActivity;
import com.hb.androidcontrols.view.loadsir.target.PlaceholderActivity;
import com.hb.androidcontrols.view.loadsir.target.ViewTargetActivity;

public class EmptyScreensLoadSir_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_screens_load_sir_activity_main);
    }

    public void inActivity(View view) {
        startActivity(new Intent(this, NormalActivity.class));
    }

    public void inActivityWithConvertor(View view) {
        startActivity(new Intent(this, ConvertorActivity.class));
    }

    public void inFragment(View view) {
        startActivity(new Intent(this, FragmentSingleActivity.class));
    }

    public void inView(View view) {
        startActivity(new Intent(this, ViewTargetActivity.class));
    }

    public void inFragmentViewSirPager(View view) {
        startActivity(new Intent(this, MultiFragmentWithViewPagerActivity.class));
    }


    public void inFragmentMutil(View view) {
        startActivity(new Intent(this, MultiFragmentActivity.class));
    }

    public void showPlaceholder(View view) {
        startActivity(new Intent(this, PlaceholderActivity.class));
    }
}
