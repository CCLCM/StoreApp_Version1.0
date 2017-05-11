package com.zhxu.storeapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhxu.storeapp.R;
import com.zhxu.storeapp.activity.AppDetailActivity;
import com.zhxu.storeapp.activity.GalleryActivity;
import com.zhxu.storeapp.bean.AppDetailBean;
import com.zhxu.storeapp.view.BounceScrollView;
import com.zhxu.storeapp.view.widget.FoldingTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 * APP介绍
 *
 * Created by xzhang on 2017/5/10.
 */

public class AppIntroductionFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.app_detail_gallery_container_linearlayout)
    LinearLayout app_detail_gallery_container ;
    @BindView(R.id.detail_appinfo_tariff_textview)
    TextView appInfoTariff ;
    @BindView(R.id.detail_appinfo_size_textview)
    TextView appInfoSize ;
    @BindView(R.id.detail_appinfo_version_textview)
    TextView appInfoVersion ;
    @BindView(R.id.detail_appinfo_release_date_textview)
    TextView appInfoDate ;
    @BindView(R.id.appdetail_appinfo_developer_textview)
    TextView appInfoDeveloper ;
    @BindView(R.id.app_detail_info)
    FoldingTextView appInfoDes ;
    @BindView(R.id.app_introduction_scrollview)
    BounceScrollView appIntroduction ;

    private AppDetailBean appDetailBeanDate ;

    private static final String KEY = "EXTRA" ;
    public static AppIntroductionFragment newInstance(String extra){
        Bundle bundle = new Bundle();
        bundle.putString(KEY,extra) ;
        AppIntroductionFragment fragment = new AppIntroductionFragment();
        fragment.setArguments(bundle);
        return fragment ;
    }

    @Override
    public int initLayout() {
        return R.layout.fragment_app_introduction;
    }

    @Override
    public void onFirstVisible() {

        appDetailBeanDate = ((AppDetailActivity) getActivity()).getAppDetailBeanDate();

        for(int i = 0 ;i < appDetailBeanDate.getMsg().getScreen().getImageCompress().size() ; i ++){
            String url = appDetailBeanDate.getMsg().getScreen().getImageCompress().get(i);
            View screenView = View.inflate(getContext(),R.layout.appdetail_item_screen_image,null) ;
            ImageView screenImageView = (ImageView) screenView.findViewById(R.id.appdetail_screen_img_imageview);
            screenImageView.setContentDescription(screenImageView.getResources().getString(R.string.appdetail_screenshot));
            screenImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            screenImageView.setTag(i);
            screenImageView.setOnClickListener(this);
            Picasso.with(getContext()).load(url).into(screenImageView);
            app_detail_gallery_container.addView(screenView);
        }

        appInfoTariff.setText(appDetailBeanDate.getMsg().getInfo().getTariffDesc());
        appInfoSize.setText(Formatter.formatFileSize(getContext(),Long.parseLong(appDetailBeanDate.getMsg().getInfo().getSize())));
        appInfoDate.setText(appDetailBeanDate.getMsg().getInfo().getReleaseDate());
        appInfoVersion.setText(appDetailBeanDate.getMsg().getInfo().getVersion());
        appInfoDeveloper.setText(appDetailBeanDate.getMsg().getInfo().getDeveloper());

        appInfoDes.setTitle(appDetailBeanDate.getMsg().getPart().getPartPer().getTitle());
        appInfoDes.setContent(appDetailBeanDate.getMsg().getPart().getPartPer().getBody());



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

    @Override
    public void onClick(View v) {
        ImageView imageView = (ImageView)v ;
        int tag = (int) imageView.getTag();
        List<String> images = appDetailBeanDate.getMsg().getScreen().getImages();
        Intent intent = new Intent(getContext(), GalleryActivity.class);
        intent.putExtra("tag",tag) ;
        intent.putStringArrayListExtra("urlList", (ArrayList<String>) images);
        getActivity().startActivity(intent) ;
    }
}
