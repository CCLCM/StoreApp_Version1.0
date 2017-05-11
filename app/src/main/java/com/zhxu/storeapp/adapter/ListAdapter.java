package com.zhxu.storeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhxu.storeapp.R;
import com.zhxu.storeapp.activity.AppDetailActivity;
import com.zhxu.storeapp.bean.AppDetailListBean;

/**
 * Created by xzhang on 2017/5/6.
 */

public class ListAdapter extends BaseAdapter {

    private AppDetailListBean appDetailListBean ;
    private Context mContext ;
    public ListAdapter(Context context ,AppDetailListBean appList){
        this.appDetailListBean = appList ;
        this.mContext = context ;
    }

    @Override
    public int getCount() {
        return appDetailListBean.getMsg().getAppList().size();
    }

    @Override
    public Object getItem(int position) {
        return appDetailListBean.getMsg().getAppList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final AppDetailListBean.MsgBean.AppListBean appListBean = appDetailListBean.getMsg().getAppList().get(position);
        ViewHolder holder ;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.item_applist,null);
            holder = new ViewHolder();
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ItemTitle = (TextView) convertView.findViewById(R.id.ItemTitle);
        holder.AppListItem = (RecyclerView) convertView.findViewById(R.id.AppListItem);

        holder.ItemTitle.setText(appListBean.getApp().getName());
        AppListAdapter adapter = new AppListAdapter(mContext,appListBean.getApp().getDetail());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.AppListItem.setLayoutManager(linearLayoutManager);
        adapter.setOnItemClickListener(new AppListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(mContext, AppDetailActivity.class) ;
                intent.putExtra("packageName",appListBean.getApp().getDetail().get(position).getPackageName());
                mContext.startActivity(intent);
            }
        });
        holder.AppListItem.setAdapter(adapter);


        return convertView;
    }

    class ViewHolder{
        TextView ItemTitle ;
        RecyclerView AppListItem ;
    }
}
