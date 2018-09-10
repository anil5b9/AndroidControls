package com.hb.androidcontrols.core;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.Utils.CommonUtils;

public class BaseActivity extends AppCompatActivity {

    public BaseFragment currentRunningFragment;

    public void setCurrentFragment(BaseFragment mBaseFragment) {
        this.currentRunningFragment = mBaseFragment;
    }

    public void push(BaseFragment fragment, boolean needToAddBackStack, boolean needAnimation) {
        CommonUtils.hideProgress();
        CommonUtils.hideKeyboard(this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (needAnimation) {
            ft.setCustomAnimations(R.anim.fragment_slide_in_right, R.anim.fragment_slide_out_left,
                    R.anim.fragment_slide_in_left, R.anim.fragment_slide_out_right);
        }
        if (needToAddBackStack) {
            ft.replace(R.id.homeFrameLayout, fragment).addToBackStack(fragment.getClass().getSimpleName()).commitAllowingStateLoss();
        } else {
            ft.replace(R.id.homeFrameLayout, fragment).commitAllowingStateLoss();
        }
    }

    public void pop() {
        CommonUtils.hideProgress();
        CommonUtils.hideKeyboard(this);
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        } else finish();
    }

    public void popUpTo(String upToName) {
        CommonUtils.hideProgress();
        CommonUtils.hideKeyboard(this);
        getSupportFragmentManager().popBackStackImmediate(upToName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void popAll() {
        CommonUtils.hideProgress();
        CommonUtils.hideKeyboard(this);
        getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

}
