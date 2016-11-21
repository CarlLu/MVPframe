package com.example.administrator.mvpframe.fuc.main.fragment;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseFragment.BaseListFragment;
import com.example.administrator.mvpframe.common.base.baseHolder.BaseViewHolder;
import com.example.administrator.mvpframe.fuc.main.entity.JokeEntity;
import com.example.administrator.mvpframe.fuc.main.presenter.JokePresenter;

import java.util.Map;

public class JokeFragment extends
        BaseListFragment<JokePresenter, JokeEntity.ResultBean.DataBean> {


    @Override
    protected Map<String, String> getRequestParams() {
        params.put("sort", "desc");
        params.put("page", PAGE + "");
        params.put("pagesize", "20");
        String time = System.currentTimeMillis() + "";
        params.put("time", time.substring(0,10));
        params.put("key", "7437bb737d4643bdb59dd1de688b5704");
        return params;
    }

    @Override
    protected void fitDates(BaseViewHolder helper, JokeEntity.ResultBean.DataBean item) {
        helper.setText(R.id.tv_item_joke_time, item.getUpdatetime()).
                setText(R.id.tv_item_joke_content, item.getContent());
    }

    @Override
    protected int getItemLayout() {
        return R.layout.item_joke;
    }

    @Override
    protected JokePresenter getChildPresenter() {
        return new JokePresenter(this);
    }

}
