package com.zhxu.storeapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhxu.storeapp.R;
import com.zhxu.storeapp.bean.AppDetailListBean;

import java.util.List;

/**
 * Created by xzhang on 2017/5/8.
 */

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.DetailViewHolder> {

    private Context mContext ;
    private List<AppDetailListBean.MsgBean.AppListBean.AppBean.DetailBean> detailBeanList ;
    private OnItemClickListener mListener ;

    public AppListAdapter(Context context, List<AppDetailListBean.MsgBean.AppListBean.AppBean.DetailBean> detailBeanList){
        this.mContext = context ;
        this.detailBeanList = detailBeanList ;

    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener ;
    }


    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext,R.layout.item_app,null);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, final int position) {
        AppDetailListBean.MsgBean.AppListBean.AppBean.DetailBean detailBean = detailBeanList.get(position);
        holder.appName.setText(detailBean.getName());
        holder.appSize.setText(detailBean.getSizeDesc());
        Picasso.with(mContext).load(detailBean.getIcon()).into(holder.appIcon);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return detailBeanList.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder{

        ImageView appIcon ;
        TextView appName ;
        TextView appSize ;


        public DetailViewHolder(View itemView) {
            super(itemView);
            appIcon = (ImageView) itemView.findViewById(R.id.detail_recommend_app_icon);
            appName = (TextView) itemView.findViewById(R.id.detail_recommend_app_name);
            appSize = (TextView) itemView.findViewById(R.id.detail_recommend_app_size);


        }
    }
}
