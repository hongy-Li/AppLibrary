package com.app.library;

import android.app.Application;
import android.content.Context;

/**
 * Created by lhy on 2017/2/20
 */
public class BaseApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public Context getContext() {
        return mContext;
    }

}
