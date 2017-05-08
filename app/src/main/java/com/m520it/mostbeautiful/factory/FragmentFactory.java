package com.m520it.mostbeautiful.factory;


import com.m520it.mostbeautiful.fragment.BaseFragment;
import com.m520it.mostbeautiful.fragment.designer.DesignerFragment;
import com.m520it.mostbeautiful.fragment.havething.HaveThingFragment;
import com.m520it.mostbeautiful.fragment.mine.MineFragment;
import com.m520it.mostbeautiful.fragment.paint.PaintFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王维波
 * @time 2016/9/24  14:39
 * @desc ${TODD}    Fragment工厂类,为Fragment做缓存
 */
public class FragmentFactory {
    private static final int FRAGMENT_PAINT = 0;//代表生成首页的fragment
    private static final int FRAGMENT_HAVETHING = 1;//
    private static final int FRAGMENT_DESIGN = 2;//
    private static final int FRAGMENT_MINE = 3;//

    private static Map<Integer,BaseFragment> fragments=new HashMap<>();


    public static BaseFragment getFragment(int position) {
        BaseFragment fragment=null;
        if(fragments.containsKey(position)) {
            fragment= fragments.get(position);
            return fragment ;
        }
        switch (position){
            case FRAGMENT_PAINT:
                fragment= new PaintFragment();
                break;
            case FRAGMENT_HAVETHING:
                fragment=new HaveThingFragment();
                break;
            case FRAGMENT_DESIGN:
                fragment=new DesignerFragment();
                break;
            case FRAGMENT_MINE:
                fragment=new MineFragment();
                break;
        }
        fragments.put(position,fragment);
        return fragment;
    }
}
