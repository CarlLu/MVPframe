package com.example.administrator.mvpframe.fuc.detail.presenter;

import android.text.TextUtils;

import com.example.administrator.mvpframe.common.base.basePresenter.BasePresenter;
import com.example.administrator.mvpframe.fuc.detail.model.TeacherInfoEntity;
import com.example.administrator.mvpframe.fuc.detail.view.DetailView;

import java.util.Map;

import rx.Observable;

public class DetailPresenter extends BasePresenter {

    private DetailView mDetailView;

    public DetailPresenter(DetailView detailView) {
        mDetailView = detailView;
    }

    @Override
    protected void onAllSuccess(Object o) {
        TeacherInfoEntity entity = (TeacherInfoEntity) o;
        if(entity.getTeacher() != null){
            if(!TextUtils.isEmpty(entity.getTeacher().getContent())){
                mDetailView.showContent(entity.getTeacher().getContent());
            }else{
                mDetailView.showEmptyView(null);
            }
        }else{
            mDetailView.showEmptyView(null);
        }
    }

    @Override
    protected void onFail() {
        mDetailView.showNetError();
    }

    @Override
    protected Observable getObservable(Map<String, String> params) {
        return getService().getDetailContent(params);
    }
}
