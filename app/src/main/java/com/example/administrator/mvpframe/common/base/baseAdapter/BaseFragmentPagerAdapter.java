package com.example.administrator.mvpframe.common.base.baseAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<? extends Fragment> mFragments;

    private String[] mTabs;

    private BaseFragmentPagerAdapter(FragmentManager fm,
                                    List<? extends Fragment> fragments,
                                    String[] tabs) {
        super(fm);
        mFragments = new ArrayList<>();
        mFragments = fragments;
        mTabs = tabs;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position];
    }


    public static class Holder {

        private final ArrayList<Fragment> fragments = new ArrayList<>();

        private FragmentManager manager;

        public Holder(FragmentManager manager) {
            this.manager = manager;
        }

        public Holder add(Fragment f) {
            //判断fragment是哪种类型的
            fragments.add(f);
            return this;
        }

        public BaseFragmentPagerAdapter build(String[] tabs) {
            return new BaseFragmentPagerAdapter(manager, fragments, tabs);
        }
    }
}
