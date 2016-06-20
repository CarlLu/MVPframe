package com.example.administrator.mvpframe;

import android.app.Application;
import android.content.Context;

import com.example.administrator.mvpframe.common.dagger.MVPframeComponent;

public class MVPframeApplication extends Application {

    private MVPframeComponent mComponent;

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mComponent = MVPframeComponent.MVPframeInitialize.init();
    }

    public static MVPframeComponent getComponent() {
        return ((MVPframeApplication) mContext.getApplicationContext()).mComponent;
    }
}
