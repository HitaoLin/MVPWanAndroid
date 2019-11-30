package com.example.mvpwanandroid.ui.fragment;

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

//    public static HomeFragment create() {
//        return new HomeFragment();
//    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        StatusbarUtils.enableTranslucentStatusbar1(getActivity());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
