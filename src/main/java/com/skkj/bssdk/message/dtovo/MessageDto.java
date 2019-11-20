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
     * 对象列表：（注意最大对象限制）
     */
    private List<String> targetList;

    /**
     * 请求参数
     */
    private Map<String, Object> paraMap;
}
