package com.skkj.bssdk.util;

import lombok.Data;

/**
 * @author: yun
 * @createdOn: 2019/11/20 10:25.
 */

@Data
public class HttpRsp {
    private int httpCode;

    private String rsp;

    private String errMsg;

    public void setErr(int code, String err) {
        this.httpCode = code;
        this.errMsg = err;
    }

    public void setRsp(String data) {
        this.httpCode = 200;
        this.rsp = data;
    }

    public boolean isOutAuth() {
        return httpCode == 401;
    }
}
