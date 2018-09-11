package com.hb.androidcontrols.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.core.BaseActivity;
import com.hb.androidcontrols.model.ControlsModelView;
import com.wang.avi.AVLoadingIndicatorView;

public class AVLoadingIndicatorViewActivity extends BaseActivity {

    private static final String[] INDICATORS = new String[]{
            "BallPulseIndicator",
            "BallGridPulseIndicator",
            "BallClipRotateIndicator",
            "BallClipRotatePulseIndicator",
            "SquareSpinIndicator",
            "BallClipRotateMultipleIndicator",
            "BallPulseRiseIndicator",
            "BallRotateIndicator",
            "CubeTransitionIndicator",
            "BallZigZagIndicator",
            "BallZigZagDeflectIndicator",
            "BallTrianglePathIndicator",
            "BallScaleIndicator",
            "LineScaleIndicator",
            "LineScalePartyIndicator",
            "BallScaleMultipleIndicator",
            "BallPulseSyncIndicator",
            "BallBeatIndicator",
            "LineScalePulseOutIndicator",
            "LineScalePulseOutRapidIndicator",
            "BallScaleRippleIndicator",
            "BallScaleRippleMultipleIndicator",
            "BallSpinFadeLoaderIndicator",
            "LineSpinFadeLoaderIndicator",
            "TriangleSkewSpinIndicator",
            "PacmanIndicator",
            "BallGridBeatIndicator",
            "SemiCircleSpinIndicator",
            "com.wang.avi.sample.MyCustomIndicator"
    };
    private RecyclerView mAVLoadingIndicatorRecycler;
    private ControlsModelView controlsModelView;

    private RelativeLayout detailsView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avl_loading_indicator_activity);

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        controlsModelView = (ControlsModelView) getIntent().getSerializableExtra("ControlData");

        TextView txtScreenTitle = findViewById(R.id.txtScreenTitle);
        txtScreenTitle.setText(controlsModelView.title);

        detailsView = findViewById(R.id.detailsView);

        mAVLoadingIndicatorRecycler = findViewById(R.id.AVLoadingIndicatorRecycler);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        mAVLoadingIndicatorRecycler.setLayoutManager(layoutManager);
        mAVLoadingIndicatorRecycler.setAdapter(new RecyclerView.Adapter<IndicatorHolder>() {
            @Override
            public IndicatorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView = getLayoutInflater().inflate(R.layout.avl_loading_indicator_item, parent, false);
                return new IndicatorHolder(itemView);
            }

            @Override
            public void onBindViewHolder(IndicatorHolder holder, final int position) {
                holder.indicatorView.setIndicator(INDICATORS[position]);
                holder.itemLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      /*  Intent intent = new Intent(AVLoadingIndicatorViewActivity.this, AVLoadingIndicatorActivity.class);
                        intent.putExtra("indicator", INDICATORS[position]);
                        startActivity(intent);*/
                        detailsView.removeAllViews();
                        AVLoadingIndicatorView mAvLoadingIndicatorView = new AVLoadingIndicatorView(AVLoadingIndicatorViewActivity.this, null, 0, R.style.AVLoadingIndicatorView_Large);
                        RelativeLayout.LayoutParams mLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        mLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                        mAvLoadingIndicatorView.setLayoutParams(mLayoutParams);
                        detailsView.addView(mAvLoadingIndicatorView);
                        mAvLoadingIndicatorView.setIndicator(INDICATORS[position]);
                        mAvLoadingIndicatorView.show();
                        detailsView.setVisibility(View.VISIBLE);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return INDICATORS.length;
            }
        });

    }

    final static class IndicatorHolder extends RecyclerView.ViewHolder {

        public AVLoadingIndicatorView indicatorView;
        public View itemLayout;

        public IndicatorHolder(View itemView) {
            super(itemView);
            itemLayout = itemView.findViewById(R.id.itemLayout);
            indicatorView = itemView.findViewById(R.id.indicator);
        }
    }

    @Override
    public void onBackPressed() {
        if (detailsView.getVisibility() == View.VISIBLE) {
            detailsView.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

}
