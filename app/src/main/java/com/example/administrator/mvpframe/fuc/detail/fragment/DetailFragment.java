package com.example.administrator.mvpframe.fuc.detail.fragment;

import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseFragment.BaseFragment;
import com.example.administrator.mvpframe.fuc.main.activity.MainActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

public class DetailFragment extends BaseFragment {

    @Bind(R.id.detail_rootView)
    LinearLayout mRootView;

    private WebView mWebView;

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void baseInit() {
        setToolbar(true, "详情");
    }

    @Override
    public void onBackClick() {
        if(mWebView.canGoBack()){
            mWebView.goBack();
        }else{
            ((MainActivity) mContext).onBack();
        }
    }

    private void setWebSetting() {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDatabaseEnabled(true);
        mWebView.getSettings().setDefaultTextEncodingName("utf-8");
        mWebView.getSettings().setSupportZoom(false);
        mWebView.getSettings().setBuiltInZoomControls(false);
        if (Build.VERSION.SDK_INT >= 19) {
            mWebView.getSettings().setLoadsImagesAutomatically(true);
        } else {
            mWebView.getSettings().setLoadsImagesAutomatically(false);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            mWebView.getSettings().setMixedContentMode(0);
            mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else if (Build.VERSION.SDK_INT >= 19) {
            mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 19) {
            mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        if (Build.VERSION.SDK_INT >= 7) {
            mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        } else {
            WebSettings settings = mWebView.getSettings();
            Class<?> clazz = settings.getClass();
            try {
                clazz.getMethod("setPluginsEnabled", boolean.class).invoke(
                        settings, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mWebView.setWebViewClient(
                new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }
                });
    }

    public void showWeb(String url) {
        if (mWebView == null) {
            mWebView = new WebView(mContext);
            setWebSetting();
            mRootView.addView(mWebView);
        }
        mWebView.loadUrl(url);
    }


    public void clear() {
        if (mWebView != null) {
            mRootView.removeView(mWebView);
            mWebView.clearHistory();
            mWebView.clearCache(true);
            mWebView.destroy();
            mWebView = null;
        }
    }

    @Override
    public void hasNoMoreDate() {

    }

    @Override
    public void loadMoreFinish(List dates) {

    }

    @Override
    public void showRefreshFinish(List score) {

    }

    @Override
    public void showToastError() {

    }
}
