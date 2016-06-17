package com.example.administrator.mvpframe.fuc.main.fragment;

import android.view.View;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseFragment.BaseListFragment;
import com.example.administrator.mvpframe.common.base.baseHolder.BaseViewHolder;
import com.example.administrator.mvpframe.common.config.Constants;
import com.example.administrator.mvpframe.fuc.main.activity.MainActivity;
import com.example.administrator.mvpframe.fuc.main.entity.TeacherEntity;
import com.example.administrator.mvpframe.fuc.main.presenter.TeacherPresenter;

public class TeacherFragment extends BaseListFragment<TeacherPresenter, TeacherEntity> {

    @Override
    protected void fitDates(BaseViewHolder helper, TeacherEntity item) {
        helper.setText(R.id.tv_detail_teacher_item_name, item.getName()).setImageUrl(
                R.id.civ_detail_teacher_item_icon, Constants.BASE_URL+item.getPic()).setImageResource(R.id.iv_detail_teacher_item_sex,
                item.getSex() == 0 ? R.mipmap.ic_male : R.mipmap.ic_female).setText(
                R.id.tv_detail_teacher_item_age, item.getSeniorityName() + "教龄").setText(
                R.id.tv_detail_teacher_item_hobby, "擅长：" + item.getSpecialty());
    }

    @Override
    protected int getItemLayout() {
        return R.layout.detail_teacher_item;
    }

    @Override
    protected TeacherPresenter getChildPresenter() {
        return new TeacherPresenter(this);
    }

    @Override
    protected void onItemClick(View v, int position) {
        TeacherEntity item = mAdapter.getItem(position);

        MainActivity activity = (MainActivity) mContext;
        if(null != activity){
            activity.toDetail(item);
        }
    }
}
