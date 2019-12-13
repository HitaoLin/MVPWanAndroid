package com.example.mvpwanandroid.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cxz.baselibs.base.BaseMvpActivity;
import com.example.mvpwanandroid.R;
import com.example.mvpwanandroid.mvp.contract.MainContract;
import com.example.mvpwanandroid.mvp.presenter.MainPresenter;
import com.example.mvpwanandroid.ui.fragment.home.HomeFragment;
import com.example.mvpwanandroid.ui.fragment.me.MeFragment;
import com.example.mvpwanandroid.ui.fragment.project.ProjectFragment;
import com.example.mvpwanandroid.ui.fragment.system.SystemFragment;
import com.example.mvpwanandroid.ui.fragment.wechat.WechatFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *     date:2019.11.29
 *     desc:普通的底部导航栏
 * </pre>
 */
public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View, BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.bottom_navigation_view)
    BottomNavigationBar bottomNavigationView;


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

    @SuppressLint("WrongConstant")
    @Override
    protected void initView(Bundle savedInstanceState) {
        // TODO 设置模式
        bottomNavigationView.setMode(BottomNavigationBar.MODE_FIXED);
        // TODO 设置背景色样式
        bottomNavigationView.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationView.setBarBackgroundColor(R.color.white);
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

        /**
         *  new BottomNavigationItem(R.mipmap.tab_home_pressed,"首页") ,选中的图标，文字
         *  setActiveColorResource：选中的颜色
         *  setInactiveIconResource：未选中的图标
         *  setInActiveColorResource：未选中的颜色
         */


        bottomNavigationView
                .addItem(new BottomNavigationItem(R.mipmap.ic_bottom_bar_home_check, "首页").setActiveColorResource(R.color.main).setInactiveIconResource(R.mipmap.ic_bottom_bar_home_uncheck).setInActiveColorResource(R.color.bottom_bar_text_color))
                .addItem(new BottomNavigationItem(R.mipmap.ic_bottom_bar_system_check, "体系").setActiveColorResource(R.color.main).setInactiveIconResource(R.mipmap.ic_bottom_bar_system_uncheck).setInActiveColorResource(R.color.bottom_bar_text_color))
                .addItem(new BottomNavigationItem(R.mipmap.ic_bottom_bar_wechat_check, "公众号").setActiveColorResource(R.color.main).setInactiveIconResource(R.mipmap.ic_bottom_bar_wechat_uncheck).setInActiveColorResource(R.color.bottom_bar_text_color))
                .addItem(new BottomNavigationItem(R.mipmap.ic_bottom_bar_project_check, "项目").setActiveColorResource(R.color.main).setInactiveIconResource(R.mipmap.ic_bottom_bar_project_uncheck).setInActiveColorResource(R.color.bottom_bar_text_color))
                .addItem(new BottomNavigationItem(R.mipmap.ic_bottom_bar_me_check, "我的").setActiveColorResource(R.color.main).setInactiveIconResource(R.mipmap.ic_bottom_bar_me_uncheck).setInActiveColorResource(R.color.bottom_bar_text_color))
                .initialise();
        // mShapeBadgeItem.hide();

        bottomNavigationView.setTabSelectedListener(this);
        bottomNavigationView.selectTab(0);

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
        switch (position){
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
