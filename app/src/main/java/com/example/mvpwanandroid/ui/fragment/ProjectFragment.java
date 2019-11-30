package com.example.mvpwanandroid.ui.fragment;

import android.os.Bundle;

import com.cxz.baselibs.base.BaseFragment;
import com.example.mvpwanandroid.R;

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

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
