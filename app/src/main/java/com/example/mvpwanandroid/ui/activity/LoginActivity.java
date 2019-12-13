package com.example.mvpwanandroid.ui.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.cxz.baselibs.base.BaseActivity;
import com.example.mvpwanandroid.R;
import com.example.mvpwanandroid.adapter.fragment.XFragmentPageAdapter;
import com.example.mvpwanandroid.ui.fragment.login.LoginFragment;
import com.example.mvpwanandroid.ui.fragment.login.RegisteredFragment;
import com.example.mvpwanandroid.utils.StatusbarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginFragment.CallBackValue {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.rl_close)
    RelativeLayout rlClose;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        StatusbarUtils.enableTranslucentStatusbar(this, true, false, R.color.main, true);
        initViewPageFragment();//初始化ViewPager
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }


    /**
     * 初始化ViewPager
     */
    private List<Fragment> fragmentList;
    private XFragmentPageAdapter xFragmentPageAdapter;
    FragmentManager fragmentManager;

    public void initViewPageFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new LoginFragment());
        fragmentList.add(new RegisteredFragment());
        fragmentManager = getSupportFragmentManager();
        xFragmentPageAdapter = new XFragmentPageAdapter(fragmentManager, fragmentList);
        vp.setAdapter(xFragmentPageAdapter);
        vp.setCurrentItem(0);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                //  Logger.e("onPageScrolled:" + i + "," + v + "," + i1);

            }

            @Override
            public void onPageSelected(int i) {
//                Log.e("log","当前页码：" + i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    //要获取的值  就是这个参数的值
    @Override
    public void SendMessageValue(String strValue) {
        // TODO Auto-generated method stub
        if (strValue.equals("0")) {//去注册
            vp.setCurrentItem(1);
        } else if (strValue.equals("1")) {//去登录
            vp.setCurrentItem(0);
        }else if (strValue.equals("3")){//登录成功
            finish();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.rl_close)
    public void onViewClicked() {
        finish();
    }
}
