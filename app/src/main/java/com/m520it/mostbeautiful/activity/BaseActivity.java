package com.m520it.mostbeautiful.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.controller.BaseController;
import com.m520it.mostbeautiful.listener.IResponseListener;

/**
 * @author jane
 * @time 2016/11/7  20:59
 * @desc ${TODD}
 */
public abstract class BaseActivity extends FragmentActivity implements
        IResponseListener {

    protected BaseController mController;
    protected Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            handlerMessage(msg);
        }

    };

    protected void initData() {
        // default Empty implementn
    }

    protected void handlerMessage(Message msg) {
        // default Empty implementn
    }

    protected void initController() {
        // default Empty implementn
    }

    protected abstract void initUI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**-- 透明导航栏和状态栏 --**/
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        /**-- 全屏显示设置 --**/
        //        View decorView = getWindow().getDecorView();
        //        // SYSTEM_UI_FLAG_IMMERSIVE 代表全屏进入沉浸式
        //        //   SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        //        decorView.setSystemUiVisibility(
        //                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        //                        | View.SYSTEM_UI_FLAG_FULLSCREEN
        //                        | SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


    }

    protected void transparentHeading() {
        int version = getSdkVersion();
        if (version >= Build.VERSION_CODES.LOLLIPOP) {
            ImageView img = (ImageView) findViewById(R.id.img);
            int statusHeight = getStatusHeight(this);
            //获取到这个ImageVierw的布局描述类,高度进行设置
            img.getLayoutParams().height = statusHeight;
            img.setBackgroundColor(Color.BLACK);
        }
    }

    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return
     */
    public int getStatusHeight(Context context) {

        int statusHeight = -1;
        try {
            Class clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    protected int getSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    public void tip(String tipStr) {
        Toast.makeText(this, tipStr, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNetworkResponsed(int action, Object... values) {
        mHandler.obtainMessage(action, values[0]).sendToTarget();
    }


    protected boolean ifValueWasEmpty(String... values) {
        for (String value : values) {
            if (TextUtils.isEmpty(value)) {
                return true;
            }
        }
        return false;
    }
}
