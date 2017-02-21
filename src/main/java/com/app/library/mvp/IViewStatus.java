package com.app.library.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by chirenjie on 2016/10/27.
 */
public interface IViewStatus {
    void onCreate(Context context, Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onRestart();

    void onPause();

    void onStop();

    void onDestroy();

    void sendNotifyMessage(NotifyMessage message);
}
