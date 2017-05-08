package com.m520it.mostbeautiful.controller;

import android.content.Context;

import com.m520it.mostbeautiful.listener.IResponseListener;

/**
 * @author jane
 * @time 2016/11/8  11:26
 * @desc ${TODD}
 */
public abstract class BaseController {
    protected IResponseListener mListener;
    protected Context mContext;

    public void setIResponseListener(IResponseListener listener) {
        mListener=listener;
    }

    public BaseController(Context c) {
        mContext=c;
    }

    /**
     * @param action  一个页面可能有多个网络请求,用来区别这些请求的
     * @param values 请求的数据
     */
    public void sendAsyncMessage(final int action,final Object... values){
        new Thread(){
            public void run() {
                handleMessage(action, values);
            }
        }.start();
    }

    /**
     * 子类处理具体的需求的业务代码
     */
    protected abstract void handleMessage(int action,Object... values);
}
