package com.skkj.bssdk.dtovo;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.skkj.bssdk.util.HttpRsp;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yun
 * @createdOn: 2019/11/20 10:33.
 */

@Data
@NoArgsConstructor
public class SbsRsp<T> {
    private int code;

    private T data;

    private String msg;

    public SbsRsp(HttpRsp rsp, TypeReference<T> typeReference) {
        this.code = rsp.getHttpCode();
        this.msg = rsp.getErrMsg();

        if (isSuc()) {
            this.data = JSONUtil.toBean(rsp.getRsp(), typeReference, true);
        }
    }

    public SbsRsp(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public SbsRsp(HttpRsp rsp) {
        this.code = rsp.getHttpCode();
        this.msg = rsp.getErrMsg();
    }

    public boolean isSuc() {
        return code == 200;
    }

    public boolean isOutAuth() {
        return code == 401;
    }
}
