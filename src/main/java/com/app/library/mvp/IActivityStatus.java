package com.app.library.mvp;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by lhy on 2017/3/13
 */
public interface IActivityStatus extends IViewStatus {

    void onCreate(Context context, Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onRestart();

    void onPause();

    void onStop();

    void onDestroy();
}
