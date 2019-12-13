package com.example.mvpwanandroid.ui.fragment.wechat;

import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.cxz.baselibs.base.BaseFragment;
import com.example.mvpwanandroid.R;
import com.example.mvpwanandroid.utils.StatusbarUtils;
import com.google.android.material.tabs.TabLayout;


import butterknife.BindView;

public class WechatFragment extends BaseFragment {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;


    /**
     * 提供Fragment实例
     *
     * @return
     */
    public static WechatFragment newInstance() {

        WechatFragment fragment = new WechatFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected void initView() {
        StatusbarUtils.enableTranslucentStatusbar(getActivity(),true,false,R.color.Black,true);
    }

    @Override
    protected void initShow() {
        StatusbarUtils.enableTranslucentStatusbar(getActivity(),true,false,R.color.Black,true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }


}
