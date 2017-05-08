package com.m520it.mostbeautiful.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.paintpage.PrintData;
import com.m520it.mostbeautiful.fragment.BaseFragment;
import com.m520it.mostbeautiful.fragment.designer.DesignerFragment;
import com.m520it.mostbeautiful.fragment.havething.HaveThingFragment;
import com.m520it.mostbeautiful.fragment.mine.MineFragment;
import com.m520it.mostbeautiful.fragment.paint.PaintFragment;
import com.m520it.mostbeautiful.listener.IBottomBarClickListener;
import com.m520it.mostbeautiful.view.BottomBar;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
public class MainActivity extends BaseActivity implements
        IBottomBarClickListener {

    private BottomBar mBottomBar;
    private FragmentManager mFragmentManager;
    public ArrayList<PrintData.DataBean.ArticlesBean> mArticleDatas;
    private WeakReference<BaseFragment> mPaintFragmentWeakReference;//画报Fragment
    private WeakReference<BaseFragment> mHaveThingFragmentWeakReference;//有物Fragment
    private WeakReference<BaseFragment> mDesignerFragmentWeakReference;//设计师Fragment
    private WeakReference<BaseFragment> mMineFragmentWeakReference;//我Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        initData();
        initUI();
    }

    @Override
    protected void initData() {
        //从splashAcivitiy里获得数据,并设置为全局变量以便fragment调用
        Intent intent = getIntent();
        if(intent != null) {
            mArticleDatas = (ArrayList<PrintData.DataBean.ArticlesBean>) intent.getSerializableExtra(Splashactivity.ARTICLES_DATAS);
        }
    }

    @Override
    protected void initUI() {
        transparentHeading();
        //
        mBottomBar = (BottomBar) findViewById(R.id.bottom_bar);
        mBottomBar.setIBottomBarClickListener(this);
        //


        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        //        transaction.replace(R.id.top_bar, new PaintFragment());
        if(mPaintFragmentWeakReference==null||mPaintFragmentWeakReference.get()==null){
            PaintFragment paintFragment = new PaintFragment();
            mPaintFragmentWeakReference = new WeakReference<BaseFragment>(paintFragment);
            transaction.add(R.id.top_bar,paintFragment);
        }else{
            //先隐藏所有的不为null的Fragment
            hideFragments(transaction);
            transaction.show(mPaintFragmentWeakReference.get());
        }
        transaction.commit();
    }


    //	Fragment
    @Override
    public void onItemClick(int action) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        switch (action) {
            case R.id.frag_main_ll:
                if(mPaintFragmentWeakReference==null||mPaintFragmentWeakReference.get()==null){
                    PaintFragment paintFragment = new PaintFragment();
                    mPaintFragmentWeakReference = new WeakReference<BaseFragment>(paintFragment);
                    transaction.add(R.id.top_bar,paintFragment);
                }else{
                    //先隐藏所有的不为null的Fragment
                    hideFragments(transaction);
                    transaction.show(mPaintFragmentWeakReference.get());
                }
                //                transaction.replace(R.id.top_bar, new PaintFragment());
                break;
            case R.id.frag_category_ll:
                if(mHaveThingFragmentWeakReference==null||mHaveThingFragmentWeakReference.get()==null){
                    HaveThingFragment haveThingFragment = new HaveThingFragment();
                    mHaveThingFragmentWeakReference = new WeakReference<BaseFragment>(haveThingFragment);
                    transaction.add(R.id.top_bar,haveThingFragment);
                }else{
                    //先隐藏所有的不为null的Fragment
                    hideFragments(transaction);
                    transaction.show(mHaveThingFragmentWeakReference.get());
                }
                //                transaction.replace(R.id.top_bar, new HaveThingFragment());
                break;
            case R.id.frag_shopcar_ll:
                if(mDesignerFragmentWeakReference==null||mDesignerFragmentWeakReference.get()==null){
                    DesignerFragment designerFragment = new DesignerFragment();
                    mDesignerFragmentWeakReference = new WeakReference<BaseFragment>(designerFragment);
                    transaction.add(R.id.top_bar,designerFragment);
                }else{
                    //先隐藏所有的不为null的Fragment
                    hideFragments(transaction);
                    transaction.show(mDesignerFragmentWeakReference.get());
                }
                //                transaction.replace(R.id.top_bar, new DesignerFragment());
                break;
            case R.id.frag_mine_ll:
                if(mMineFragmentWeakReference==null||mMineFragmentWeakReference.get()==null){
                    MineFragment mineFragment = new MineFragment();
                    mMineFragmentWeakReference = new WeakReference<BaseFragment>(mineFragment);
                    transaction.add(R.id.top_bar,mineFragment);
                }else{
                    //先隐藏所有的不为null的Fragment
                    hideFragments(transaction);
                    transaction.show(mMineFragmentWeakReference.get());
                }
                //                transaction.replace(R.id.top_bar, FragmentFactory.getFragment(3));
                //                transaction.replace(R.id.top_bar, new MineFragment());
                break;
        }
        transaction.commit();
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (mPaintFragmentWeakReference != null&&mPaintFragmentWeakReference.get()!=null) {
            transaction.hide(mPaintFragmentWeakReference.get());
        }
        if (mHaveThingFragmentWeakReference != null&&mHaveThingFragmentWeakReference.get()!=null) {
            transaction.hide(mHaveThingFragmentWeakReference.get());
        }
        if (mDesignerFragmentWeakReference != null&&mDesignerFragmentWeakReference.get()!=null) {
            transaction.hide(mDesignerFragmentWeakReference.get());
        }
        if (mMineFragmentWeakReference != null&&mMineFragmentWeakReference.get()!=null) {
            transaction.hide(mMineFragmentWeakReference.get());
        }
    }

}

/*
public class MainActivity extends BaseActivity implements
        IBottomBarClickListener {

    private BottomBar mBottomBar;
    private FragmentManager mFragmentManager;
    public ArrayList<PrintData.DataBean.ArticlesBean> mArticleDatas;//PaintFragment的数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        initData();
        initUI();
    }

    @Override
    protected void initData() {
        //从splashAcivitiy里获得数据,并设置为全局变量以便PaintFragment调用
        Intent intent = getIntent();
        if(intent != null) {
            mArticleDatas = (ArrayList<PrintData.DataBean.ArticlesBean>) intent.getSerializableExtra(Splashactivity.ARTICLES_DATAS);
        }
    }

    @Override
    protected void initUI() {
        transparentHeading();
        //
        mBottomBar = (BottomBar) findViewById(R.id.bottom_bar);
        mBottomBar.setIBottomBarClickListener(this);
        //
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.top_bar, new PaintFragment());
        transaction.commit();
    }


    //	Fragment
    @Override
    public void onItemClick(int action) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        switch (action) {
            case R.id.frag_main_ll:
//                transaction.replace(R.id.top_bar, FragmentFactory.getFragment(0));
                transaction.replace(R.id.top_bar, new PaintFragment());
                break;
            case R.id.frag_category_ll:
//                transaction.replace(R.id.top_bar, FragmentFactory.getFragment(1));
                transaction.replace(R.id.top_bar, new HaveThingFragment());
                break;
            case R.id.frag_shopcar_ll:
//                transaction.replace(R.id.top_bar, FragmentFactory.getFragment(2));
                transaction.replace(R.id.top_bar, new DesignerFragment());
                break;
            case R.id.frag_mine_ll:
//                transaction.replace(R.id.top_bar, FragmentFactory.getFragment(3));
                transaction.replace(R.id.top_bar, new MineFragment());
                break;
        }
        transaction.commit();
    }

}*/
