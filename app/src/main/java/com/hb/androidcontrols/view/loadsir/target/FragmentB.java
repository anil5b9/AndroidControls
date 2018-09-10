package com.hb.androidcontrols.view.loadsir.target;

import android.view.View;
import android.widget.Toast;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.view.loadsir.PostUtil;
import com.hb.androidcontrols.view.loadsir.base.BaseFragment;
import com.hb.androidcontrols.view.loadsir.callback.EmptyCallback;
import com.hb.androidcontrols.view.loadsir.callback.LoadingCallback;

/**
 * Description:TODO
 * Create Time:2017/9/5 13:27
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FragmentB extends BaseFragment {

    @Override
    protected int onCreateFragmentView() {
        return R.layout.empty_screens_load_sir_fragment_b_content;
    }

    @Override
    protected void loadNet() {
        // do net here...
        // call back
        PostUtil.postCallbackDelayed(mBaseLoadService, EmptyCallback.class);
    }

    @Override
    protected void onNetReload(View v) {
        Toast.makeText(getContext(), "reload in Fragment B", Toast.LENGTH_SHORT).show();
        mBaseLoadService.showCallback(LoadingCallback.class);
        //do retry logic...

        //callback
        PostUtil.postSuccessDelayed(mBaseLoadService);
    }
}