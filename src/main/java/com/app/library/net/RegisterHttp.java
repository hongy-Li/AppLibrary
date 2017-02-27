package com.app.library.net;

import com.app.library.dialog.BaseDialog;

import org.json.JSONObject;

/**
 * Created by lhy on 2017/2/24
 */
public class RegisterHttp extends BaseHttp<IHttpListener> {
    @Override
    public void sendRequest(BaseDialog dialog, Object... params) {

    }

    @Override
    protected void parseData(String ret, JSONObject jsonObject) {

    }

    @Override
    protected void parseFailData(String ret, String jsonObject) {

    }
}
