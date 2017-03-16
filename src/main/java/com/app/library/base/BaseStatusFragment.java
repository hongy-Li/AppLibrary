package com.app.library.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Created by lhy on 2017/3/13
 */
public abstract class BaseStatusFragment extends Fragment {
    private View vg_root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (vg_root != null) {
            //  先找到爹 在通过爹去移除孩子
            ViewParent parent = vg_root.getParent();
            //所有的控件 都有爹  爹一般情况下 就是ViewGroup
            if (parent instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) parent;
                group.removeView(vg_root);
            }
        } else {
            vg_root = createView();
        }
        initView();
        initEvent();
        return vg_root;
    }

    protected abstract View createView();

    protected void initView() {
    }

    protected void initEvent() {
    }

}
