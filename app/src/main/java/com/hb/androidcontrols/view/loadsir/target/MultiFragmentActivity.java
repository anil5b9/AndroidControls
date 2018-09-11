package com.hb.androidcontrols.view.loadsir.target;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.core.BaseActivity;

/**
 * Description:TODO
 * Create Time:2017/9/4 10:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class MultiFragmentActivity extends BaseActivity {
    private static final String TAG = "FragmentSingleActivity";
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_screens_load_sir_activity_fragment_mutil);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, fragmentA).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, fragmentB).commit();
        getSupportFragmentManager().beginTransaction().show(fragmentA).hide(fragmentB).commit();

        updateTabBar("Multiple Fragment");

    }

    private void updateTabBar(String title) {
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView txtScreenTitle = findViewById(R.id.txtScreenTitle);
        txtScreenTitle.setText(title);
    }


    public void showFragmentA(View view) {
        getSupportFragmentManager().beginTransaction().show(fragmentA).hide(fragmentB).commit();
    }

    public void showFragmentB(View view) {
        getSupportFragmentManager().beginTransaction().show(fragmentB).hide(fragmentA).commit();
    }
}
