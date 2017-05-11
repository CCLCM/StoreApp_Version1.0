package com.zhxu.storeapp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhxu.storeapp.R;
import com.zhxu.storeapp.adapter.AppDetailPagerAdapter;
import com.zhxu.storeapp.bean.AppDetailBean;
import com.zhxu.storeapp.fragment.AppCommentFragment;
import com.zhxu.storeapp.fragment.AppIntroductionFragment;
import com.zhxu.storeapp.fragment.AppRecommendFragment;
import com.zhxu.storeapp.utils.SinaWeibo;
import com.zhxu.storeapp.view.widget.SubTabNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AppDetailActivity extends BaseActivity {

    @BindView(R.id.title_text)
    TextView title_text ;
    @BindView(R.id.iv_search)
    ImageView iv_search ;
    @BindView(R.id.detail_head_app_icon_imageview)
    ImageView detail_app_icon ;
    @BindView(R.id.detail_head_app_name_textview)
    TextView detail_app_name ;
    @BindView(R.id.detail_head_download_count_textview)
    TextView detail_app_download_count ;
    @BindView(R.id.detail_head_app_stars_ratingbar)
    RatingBar detail_app_stars ;
    @BindView(R.id.detail_head_label_layout_linearlayout)
    RelativeLayout detail_head_label_layout ;
    @BindView(R.id.detail_head_label_icon_layout_linearlayout)
    LinearLayout detail_head_label_icon_layout ;
    @BindView(R.id.detail_head_lable_folding_textview)
    TextView detail_head_lable_folding ;
    @BindView(R.id.detail_head_safe_icon_container_linearlayout)
    LinearLayout detail_head_safe_icon_container ;
    @BindView(R.id.detail_head_safe_icon_layout_linearlayout)
    LinearLayout detail_head_safe_icon_layout ;
    @BindView(R.id.subTab)
    SubTabNavigator subTabNavigator ;
    @BindView(R.id.vp)
    ViewPager mViewPager ;
    @BindView(R.id.appdetail_head)
    LinearLayout appdetail_head ;


    private String packageName ;

    private AppIntroductionFragment appIntroductionFragment ;
    private AppCommentFragment appCommentFragment ;
    private AppRecommendFragment appRecommendFragment ;
    private List<Fragment> fragments ;
    private AppDetailPagerAdapter appDetailPagerAdapter ;

    protected boolean expand = false;
    private AppDetailBean mAppDetailBean ;

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_app_detail);
        //设置沉浸式状态栏
        setStatusBar();
    }

    @Override
    protected void initView() {

        packageName = getIntent().getStringExtra("packageName");
        iv_search.setVisibility(View.VISIBLE);
        //设置沉浸式状态栏背景
        title_bar.setBackgroundResource(R.color.black_alpha_5);
        title_text.setText(getResources().getString(R.string.title_activity_app_detail));

        AppDetailBean appDetailBean = new AppDetailBean();
        appDetailBean = (AppDetailBean) appDetailBean.fromJson(SinaWeibo.str);
        mAppDetailBean = appDetailBean ;

        Picasso.with(this).load(appDetailBean.getMsg().getIntroduce().getIconUrl()).into(detail_app_icon);
        detail_app_name.setText(appDetailBean.getMsg().getIntroduce().getName());
        detail_app_download_count.setText(appDetailBean.getMsg().getIntroduce().getDownloadNum());
        detail_app_stars.setRating(appDetailBean.getMsg().getIntroduce().getStars());


        setLabel(appDetailBean);
        setSafeLabel(appDetailBean);
        setSubTab(appDetailBean);

        detail_head_label_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expand){
                    expand = false ;
                    detail_head_safe_icon_layout.setVisibility(View.GONE);
                    detail_head_lable_folding.setBackgroundResource(R.drawable.ic_public_arrow_down);
                }else {
                    expand = true ;
                    detail_head_safe_icon_layout.setVisibility(View.VISIBLE);
                    detail_head_lable_folding.setBackgroundResource(R.drawable.ic_public_arrow_up);
                }
            }
        });


    }
    public void setLabel(AppDetailBean appDetailBean){
        for(AppDetailBean.MsgBean.IntroduceBean.LabelNamesBean labelNamesBean : appDetailBean.getMsg().getIntroduce().getLabelNames()){
            View labelView = View.inflate(this,R.layout.appdetail_item_head_label_item,null);
            TextView label = (TextView) labelView.findViewById(R.id.appdetail_head_label_textview);
            label.setText(labelNamesBean.getName());
            if(labelNamesBean.getType() == 1){
                label.setTextColor(getResources().getColor(R.color.app_not_safe_textcolor));
            }
            detail_head_label_icon_layout.addView(labelView);
        }
    }

    public void setSafeLabel(AppDetailBean appDetailBean){

        for(AppDetailBean.MsgBean.IntroduceBean.SafeLabelsBean safeLabelsBean : appDetailBean.getMsg().getIntroduce().getSafeLabels()){
            View safeLabelView = View.inflate(this,R.layout.appdetail_item_head_safe_item, null);
            TextView safe_checker = (TextView) safeLabelView.findViewById(R.id.safe_checker_textview);
            TextView safe_checker_label = (TextView) safeLabelView.findViewById(R.id.safe_checker_label);
            ImageView detail_head_app_icon = (ImageView) safeLabelView.findViewById(R.id.detail_head_app_icon_imageview);
            TextView detail_safe_desc_textview = (TextView) safeLabelView.findViewById(R.id.detail_safe_desc_textview);

            safe_checker.setText(safeLabelsBean.getDetectorName());
            safe_checker_label.setText(safeLabelsBean.getDetectorDesc());
            Picasso.with(this).load(safeLabelsBean.getUrl()).into(detail_head_app_icon);
            detail_safe_desc_textview.setText(safeLabelsBean.getName());

            detail_head_safe_icon_container.addView(safeLabelView);
        }
    }

    private void setSubTab(AppDetailBean appDetailBean){
        fragments = new ArrayList<>() ;
        appDetailPagerAdapter = new AppDetailPagerAdapter(getSupportFragmentManager()) ;
        appIntroductionFragment = AppIntroductionFragment.newInstance("introduction");
        appCommentFragment = AppCommentFragment.newInstance("comment");
        appRecommendFragment = AppRecommendFragment.newInstance("recommend") ;

        fragments.add(appIntroductionFragment);
        fragments.add(appCommentFragment);
        fragments.add(appRecommendFragment);

        appDetailPagerAdapter.setFragments(fragments);
        mViewPager.setAdapter(appDetailPagerAdapter);
        mViewPager.setOnPageChangeListener(subTabNavigator);
        subTabNavigator.setViewPager(mViewPager);

        subTabNavigator.setLeftText(appDetailBean.getTabInfo().get(0).getTabName());
        subTabNavigator.setNoneText(appDetailBean.getTabInfo().get(1).getTabName());
        subTabNavigator.setRightText(appDetailBean.getTabInfo().get(2).getTabName());
    }

    public AppDetailBean getAppDetailBeanDate(){
        return mAppDetailBean ;
    }

    public SubTabNavigator getSubTabNavigator(){
        return subTabNavigator ;
    }

    public LinearLayout getAppDetailHead(){
        return appdetail_head ;
    }
}
