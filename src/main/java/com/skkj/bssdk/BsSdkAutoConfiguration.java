package com.skkj.bssdk;

import com.skkj.bssdk.auth.AuthO2;
import com.skkj.bssdk.message.MessageServer;
import com.skkj.bssdk.property.SbsProperty;
import com.skkj.bssdk.util.HttpUtil;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: yun
 * @createdOn: 2019-05-30 13:05.
 */

@Configuration
@EnableConfigurationProperties()
@Import({AuthO2.class, MessageServer.class, SbsProperty.class, HttpUtil.class})
public class BsSdkAutoConfiguration {
}
