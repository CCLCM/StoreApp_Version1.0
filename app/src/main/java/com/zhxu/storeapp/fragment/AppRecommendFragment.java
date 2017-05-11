package com.zhxu.storeapp.fragment;

import android.os.Bundle;

import com.zhxu.storeapp.R;

/**
 *
 * APP推荐
 * Created by xzhang on 2017/5/10.
 */

public class AppRecommendFragment extends BaseFragment {

    private static final String KEY = "EXTRA" ;
    public static AppRecommendFragment newInstance(String extra){
        Bundle bundle = new Bundle();
        bundle.putString(KEY,extra) ;
        AppRecommendFragment fragment = new AppRecommendFragment();
        fragment.setArguments(bundle);
        return fragment ;
    }

    @Override
    public int initLayout() {
        return R.layout.fragment_app_recomment;
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
