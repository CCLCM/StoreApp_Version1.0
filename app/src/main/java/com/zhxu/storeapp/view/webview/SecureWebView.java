package com.zhxu.storeapp.view.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class SecureWebView extends WebView {
    public SecureWebView(Context paramContext) {
        super(paramContext);
    }

    public SecureWebView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public SecureWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    @SuppressLint({"NewApi"})
    public SecureWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
        super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    }

    public SecureWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean) {
        super(paramContext, paramAttributeSet, paramInt, paramBoolean);
    }

    private void init() {
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        removeJavascriptInterface("searchBoxJavaBridge_");
    }


    public void addJavascriptInterface(Object paramObject, String paramString) {
        super.addJavascriptInterface(paramObject, paramString);
        init();
    }
}