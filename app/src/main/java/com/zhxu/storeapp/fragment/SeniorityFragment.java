package com.zhxu.storeapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhxu.storeapp.R;

/**
 * Created by xzhang on 2017/5/6.
 */

public class SeniorityFragment extends BaseFragment {



    private static final String KEY = "EXTRA" ;
    public static SeniorityFragment newInstance(String extra){
        Bundle bundle = new Bundle();
        bundle.putString(KEY,extra) ;
        SeniorityFragment fragment = new SeniorityFragment();
        fragment.setArguments(bundle);
        return fragment ;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initLayout() {
        return R.layout.fragment_seniority;
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
