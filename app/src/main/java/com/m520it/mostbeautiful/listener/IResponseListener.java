package com.m520it.mostbeautiful.listener;

/**
 * @author jane
 * @time 2016/11/8  11:17
 * @desc ${TODD}
 */
public interface IResponseListener {
    /**
     *
     * @param action  用来区别多重请求
     * @param values 返回的值
     */
    public void onNetworkResponsed(int action, Object... values);
}
