package com.skkj.bssdk.auth;

import com.skkj.bssdk.auth.dtovo.AuthO2Vo;
import com.skkj.bssdk.exception.SbsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: yun
 * @createdOn: 2019/11/20 11:18.
 */

@Component
public class AuthO2Util {
    @Autowired
    private AuthO2 authO2;

    private AuthO2Vo authO2Data;

    private String authHeader;

    public AuthO2Vo getAuthO2Data() {
        return authO2Data;
    }

    public void setAuthO2Data(AuthO2Vo authO2Data) {
        this.authO2Data = authO2Data;

        if (authO2Data == null) {
            authHeader = null;
        }

        // bearer db3cf21f-45ca-4c62-8089-978d75e044c6
        authHeader = authO2Data.getToken_type() + " " + authO2Data.getAccess_token();
    }

    public String getAuthHeader() {
        if (authHeader == null) {
            // 重新授权
            AuthO2Vo vo = authO2.authValid();
            setAuthO2Data(vo);
        }

        if (authHeader == null) {
            throw SbsException.cmpEp("无授权信息:");
        }

        return authHeader;
    }
}
