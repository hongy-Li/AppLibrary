package com.app.library.mvp;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by lhy on 2017/3/13
 */
public class ActivityPresenter extends BasePresenter implements IActivityStatus {


    public ActivityPresenter(IPresenterNotify notifyListener) {
        super(notifyListener);
        this.mNotifyListener = notifyListener;
    }

    @Override
    public void sendNotifyMessage(NotifyMessage message) {
        mNotifyListener.notify(message);
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
