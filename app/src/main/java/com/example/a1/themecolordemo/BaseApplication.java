package com.example.a1.themecolordemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by 1 on 2017/3/22.
 */

public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
