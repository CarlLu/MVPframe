package com.example.administrator.mvpframe.fuc.main.fragment;

import android.view.View;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseFragment.BaseListFragment;
import com.example.administrator.mvpframe.common.base.baseHolder.BaseViewHolder;
import com.example.administrator.mvpframe.fuc.main.activity.MainActivity;
import com.example.administrator.mvpframe.fuc.main.entity.NewsTopEntity;
import com.example.administrator.mvpframe.fuc.main.entity.WeiChatEntity;
import com.example.administrator.mvpframe.fuc.main.presenter.WeiChatPresenter;

import java.util.Map;

public class WeiChatFragment extends BaseListFragment<WeiChatPresenter, WeiChatEntity.ResultBean.ListBean> {

    @Override
    protected void fitDates(BaseViewHolder helper, WeiChatEntity.ResultBean.ListBean item) {
        helper.setText(R.id.tv_item_weiChat_title, item.getTitle()).
                setText(R.id.tv_item_weiChat_source, item.getSource()).
                setImageUrl(R.id.iv_item_weiChat_icon, mContext,item.getFirstImg());
    }

    @Override
    protected int getItemLayout() {
        return R.layout.item_wei_chat;
    }

    @Override
    protected WeiChatPresenter getChildPresenter() {
        return new WeiChatPresenter(this);
    }

    @Override
    protected Map<String, String> getRequestParams() {
        params.put("pno",PAGE+"");
        params.put("key","691c53aee2376cbc84ae397ff8ffe7fe");
        return params;
    }

    @Override
    protected void onItemClick(View v, int position) {
        WeiChatEntity.ResultBean.ListBean item = mAdapter.getItem(position);

        MainActivity activity = (MainActivity) mContext;
        if(null != activity){
            activity.toDetail(item.getUrl());
        }
    }
}
