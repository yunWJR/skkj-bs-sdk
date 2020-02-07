package com.skkj.bssdk.message.dtovo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: yun
 * @createdOn: 2019/9/3 11:07.
 */

@Getter
@AllArgsConstructor
public enum ChannelType {

    /**
     * Type_Min
     */
    Type_Min(0, "Type_Min"),

    /**
     * EMAIL_SMTP
     */
    EMAIL_SMTP(1, "EMAIL_SMTP"),

    /**
     * SMS
     */
    SMS(2, "SMS"),

    /**
     * WC_MP
     */
    WC_MP(3, "WC_MP"),

    /**
     * NOTI
     */
    NOTI(4, "NOTI"),

    /**
     * Max
     */
    Max(Integer.MAX_VALUE, "Max");

    /**
     *
     */
    public static final String des = "通道类型：1、EMAIL_SMTP;2、SMS;3、WC_MP;4、NOTI";

    /**
     * 类型
     */

    private final Integer type;
    /**
     * 描述
     */
    private final String description;

    public boolean isSameItem(Integer value) {
        if (value == null) {
            return false;
        }

        return value.equals(getType());
    }
}