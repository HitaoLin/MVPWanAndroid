package com.example.mvpwanandroid.mvp.contract;

import com.cxz.baselibs.mvp.IModel;
import com.cxz.baselibs.mvp.IPresenter;
import com.cxz.baselibs.mvp.IView;

public interface MainContract {

    interface View extends IView{

    }

    interface Presenter extends IPresenter<View>{

    }

    interface Model extends IModel{

    }

}
