package com.example.mvpwanandroid.app;


import com.cxz.baselibs.app.BaseApp;
import com.example.mvpwanandroid.BuildConfig;

import timber.log.Timber;

/**
 * @author chenxz
 * @date 2018/8/31
 * @desc
 */
public class App extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.LOG_DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

    }
}
