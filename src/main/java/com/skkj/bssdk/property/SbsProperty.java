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
    private String serverUrl = "http://127.0.0.1:17820"; // 测试用

    private String msg = "api data";

}
