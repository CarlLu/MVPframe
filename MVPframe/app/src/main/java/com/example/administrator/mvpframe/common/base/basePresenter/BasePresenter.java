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

    public BasePresenter() {
        MVPframeApplication.getComponent().inject(this);
    }

    @SuppressWarnings("unchecked")
    public void requestDate(Map<String, String> params) {
        if (null == getObservable(params)) {
            throw new IllegalArgumentException("no Observable");
        }

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
                    onSuccess(o);
                } else {
                    onFail();
                }
            }
        });
    }

    protected ConnectService getService() {
        return mService;
    }

    private void onFinish() {

    }

    protected abstract void onSuccess(Object o);


    protected abstract void onFail();


    protected abstract Observable getObservable(Map<String, String> params);
}
