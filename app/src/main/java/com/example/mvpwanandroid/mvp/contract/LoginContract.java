package com.example.mvpwanandroid.mvp.contract;

import com.cxz.baselibs.bean.BaseBean;
import com.cxz.baselibs.mvp.IModel;
import com.cxz.baselibs.mvp.IPresenter;
import com.cxz.baselibs.mvp.IView;
import com.example.mvpwanandroid.mvp.model.bean.LoginBean;
import com.example.mvpwanandroid.mvp.model.bean.PersonalScoreBean;

import io.reactivex.Observable;

public interface LoginContract {

    interface View extends IView{
        //登录
        void loginSuccess(LoginBean.DataBean login);

    }

    interface Presenter extends IPresenter<View>{
        //登录
        void login(String username,String password);

    }

    interface Model extends IModel{
        //登录
        Observable<LoginBean> login(String username,String password);

    }

}
