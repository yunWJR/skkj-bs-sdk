package com.skkj.bssdk.auth.dtovo;

import lombok.Data;

/**
 * @author: yun
 * @createdOn: 2019/11/20 09:56.
 */

@Data
public class AuthO2Vo {
    private String access_token;
    private String token_type;
    private String scope;
    private String license;
    private Integer expires_in;
}
