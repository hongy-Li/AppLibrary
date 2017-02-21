package com.app.library.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by lhy on 2017/2/20
 */
public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutXML());
        initView();
        initEvent();
    }
    protected abstract int getLayoutXML();
    protected void initView(){}
    protected void initEvent(){}
}
