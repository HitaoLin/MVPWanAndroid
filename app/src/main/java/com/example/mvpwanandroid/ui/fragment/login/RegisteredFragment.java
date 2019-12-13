package com.example.mvpwanandroid.ui.fragment.login;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.cxz.baselibs.base.BaseFragment;
import com.example.mvpwanandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisteredFragment extends BaseFragment {

    @BindView(R.id.ll_go_login)
    LinearLayout llGoLogin;//去登录

    /**
     * from:https://blog.csdn.net/u010936731/article/details/54380011
     */
    LoginFragment.CallBackValue callBackValue;

    /**
     * fragment与activity产生关联是  回调这个方法
     *
     * @param context
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //当前fragment从activity重写了回调接口  得到接口的实例化对象
        callBackValue = (LoginFragment.CallBackValue) getActivity();
    }

    @OnClick(R.id.ll_go_login)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.ll_go_login://去登录
                callBackValue.SendMessageValue("1");
                break;
        }
    }


    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_registered;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initShow() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
