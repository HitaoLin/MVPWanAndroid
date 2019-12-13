package com.example.mvpwanandroid.ui.fragment.home;

import android.os.Bundle;

import com.cxz.baselibs.base.BaseFragment;
import com.example.mvpwanandroid.R;
import com.example.mvpwanandroid.utils.StatusbarUtils;

public class HomeFragment extends BaseFragment {

    /**
     * 提供Fragment实例
     *
     * @return
     */
    public static HomeFragment newInstance() {

        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        StatusbarUtils.enableTranslucentStatusbar(getActivity(),true,false,R.color.Red,true);
    }

    @Override
    protected void initShow() {
        StatusbarUtils.enableTranslucentStatusbar(getActivity(),true,false,R.color.Red,true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
