package com.m520it.mostbeautiful.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.m520it.mostbeautiful.controller.BaseController;
import com.m520it.mostbeautiful.listener.IResponseListener;

/**
 * @author jane
 * @time 2016/11/8  11:25
 * @desc ${TODD}
 */
public abstract class BaseFragment extends Fragment implements IResponseListener{

    private boolean isFirstIn = true;
    protected BaseController mController;
    protected Handler mHandler = new Handler() {

        public void handleMessage(android.os.Message msg) {
            handlerMessage(msg);
        }

    };

    protected abstract void initUI();

    protected void handlerMessage(Message msg) {
        // default Empty implementn
    }

    protected void initController() {
        // default Empty implementn
    }

    @Override
    public void onNetworkResponsed(int action, Object... values) {
        mHandler.obtainMessage(action, values[0]).sendToTarget();
    }

    public void tip(String tipStr) {
        Toast.makeText(getActivity(), tipStr, Toast.LENGTH_SHORT).show();
    }

}
