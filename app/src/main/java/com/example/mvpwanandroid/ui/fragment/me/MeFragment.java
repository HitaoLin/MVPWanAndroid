package com.example.mvpwanandroid.ui.fragment.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cxz.baselibs.base.BaseFragment;
import com.example.mvpwanandroid.R;
import com.example.mvpwanandroid.ui.activity.LoginActivity;
import com.example.mvpwanandroid.ui.view.CircleImageView;
import com.example.mvpwanandroid.utils.StatusbarUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MeFragment extends BaseFragment {


    @BindView(R.id.civ_user_icon)
    CircleImageView civUserIcon;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_user_id)
    TextView tvUserId;
    @BindView(R.id.tv_user_level)
    TextView tvUserLevel;
    @BindView(R.id.tv_user_ranking)
    TextView tvUserRanking;
    @BindView(R.id.tv_coin)
    TextView tvCoin;
    @BindView(R.id.ll_coin)
    LinearLayout llCoin;
    @BindView(R.id.ll_share)
    LinearLayout llShare;
    @BindView(R.id.ll_collect)
    LinearLayout llCollect;
    @BindView(R.id.ll_read_later)
    LinearLayout llReadLater;
    @BindView(R.id.ll_open)
    LinearLayout llOpen;
    @BindView(R.id.ll_about_me)
    LinearLayout llAboutMe;
    @BindView(R.id.ll_setting)
    LinearLayout llSetting;

    /**
     * 提供Fragment实例
     *
     * @return
     */
    public static MeFragment newInstance() {

        MeFragment fragment = new MeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {
        StatusbarUtils.enableTranslucentStatusbar(getActivity(),true,true,R.color.main,true);
    }

    @Override
    protected void initShow() {
        StatusbarUtils.enableTranslucentStatusbar(getActivity(),true,true,R.color.main,true);
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initListener() {

    }

    @OnClick({R.id.civ_user_icon, R.id.ll_coin, R.id.ll_share, R.id.ll_collect, R.id.ll_read_later, R.id.ll_open, R.id.ll_about_me, R.id.ll_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.civ_user_icon://头像
                Intent intent = new Intent(mContext, LoginActivity.class);
                //设置activity从底部弹出
                getActivity().overridePendingTransition(R.anim.from_top_to_bottom, R.anim.from_bottom_to_top);
                startActivity(intent);
                break;
            case R.id.ll_coin:
                break;
            case R.id.ll_share:
                break;
            case R.id.ll_collect:
                break;
            case R.id.ll_read_later:
                break;
            case R.id.ll_open:
                break;
            case R.id.ll_about_me:
                break;
            case R.id.ll_setting:
                break;
        }
    }

}
