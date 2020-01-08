package com.skkj.bssdk.message.dtovo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author: yun
 * @createdOn: 2019/9/3 17:07.
 */

@Data
public class MessageDto {
    /**
     * 模板 id
     */
    private Long templateId;

    /**
     * 对象列表：已废弃
     */
    // private List<String> targetList;

    /**
     * 对象列表
     */
    private List<MessageTargetDto> targets;

    /**
     * 请求参数
     */
    private Map<String, Object> paraMap;
}
