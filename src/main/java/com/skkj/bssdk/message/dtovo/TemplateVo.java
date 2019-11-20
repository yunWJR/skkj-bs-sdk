package com.skkj.bssdk.message.dtovo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: yun
 * @createdOn: 2019/10/9 13:54.
 */

@Data
@NoArgsConstructor
public class TemplateVo {

    private Template tmp;

    private List<TemplateChannelVo> list;
}
