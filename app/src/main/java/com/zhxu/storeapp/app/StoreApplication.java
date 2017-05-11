package com.zhxu.storeapp.app;

import android.app.Application;

/**
 * Created by xzhang on 2017/5/5.
 */

public class StoreApplication extends Application {

    private static StoreApplication instance ;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this ;
    }

    public static StoreApplication getInstance(){
        return instance ;
    }
}
