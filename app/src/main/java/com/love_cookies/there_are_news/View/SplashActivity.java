package com.love_cookies.there_are_news.View;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.there_are_news.R;

import org.xutils.view.annotation.ContentView;

/**
 * Created by xiekun on 2016/7/6 0006.
 *
 * App启动页
 */
@ContentView(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {

    private final int SPLASH_DISPLAY_DURATION = 1500;//启动页显示时长
    private Looper looper = Looper.myLooper();
    private Handler handler = new Handler(looper);

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            turnThenFinish(MainActivity.class);
        }
    };

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        handler.postDelayed(runnable, SPLASH_DISPLAY_DURATION);
    }

    /**
     * 控件点击事件
     * @param v
     */
    @Override
    public void widgetClick(View v) {

    }

    /**
     * 重写物理按键
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            handler.removeCallbacks(runnable);
        }
        return super.onKeyDown(keyCode, event);
    }

}
