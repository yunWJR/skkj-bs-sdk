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
    private Long id;

    private Long createTime;

    private Long defChannelId;

    /**
     * 执行模式：1-默认优先、2-轮询、3-全部
     */
    private Integer executeMode;

    private Long templateId;
}
