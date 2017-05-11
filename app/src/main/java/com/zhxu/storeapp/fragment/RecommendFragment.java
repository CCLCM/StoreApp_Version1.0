package com.zhxu.storeapp.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.cniao5.cwidgetutils.AutoGallery;
import com.cniao5.cwidgetutils.FlowIndicator;
import com.squareup.picasso.Picasso;
import com.zhxu.storeapp.R;
import com.zhxu.storeapp.adapter.ListAdapter;
import com.zhxu.storeapp.bean.AppDetailListBean;
import com.zhxu.storeapp.utils.Date;

import butterknife.BindView;

/**
 * Created by xzhang on 2017/5/6.
 */

public class RecommendFragment extends BaseFragment{

    @BindView(R.id.recommend_listview)
    ListView recommend_listview;

    private AppDetailListBean appDetailListBean ;

    private AutoGallery headline_image_gallery ;
    private FlowIndicator headline_circle_indicator ;
    private View headView;

    private int gallerySelectedPositon=0;//Gallery索引
    private int circleSelectedPosition = 0; // 默认指示器的圆圈的位置为第一

    private ListAdapter adapter ;

    private static final String KEY = "EXTRA" ;
    public static RecommendFragment newInstance(String extra){
        Bundle bundle = new Bundle();
        bundle.putString(KEY,extra) ;
        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(bundle);
        return fragment ;
    }

    @Override
    public int initLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void onFirstVisible() {

        appDetailListBean = new AppDetailListBean();
        appDetailListBean = (AppDetailListBean) appDetailListBean.fromJson(Date.str);

        headView=View.inflate(getContext(),R.layout.gallery_indicator_layout,null);
        //获取AutoGallery和FlowIndicator控件
        headline_image_gallery=(AutoGallery)headView.findViewById(R.id.headline_image_gallery);
        headline_circle_indicator=(FlowIndicator)headView.findViewById(R.id.headline_circle_indicator);

        recommend_listview.addHeaderView(headView);

        //设置指示器
        headline_circle_indicator.setCount(appDetailListBean.getMsg().getPicture().size());
        headline_circle_indicator.setSeletion(circleSelectedPosition);

        headline_image_gallery.setLength(appDetailListBean.getMsg().getPicture().size());
        gallerySelectedPositon=appDetailListBean.getMsg().getPicture().size()*50+circleSelectedPosition;
        headline_image_gallery.setSelection(gallerySelectedPositon);
        headline_image_gallery.setDelayMillis(4000);
        headline_image_gallery.start();
        headline_image_gallery.setAdapter(new GalleryAdapter());
        headline_image_gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                circleSelectedPosition=position;
                gallerySelectedPositon=circleSelectedPosition% appDetailListBean.getMsg().getPicture().size();
                headline_circle_indicator.setSeletion(gallerySelectedPositon);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter = new ListAdapter(getContext(),appDetailListBean) ;
        recommend_listview.setAdapter(adapter);



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

    /**
     * AutoGallery的自定义Adapter
     */
    class GalleryAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public Object getItem(int position) {
            return appDetailListBean.getMsg().getPicture().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder _Holder=null;
            if(convertView==null){
                _Holder=new Holder();
                convertView=View.inflate(getContext(),R.layout.item_gallery_layout,null);
                _Holder.item_head_gallery_img=(ImageView)convertView.findViewById(R.id.item_head_gallery_img);
                convertView.setTag(_Holder);
            }else {
                _Holder=(Holder)convertView.getTag();
            }
            //显示数据
            Picasso.with(mView.getContext()).load(appDetailListBean.getMsg().getPicture().get(position%appDetailListBean.getMsg().getPicture().size())).into(_Holder.item_head_gallery_img);
            return convertView;
        }
    }

    private static class  Holder{
        ImageView item_head_gallery_img;
    }
}
