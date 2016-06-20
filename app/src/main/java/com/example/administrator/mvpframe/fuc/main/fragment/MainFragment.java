package com.example.administrator.mvpframe.fuc.main.fragment;

import android.support.v4.view.ViewPager;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseAdapter.BaseFragmentPagerAdapter;
import com.example.administrator.mvpframe.common.base.baseFragment.BaseFragment;
import com.example.administrator.mvpframe.common.widget.PagerSlidingTabStrip;

import butterknife.Bind;

public class MainFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    @Bind(R.id.indicator) PagerSlidingTabStrip mIndicator;

    @Bind(R.id.viewPager) ViewPager mViewPager;

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void baseInit() {
        setToolbar(false, "教师");
        mViewPager.setAdapter(new BaseFragmentPagerAdapter.Holder(getChildFragmentManager()).add(
                new TeacherFragment()).add(new EvaluateFragment()).add(new MsgFragment()).build(
                new String[]{"教师", "评论", "消息"}));


        mViewPager.addOnPageChangeListener(this);

        mIndicator.setShouldExpand(true);
        mIndicator.setTextSize(32);
        mIndicator.setIndicatorColor(getResources().getColor(R.color.indicator_color));
        mIndicator.setIndicatorHeight(2);
        mIndicator.setViewPager(mViewPager);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            changeTitle("教师");
        } else if (position == 1) {
            changeTitle("评论");
        } else {
            changeTitle("消息");
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
