package com.example.administrator.mvpframe.fuc.main.presenter;

import com.example.administrator.mvpframe.common.base.basePresenter.BasePresenter;
import com.example.administrator.mvpframe.fuc.main.entity.EvaluateEntity;
import com.example.administrator.mvpframe.fuc.main.view.MainView;

import java.util.Map;

import rx.Observable;

public class EvaluatePresenter extends BasePresenter {

    private MainView mMainView;

    public EvaluatePresenter(MainView mainView) {
        mMainView = mainView;
    }

    @Override
    protected void onAllSuccess(Object o) {
        EvaluateEntity entity = (EvaluateEntity) o;
        if (null != entity.getScore() && entity.getScore().size() > 0) {
            if (mode == RequestMode.FRIST) {
                mMainView.showFinishDates(entity.getScore());
            } else if (mode == RequestMode.LOAD_MORE) {
                mMainView.loadMoreFinish(entity.getScore());
            } else if (mode == RequestMode.REFRESH) {
                mMainView.showRefreshFinish(entity.getScore());
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
        mMainView.showNetError();
    }

    @Override
    protected Observable getObservable(Map<String, String> params) {
        return getService().getEvaluateList(params);
    }
}
