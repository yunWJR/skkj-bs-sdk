package com.skkj.bssdk.message.dtovo;

import lombok.Data;

/**
 * @author: yun
 * @createdOn: 2019/9/2 11:27.
 */

@Data
public class Para {
    private Long id;

    private Long createTime;

    private Long clientId;

    private Integer type;

    private Long masterId;

    /**
     * 名称
     */
    private String name;

    /**
     * 别名
     */
    private String aliasName;

    /**
     * 值
     */
    private String value;

    /**
     * 备注
     */
    private String remark;

    /**
     *
     */
    private Long subMasterId;
}