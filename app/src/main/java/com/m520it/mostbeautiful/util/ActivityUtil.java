package com.m520it.mostbeautiful.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.m520it.mostbeautiful.activity.BaseActivity;

/**
 * @author jane
 * @time 2016/11/7  20:57
 * @desc ${TODD}
 */
public class ActivityUtil {

    public static void start(Context c, Class<? extends BaseActivity> clazz, boolean ifFinishSelf){
        Intent intent=new Intent(c,clazz);
        c.startActivity(intent);
        if (ifFinishSelf) {
            ((Activity)c).finish();
        }
    }
}
