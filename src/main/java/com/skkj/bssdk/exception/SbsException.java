package com.skkj.bssdk.exception;

/**
 * @author: yun
 * @createdOn: 2019/11/20 11:01.
 */

public class SbsException extends RuntimeException {
    private Integer code;
    private String errMsg;

    public SbsException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

    public SbsException() {
        super();
    }

    public static SbsException cmpEp(String msg) {
        return new SbsException(msg);
    }
}
