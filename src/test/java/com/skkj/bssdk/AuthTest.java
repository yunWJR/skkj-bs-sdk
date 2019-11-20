package com.skkj.bssdk;

import com.skkj.bssdk.auth.AuthO2;
import com.skkj.bssdk.auth.dtovo.AuthO2Vo;
import com.skkj.bssdk.property.SbsProperty;
import com.skkj.bssdk.util.HttpUtil;

/**
 * @author: yun
 * @createdOn: 2019/11/20 12:13.
 */

public class AuthTest {
    public static void main(String[] args) throws Exception {
        SbsProperty sbsProperty = new SbsProperty();
        HttpUtil httpUtil = new HttpUtil();
        AuthO2 authO2 = new AuthO2(sbsProperty, httpUtil);

        AuthO2Vo vo = authO2.authValid();
    }
}
