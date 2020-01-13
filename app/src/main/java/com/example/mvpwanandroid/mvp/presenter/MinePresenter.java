package com.example.mvpwanandroid.mvp.presenter;

import com.cxz.baselibs.mvp.BasePresenter;
import com.cxz.baselibs.rx.BaseObserver;
import com.example.mvpwanandroid.mvp.contract.MineContract;
import com.example.mvpwanandroid.mvp.model.MineModel;
import com.example.mvpwanandroid.mvp.model.bean.PersonalScoreBean;


public class MinePresenter extends BasePresenter<MineContract.Model, MineContract.View> implements MineContract.Presenter{
    @Override
    protected MineContract.Model createModel() {
        return new MineModel();
    }

    /**
     * 个人积分
     */
    @Override
    public void personalScore() {
        getModel().personalScore()
                .compose(getView().bindToLife())
                .subscribe(new BaseObserver<PersonalScoreBean>(getView()) {
                    @Override
                    protected void onSuccess(PersonalScoreBean personalScoreBean) {
                        getView().personalScoreSuccess(personalScoreBean.getData());
                    }
                });
    }

}
