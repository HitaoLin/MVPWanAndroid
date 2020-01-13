package com.example.mvpwanandroid.mvp.contract;

import com.cxz.baselibs.mvp.IModel;
import com.cxz.baselibs.mvp.IPresenter;
import com.cxz.baselibs.mvp.IView;
import com.example.mvpwanandroid.mvp.model.bean.PersonalScoreBean;

import io.reactivex.Observable;

public interface MineContract {

    interface View extends IView{
        //个人积分Leak
        void personalScoreSuccess(PersonalScoreBean.DataBean dataBean);
    }

    interface Presenter extends IPresenter<View>{
        //个人积分
        void personalScore();
    }

    interface Model extends IModel{
        //个人积分
        Observable<PersonalScoreBean> personalScore();
    }

}
