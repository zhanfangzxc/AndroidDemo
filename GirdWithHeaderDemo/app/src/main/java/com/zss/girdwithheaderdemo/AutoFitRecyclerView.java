package com.zss.girdwithheaderdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by zhaoshanshan on 15/10/13.
 */
public class AutoFitRecyclerView extends RecyclerView {
    private GridLayoutManager mGridLayoutManager;
    private int columnWidth = -1;

    public AutoFitRecyclerView(Context context) {
        super(context);
        init(context, null);
    }

    public AutoFitRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AutoFitRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] attrsArray = {android.R.attr.columnWidth};
            TypedArray array = context.obtainStyledAttributes(attrs, attrsArray);
            columnWidth = array.getDimensionPixelSize(0, -1);
            array.recycle();
        }
        mGridLayoutManager = new GridLayoutManager(getContext(), 1);
        setLayoutManager(mGridLayoutManager);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (columnWidth > 0) {
            int spanCount = Math.max(1, getMeasuredWidth() / columnWidth);
            mGridLayoutManager.setSpanCount(spanCount);
        }
    }
}
