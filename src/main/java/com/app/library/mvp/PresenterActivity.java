package com.app.library.mvp;

import android.os.Bundle;

import com.app.library.base.BaseActivity;

/**
 * Created by lhy on 2017/2/21.
 */
public abstract class PresenterActivity<T extends BasePresenter> extends BaseActivity implements IPresenterNotify {
    protected T mPresenter;
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.onCreate(this, savedInstanceState);
    }

    public abstract T createPresenter();

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        mPresenter.onPause();
        super.onPause();

    }

    @Override
    protected void onStop() {
        mPresenter.onPause();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

}
