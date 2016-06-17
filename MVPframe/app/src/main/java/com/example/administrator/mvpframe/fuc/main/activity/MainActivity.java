package com.example.administrator.mvpframe.fuc.main.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseAdapter.BaseFragmentPagerAdapter;
import com.example.administrator.mvpframe.common.widget.NoScrollViewPager;
import com.example.administrator.mvpframe.fuc.detail.fragment.DetailFragment;
import com.example.administrator.mvpframe.fuc.main.entity.TeacherEntity;
import com.example.administrator.mvpframe.fuc.main.fragment.MainFragment;

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

    public void toDetail(TeacherEntity item) {
        mNoScrollViewPager.setCurrentItem(1,true);
        mDetailFragment.upDate(item);
    }

    public void onBack(){
        mNoScrollViewPager.setCurrentItem(0,true);
    }

    @Override
    public void onBackPressed() {
        if (mNoScrollViewPager.getCurrentItem() == 1) {
            mNoScrollViewPager.setCurrentItem(0, true);
        } else {
            super.onBackPressed();
        }
    }
}
