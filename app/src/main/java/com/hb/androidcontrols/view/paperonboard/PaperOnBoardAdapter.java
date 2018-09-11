package com.hb.androidcontrols.view.paperonboard;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hb.androidcontrols.R;

import java.util.ArrayList;


/**
 * Created by Jaison
 */

public class PaperOnBoardAdapter extends PagerAdapter {

    ArrayList<PaperOnBoardItem> paperOnBoardItems = new ArrayList<>();
    private Context mContext;


    public PaperOnBoardAdapter(Context mContext, ArrayList<PaperOnBoardItem> items) {
        this.mContext = mContext;
        this.paperOnBoardItems = items;
    }

    @Override
    public int getCount() {
        return paperOnBoardItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.paper_on_board__item, container, false);

        PaperOnBoardItem item = paperOnBoardItems.get(position);

        ImageView imageView = itemView.findViewById(R.id.iv_onboard);
        imageView.setImageResource(item.getImageID());

        TextView tv_title = itemView.findViewById(R.id.tv_header);
        tv_title.setText(item.getTitle());

        TextView tv_content = itemView.findViewById(R.id.tv_desc);
        tv_content.setText(item.getDescription());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
