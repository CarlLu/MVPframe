package com.example.administrator.mvpframe.common.base.baseAdapter.listener;

import android.support.v7.widget.RecyclerView;

public interface OnItemDragListener {
    void onItemDragStart(RecyclerView.ViewHolder viewHolder);
    void onItemDragMoving(RecyclerView.ViewHolder source, RecyclerView.ViewHolder target);
    void onItemDragEnd(RecyclerView.ViewHolder viewHolder);
}
