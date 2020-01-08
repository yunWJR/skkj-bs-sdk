package com.skkj.bssdk.message.dtovo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yun
 * @createdOn: 2019/10/10 10:49.
 */

@Data
@NoArgsConstructor
public class MessageVo {
    /**
     * 消息 ID
     */
    private Long id;

    /**
     * createTime
     */
    private Long createTime;

    /**
     * 模板 id
     */
    private Long templateId;

    /**
     * 模板默认通道
     */
    private Long defChannelId;

    /**
     * 执行模式：1-默认优先、2-通道轮询、3-全部通道、4-所有类型,5-类型轮询
     */
    private Integer executeMode;

    /**
     * 状态
     */
    private Integer status;
}
