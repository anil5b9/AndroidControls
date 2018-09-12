package com.hb.androidcontrols.view.calenderview.pager;

import android.support.v7.widget.LinearLayoutManager;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.view.calenderview.Article;
import com.hb.androidcontrols.view.calenderview.ArticleAdapter;
import com.hb.androidcontrols.view.calenderview.base.fragment.BaseFragment;
import com.hb.androidcontrols.view.calenderview.group.GroupItemDecoration;
import com.hb.androidcontrols.view.calenderview.group.GroupRecyclerView;

public class PagerFragment extends BaseFragment {

    private GroupRecyclerView mRecyclerView;


    public static PagerFragment newInstance() {
        return new PagerFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.h_calender_view_fragment_pager;
    }

    @Override
    protected void initView() {
        mRecyclerView = (GroupRecyclerView) mRootView.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new GroupItemDecoration<String, Article>());
        mRecyclerView.setAdapter(new ArticleAdapter(mContext));
        mRecyclerView.notifyDataSetChanged();
    }

    @Override
    protected void initData() {

    }

    public boolean isScrollTop() {
        return mRecyclerView != null && mRecyclerView.computeVerticalScrollOffset() == 0;
    }
}
