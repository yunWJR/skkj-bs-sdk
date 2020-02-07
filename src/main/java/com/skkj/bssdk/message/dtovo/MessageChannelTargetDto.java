package com.skkj.bssdk.message.dtovo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yun
 * @createdOn: 2019/12/6 09:50.
 */

@Data
@NoArgsConstructor
public class MessageChannelTargetDto {
    /**
     * 默认对象
     */
    private String defTarget;

    /**
     * 模板通道ID-推送对象 map
     */
    private Map<Long, String> templateChannelIdTarget;

    public MessageChannelTargetDto(String defTarget) {
        this.defTarget = defTarget;
        this.templateChannelIdTarget = new HashMap<>();
    }

    /**
     * 添加参数
     * @param tmpChannelId
     * @param target
     */
    public void addTarget(Long tmpChannelId, String target) {
        if (tmpChannelId == null) {
            this.defTarget = target;
            return;
        }

        if (this.templateChannelIdTarget == null) {
            this.templateChannelIdTarget = new HashMap<>();
        }

        this.templateChannelIdTarget.put(tmpChannelId, target);
    }
}