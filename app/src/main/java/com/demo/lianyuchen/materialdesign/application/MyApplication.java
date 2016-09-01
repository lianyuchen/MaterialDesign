package com.demo.lianyuchen.materialdesign.application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by lianyuchen on 16/8/31.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
