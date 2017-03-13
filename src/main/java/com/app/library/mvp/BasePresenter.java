package com.app.library.mvp;

/**
 * Created by lhy on 2017/2/21.
 */
public class BasePresenter {
    protected IPresenterNotify mNotifyListener;

    public BasePresenter(IPresenterNotify notifyListener) {
        this.mNotifyListener = notifyListener;
    }
}
