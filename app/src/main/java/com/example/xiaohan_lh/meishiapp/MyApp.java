package com.example.xiaohan_lh.meishiapp;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import cn.smssdk.SMSSDK;


/**
 * Created by xiaohan-lh on 16/3/11.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        SMSSDK.initSDK(this, "105f138175110", "528c77fc729db818925821925ae4941b");
    }
}
