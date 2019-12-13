package com.example.mvpwanandroid.mvp.presenter;

import com.cxz.baselibs.bean.BaseBean;
import com.cxz.baselibs.mvp.BasePresenter;
import com.cxz.baselibs.rx.BaseObserver;
import com.example.mvpwanandroid.mvp.contract.LoginContract;
import com.example.mvpwanandroid.mvp.model.LoginModel;

public class LoginPresenter extends BasePresenter<LoginContract.Model,LoginContract.View> implements LoginContract.Presenter{
    @Override
    protected LoginContract.Model createModel() {
        return new LoginModel();
    }


    @Override
    public void login(String username, String password) {
        getModel().login(username,password)
                .compose(getView().bindToLife())
                .subscribe(new BaseObserver<BaseBean>(getView()){
                    @Override
                    protected void onSuccess(BaseBean baseBean) {
                        getView().loginSuccess();
                    }
                });
    }
}
