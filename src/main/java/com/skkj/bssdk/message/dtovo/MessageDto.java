package com.skkj.bssdk.message.dtovo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yun
 * @createdOn: 2019/9/3 17:07.
 */

@Data
@NoArgsConstructor
public class MessageDto {
    /**
     * 模板 id
     */
    private Long templateId;

    /**
     * 对象列表
     */
    private List<MessageTargetDto> targets;

    /**
     * 请求参数
     */
    private Map<String, Object> paraMap;

    public MessageDto(Long templateId) {
        this.templateId = templateId;
        this.targets = new ArrayList<>();
        this.paraMap = new HashMap<>();
    }

    /**
     * 添加参数
     * @param key
     * @param value
     */
    public void addPara(String key, String value) {
        if (this.paraMap == null) {
            this.paraMap = new HashMap<>();
        }

        this.paraMap.put(key, value);
    }
}
