package com.m520it.mostbeautiful.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.m520it.mostbeautiful.Adapter.designer.DesignerMostwelAdapter;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.designer.DesignerMw;
import com.m520it.mostbeautiful.bean.designer.RecommBean;
import com.m520it.mostbeautiful.bean.designer.RecommData;
import com.m520it.mostbeautiful.cons.Actions;
import com.m520it.mostbeautiful.cons.NetWorkUrl;
import com.m520it.mostbeautiful.util.NetWorkUtil;

import java.util.List;

/**
 * @author Jacob.Huang
 * @time 2016/11/12  15:43
 * @desc ${TODD}
 */
public class DesignItemActivity extends BaseActivity implements View.OnClickListener {
    private ListView mListView;
    private DesignerMostwelAdapter mAdapter;
    private String mName;
    private TextView mTextView;
    private ImageView mImggeView;

    @Override
    protected void handlerMessage(Message msg) {
        switch (msg.what){
            case Actions.DESIGN_RECOMMENDITEM_ACTION:
                String jsonStr = (String) msg.obj;
                final List<DesignerMw> resultDatas = paseJson(jsonStr);
                mAdapter = new DesignerMostwelAdapter(this);
                mListView.setAdapter(mAdapter);
                mAdapter.setDatas(resultDatas);
                mAdapter.notifyDataSetChanged();
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent= new Intent(DesignItemActivity.this,DesignDetailsActivity.class);
                        intent.putExtra("id",resultDatas.get(position).getId());
                        startActivity(intent);
                    }
                });
                break;
        }
    }

    private List<DesignerMw> paseJson(String jsonStr) {
        RecommData recommData = JSON.parseObject(jsonStr, RecommData.class);
        RecommBean recommBean = JSON.parseObject(recommData.getData(), RecommBean.class);
        List<DesignerMw> resultArr = JSON.parseArray(recommBean.getDesigners(), DesignerMw.class);
        return resultArr;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_item);
        initData();
        initUI();
        initEvent();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        long id = intent.getLongExtra("id", 0);
        mName = intent.getStringExtra("name");
        NetWorkUtil netWorkUtil= new NetWorkUtil();
        netWorkUtil.setListener(this);
        String url = NetWorkUrl.DESGIN_RECOMMITEM_URL + id+"/";

        netWorkUtil.doGet(Actions.DESIGN_RECOMMENDITEM_ACTION,url);
    }

    @Override
    protected void initUI() {
        mListView= (ListView) findViewById(R.id.lv);

        mTextView= (TextView) findViewById(R.id.tv_title);
        mImggeView= (ImageView) findViewById(R.id.img_back);

    }

    private void initEvent() {
        if(mName!=null) {
              mTextView.setText(mName);
        }

        mImggeView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
