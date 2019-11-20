package com.skkj.bssdk.message.dtovo;

import lombok.Data;

/**
 * @author: yun
 * @createdOn: 2019/9/2 11:27.
 */

@Data
public class Template {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private Long clientId;

    /**
     * 模板默认使用的通道ID
     */
    private Long defChannelId;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 执行模式：1-默认优先、2-轮询、3-全部
     */
    private Integer executeMode;

    /**
     * 是否支持多对象推送
     */
    private Integer batch;

    /**
     * 每次最大推送对象数：0为不限制
     */
    private Integer maxTarget;

    /**
     * 模板备注
     */
    private String remark;
}