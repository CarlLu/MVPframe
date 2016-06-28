package com.example.administrator.mvpframe.fuc.main.fragment;

import com.example.administrator.mvpframe.R;
import com.example.administrator.mvpframe.common.base.baseFragment.BaseListFragment;
import com.example.administrator.mvpframe.common.base.baseHolder.BaseViewHolder;
import com.example.administrator.mvpframe.common.config.Constants;
import com.example.administrator.mvpframe.fuc.main.entity.EvaluateEntity;
import com.example.administrator.mvpframe.fuc.main.presenter.EvaluatePresenter;

public class EvaluateFragment extends
        BaseListFragment<EvaluatePresenter, EvaluateEntity.ScoreEntity> {


    @Override
    protected void fitDates(BaseViewHolder helper, EvaluateEntity.ScoreEntity item) {
        helper.setText(R.id.tv_evaluate_item_name, item.getName()).setImageUrl(
                R.id.civ_detail_evaluate_item_icon, mContext,
                Constants.BASE_URL + item.getPic()).setRating(
                R.id.rb_detail_evaluate_item_ratingbar,
                (float) (Math.ceil(item.getScore()) / 2)).setText(
                R.id.tv_detail_evaluate_item_child, "关系：" + item.getRelation()).setText(
                R.id.tv_detail_evaluate_item_des, item.getContent());
    }

    @Override
    protected int getItemLayout() {
        return R.layout.detail_evaluate_item;
    }

    @Override
    protected EvaluatePresenter getChildPresenter() {
        return new EvaluatePresenter(this);
    }

    @Override
    public void onLoadMoreRequested() {
        PAGE = PAGE +1;
        params.put("mechanismId", "1");
        params.put("pageNum", PAGE + "");
        mPresenter.loadMore(params);
    }

    @Override
    public void onRefresh() {
        params.put("mechanismId", "1");
        params.put("pageNum", "1");
        mPresenter.onRefresh(params);
    }
}
