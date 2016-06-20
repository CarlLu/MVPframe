package com.example.administrator.mvpframe.fuc.main.presenter;

import com.example.administrator.mvpframe.common.base.basePresenter.BasePresenter;
import com.example.administrator.mvpframe.fuc.main.entity.NewsEntity;
import com.example.administrator.mvpframe.fuc.main.view.MainView;

import java.util.Map;

import rx.Observable;

public class MsgPresenter extends BasePresenter {

    private MainView mMainView;

    public MsgPresenter(MainView mainView) {
        mMainView = mainView;
    }

    @Override
    protected void onSuccess(Object o) {
        NewsEntity entity = (NewsEntity) o;
        if (entity.getPages() != null) {
            if (entity.getPages().getPage() != null && entity.getPages().getPage().size() > 0) {
                mMainView.showFinishDates(entity.getPages().getPage());
            } else {
                mMainView.showEmptyView(null);
            }
        } else {
            mMainView.showEmptyView(null);
        }
    }

    @Override
    protected void onFail() {
        mMainView.showNetError();
    }

    @Override
    protected Observable getObservable(Map<String, String> params) {
        return getService().getNewsList("0", "0", "112", "1");
    }
}
