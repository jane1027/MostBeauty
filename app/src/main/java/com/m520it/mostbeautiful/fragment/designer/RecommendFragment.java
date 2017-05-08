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
import android.widget.GridView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.m520it.mostbeautiful.Adapter.designer.DesignerMostwelAdapter;
import com.m520it.mostbeautiful.Adapter.designer.DesignerRecommGridViewAdapter;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.activity.DesignDetailsActivity;
import com.m520it.mostbeautiful.activity.DesignItemActivity;
import com.m520it.mostbeautiful.bean.designer.DesignerMw;
import com.m520it.mostbeautiful.bean.designer.RecommBean;
import com.m520it.mostbeautiful.bean.designer.RecommCategoriesValue;
import com.m520it.mostbeautiful.bean.designer.RecommData;
import com.m520it.mostbeautiful.cons.Actions;
import com.m520it.mostbeautiful.cons.NetWorkUrl;
import com.m520it.mostbeautiful.fragment.BaseFragment;
import com.m520it.mostbeautiful.util.FixedViewUtil;
import com.m520it.mostbeautiful.util.NetWorkUtil;

import java.util.List;

/**
 * @author Jacob.Huang
 * @time 2016/11/10  0:00
 * @desc ${TODD}
 */
public class RecommendFragment extends BaseFragment  {

    private RecommBeanList mRecommBeanList;
    private GridView mGridView;
    private ListView mListView;
    private DesignerMostwelAdapter mDesignerMostwelAdapter;
    private DesignerRecommGridViewAdapter mGridViewAdapter;

    @Override
    protected void handlerMessage(Message msg) {
        switch (msg.what){
            case Actions.DESIGN_RECOMMEND_ACTION:
                String JsonStr= (String) msg.obj;
                RecommBeanList recommBeanListResult = paseJson(JsonStr);
                mGridViewAdapter = new DesignerRecommGridViewAdapter(getActivity());
                mGridViewAdapter.setDatas(recommBeanListResult.categoriesResult);
                mGridView.setAdapter(mGridViewAdapter);
                mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(getActivity(), DesignItemActivity.class);
                        intent.putExtra("id",mRecommBeanList.categoriesResult.get(position).getId());
                        intent.putExtra("name",mRecommBeanList.categoriesResult.get(position).getName());
                        startActivity(intent);
                    }
                });


                mDesignerMostwelAdapter = new DesignerMostwelAdapter(getActivity());
                mDesignerMostwelAdapter.setDatas(recommBeanListResult.DesignersArrResult);
                mListView.setAdapter(mDesignerMostwelAdapter);
                FixedViewUtil.setListViewHeightBasedOnChildren(mListView);
                mDesignerMostwelAdapter.notifyDataSetChanged();
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent= new Intent(getActivity(),DesignDetailsActivity.class);
                        intent.putExtra("id",mRecommBeanList.DesignersArrResult.get(position).getId());
                        startActivity(intent);
                    }
                });


                break;
        }
    }







    private RecommBeanList paseJson(String JsonStr) {
        RecommData recommData = JSON.parseObject(JsonStr, RecommData.class);
        RecommBean recommBean = JSON.parseObject(recommData.getData(),RecommBean.class);
        mRecommBeanList = new RecommBeanList();
        mRecommBeanList.categoriesResult = JSON.parseArray(recommBean.getCategories(), RecommCategoriesValue.class);
        Log.v("520it",mRecommBeanList.categoriesResult+"");
        mRecommBeanList.DesignersArrResult = JSON.parseArray(recommBean.getDesigners(), DesignerMw.class);
        Log.v("520it",mRecommBeanList.DesignersArrResult+"");
        return mRecommBeanList;
    }



    class RecommBeanList{
        List<RecommCategoriesValue> categoriesResult;
        List<DesignerMw> DesignersArrResult;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommend,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
        initUI();

    }

    private void loadData() {
        NetWorkUtil netWorkUtil=new NetWorkUtil();
        netWorkUtil.setListener(this);
        netWorkUtil.doGet(Actions.DESIGN_RECOMMEND_ACTION, NetWorkUrl.DESGIN_RECOMM_URL);
    }


    @Override
    protected void initUI() {
        mGridView= (GridView) getActivity().findViewById(R.id.gridView);
        mListView= (ListView) getActivity().findViewById(R.id.listView);

    }
}
