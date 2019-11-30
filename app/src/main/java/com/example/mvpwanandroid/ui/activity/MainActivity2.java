package com.example.mvpwanandroid.ui.activity;


import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.cxz.baselibs.base.BaseMvpActivity;
import com.example.mvpwanandroid.R;
import com.example.mvpwanandroid.mvp.contract.MainContract;
import com.example.mvpwanandroid.mvp.presenter.MainPresenter;
import com.example.mvpwanandroid.ui.fragment.HomeFragment;
import com.example.mvpwanandroid.ui.fragment.MeFragment;
import com.example.mvpwanandroid.ui.fragment.ProjectFragment;
import com.example.mvpwanandroid.ui.fragment.SystemFragment;
import com.example.mvpwanandroid.ui.fragment.WechatFragment;
import com.example.mvpwanandroid.view.BottomBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity2 extends BaseMvpActivity<MainPresenter> implements MainContract.View, BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.bottom_navigation_view)
    BottomBar bottomNavigationView;

    //Fragment管理器和执行器
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private HomeFragment mHomeFragment;
    private SystemFragment mSystemFragment;
    private WechatFragment mWechatFragment;
    private ProjectFragment mProjectFragment;
    private MeFragment mMeFragment;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        mFragmentManager = getSupportFragmentManager();
        initBottomNavigationBar();
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (mHomeFragment != null) {
            mFragmentTransaction.hide(mHomeFragment);
        }

        if (mSystemFragment != null) {
            mFragmentTransaction.hide(mSystemFragment);
        }

        if (mWechatFragment != null) {
            mFragmentTransaction.hide(mWechatFragment);
        }

        if (mProjectFragment != null) {
            mFragmentTransaction.hide(mProjectFragment);
        }

        if (mMeFragment != null) {
            mFragmentTransaction.hide(mMeFragment);
        }
    }

    private void initBottomNavigationBar() {

        bottomNavigationView.setContainer(R.id.fl_content)
                .setTitleBeforeAndAfterColor("#707070", "#4282f4")
                .addItem(HomeFragment.class,
                        "首页",
                        R.mipmap.ic_bottom_bar_home_uncheck,
                        R.mipmap.ic_bottom_bar_home_check)
                .addItem(SystemFragment.class,
                        "体系",
                        R.mipmap.ic_bottom_bar_system_uncheck,
                        R.mipmap.ic_bottom_bar_system_check)
                .addItem(WechatFragment.class,
                        "公众号",
                        R.mipmap.ic_bottom_bar_wechat_uncheck,
                        R.mipmap.ic_bottom_bar_wechat_check)
                .addItem(ProjectFragment.class,
                        "项目",
                        R.mipmap.ic_bottom_bar_project_uncheck,
                        R.mipmap.ic_bottom_bar_project_check)
                .addItem(MeFragment.class,
                        "我的",
                        R.mipmap.ic_bottom_bar_me_uncheck,
                        R.mipmap.ic_bottom_bar_me_check)
                .build();

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected MainPresenter createPresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onTabSelected(int position) {
        //开启事务
        mFragmentTransaction = mFragmentManager.beginTransaction();
        hideFragment(mFragmentTransaction);


        /**
         * fragment 用 add + show + hide 方式
         * 只有第一次切换会创建fragment，再次切换不创建
         *
         * fragment 用 replace 方式
         * 每次切换都会重新创建
         *
         */
        switch (position) {
            case 0:   // 首页
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance();
                    mFragmentTransaction.add(R.id.fl_content,
                            mHomeFragment);
                } else {
                    mFragmentTransaction.show(mHomeFragment);
                }
                break;
            case 1:    // 体系
                if (mSystemFragment == null) {
                    mSystemFragment = SystemFragment.newInstance();
                    mFragmentTransaction.add(R.id.fl_content,
                            mSystemFragment);
                } else {
                    mFragmentTransaction.show(mSystemFragment);
                }
                break;
            case 2:  // 公众号
                if (mWechatFragment == null) {
                    mWechatFragment = WechatFragment.newInstance();
                    mFragmentTransaction.add(R.id.fl_content,
                            mWechatFragment);
                } else {
                    mFragmentTransaction.show(mWechatFragment);
                }
                break;
            case 3:  // 项目
                if (mProjectFragment == null) {
                    mProjectFragment = ProjectFragment.newInstance();
                    mFragmentTransaction.add(R.id.fl_content,
                            mProjectFragment);
                } else {
                    mFragmentTransaction.show(mProjectFragment);
                }
                break;
            case 4:  // 我的
                if (mMeFragment == null) {
                    mMeFragment = MeFragment.newInstance();
                    mFragmentTransaction.add(R.id.fl_content,
                            mMeFragment);
                } else {
                    mFragmentTransaction.show(mMeFragment);
                }
                break;
        }
        // 事务提交
        mFragmentTransaction.commit();
        //  mTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
