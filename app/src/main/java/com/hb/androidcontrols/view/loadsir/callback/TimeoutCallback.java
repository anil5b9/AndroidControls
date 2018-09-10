package com.hb.androidcontrols.view.loadsir.callback;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.hb.androidcontrols.R;
import com.kingja.loadsir.callback.Callback;

/**
 * Description:TODO
 * Create Time:2017/9/2 16:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class TimeoutCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.empty_screens_load_sir_layout_timeout;
    }

    @Override
    protected boolean onRetry(Context context, View view) {
        Toast.makeText(context.getApplicationContext(), "Connecting to the network again!", Toast.LENGTH_SHORT).show();
        return false;
    }
}
