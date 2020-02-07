package com.skkj.bssdk.message.dtovo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yun
 * @createdOn: 2020/1/8 09:16.
 */

@Data
@NoArgsConstructor
public class MessageTargetDto {
    /**
     * 对象名称，最大100
     */
    private String name;

    /**
     * 默认对象
     */
    private String defTarget;

    /**
     * 通道类型-推送对象 map
     * 通道类型：1、EMAIL_SMTP；2、SMS；3、WC_MP；4、NOTI
     */
    private Map<Integer, MessageChannelTargetDto> typeTarget;

    public MessageTargetDto(String name) {
        this.name = name;
        this.typeTarget = new HashMap<>();
    }

    /**
     * 添加参数
     * @param type
     * @param target
     */
    public void addTarget(Integer type, MessageChannelTargetDto target) {
        if (this.typeTarget == null) {
            this.typeTarget = new HashMap<>();
        }

        this.typeTarget.put(type, target);
    }

    /**
     * 添加参数
     * @param type
     * @param target
     */
    public void addTarget(ChannelType type, MessageChannelTargetDto target) {
        this.addTarget(type.getType(), target);
    }
}
