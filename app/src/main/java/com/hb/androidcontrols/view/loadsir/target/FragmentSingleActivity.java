package com.hb.androidcontrols.view.loadsir.target;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hb.androidcontrols.R;

/**
 * Description:TODO
 * Create Time:2017/9/4 10:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class FragmentSingleActivity extends AppCompatActivity {
    private static final String TAG = "FragmentSingleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_screens_load_sir_activity_fragment);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, new NormalFragment()).commit();

    }


}
