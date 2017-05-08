package com.m520it.mostbeautiful.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.m520it.mostbeautiful.Adapter.SuggustionAdapter;
import com.m520it.mostbeautiful.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author ben
 * @time 2016/11/12  20:23
 * @desc ${TODD}
 */
public class SuggestionActivity extends BaseActivity implements View.OnClickListener {
    private ListView mReplyLv;
    private ImageButton mBackBtn;
    private Button mSendBtn;
    private EditText mReplyEt;
    private SuggustionAdapter mAdapter;
    private ArrayList<String> mReplyContent = new ArrayList<>();
    private ArrayList<String> mReplyDate = new ArrayList<>();
    private RelativeLayout mContectRl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        initUI();
    }

    @Override
    protected void initUI() {
        transparentHeading();
        mBackBtn = (ImageButton) findViewById(R.id.back_iv);
        mBackBtn.setOnClickListener(this);

        mContectRl = (RelativeLayout) findViewById(R.id.contect_rl);
        mContectRl.setOnClickListener(this);

        mReplyLv = (ListView) findViewById(R.id.reply_list_lv);
        mAdapter = new SuggustionAdapter(this);
        mReplyLv.setAdapter(mAdapter);

        mSendBtn = (Button) findViewById(R.id.send_btn);
        mSendBtn.setOnClickListener(this);
        mReplyEt = (EditText) findViewById(R.id.reply_content_et);
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    public  boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = { 0, 0 };
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_iv:
                finish();
                break;
            case R.id.send_btn:
                //获取输入内容
                String replyStr = mReplyEt.getText().toString();
                if(!TextUtils.isEmpty(replyStr)) {
                    mReplyEt.getText().clear();
                    mReplyContent.add(replyStr);
                    //展示在listview里
                    mAdapter.setDatas(mReplyContent);
                    mAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.contect_rl:
                Snackbar.make(mContectRl,"没时间解释了,快上车!",0).setAction("好的!", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SuggestionActivity.this, "已报警", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.WHITE).show();
                break;
        }
    }

    public ArrayList<String> getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("—— yyyy年MM月dd日 HH:mm:ss ——");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String date = formatter.format(curDate);
        mReplyDate.add(date);
        return mReplyDate;
    }
}
