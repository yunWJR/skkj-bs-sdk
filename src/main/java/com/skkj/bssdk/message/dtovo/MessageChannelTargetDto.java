package com.skkj.bssdk.message.dtovo;

import lombok.Data;

import java.util.Map;

/**
 * @author: yun
 * @createdOn: 2019/12/6 09:50.
 */

@Data
public class MessageChannelTargetDto {
    /**
     * 默认对象
     */
    private String defTarget;

    /**
     * 模板通道ID-推送对象 map
     */
    private Map<Long, String> templateChanelIdTarget;
}