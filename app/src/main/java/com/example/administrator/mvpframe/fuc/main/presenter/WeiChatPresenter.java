package com.example.administrator.mvpframe.fuc.main.presenter;

import com.example.administrator.mvpframe.common.base.basePresenter.BasePresenter;
import com.example.administrator.mvpframe.fuc.main.entity.WeiChatEntity;
import com.example.administrator.mvpframe.fuc.main.view.MainView;

import java.util.List;
import java.util.Map;

import rx.Observable;

public class WeiChatPresenter extends BasePresenter {

    private MainView mMainView;

    public WeiChatPresenter(MainView mainView) {
        mMainView = mainView;
    }

    @Override
    protected void onAllSuccess(Object o) {
        WeiChatEntity entity = (WeiChatEntity) o;
        if (null != entity) {
            if (null != entity.getResult()) {
                List<WeiChatEntity.ResultBean.ListBean> list = entity.getResult().getList();
                if (null!= list && list.size() > 0) {
                    if (mode == RequestMode.FRIST) {
                        mMainView.showFinishDates(list);
                    } else if (mode == RequestMode.LOAD_MORE) {
                        mMainView.loadMoreFinish(list);
                    } else if (mode == RequestMode.REFRESH) {
                        mMainView.showRefreshFinish(list);
                    }
                } else {
                    if (mode == RequestMode.LOAD_MORE) {
                        mMainView.hasNoMoreDate();
                    } else {
                        mMainView.showEmptyView(null);
                    }
                }
            } else {
                mMainView.showEmptyView(null);
            }
        } else {
            mMainView.showEmptyView(null);
        }
    }

    @Override
    protected void onFail() {
        if (mode == RequestMode.FRIST) {
            mMainView.showNetError();
        } else {
            mMainView.showToastError();
        }
    }

    @Override
    protected Observable getObservable(Map<String, String> params) {
        return getService().getWeiChatList(params);
    }
}
