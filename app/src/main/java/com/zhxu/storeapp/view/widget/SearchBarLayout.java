package com.zhxu.storeapp.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.zhxu.storeapp.R;

public class SearchBarLayout extends RelativeLayout {
    private static final int STATE_NORMAL = 101;
    private static final int STATE_PRESSED = 102;
    private boolean isDrawShadow = false;
    private boolean isImmerStyle = false;
    private Paint mCoverPaint;
    private RectF mDrawingRect;
    private int mLastState = 101;
    private int mPaddingBottom = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private Paint mPaint;
    private Path mPath;
    private int mRadius = 0;
    private int mSearchBarAlpha = 255;
    private int mSearchBarColor = 0;
    private int mSearchBarColorButton = 0;
    private int mSearchBarColorNormal = 0;
    private int mSearchBarColorPressed = 0;
    private int mShadowColor = 0;
    private int mShadowPadding = 0;

    public SearchBarLayout(Context paramContext) {
        super(paramContext);
        init(paramContext, null);
    }

    public SearchBarLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext, paramAttributeSet);
    }

    public SearchBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramContext, paramAttributeSet);
    }

    public SearchBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
        super(paramContext, paramAttributeSet, paramInt1, paramInt2);
        init(paramContext, paramAttributeSet);
    }

    private void changeState(int paramInt) {
        if (this.mLastState != paramInt) {
            this.mLastState = paramInt;
            invalidate();
        }
    }

    @TargetApi(17)
    private void init(Context context, AttributeSet paramAttributeSet) {
        setWillNotDraw(false);
        setLayerType(1, null);
        if (paramAttributeSet != null) {
            TypedArray localTypedArray = context.obtainStyledAttributes(paramAttributeSet, R.styleable.SearchBarLayout);
            this.mSearchBarColorNormal = localTypedArray.getColor(R.styleable.SearchBarLayout_search_bar_color_normal, 0);
            this.mSearchBarColorPressed = localTypedArray.getColor(R.styleable.SearchBarLayout_search_bar_color_pressed, 0);
            this.mSearchBarColorButton = localTypedArray.getColor(R.styleable.SearchBarLayout_search_bar_color_button, 0);
            this.mShadowColor = localTypedArray.getColor(R.styleable.SearchBarLayout_search_bar_color_shadow, 0);
            this.mShadowPadding = localTypedArray.getDimensionPixelSize(R.styleable.SearchBarLayout_search_bar_shadow_padding, 0);
            this.isDrawShadow = localTypedArray.getBoolean(R.styleable.SearchBarLayout_search_bar_enable_shadow, false);
            this.mSearchBarColor = this.mSearchBarColorNormal;

            localTypedArray.recycle();
        }
        this.mPaddingLeft = (2 + getPaddingLeft());
        this.mPaddingTop = getPaddingTop();
        this.mPaddingRight = (2 + getPaddingRight());
        this.mPaddingBottom = (2 + (getPaddingBottom() + this.mShadowPadding));
        this.mPaint = new Paint();
        this.mCoverPaint = new Paint();
        this.mPath = new Path();
    }

    private boolean isTouch(float paramFloat1, float paramFloat2) {
        if (this.mDrawingRect == null)
            this.mDrawingRect = new RectF();
        int[] arrayOfInt = new int[2];
        getLocationOnScreen(arrayOfInt);
        this.mDrawingRect.left = arrayOfInt[0];
        this.mDrawingRect.top = arrayOfInt[1];
        this.mDrawingRect.right = (getWidth() + arrayOfInt[0]);
        this.mDrawingRect.bottom = (getHeight() + arrayOfInt[1]);
        return this.mDrawingRect.contains(paramFloat1, paramFloat2);
    }

    public void afterExpand() {
        if (!this.isImmerStyle)
            this.mSearchBarColor = this.mSearchBarColorNormal;
        this.isDrawShadow = false;
        invalidate();
    }

    public void beforeShrink() {
        this.mSearchBarColor = this.mSearchBarColorButton;
        this.isDrawShadow = true;
    }

    public boolean getImmerStyle() {
        return this.isImmerStyle;
    }

    public int getSearchBarAlpha() {
        return this.mSearchBarAlpha;
    }

    public int getSearchBarColor() {
        return this.mSearchBarColor;
    }

    protected void onDraw(Canvas paramCanvas) {
        paramCanvas.saveLayerAlpha(0.0F, 0.0F, getWidth(), getHeight(), this.mSearchBarAlpha, 31);
        this.mPaint.reset();
        this.mPaint.setColor(this.mSearchBarColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        if (this.isDrawShadow)
            this.mPaint.setShadowLayer(2.0F, 0.0F, 4.0F, this.mShadowColor);
        this.mPath.rewind();
        this.mPath.moveTo(this.mPaddingLeft + this.mRadius, this.mPaddingTop);
        this.mPath.lineTo(getWidth() - this.mPaddingRight - this.mRadius, this.mPaddingTop);
        RectF localRectF1 = new RectF();
        localRectF1.left = (getWidth() - this.mPaddingRight - this.mRadius - this.mRadius);
        localRectF1.top = this.mPaddingTop;
        localRectF1.right = (getWidth() - this.mPaddingRight);
        localRectF1.bottom = (getHeight() - this.mPaddingBottom);
        this.mPath.arcTo(localRectF1, 270.0F, 180.0F, false);
        this.mPath.lineTo(this.mPaddingLeft + this.mRadius, getHeight() - this.mPaddingBottom);
        RectF localRectF2 = new RectF();
        localRectF2.left = this.mPaddingLeft;
        localRectF2.top = this.mPaddingTop;
        localRectF2.right = (this.mPaddingLeft + this.mRadius + this.mRadius);
        localRectF2.bottom = (getHeight() - this.mPaddingBottom);
        this.mPath.arcTo(localRectF2, 90.0F, 180.0F, false);
        this.mPath.close();
        paramCanvas.drawPath(this.mPath, this.mPaint);
        paramCanvas.restore();
        if ((this.mLastState == 102) && (this.mSearchBarColorPressed != 0)) {
            this.mCoverPaint.reset();
            this.mCoverPaint.setColor(this.mSearchBarColorPressed);
            this.mCoverPaint.setStyle(Paint.Style.FILL);
            this.mCoverPaint.setAntiAlias(true);
            paramCanvas.drawPath(this.mPath, this.mCoverPaint);
        }
        super.onDraw(paramCanvas);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        this.mRadius = ((getMeasuredHeight() - this.mPaddingBottom - this.mPaddingTop) / 2);
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {

        /*float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        switch (paramMotionEvent.getAction()) {
            default:
            case 0:
            case 2:
            case 1:
            case 3:
        }
        while (true) {
            if (isTouch(f1, f2)) {
                changeState(102);
                continue;
            }
            changeState(101);
            changeState(101);
        }*/
        return super.onTouchEvent(paramMotionEvent);
    }

    public void setHeight(int paramInt) {
        getLayoutParams().height = paramInt;
        requestLayout();
    }

    public void setImmerStyle(boolean paramBoolean) {
        this.isImmerStyle = paramBoolean;
        if (paramBoolean) {

            this.mSearchBarColor = getContext().getResources().getColor(R.color.search_bar_color_normal);
            this.mSearchBarColorNormal = getContext().getResources().getColor(R.color.search_bar_color_normal);
            this.mSearchBarColorButton = getContext().getResources().getColor(R.color.search_btn_color_normal);
            this.mShadowColor = getContext().getResources().getColor(R.color.search_bar_color_shadow);
            return;
        }
        this.mSearchBarColor = getContext().getResources().getColor(R.color.search_bar_normal_color_normal);
        this.mSearchBarColorNormal = getContext().getResources().getColor(R.color.search_bar_normal_color_normal);
        this.mSearchBarColorButton = getContext().getResources().getColor(R.color.search_btn_normal_color_normal);
        this.mShadowColor = getContext().getResources().getColor(R.color.search_bar_normal_color_shadow);
    }

    public void setSearchBarAlpha(int paramInt) {
        this.mSearchBarAlpha = paramInt;
        invalidate();
    }

    public void setSearchBarColor(int paramInt) {
        this.mSearchBarColor = paramInt;
        invalidate();
    }
}