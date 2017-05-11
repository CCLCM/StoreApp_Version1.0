package com.zhxu.storeapp.fragment;

import android.os.Bundle;

import com.zhxu.storeapp.R;

/**
 * Created by xzhang on 2017/5/6.
 */

public class MyFragment extends BaseFragment {

    private static final String KEY = "EXTRA" ;
    public static MyFragment newInstance(String extra){
        Bundle bundle = new Bundle();
        bundle.putString(KEY,extra) ;
        MyFragment fragment = new MyFragment();
        fragment.setArguments(bundle);
        return fragment ;

    }

    @Override
    public int initLayout() {
        return R.layout.fragment_my;
    }

    @Override
    public void onFirstVisible() {

    }

    @Override
    public void onVisible() {

    }

    @Override
    public void onFirstInVisible() {

    }

    @Override
    public void onInVisible() {

    }
}
