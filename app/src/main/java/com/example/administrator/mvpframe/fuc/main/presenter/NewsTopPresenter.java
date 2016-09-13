package com.example.administrator.mvpframe.fuc.main.presenter;

import com.example.administrator.mvpframe.common.base.basePresenter.BasePresenter;
import com.example.administrator.mvpframe.fuc.main.entity.NewsTopEntity;
import com.example.administrator.mvpframe.fuc.main.view.MainView;

import java.util.List;
import java.util.Map;

import rx.Observable;

public class NewsTopPresenter extends BasePresenter {

    private MainView mMainView;

    public NewsTopPresenter(MainView mainView) {
        mMainView = mainView;
    }

    @Override
    protected void onAllSuccess(Object o) {
        NewsTopEntity entity = (NewsTopEntity) o;
        if (null != entity) {
            if (null != entity.getResult()) {
                List<NewsTopEntity.ResultBean.DataBean> data = entity.getResult().getData();
                if (null != data && data.size() > 0) {
                    if (mode == RequestMode.FRIST) {
                        mMainView.showFinishDates(data);
                    } else if (mode == RequestMode.LOAD_MORE) {
                        mMainView.loadMoreFinish(data);
                    } else if (mode == RequestMode.REFRESH) {
                        mMainView.showRefreshFinish(data);
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
        return getService().getNewTopList(params);
    }

}
