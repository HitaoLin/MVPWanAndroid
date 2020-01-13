package com.example.mvpwanandroid.mvp.presenter;

import com.cxz.baselibs.bean.BaseBean;
import com.cxz.baselibs.mvp.BasePresenter;
import com.cxz.baselibs.rx.BaseObserver;
import com.example.mvpwanandroid.mvp.contract.LoginContract;
import com.example.mvpwanandroid.mvp.model.LoginModel;
import com.example.mvpwanandroid.mvp.model.bean.LoginBean;
import com.example.mvpwanandroid.mvp.model.bean.PersonalScoreBean;

public class LoginPresenter extends BasePresenter<LoginContract.Model,LoginContract.View> implements LoginContract.Presenter{
    @Override
    protected LoginContract.Model createModel() {
        return new LoginModel();
    }

    /**
     * 登录
     * @param username 姓名
     * @param password 密码
     */
    @Override
    public void login(String username, String password) {
        getModel().login(username,password)
                .compose(getView().bindToLife())
                .subscribe(new BaseObserver<LoginBean>(getView()){
                    @Override
                    protected void onSuccess(LoginBean loginBean) {
                        getView().loginSuccess(loginBean.getData());
                    }
                });
    }


}
