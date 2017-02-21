package com.app.library.mvp;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by lenovo on 2017/2/21.
 */
public class BasePresenter implements IViewStatus{
    private IPresenterNotify mNotifyListener;

    protected BasePresenter(IPresenterNotify notifyListener) {
        this.mNotifyListener = notifyListener;
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

    @Override
    public void sendNotifyMessage(NotifyMessage message) {

    }
}
