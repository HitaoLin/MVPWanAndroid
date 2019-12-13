package com.example.mvpwanandroid.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.view.ViewCompat;

/**
 * <pre>
 *     aduthor:LHT
 *     date:2019.12.03
 *     desc:设置系统状态栏和导航栏透明化
 * </pre>
 */

public class StatusbarUtils {

    /**
     * @param activity
     * @param isShowStatusBar  true 显示状态栏，false 隐藏状态栏
     * @param isFullScreen     true 全屏 ，false 不全屏
     * @param backgroundColor  状态栏背景颜色
     * @param isWhiteTextColor true 白色字体，false 黑色字体
     */
    public static void enableTranslucentStatusbar(Activity activity, boolean isShowStatusBar, boolean isFullScreen, int backgroundColor, boolean isWhiteTextColor) {
        /**
         * 0x00000000 透明
         * 0xFFFFFFFF白色
         * 0x4282f4 主题色
         */
        if (Build.VERSION.SDK_INT >= 21) {
            if (isFullScreen) {//全屏
                /**
                 * 允许window扩展值屏幕之外
                 * 使用activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);无法设置回来
                 * 只能clearFlags
                 */
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

            } else {//不全屏
                activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
                Window window = activity.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(activity.getResources().getColor(backgroundColor));
                ViewGroup mContentview = (ViewGroup) activity.findViewById(Window.ID_ANDROID_CONTENT);
                View mChildView = mContentview.getChildAt(0);
                if (mChildView != null) {
                    ViewCompat.setFitsSystemWindows(mChildView, true);
                }
            }
        }
        View decor = activity.getWindow().getDecorView();
        if (isWhiteTextColor) {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        } else {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if (isShowStatusBar) {
            showStatusBar(activity);
        } else {
            hideStatusBar(activity);
        }

    }

    /**
     * 全屏，隐藏状态栏
     *
     * @param activity
     */
    public static void hideStatusBar(Activity activity) {
        WindowManager.LayoutParams attrs = activity.getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        activity.getWindow().setAttributes(attrs);
    }

    /**
     * 全屏，显示状态栏
     *
     * @param activity
     */
    public static void showStatusBar(Activity activity) {
        WindowManager.LayoutParams attrs = activity.getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        activity.getWindow().setAttributes(attrs);
    }

}
