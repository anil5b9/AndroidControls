package com.hb.androidcontrols.view.loadsir.target;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.view.loadsir.PostUtil;
import com.hb.androidcontrols.view.loadsir.callback.EmptyCallback;
import com.hb.androidcontrols.view.loadsir.callback.LoadingCallback;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;


/**
 * Description:TODO
 * Create Time:2017/9/4 10:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class NormalActivity extends AppCompatActivity {


    private LoadService loadService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_screens_load_sir_activity_content);
        // Your can change the callback on sub thread directly.
        loadService = LoadSir.getDefault().register(this, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                // Your can change the status out of Main thread.
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadService.showCallback(LoadingCallback.class);
                        //do retry logic...
                        SystemClock.sleep(500);
                        //callback
                        loadService.showSuccess();
                    }
                }).start();
            }
        });
        PostUtil.postCallbackDelayed(loadService, EmptyCallback.class);
    }

}
