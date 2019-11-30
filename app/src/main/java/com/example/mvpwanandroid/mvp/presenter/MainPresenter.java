package com.example.mvpwanandroid.mvp.presenter;

import com.cxz.baselibs.mvp.BasePresenter;
import com.example.mvpwanandroid.mvp.contract.MainContract;
import com.example.mvpwanandroid.mvp.model.MainModel;

public class MainPresenter extends BasePresenter<MainContract.Model,MainContract.View> implements MainContract.Presenter{
    @Override
    protected MainContract.Model createModel() {
        return new MainModel();
    }
}
