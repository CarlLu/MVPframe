package com.example.administrator.mvpframe.fuc.main.fragment;

import android.view.View;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseFragment.BaseListFragment;
import com.example.administrator.mvpframe.common.base.baseHolder.BaseViewHolder;
import com.example.administrator.mvpframe.fuc.main.activity.MainActivity;
import com.example.administrator.mvpframe.fuc.main.entity.NewsTopEntity;
import com.example.administrator.mvpframe.fuc.main.presenter.NewsTopPresenter;

import java.util.Map;

public class NewsTopFragment extends BaseListFragment<NewsTopPresenter, NewsTopEntity.ResultBean.DataBean> {

    @Override
    protected int getItemLayout() {
        return R.layout.item_news_top;
    }

    @Override
    protected NewsTopPresenter getChildPresenter() {
        return new NewsTopPresenter(this);
    }


    @Override
    protected Map<String, String> getRequestParams() {
        params.put("key", "6e72ebfc6449ee2c8d538797890099ea");
        return params;
    }

    @Override
    protected void onItemClick(View v, int position) {
        NewsTopEntity.ResultBean.DataBean item = mAdapter.getItem(position);

        MainActivity activity = (MainActivity) mContext;
        if(null != activity){
            activity.toDetail(item.getUrl());
        }
    }

    @Override
    protected void fitDates(BaseViewHolder helper, NewsTopEntity.ResultBean.DataBean item) {
        helper.setText(R.id.tv_item_news_top_title, item.getTitle()).
                setText(R.id.tv_item_news_top_author_name, item.getAuthor_name()).
                setText(R.id.tv_item_news_top_type, item.getRealtype()).
                setText(R.id.tv_item_news_top_time, item.getDate()).
                setImageUrl(R.id.iv_item_news_top_icon_one, mContext, item.getThumbnail_pic_s()).
                setImageUrl(R.id.iv_item_news_top_icon_two, mContext, item.getThumbnail_pic_s02()).
                setImageUrl(R.id.iv_item_news_top_icon_three, mContext, item.getThumbnail_pic_s03());
    }

    @Override
    public void onLoadMore() {
        hasNoMoreDate();
    }
}
