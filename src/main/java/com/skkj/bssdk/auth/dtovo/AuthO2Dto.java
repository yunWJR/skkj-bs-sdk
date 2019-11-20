package com.skkj.bssdk.auth.dtovo;

import lombok.Data;

/**
 * @author: yun
 * @createdOn: 2019/11/20 09:57.
 */

@Data
public class AuthO2Dto {
    private String grantType = "client_credentials";
    private String authType = "Basic";

    private String username;
    private String password;
}
