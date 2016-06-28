package com.example.administrator.mvpframe.fuc.main.fragment;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseFragment.BaseListFragment;
import com.example.administrator.mvpframe.common.base.baseHolder.BaseViewHolder;
import com.example.administrator.mvpframe.fuc.main.entity.NewsEntity;
import com.example.administrator.mvpframe.fuc.main.presenter.MsgPresenter;
import com.example.administrator.mvpframe.common.util.DateUtil;

import java.util.HashMap;
import java.util.Map;

public class MsgFragment extends BaseListFragment<MsgPresenter, NewsEntity.PagesEntity.PageEntity> {


    @Override
    protected void baseInit() {
        params = new HashMap<>();
        showLoading();
        setMapDates("1");
        mPresenter.requestDate(params);
    }

    @Override
    protected void fitDates(BaseViewHolder helper, NewsEntity.PagesEntity.PageEntity item) {
        helper.setText(R.id.tv_center_news_item_title, item.getTitle()).setText(
                R.id.tv_center_news_item_content, item.getContent()).setText(
                R.id.tv_center_news_item_time,
                DateUtil.formatMills(item.getCreateDate()));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.center_news_item;
    }

    @Override
    protected MsgPresenter getChildPresenter() {
        return new MsgPresenter(this);
    }

    @Override
    public void onLoadMoreRequested() {
        PAGE = PAGE + 1;
        setMapDates(PAGE+"");
        mPresenter.loadMore(params);
    }

    @Override
    protected Map<String, String> getRequestParams() {
        return setMapDates("1");
    }

    @Override
    public void onRefresh() {
        setMapDates("1");
        mPresenter.onRefresh(params);
    }

    private Map<String, String> setMapDates(String page) {
        params.put("messageType", "0");
        params.put("loginType", "0");
        params.put("loginId", "112");
        params.put("pageNum", page);
        return params;
    }
}
