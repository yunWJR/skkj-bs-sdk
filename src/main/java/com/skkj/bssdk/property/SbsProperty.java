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
     * 服务地址 todo 测试数据
     */
    private String serverHost = "http://127.0.0.1:17820";

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
         * 认证类型：默认 Basic
         */
        private String authType = "Basic";

        /**
         * 认证：用户名 todo 测试数据
         */
        private String username = "MTkuMC41YzQ0YjQ5ZC1lODZlLTQ3NWQtOTUxNy1iNDY2YzBmOWI5ODA=";

        /**
         * 认证：密码 todo 测试数据
         */
        private String password = "cc784e70-03e4-4238-ba4b-74bded8db6d6";
    }
}
