package com.example.administrator.mvpframe.common.base.baseFragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseAdapter.BaseQuickAdapter;
import com.example.administrator.mvpframe.common.base.baseHolder.BaseViewHolder;
import com.example.administrator.mvpframe.common.base.basePresenter.BasePresenter;
import com.example.administrator.mvpframe.fuc.main.view.MainView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public abstract class BaseListFragment<T extends BasePresenter, K> extends
        BaseFragment<T> implements
        MainView<K> {

    @Bind(R.id.recycleView) RecyclerView mRecyclerView;

    protected BaseQuickAdapter<K> mAdapter;

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_main_common;
    }

    @Override
    protected void baseInit() {
        showLoading();
        mPresenter.requestDate(null);
    }

    @Override
    protected View getLoadingTargetView() {
        return mRecyclerView;
    }


    @Override
    public void showFinishDates(List<K> dates) {
        refreshView();
        mAdapter = new BaseQuickAdapter<K>(mContext, getItemLayout(), dates) {
            @Override
            protected void convert(BaseViewHolder helper, K item) {
                fitDates(helper, item);
            }
        };

        if (mRecyclerView == null) {
            mRecyclerView = ButterKnife.findById(mRootView, R.id.recycleView);
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnRecyclerViewItemClickListener(
                (View v, int position) -> onItemClick(v, position));
    }

    protected void onItemClick(View v, int position) {

    }

    protected abstract void fitDates(BaseViewHolder helper, K item);

    protected abstract int getItemLayout();
}
