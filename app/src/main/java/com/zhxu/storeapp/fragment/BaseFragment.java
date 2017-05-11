package com.zhxu.storeapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by xzhang on 2017/5/6.
 */

public abstract class BaseFragment extends Fragment {

    protected View mView ;

    /**
     * 是否第一次显示
     */
    private boolean isFirstVisible = true;
    /**
     * 是否第一次不显示
     */
    private boolean isFirstInVisible = true;
    /**
     * 是否初始化
     */
    private boolean isPrepared = false;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = View.inflate(getContext(),initLayout(),null);
        ButterKnife.bind(this,mView) ;
        return mView ;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {//fragment可见
            if (isFirstVisible) { //第一次可见
                isFirstVisible = false;
                initPrepare();
            } else { //fragment可见  但不是第一次可见
                onVisible();
            }
        } else { //fragment不见
            if (isFirstInVisible) {  //第一次不可见
                isFirstInVisible = false;
                onFirstInVisible();
            } else { //fragment不可见 但不是第一次不可见
                onInVisible();
            }
        }
    }

    /**
     * 初始化
     */
    private void initPrepare() {
        if (isPrepared) {
            onFirstVisible();
        } else {
            isPrepared = true;
        }
    }

    public abstract int initLayout();

    /**
     * 第一次fragment可见
     */
    public abstract void onFirstVisible();

    /**
     * fragment可见（切换回来或onResume）
     */
    public abstract void onVisible();

    /**
     * 第一次fragment不可见
     */
    public abstract void onFirstInVisible();

    /**
     * fragment不可见（切换不可见或onPause）
     */
    public abstract void onInVisible();
}
