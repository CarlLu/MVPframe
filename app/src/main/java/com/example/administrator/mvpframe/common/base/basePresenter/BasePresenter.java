package com.example.administrator.mvpframe.common.base.basePresenter;

import com.example.administrator.mvpframe.MVPframeApplication;
import com.example.administrator.mvpframe.common.inter.ConnectService;

import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public abstract class BasePresenter {

    @Inject
    ConnectService mService;

    Subscription mSubscription;

    protected RequestMode mode = RequestMode.FRIST;

    public BasePresenter() {
        MVPframeApplication.getComponent().inject(this);
    }

    public enum RequestMode {
        FRIST, LOAD_MORE, REFRESH
    }

    @SuppressWarnings("unchecked")
    public void requestDate(Map<String, String> params, RequestMode mode) {
        if (null == getObservable(params)) {
            throw new IllegalArgumentException("no Observable");
        }

        this.mode = mode;
        mSubscription = getObservable(params).subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
            @Override
            public void onCompleted() {
                onFinish();
            }

            @Override
            public void onError(Throwable e) {
                onFail();
            }

            @Override
            public void onNext(Object o) {
                if (null != o) {
                    onAllSuccess(o);
                } else {
                    onFail();
                }
            }
        });
    }

    protected void onAllSuccess(Object o) {
    }

    protected ConnectService getService() {
        return mService;
    }

    protected void onFinish() {

    }

    protected abstract void onFail();


    protected abstract Observable getObservable(Map<String, String> params);
}
