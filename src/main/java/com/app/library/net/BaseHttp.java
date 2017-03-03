package com.app.library.net;

import com.app.library.dialog.BaseDialog;
import com.lhy.netlibrary.BaseNet;
import com.lhy.netlibrary.IRequestListener;
import com.lhy.netlibrary.NetFactory;
import com.lhy.netlibrary.okhttp.OKHttpUtils;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by lhy on 2017/2/7
 */
public abstract class BaseHttp<T extends IHttpListener> {
    protected static final int HTTP_GET = 1000;
    public T mListener;

    public BaseHttp(T listener) {
        mListener = listener;
    }

    protected void sendRequest(boolean isDialogShow, final BaseDialog dialog, String url, Map<String, Object> params, int method) {
        if (isDialogShow && dialog != null) {
            dialog.show();
        }
        OKHttpUtils net = NetFactory.createNetUtils(NetFactory.NetType.OK_HTTP);
        switch (method) {
            case HTTP_GET:
                get(net, url, params);
                break;
        }

    }

    private void get(BaseNet net, String url, Map<String, Object> params) {
        net.getHttp(url, params, new IRequestListener() {
            @Override
            public void onSucceed(String msg) {

            }

            @Override
            public void onFailed(Exception e) {

            }
        });
    }

    protected void parseSucceed(String string) {
    }

    ;
}
