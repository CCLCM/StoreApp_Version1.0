package com.zhxu.storeapp.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.zhxu.storeapp.R;

public class DetailRelativeLayout extends RelativeLayout {
    private static final int CHILD_COUNT = 3;
    private int commentMeasureWidth;
    private int margin;
    private int maxWidth;
    private int shareMeasureWidth;

    public DetailRelativeLayout(Context paramContext) {
        super(paramContext);
        initParam();
    }

    public DetailRelativeLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        initParam();
    }

    public DetailRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        initParam();
    }

    private void initParam() {
        this.maxWidth = Math.round(getResources().getDimension(R.dimen.appdetail_download_btn_max_width));
        this.margin = Math.round(getResources().getDimension(R.dimen.appdetail_download_btn_margin));
    }



    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() != 3) ;
        View firstChildView;
        View secondChildView;
        View thirdChildView;
        int firstChilWidth;
        int secondChilWidth;
        int thirdChildWidth;

        firstChildView = getChildAt(0);
        secondChildView = getChildAt(1);
        thirdChildView = getChildAt(2);

        firstChilWidth = firstChildView.getMeasuredWidth();
        secondChilWidth = secondChildView.getMeasuredWidth();
        thirdChildWidth = thirdChildView.getMeasuredWidth();

//        while ((!(thirdChildView instanceof FrameLayout)) || (thirdChildWidth <= this.maxWidth) || ((firstChilWidth == this.shareMeasureWidth) && (secondChilWidth == this.commentMeasureWidth)));

        this.shareMeasureWidth = firstChilWidth;
        this.commentMeasureWidth = secondChilWidth;

        int m = (getMeasuredWidth() - firstChilWidth - secondChilWidth - this.maxWidth - 2 * this.margin) / 2;
        RelativeLayout.LayoutParams firstLayoutParams = (RelativeLayout.LayoutParams) firstChildView.getLayoutParams();
        firstLayoutParams.leftMargin = m;
        firstLayoutParams.rightMargin = this.margin;
        firstChildView.setLayoutParams(firstLayoutParams);
        RelativeLayout.LayoutParams secondLayoutParams = (RelativeLayout.LayoutParams) secondChildView.getLayoutParams();
        secondLayoutParams.leftMargin = this.margin;
        secondLayoutParams.rightMargin = m;
        secondChildView.setLayoutParams(secondLayoutParams);

    }
}