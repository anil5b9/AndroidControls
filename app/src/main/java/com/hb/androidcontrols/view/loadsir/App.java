package com.hb.androidcontrols.view.loadsir;

import android.app.Application;

import com.hb.androidcontrols.view.loadsir.callback.CustomCallback;
import com.hb.androidcontrols.view.loadsir.callback.EmptyCallback;
import com.hb.androidcontrols.view.loadsir.callback.ErrorCallback;
import com.hb.androidcontrols.view.loadsir.callback.LoadingCallback;
import com.hb.androidcontrols.view.loadsir.callback.TimeoutCallback;
import com.kingja.loadsir.core.LoadSir;

/**
 * Description:TODO
 * Create Time:2017/9/3 14:02
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }
}
