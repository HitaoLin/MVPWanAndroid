package com.example.mvpwanandroid.ui.fragment.wechat;

import android.os.Bundle;
import android.widget.TextView;

import com.cxz.baselibs.base.BaseFragment;
import com.example.mvpwanandroid.R;

import butterknife.BindView;

public class WechatContentFragment extends BaseFragment {

    @BindView(R.id.tv_wechat_content)
    TextView tvWechatContent;
    private String name;

    /**
     * 提供Fragment实例
     *
     * @return
     */
    public static WechatContentFragment newInstance() {

        WechatContentFragment fragment = new WechatContentFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_wechat_content;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        name = bundle.getString("name");
        if (name == null) {
            name = "参数非法";
        }
    }

    @Override
    protected void initShow() {

    }

    @Override
    protected void initData() {
        tvWechatContent.setText(name);
    }

    @Override
    protected void initListener() {

    }
}
