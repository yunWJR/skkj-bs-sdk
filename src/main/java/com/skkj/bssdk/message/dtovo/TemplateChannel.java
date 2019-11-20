package com.skkj.bssdk.message.dtovo;

import lombok.Data;

/**
 * @author: yun
 * @createdOn: 2019/9/2 13:25.
 */

@Data
public class TemplateChannel {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private Long channelId;

    private Long templateId;

    private String remark;
}
