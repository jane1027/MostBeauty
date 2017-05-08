package com.m520it.mostbeautiful.fragment.designer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.m520it.mostbeautiful.Adapter.designer.DesignerMostwelAdapter;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.activity.DesignDetailsActivity;
import com.m520it.mostbeautiful.bean.designer.DesignerMw;
import com.m520it.mostbeautiful.bean.designer.MWbean;
import com.m520it.mostbeautiful.bean.designer.datas;
import com.m520it.mostbeautiful.cons.Actions;
import com.m520it.mostbeautiful.cons.NetWorkUrl;
import com.m520it.mostbeautiful.fragment.BaseFragment;
import com.m520it.mostbeautiful.util.NetWorkUtil;

import java.util.List;

/**
 * @author Jacob.Huang
 * @time 2016/11/10  0:01
 * @desc ${TODD}
 */
public class SingDesignerFragment extends BaseFragment {

    private DesignerMostwelAdapter mAdapter;
    private ListView mListView;

    @Override
    protected void handlerMessage(Message msg) {
        switch (msg.what) {
            case Actions.DESIGN_SINGLE_ACTION :
                handleWelcomeJson((String) msg.obj);
                Log.v("jane",(String) msg.obj);
                break;
        }

    }

    private void handleWelcomeJson(String JsonStr) {
        MWbean mWbean = JSON.parseObject(JsonStr, MWbean.class);
        datas datas = JSON.parseObject(mWbean.getData(), datas.class);
        final List<DesignerMw> designerMws = JSON.parseArray(datas.getDesigners(), DesignerMw.class);
        mAdapter.setDatas(designerMws);
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DesignDetailsActivity.class);
                intent.putExtra("id",designerMws.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_designer_single,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initUI();
        NetWorkUtil netWorkUtil = new NetWorkUtil();
        netWorkUtil.setListener(this);
        netWorkUtil.doGet(Actions.DESIGN_SINGLE_ACTION, NetWorkUrl.DESIGN_SINGLE_URL);
    }

    @Override
    protected void initUI() {
        mListView = (ListView) getActivity().findViewById(R.id.design_single);
        mAdapter = new DesignerMostwelAdapter(getActivity());

    }
}
