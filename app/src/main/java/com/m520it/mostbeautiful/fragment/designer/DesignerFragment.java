package com.m520it.mostbeautiful.fragment.designer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m520it.mostbeautiful.Adapter.designer.DesignerAdapter;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.designer.DesignerFragmentBean;
import com.m520it.mostbeautiful.fragment.BaseFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;


/**
 * 设计师
 */
public class DesignerFragment extends BaseFragment {
    private ArrayList<DesignerFragmentBean> mPagers;
    private FragmentActivity mActivity;
    private SmartTabLayout mdesignerStl;
    private ViewPager mdesignerVp;
    private DesignerAdapter mDesignerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_designer, null, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initUI();
        mPagers = new ArrayList<>();
        String[] titles = getResources().getStringArray(R.array.designer);
        for (int i = 0; i < titles.length; i++) {
            DesignerFragmentBean infoBean = null;
            switch (i) {

                case 0 :
                    infoBean = new DesignerFragmentBean(new RecommendFragment(),titles[i]);
                    break;
                case 1 :
                    infoBean = new DesignerFragmentBean(new MostWelcomeFragment(),titles[i]);
                    break;
                case 2 :
                    infoBean = new DesignerFragmentBean(new SingDesignerFragment(),titles[i]);
                    break;
                case 3:
                    infoBean = new DesignerFragmentBean(new BrandDesignerFragment(),titles[i]);
                    break;

            }
            mPagers.add(infoBean);
        }

        mDesignerAdapter = new DesignerAdapter(getFragmentManager(), mPagers);
        mdesignerVp.setAdapter(mDesignerAdapter);
        //自动绑定数据
        mdesignerStl.setViewPager(mdesignerVp);
    }

    @Override
    protected void initUI() {
        mActivity = getActivity();
        mdesignerStl = (SmartTabLayout) mActivity.findViewById(R.id.designer_stl);
        //        mHaveThingStl.setItemClick(this);
        mdesignerVp = (ViewPager) getActivity().findViewById(R.id.designer_vp);


    }
}
