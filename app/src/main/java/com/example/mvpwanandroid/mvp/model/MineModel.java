package com.example.mvpwanandroid.mvp.model;

import com.cxz.baselibs.mvp.BaseModel;
import com.example.mvpwanandroid.http.RetrofitHelper;
import com.example.mvpwanandroid.mvp.contract.MineContract;
import com.example.mvpwanandroid.mvp.model.bean.PersonalScoreBean;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MineModel extends BaseModel implements MineContract.Model {

    //个人积分
    @Override
    public Observable<PersonalScoreBean> personalScore() {
        return RetrofitHelper.getRetrofitService().personalScore()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
