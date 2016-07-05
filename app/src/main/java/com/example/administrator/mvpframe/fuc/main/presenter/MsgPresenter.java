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
    protected void onAllSuccess(Object o) {
        NewsEntity entity = (NewsEntity) o;
        if (entity.getPages() != null) {
            if (entity.getPages().getPage() != null && entity.getPages().getPage().size() > 0) {
                if (mode == RequestMode.FRIST) {
                    mMainView.showFinishDates(entity.getPages().getPage());
                } else if (mode == RequestMode.LOAD_MORE) {
                    mMainView.loadMoreFinish(entity.getPages().getPage());
                } else if (mode == RequestMode.REFRESH) {
                    mMainView.showRefreshFinish(entity.getPages().getPage());
                }
            } else {
                if (mode == RequestMode.LOAD_MORE) {
                    mMainView.hasNoMoreDate();
                } else {
                    mMainView.showEmptyView(null);
                }
            }
        } else {
            if (mode == RequestMode.LOAD_MORE) {
                mMainView.hasNoMoreDate();
            } else {
                mMainView.showEmptyView(null);
            }
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
        return getService().getNewsList(params);
    }
}
