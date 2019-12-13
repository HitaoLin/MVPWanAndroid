package com.example.mvpwanandroid.adapter.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * <pre>
 *     author:LHT
 *     date:2019.12.12
 *     desc:Fragment适配器
 *     from:https://blog.csdn.net/mei_jia12/article/details/84345722
 * </pre>
 */
public class XFragmentPageAdapter extends FragmentPagerAdapter {

    FragmentManager fragmentManager;
    List<Fragment> mList;

    public XFragmentPageAdapter(FragmentManager fm, List<Fragment>list) {
        super(fm);
        this.mList=list;
    }

    @Override
    public Fragment getItem(int i) {
//        Logger.i("getItem当生成Fragment时调用？");
        return mList.get(i);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

}
