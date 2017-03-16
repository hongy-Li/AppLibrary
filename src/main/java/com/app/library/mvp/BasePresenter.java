package com.app.library.mvp;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by lhy on 2017/2/21.
 */
public class BasePresenter implements IViewStatus {
    protected IPresenterNotify mNotifyListener;

    public BasePresenter(IPresenterNotify notifyListener) {
        this.mNotifyListener = notifyListener;
    }

    @Override
    public void sendNotifyMessage(NotifyMessage message) {

    }

    @Override
    public void onCreate(Context context, Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }
}
