package com.example.mvpwanandroid.ui.fragment.system;

import android.os.Bundle;

import com.cxz.baselibs.base.BaseFragment;
import com.example.mvpwanandroid.R;
import com.example.mvpwanandroid.utils.StatusbarUtils;

public class SystemFragment extends BaseFragment {

    /**
     * 提供Fragment实例
     *
     * @return
     */
    public static SystemFragment newInstance() {

        SystemFragment fragment = new SystemFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_system;
    }

    @Override
    protected void initView() {
        StatusbarUtils.enableTranslucentStatusbar(getActivity(),true,false,R.color.colorPrimary,true);
    }

    @Override
    protected void initShow() {
        StatusbarUtils.enableTranslucentStatusbar(getActivity(),true,false,R.color.colorPrimary,true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
