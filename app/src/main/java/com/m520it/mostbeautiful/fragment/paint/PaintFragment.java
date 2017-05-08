package com.m520it.mostbeautiful.fragment.paint;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.appeaser.deckview.views.DeckChildView;
import com.appeaser.deckview.views.DeckView;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.activity.MainActivity;
import com.m520it.mostbeautiful.activity.WebActivity;
import com.m520it.mostbeautiful.bean.paintpage.PrintData;
import com.m520it.mostbeautiful.fragment.BaseFragment;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;


/**
 * 画报
 */
public class PaintFragment extends BaseFragment {
    DeckView<Datum> mDeckView;
    ImageView mImageView;
    Drawable mDefaultHeaderIcon;
    ArrayList<Datum> mData;
    Bitmap mDefaultThumbnail;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_paint,null,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initUI();
        initData();
    }

    private void initData() {
        //获取数据,显示不同页面
        ArrayList<PrintData.DataBean.ArticlesBean> articleDatas = ((MainActivity) getActivity()).mArticleDatas;
        if(articleDatas != null) {
            //设置数据
            setData(articleDatas);
            mDeckView.setVisibility(View.VISIBLE);
        }else {
            mImageView.setVisibility(View.VISIBLE);
        }
    }

    private void setData(ArrayList<PrintData.DataBean.ArticlesBean> articleDatas) {
        //设置
        if (mData == null) {
            mData = new ArrayList<>();

            for (int i = 0; i < 30; i++) {
                Datum datum = new Datum();
                datum.id = articleDatas.get(i).getId();
                datum.link = articleDatas.get(i).getImage_url();
                datum.headerTitle = articleDatas.get(i).getTitle();
                datum.iconLink = articleDatas.get(i).getAuthor().getAvatar_url();
                datum.subTitle = articleDatas.get(i).getSub_title();
                datum.authorName = articleDatas.get(i).getAuthor().getUsername();
                mData.add(datum);
            }
        }


        // Callback implementation
        DeckView.Callback<Datum> deckViewCallback = new DeckView.Callback<Datum>() {
            @Override
            public ArrayList<Datum> getData() {
                return mData;
            }

            @Override
            public void loadViewData(WeakReference<DeckChildView<Datum>> dcv, Datum item) {
                loadViewDataInternal(item, dcv);
            }

            @Override
            public void unloadViewData(Datum item) {
                Picasso.with(getActivity()).cancelRequest(item.target);
            }

            @Override
            public void onViewDismissed(Datum item) {
                mData.remove(item);
                mDeckView.notifyDataSetChanged();
            }

            @Override
            public void onItemClick(Datum item) {
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra(WebActivity.ID,item.id);
                startActivity(intent);
            }

            @Override
            public void onNoViewsToDeck() {
                Toast.makeText(getActivity(),
                        "No views to show",
                        Toast.LENGTH_SHORT).show();
            }
        };

        //设置回调事件
        mDeckView.initialize(deckViewCallback);
    }

    @Override
    protected void initUI() {
        //初始化view
        mDeckView = (DeckView) getActivity().findViewById(R.id.deckview);
        mImageView = (ImageView) getActivity().findViewById(R.id.bg_iv);
        //设置默认图片
        mDefaultThumbnail = BitmapFactory.decodeResource(getResources(), R.drawable.default_thumbnail);
        mDefaultHeaderIcon = getResources().getDrawable(R.drawable.default_header_icon);
    }

    void loadViewDataInternal(final Datum datum,
                              final WeakReference<DeckChildView<Datum>> weakView) {
        Picasso.with(getActivity()).cancelRequest(datum.target);

        datum.target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                // Pass loaded Bitmap to view
                if (weakView.get() != null) {
                    weakView.get().onDataLoaded(datum, bitmap,mDefaultHeaderIcon
                            , datum.headerTitle, Color.WHITE,datum.subTitle,"一一 "+datum.authorName+" 一一");
                }
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                // Loading failed. Pass default thumbnail instead
                if (weakView.get() != null) {
                    weakView.get().onDataLoaded(datum, mDefaultThumbnail,
                            mDefaultHeaderIcon, datum.headerTitle + " Failed", Color.WHITE,"loading...","loading...");
                }
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                // Pass the default thumbnail for now. It will
                // be replaced once the target Bitmap has been loaded
                if (weakView.get() != null) {
                    weakView.get().onDataLoaded(datum, mDefaultThumbnail,
                            mDefaultHeaderIcon, "Loading...", Color.WHITE,"loading...","loading...");
                }
            }
        };

        //加载头像
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Bitmap bitmap = Picasso.with(getActivity()).load(datum.iconLink).get();
                    Drawable drawable =new BitmapDrawable(bitmap);
                    mDefaultHeaderIcon = drawable;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        // 加载内容图片
        Picasso.with(getActivity()).load(datum.link).into(datum.target);
    }
}
