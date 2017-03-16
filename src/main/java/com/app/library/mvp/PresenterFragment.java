package com.app.library.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.app.library.base.BaseFragment;

/**
 * Created by lhy on 2017/3/13
 */
public abstract class PresenterFragment<T extends BasePresenter> extends BaseFragment implements IPresenterNotify {
    protected T mPresenter;
    protected final String TAG = this.getClass().getSimpleName();
    protected Context mContext;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
        this.mPresenter = createPresenter();
        mPresenter.onCreate(this.getContext(), savedInstanceState);
    }

    public abstract T createPresenter();
}
