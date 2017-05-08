package com.m520it.mostbeautiful.Adapter.designer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.m520it.mostbeautiful.bean.designer.DesignerFragmentBean;

import java.util.ArrayList;

/**
 * @author jane
 * @time 2016/11/11  15:22
 * @desc ${TODD}
 */
public class DesignerAdapter extends FragmentPagerAdapter {

    private ArrayList<DesignerFragmentBean> mPagers;
    public DesignerAdapter(FragmentManager fm, ArrayList<DesignerFragmentBean> pagers) {
        super(fm);
        this.mPagers = pagers;
    }

    @Override
    public Fragment getItem(int position) {
        return mPagers.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mPagers.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPagers.get(position).getTitle();
    }
}