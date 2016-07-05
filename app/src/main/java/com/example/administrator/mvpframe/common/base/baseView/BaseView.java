package com.example.administrator.mvpframe.common.base.baseView;

import java.util.List;

public interface BaseView {

    void showLoading();

    void refreshView();

    void showNetError();

    void showEmptyView(String msg);

    void hasNoMoreDate();

    void loadMoreFinish(List dates);

    void showRefreshFinish(List score);

    void showToastError();
}
