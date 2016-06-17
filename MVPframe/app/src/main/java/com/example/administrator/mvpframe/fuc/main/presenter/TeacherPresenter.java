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
    @SuppressWarnings("unchecked")
    protected void onSuccess(Object o) {
        MainTeacherEntity entity = (MainTeacherEntity) o;
        if (null != entity.getTeacher() && entity.getTeacher().size() > 0) {
            mMainView.showFinishDates(entity.getTeacher());
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
        return getService().getTeacherList("1", "1");
    }

}
