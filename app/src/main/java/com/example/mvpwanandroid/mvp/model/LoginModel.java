package com.example.mvpwanandroid.mvp.model;

import com.cxz.baselibs.bean.BaseBean;
import com.cxz.baselibs.mvp.BaseModel;
import com.example.mvpwanandroid.http.RetrofitHelper;
import com.example.mvpwanandroid.mvp.contract.LoginContract;
import com.example.mvpwanandroid.mvp.contract.MainContract;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginModel extends BaseModel implements LoginContract.Model {
    @Override
    public Observable<BaseBean> login(String username, String password) {
        return RetrofitHelper.getRetrofitService().login(username,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
