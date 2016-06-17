package com.example.administrator.mvpframe.fuc.main.view;

import com.example.administrator.mvpframe.common.base.baseView.BaseView;

import java.util.List;

public interface MainView<T> extends BaseView{

    void showFinishDates(List<T> dates);
}
