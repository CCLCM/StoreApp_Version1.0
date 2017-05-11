package com.zhxu.storeapp.fragment;

import android.os.Bundle;

import com.zhxu.storeapp.R;

/**
 * Created by xzhang on 2017/5/6.
 */

public class ManagerFragment extends BaseFragment {


    private static final String KEY = "EXTRA" ;
    public static ManagerFragment newInstance(String extra){
        Bundle bundle = new Bundle();
        bundle.putString(KEY,extra) ;
        ManagerFragment fragment = new ManagerFragment();
        fragment.setArguments(bundle);
        return fragment ;

    }

    @Override
    public int initLayout() {
        return R.layout.fragment_manager;
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
