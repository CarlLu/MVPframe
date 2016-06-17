package com.example.administrator.mvpframe.fuc.main.fragment;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseFragment.BaseListFragment;
import com.example.administrator.mvpframe.common.base.baseHolder.BaseViewHolder;
import com.example.administrator.mvpframe.fuc.main.entity.NewsEntity;
import com.example.administrator.mvpframe.fuc.main.presenter.MsgPresenter;
import com.example.administrator.mvpframe.common.util.DateUtil;

public class MsgFragment extends BaseListFragment<MsgPresenter, NewsEntity.PagesEntity.PageEntity> {


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
}
