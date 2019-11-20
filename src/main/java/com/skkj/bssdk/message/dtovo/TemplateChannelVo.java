package com.skkj.bssdk.message.dtovo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: yun
 * @createdOn: 2019/11/19 16:27.
 */

@Data
@NoArgsConstructor
public class TemplateChannelVo {
    private TemplateChannel channel;

    private List<Para> defParas;

    private List<Para> cusParas;
}
