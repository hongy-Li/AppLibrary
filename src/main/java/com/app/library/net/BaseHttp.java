package com.app.library.net;

import com.app.library.dialog.BaseDialog;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by lhy on 2017/2/7
 */
public abstract class BaseHttp<T extends IHttpListener> {
    public static final String TAG = "BaseHttp";
    protected static final int REQUEST_METHOD_POST = 0;
    protected static final int POST = 1;
    protected static final int REQUEST_METHOD_GET = 2;
    protected static final String HTTP_CODE_ERROR = "-9999";
    protected static final String HTTP_CODE_SUCCESS = "SUCCESS";
    private static final String HTTP_CODE_KICK_OFF = "kick_off";//被别的账号挤掉
    private static final String HTTP_CODE_SESSION_FAILURE = "session_failure";//登录过期
    private static final String HTTP_CODE_SYS_ERROR = "SYS_ERROR";//登录过期
    private static final String HTTP_CODE_SYSTEM_ERROR = "SYSTEM_ERROR";//登录过期
    private String mClassName;

    public T mListener;

    public BaseHttp(T listener) {
        mListener = listener;
    }

    protected void sendRequest(final BaseDialog dialog, String url, Map<String, Object> params, int method) {
        mClassName = this.getClass().getSimpleName();

    }

    private void parseFailData(int code, String msg) {
        switch (code) {

            default:
                parseFailData(HTTP_CODE_ERROR, msg);
                break;
        }
    }

    private void parseSuccessData(String result) {

    }

    public abstract void sendRequest(BaseDialog dialog, Object... params);

    /**
     * @param ret        HTTP_CODE_SUCCESS 成功，HTTP_CODE_NO_DATA 没有数据
     * @param jsonObject 解析后json
     */
    protected abstract void parseData(String ret, JSONObject jsonObject);

    protected abstract void parseFailData(String ret, String jsonObject);

}
