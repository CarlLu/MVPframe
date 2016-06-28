package com.example.administrator.mvpframe.common.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class RefreshRecylerView extends SwipeRefreshLayout {

    private RecyclerView mRecyclerView;

    public RefreshRecylerView(Context context) {
        this(context, null);
    }

    public RefreshRecylerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mRecyclerView = new RecyclerView(context);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        addView(mRecyclerView, params);

        setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public void setLayoutManager(RecyclerView.LayoutManager manager) {
        mRecyclerView.setLayoutManager(manager);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }
}
