package com.example.mvpwanandroid.ui.fragment.project;

import android.os.Bundle;

import com.cxz.baselibs.base.BaseFragment;
import com.example.mvpwanandroid.R;
import com.example.mvpwanandroid.utils.StatusbarUtils;

public class ProjectFragment extends BaseFragment {

    /**
     * 提供Fragment实例
     *
     * @return
     */
    public static ProjectFragment newInstance() {

        ProjectFragment fragment = new ProjectFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_project;
    }

    @Override
    protected void initView() {
        StatusbarUtils.enableTranslucentStatusbar(getActivity(),true,false,R.color.colorHelper_square_alpha_background,true);
    }

    @Override
    protected void initShow() {
        StatusbarUtils.enableTranslucentStatusbar(getActivity(),true,false,R.color.colorHelper_square_alpha_background,true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
