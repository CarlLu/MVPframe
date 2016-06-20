package com.example.administrator.mvpframe.fuc.detail.fragment;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseFragment.BaseFragment;
import com.example.administrator.mvpframe.common.config.Constants;
import com.example.administrator.mvpframe.fuc.detail.presenter.DetailPresenter;
import com.example.administrator.mvpframe.fuc.detail.view.DetailView;
import com.example.administrator.mvpframe.fuc.main.activity.MainActivity;
import com.example.administrator.mvpframe.fuc.main.entity.TeacherEntity;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailFragment extends BaseFragment<DetailPresenter> implements DetailView {

    @Bind(R.id.civ_detail_teacher_icon) CircleImageView mDetailTeacherIcon;

    @Bind(R.id.tv_detail_teacher_name) TextView mDetailTeacherName;

    @Bind(R.id.iv_detail_teacher_sex) ImageView mDetailTeacherSex;

    @Bind(R.id.tv_detail_teacher_workAge) TextView mDetailTeacherWorkAge;

    @Bind(R.id.tv_detail_teacher_hobby) TextView mDetailTeacherHobby;

    @Bind(R.id.fl_detail_teacher_content) FrameLayout mDetailTeacherContent;

    private TextView mContentView;

    private Map<String, String> mParams;

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void baseInit() {
        setToolbar(true, "详情");

        mContentView = new TextView(mContext);
        mContentView.setTextSize(16);
        mDetailTeacherContent.addView(mContentView);

        mParams = new HashMap<>();
    }

    @Override
    protected View getLoadingTargetView() {
        return mDetailTeacherContent;
    }

    public void upDate(TeacherEntity item) {
        Glide.with(this).load(Constants.BASE_URL + item.getPic()).into(
                mDetailTeacherIcon);

        //设置姓名
        mDetailTeacherName.setText(item.getName());

        //设置工龄
        mDetailTeacherWorkAge.setText(item.getSeniority() + "年教龄");

        //设置擅长
        mDetailTeacherHobby.setText("擅长：" + item.getSpecialty());

        //设置性别
        mDetailTeacherSex.setImageResource(item.getSex() ==
                0 ? R.mipmap.ic_male_teacher_detail : R.mipmap.ic_female_teacher_detail);

        showLoading();
        mParams.put("teacherId", item.getId() + "");
        mPresenter.requestDate(mParams);
    }

    @Override
    protected DetailPresenter getChildPresenter() {
        return new DetailPresenter(this);
    }

    @Override
    protected void onBackClick() {
        MainActivity activity = (MainActivity) mContext;
        if (null != activity) {
            activity.onBack();
        }
    }

    @Override
    public void showNetError() {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }

        mVaryViewHelperController.showNetworkError(v -> {
            showLoading();
            mPresenter.requestDate(mParams);
        });
    }

    @Override
    public void showContent(String content) {
        refreshView();
        Log.d("DetailFragment", content);
        mContentView.setText(content);
    }
}
