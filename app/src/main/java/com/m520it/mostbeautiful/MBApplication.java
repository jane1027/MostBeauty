package com.m520it.mostbeautiful;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author jane
 * @time 2016/11/7  20:27
 * @desc ${TODD}
 */
public class MBApplication extends Application{
    private static RequestQueue mQueue;

    public static RequestQueue getRequestQueue(){
        return mQueue;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mQueue= Volley.newRequestQueue(this);
    }
}
