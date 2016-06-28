package com.example.administrator.mvpframe.common.base.baseFragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseAdapter.BaseQuickAdapter;
import com.example.administrator.mvpframe.common.base.baseHolder.BaseViewHolder;
import com.example.administrator.mvpframe.common.base.basePresenter.BasePresenter;
import com.example.administrator.mvpframe.common.widget.RefreshRecylerView;
import com.example.administrator.mvpframe.fuc.main.view.MainView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;


public abstract class BaseListFragment<T extends BasePresenter, K> extends
        BaseFragment<T> implements
        MainView<K>, BaseQuickAdapter.RequestLoadMoreListener,
        SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recycleView) RefreshRecylerView mRecyclerView;

    protected BaseQuickAdapter<K> mAdapter;

    protected Map<String, String> params;

    protected int PAGE = 1;

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_main_common;
    }

    @Override
    protected void baseInit() {
        params = new HashMap<>();
        showLoading();
        setMapDates();
        mPresenter.requestDate(params);
    }

    private Map<String, String> setMapDates() {
        params.put("mechanismId", "1");
        params.put("pageNum", "1");
        return params;
    }

    @Override
    protected Map<String, String> getRequestParams() {
        return setMapDates();
    }

    @Override
    protected View getLoadingTargetView() {
        return mRecyclerView;
    }


    @Override
    public void showFinishDates(List<K> dates) {
        refreshView();
        if (mAdapter == null) {
            mAdapter = new BaseQuickAdapter<K>(getItemLayout(), dates) {
                @Override
                protected void convert(BaseViewHolder helper, K item) {
                    fitDates(helper, item);
                }
            };

            if (mRecyclerView == null) {
                mRecyclerView = ButterKnife.findById(mRootView, R.id.recycleView);
            }

            mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            mAdapter.openLoadAnimation();
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.setOnLoadMoreListener(this);
            mAdapter.openLoadMore(8, true);

            mRecyclerView.setOnRefreshListener(this);
        } else {
            mAdapter.notifyDataSetChanged();
        }
        mAdapter.setOnRecyclerViewItemClickListener(
                (View v, int position) -> onItemClick(v, position));
    }

    protected void onItemClick(View v, int position) {

    }

    protected abstract void fitDates(BaseViewHolder helper, K item);

    protected abstract int getItemLayout();

    @Override
    public void onLoadMoreRequested() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void hasNoMoreDate() {
        mAdapter.notifyDataChangedAfterLoadMore(false);
        View view = View.inflate(mContext, R.layout.not_loading, null);
        mAdapter.addFooterView(view);
    }

    @Override
    public void loadMoreFinish(List dates) {
        mAdapter.notifyDataChangedAfterLoadMore(dates, true);
    }

    @Override
    public void showRefreshFinish(List score) {
        if(mRecyclerView == null){
            mRecyclerView = ButterKnife.findById(mRootView, R.id.recycleView);
        }
        mRecyclerView.setRefreshing(false);
        mAdapter.setNewData(score);
    }
}
