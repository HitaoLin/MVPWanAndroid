package com.example.mvpwanandroid.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mvpwanandroid.R;
import com.example.mvpwanandroid.utils.StatusbarUtils;

/**
 * <pre>
 *     author:LHT
 *     date:2019.11.30
 *     desc:启动页 Activity
 * </pre>
 */
public class SplashActivity extends AppCompatActivity {

    private static final int mDuration = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StatusbarUtils.enableTranslucentStatusbar(this,true,true,0x00000000,true);
        initSplash();
    }

    private void initSplash(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity2.class));
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        },mDuration);
    }

}
