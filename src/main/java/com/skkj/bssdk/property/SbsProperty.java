package com.skkj.bssdk.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: yun
 * @createdOn: 2019/9/9 14:39.
 */

@Component
@ConfigurationProperties(prefix = "skkj.sbs")
@Data
public class SbsProperty {

    /**
     * 服务地址
     */
    private String serverHost;

    /**
     * 认证参数
     */
    private Auth auth = new Auth();

    @Data
    public static class Auth {
        /**
         * grantType：client_credentials
         */
        private String grantType = "client_credentials";

        /**
         * scope：xxx
         */
        private String scope = "";

        /**
         * 认证类型：默认 Basic
         */
        private String authType = "Basic";

        /**
         * 认证：用户名
         */
        private String username;

        /**
         * 认证：密码
         */
        private String password;
    }
}
