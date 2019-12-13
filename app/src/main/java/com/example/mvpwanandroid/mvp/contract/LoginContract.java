package com.example.mvpwanandroid.mvp.contract;

import com.cxz.baselibs.bean.BaseBean;
import com.cxz.baselibs.mvp.IModel;
import com.cxz.baselibs.mvp.IPresenter;
import com.cxz.baselibs.mvp.IView;

import io.reactivex.Observable;

public interface LoginContract {

    interface View extends IView{
        void  loginSuccess();
    }

    interface Presenter extends IPresenter<View>{
        //登录
        void login(String username,String password);
    }

    interface Model extends IModel{
        //登录
        Observable<BaseBean> login(String username,String password);
    }

}
