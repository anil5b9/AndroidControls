package com.hb.androidcontrols.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hb.androidcontrols.R;
import com.hb.androidcontrols.model.ControlsModelView;

import java.util.List;

public class ControlsAdapter extends RecyclerView.Adapter<ControlsAdapter.ControlsViewHolder> {

    private Context mContext;
    private List<ControlsModelView> mControlsModelViewArrayList;
    private OnItemClickListener mOnItemClickListener;

    public ControlsAdapter(Context mContext,
                           List<ControlsModelView> mControlsModelViewArrayList,
                           OnItemClickListener mOnItemClickListener) {
        this.mContext = mContext;
        this.mControlsModelViewArrayList = mControlsModelViewArrayList;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public ControlsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.controls_item_view, parent, false);
        return new ControlsViewHolder(view, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ControlsViewHolder holder, int position) {
        holder.txtControlName.setText(mControlsModelViewArrayList.get(position).title);
    }

    @Override
    public int getItemCount() {
        return mControlsModelViewArrayList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class ControlsViewHolder extends RecyclerView.ViewHolder {

        TextView txtControlName;

        public ControlsViewHolder(View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);
            txtControlName = itemView.findViewById(R.id.txtControlName);

            itemView.findViewById(R.id.mainItemView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }

    }

}