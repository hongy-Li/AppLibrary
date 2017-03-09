package com.app.library.net;

import com.app.library.dialog.IDialog;
import com.lhy.netlibrary.BaseNet;
import com.lhy.netlibrary.IRequestListener;
import com.lhy.netlibrary.NetFactory;

import java.util.Map;

/**
 * Created by lhy on 2017/2/7
 */
public abstract class BaseHttp<T extends IHttpListener> {
    protected static final String HTTP_GET = "GET";
    protected static final String HTTP_POST = "POST";
    public T mListener;

    public BaseHttp(T listener) {
        mListener = listener;
    }

    protected void sendRequest(boolean isDialogShow, final IDialog dialog, String url, Map<String, Object> params, String method) throws Exception {
        if (isDialogShow && dialog != null) {
            dialog.show();
        }
        BaseNet net = NetFactory.createNetUtils(NetFactory.NetType.OK_HTTP);
        switch (method) {
            case HTTP_GET:
                get(net, url, params);
                break;
            case HTTP_POST:
                post(net, url, params);
                break;
        }

    }

    private void post(BaseNet net, String url, Map<String, Object> params) throws Exception {
        net.postHttp(url, params, new IRequestListener() {
            @Override
            public void onSucceed(String msg) {
                succeedRequest(msg);
            }

            @Override
            public void onFailed(Exception e) {
                failedRequest(e);
            }
        });
    }

    private void get(BaseNet net, String url, Map<String, Object> params) {
        net.getHttp(url, params, new IRequestListener() {
            @Override
            public void onSucceed(String msg) {
                succeedRequest(msg);
            }

            @Override
            public void onFailed(Exception e) {
                failedRequest(e);
            }
        });
    }

    protected  void succeedRequest(String msg){}

    protected  void failedRequest(Exception e){}

    public abstract void sendRequestToServer(boolean isShow, IDialog dialog, Object... objects);
}
