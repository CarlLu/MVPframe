package com.example.administrator.mvpframe.fuc.main.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseAdapter.BaseFragmentPagerAdapter;
import com.example.administrator.mvpframe.common.widget.NoScrollViewPager;
import com.example.administrator.mvpframe.fuc.detail.fragment.DetailFragment;
import com.example.administrator.mvpframe.fuc.main.fragment.MainFragment;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_viewPager) NoScrollViewPager mNoScrollViewPager;

    private DetailFragment mDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setTranslucentStatus();

        setSystemBarTintDrawable(R.color.toolBar_color);

        mDetailFragment = new DetailFragment();

        mNoScrollViewPager.setAdapter(
                new BaseFragmentPagerAdapter.Holder(getSupportFragmentManager()).add(
                        new MainFragment()).add(mDetailFragment).build(null));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }

    public void toDetail(String url) {
        mNoScrollViewPager.setCurrentItem(1,true);
        mDetailFragment.showWeb(url);
    }

    public void onBack(){
        mNoScrollViewPager.setCurrentItem(0,true);
        mDetailFragment.clear();
    }

    @Override
    public void onBackPressed() {
        if (mNoScrollViewPager.getCurrentItem() == 1) {
            mDetailFragment.onBackClick();
        } else {
            super.onBackPressed();
        }
    }

    private void setTranslucentStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            winParams.flags |= bits;
            win.setAttributes(winParams);

            mNoScrollViewPager.setPadding(0,getStatusBarHeight(),0,0);
        }
    }

    //得到通知栏（状态栏）的高度
    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void setSystemBarTintDrawable(int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager mTintManager = new SystemBarTintManager(this);
            if (resId != 0) {
                mTintManager.setStatusBarTintEnabled(true);
                mTintManager.setTintResource(resId);
            } else {
                mTintManager.setStatusBarTintEnabled(false);
                mTintManager.setTintDrawable(null);
            }
        }
    }
}
