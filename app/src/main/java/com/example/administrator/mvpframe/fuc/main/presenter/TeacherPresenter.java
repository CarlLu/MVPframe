package com.example.administrator.mvpframe.fuc.main.presenter;

import com.example.administrator.mvpframe.common.base.basePresenter.BasePresenter;
import com.example.administrator.mvpframe.fuc.main.entity.MainTeacherEntity;
import com.example.administrator.mvpframe.fuc.main.view.MainView;

import java.util.Map;

import rx.Observable;

public class TeacherPresenter extends BasePresenter {

    private MainView mMainView;

    public TeacherPresenter(MainView mainView) {
        mMainView = mainView;
    }

    @Override
    protected void onAllSuccess(Object o) {
        MainTeacherEntity entity = (MainTeacherEntity) o;
        if (null != entity.getTeacher() && entity.getTeacher().size() > 0) {
            if (mode == RequestMode.FRIST) {
                mMainView.showFinishDates(entity.getTeacher());
            } else if (mode == RequestMode.LOAD_MORE) {
                mMainView.loadMoreFinish(entity.getTeacher());
            } else if (mode == RequestMode.REFRESH) {
                mMainView.showRefreshFinish(entity.getTeacher());
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
        if(mode == RequestMode.FRIST){
            mMainView.showNetError();
        }else{
            mMainView.showToastError();
        }
    }

    @Override
    protected Observable getObservable(Map<String, String> params) {
        return getService().getTeacherList(params);
    }

}
