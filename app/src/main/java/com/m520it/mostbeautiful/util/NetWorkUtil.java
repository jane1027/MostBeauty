package com.m520it.mostbeautiful.util;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.m520it.mostbeautiful.MBApplication;
import com.m520it.mostbeautiful.listener.IResponseListener;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jane
 * @ 2016/11/7  20:57
 * @ ${}
 */
public class NetWorkUtil {
        private IResponseListener mListener;

        public void setListener(IResponseListener listener) {
            mListener = listener;
        }

        public void doGet(final int action, String urlPath) {
            //传递一个URL对象---->String类型的JSON语句
            StringRequest request = new StringRequest(urlPath, new Response.Listener<String>() {

                //该方法是在主线程中执行的
                @Override
                public void onResponse(String response) {
                               Log.i("TAG", "onResponse123 "+response);
                    if (mListener != null) {
                        mListener.onNetworkResponsed(action, response);
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (mListener != null) {
                        mListener.onNetworkResponsed(action, error);
                        Log.i("TAG", "失败" );
                    }
                }
            });
            //一般 一个应用多个请求--->请求队列里面去
            MBApplication.getRequestQueue().add(request);
        }

        public void doPost(final int action, String urlPath, final HashMap<String, String> paramsMap) {
            StringRequest request = new StringRequest(Request.Method.POST, urlPath,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.i("TAG", "Post onResponse " + response);
                            if(mListener!=null) {
                                mListener.onNetworkResponsed(action,response);
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    return paramsMap;
                }
            };
            MBApplication.getRequestQueue().add(request);
        }


}
