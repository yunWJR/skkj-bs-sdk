package com.skkj.bssdk.dtovo;

import com.skkj.bssdk.util.HttpRsp;
import lombok.NoArgsConstructor;

/**
 * @author: yun
 * @createdOn: 2019/11/20 10:33.
 */

@NoArgsConstructor
public class SbsRspStr extends SbsRsp<String> {
    public SbsRspStr(HttpRsp rsp) {
        super(rsp);

        this.setData(rsp.getRsp());
    }
}
