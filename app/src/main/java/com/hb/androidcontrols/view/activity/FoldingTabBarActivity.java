package com.hb.androidcontrols.view.activity;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.core.BaseActivity;
import com.hb.androidcontrols.model.ControlsModelView;
import com.srx.widget.TabBarView;
import com.srx.widget.TabBarView.OnTabBarClickListener;

public class FoldingTabBarActivity extends BaseActivity {

    public static final String TAG = "FoldingTabBarActivity";
    private TabBarView tabBarAnimView;
    private ImageView imageView;
    private Drawable drawable[] = new Drawable[5];
    private View groundView;
    private int[] location;
    private int pageTable = 0;
    private int lastPageTable = -1;
    private float maxSize = 0;
    private int initY = 0;
    private long durationMillis = 500;
    private ControlsModelView controlsModelView;
    private OnTabBarClickListener onTabBarClickListener = new OnTabBarClickListener() {

        @Override
        public void onMainBtnsClick(int position, int[] clickLocation) {
            if (lastPageTable == position)
                return;
            if (position < 5) {
                clickLocation[1] = clickLocation[1] - initY;
                location = clickLocation;
                pageTable = position;
                groundView.setVisibility(View.VISIBLE);
                groundView.startAnimation(animation);
            }
            lastPageTable = position;
        }

        @Override
        public void onMainBtnsClick(int position) {
            imageView.setImageDrawable(drawable[position]);
            Log.e(TAG, "center--->" + position);
        }

        @Override
        public void onLeftBtnClick(int page) {
            Log.e(TAG, "left--->" + page);
        }

        @Override
        public void onRightBtnClick(int page) {
            Log.e(TAG, "right--->" + page);
        }

    };
    private Animation animation = new Animation() {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            float size = (maxSize - 1) * interpolatedTime + 1;
            Matrix matrix = t.getMatrix();
            matrix.postTranslate(location[0] - groundView.getWidth() / 2, location[1] - groundView.getHeight() / 2);
            matrix.postScale(size, size, location[0], location[1]);
            if (interpolatedTime == 1) {
                groundView.setVisibility(View.INVISIBLE);
                onTabBarClickListener.onMainBtnsClick(pageTable);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.folding_tabbar_activity);

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        controlsModelView = (ControlsModelView) getIntent().getSerializableExtra("ControlData");

        TextView txtScreenTitle = findViewById(R.id.txtScreenTitle);
        txtScreenTitle.setText(controlsModelView.title);

        initView();
        initListener();
        initDrawable();
        initTabBarAnimView();
        onTabBarClickListener.onMainBtnsClick(pageTable);
    }

    private void initView() {
        groundView = findViewById(R.id.groundView);
        imageView = findViewById(R.id.imageView);
        tabBarAnimView = findViewById(R.id.tabBarAnimView);
    }

    private void initListener() {
        tabBarAnimView.setOnTabBarClickListener(onTabBarClickListener);
        animation.setDuration(durationMillis);
        animation.setInterpolator(new DecelerateInterpolator());
    }

    private void initDrawable() {
        drawable[0] = getResources().getDrawable(R.drawable.folding_tabbar_page0);
        drawable[1] = getResources().getDrawable(R.drawable.folding_tabbar_page1);
        drawable[2] = getResources().getDrawable(R.drawable.folding_tabbar_page1);
        drawable[3] = getResources().getDrawable(R.drawable.folding_tabbar_page2);
        drawable[4] = getResources().getDrawable(R.drawable.folding_tabbar_page3);
    }

    private void initTabBarAnimView() {
        tabBarAnimView.setMainBitmap(R.drawable.folding_tabbar_plus_icon);
        tabBarAnimView.bindBtnsForPage(0, R.drawable.folding_tabbar_nearby_icon, R.drawable.folding_tabbar_search_icon, R.drawable.folding_tabbar_chats_icon);
        tabBarAnimView.bindBtnsForPage(1, R.drawable.folding_tabbar_profile_icon, R.drawable.folding_tabbar_edit_icon, 0);
        tabBarAnimView.bindBtnsForPage(2, R.drawable.folding_tabbar_chats_icon, R.drawable.folding_tabbar_search_icon, 0);
        tabBarAnimView.bindBtnsForPage(3, R.drawable.folding_tabbar_settings_icon, 0, R.drawable.folding_tabbar_edit_icon);
        tabBarAnimView.initializePage(0);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        int local[] = new int[2];
        groundView.getLocationOnScreen(local);
        initY = local[1];
        maxSize = 2f * (float) (((ViewGroup) groundView.getParent()).getHeight() / groundView.getHeight());
        super.onWindowFocusChanged(hasFocus);
    }
}
