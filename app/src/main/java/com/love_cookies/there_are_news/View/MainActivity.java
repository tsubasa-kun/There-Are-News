package com.love_cookies.there_are_news.View;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;
import com.love_cookies.there_are_news.R;

import org.xutils.view.annotation.ContentView;

/**
 * Created by xiekun on 2016/7/6 0006.
 *
 * App主页
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private long exitTime;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
    }

    /**
     * 控件点击事件
     * @param v
     */
    @Override
    public void widgetClick(View v) {

    }

    /**
     * 点两次返回退出程序
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000)
            {
                ToastUtils.show(getApplicationContext(), R.string.exit_tip);
                exitTime = System.currentTimeMillis();
            } else {
                ActivityCollections.getInstance().finishAllActivity();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
