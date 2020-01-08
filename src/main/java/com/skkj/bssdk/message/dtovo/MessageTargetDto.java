package com.skkj.bssdk.message.dtovo;

import lombok.Data;

import java.util.Map;

/**
 * @author: yun
 * @createdOn: 2020/1/8 09:16.
 */

@Data
public class MessageTargetDto {
    /**
     * 对象名称，最大100
     */
    private String name;

    /**
     * 通道类型-推送对象 map
     * 通道类型：1、EMAIL_SMTP；2、SMS；3、WC_MP
     */
    private Map<Integer, String> typeTarget;
}
