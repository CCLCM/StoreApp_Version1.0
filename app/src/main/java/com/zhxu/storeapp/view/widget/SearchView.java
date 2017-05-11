package com.zhxu.storeapp.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.zhxu.storeapp.R;

public class SearchView extends RelativeLayout
        implements View.OnClickListener {
    private Context mContext;

    public SearchView(Context paramContext) {
        super(paramContext);
        init(paramContext);
    }

    public SearchView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext);
    }

    public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramContext);
    }

    private void init(Context paramContext) {
        this.mContext = paramContext;
        initViews();
    }

    private void initViews() {
        LayoutInflater.from(this.mContext).cloneInContext(this.mContext).inflate(R.layout.search_view_layout, this);
    }

    public void onClick(View paramView) {
    }
}