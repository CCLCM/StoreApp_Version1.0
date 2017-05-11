package com.zhxu.storeapp.activity;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.zhxu.storeapp.R;
import com.zhxu.storeapp.adapter.FixPagerAdapter;
import com.zhxu.storeapp.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout ;
    @BindView(R.id.main_viewpager)
    ViewPager mainViewPager ;
    @BindView(R.id.status_bar)
    LinearLayout statusBar ;

    private FixPagerAdapter fixPagerAdapter ;
    private String[] titles = {"推荐","分类","排行","管理","我的"};
    private List<Fragment> fragments ;


    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            final int statusHeight = getStatusBarHeight();
            statusBar.post(new Runnable() {
                @Override
                public void run() {
                    int titleHeight = statusBar.getHeight();
                    android.widget.LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) statusBar.getLayoutParams();
                    params.height = statusHeight + titleHeight;
                    statusBar.setLayoutParams(params);
                }
            });
        }

        fixPagerAdapter = new FixPagerAdapter(getSupportFragmentManager()) ;

        fragments = new ArrayList<>() ;
        for(int i = 0 ;i < titles.length ; i ++){
            fragments.add(RecommendFragment.newInstance(titles[i])) ;
        }
        fixPagerAdapter.setTitles(titles);
        fixPagerAdapter.setFragments(fragments);

        mainViewPager.setAdapter(fixPagerAdapter);
        tabLayout.setupWithViewPager(mainViewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
}
