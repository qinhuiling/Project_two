package com.bwie.asus.project_two.app;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by ASUS on 2017/10/12.
 */

public class MyApplication extends Application {

    public static MyApplication mapp;

    @Override
    public void onCreate() {
        super.onCreate();

        mapp = this;

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);

    }

    public static MyApplication getInstance(){
        return mapp;
    }

}
