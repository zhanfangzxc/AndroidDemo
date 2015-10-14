package com.zss.girdwithheaderdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zhaoshanshan on 15/10/12.
 */
public class TextViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextView;

    public TextViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.text);
    }
}
