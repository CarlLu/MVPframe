package com.example.administrator.mvpframe.common.base.baseFragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.basePresenter.BasePresenter;
import com.example.administrator.mvpframe.common.base.baseView.BaseView;
import com.example.administrator.mvpframe.common.loading.VaryViewHelperController;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.lang.reflect.Field;
import java.util.Map;

import butterknife.ButterKnife;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements
        BaseView {

    protected Activity mContext;

    protected VaryViewHelperController mVaryViewHelperController;

    protected Toolbar mToolbar;

    private TextView mTitleView;

    protected View mRootView;

    protected T mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = (Activity) context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == mRootView) {
            mRootView = inflater.inflate(getContentLayout(), container, false);
            baseInitView();
            ButterKnife.bind(this, mRootView);
            mToolbar = (Toolbar) mRootView.findViewById(R.id.toolbar);
            if (null != getLoadingTargetView()) {
                mVaryViewHelperController = new VaryViewHelperController(getLoadingTargetView());
            }

            if (null != getChildPresenter()) {
                mPresenter = getChildPresenter();
            }

            baseInit();
        } else {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (null != parent) {
                parent.removeView(mRootView);
            }
        }
        return mRootView;
    }

    protected void baseInitView() {

    }

    protected void baseInit() {

    }

    protected T getChildPresenter() {
        return null;
    }

    protected abstract int getContentLayout();

    protected void setToolbar(boolean isNeedBackImg, String titleContent) {
        if (mToolbar != null) {
            if (isNeedBackImg) {
                mToolbar.setNavigationIcon(R.mipmap.ico_back);
                mToolbar.setNavigationOnClickListener(v -> onBackClick());
            }
            if (!TextUtils.isEmpty(titleContent)) {
                mTitleView = new TextView(mContext);
                mTitleView.setTextSize(18);
                mTitleView.setTextColor(Color.WHITE);
                mTitleView.setText(titleContent);
                Toolbar.LayoutParams params = new Toolbar.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
                mToolbar.addView(mTitleView, params);
            }
        }
    }

    protected void changeTitle(String title) {
        if (null != mTitleView) {
            mTitleView.setText(title);
        }
    }

    protected void onBackClick() {

    }

    protected View getLoadingTargetView() {
        return null;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showLoading() {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.showLoading();
    }

    @Override
    public void refreshView() {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.restore();
    }

    @Override
    public void showNetError() {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.showNetworkError(v -> {
            showLoading();
            mPresenter.requestDate(getRequestParams(), BasePresenter.RequestMode.FRIST);
        });
    }

    protected Map<String, String> getRequestParams() {
        return null;
    }

    public void showEmptyView(String msg) {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.showEmpty(msg);
    }
}
