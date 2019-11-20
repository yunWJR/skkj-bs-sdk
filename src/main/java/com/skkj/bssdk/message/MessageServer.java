package com.skkj.bssdk.message;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.skkj.bssdk.auth.AuthO2;
import com.skkj.bssdk.dtovo.SbsRsp;
import com.skkj.bssdk.property.SbsProperty;
import com.skkj.bssdk.util.HttpRsp;
import com.skkj.bssdk.util.HttpUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yun
 * @createdOn: 2019/11/20 11:20.
 */

@Component
@AllArgsConstructor
public class MessageServer {
    private final SbsProperty sbsProperty;

    private final HttpUtil httpUtil;

    private final AuthO2 authO2;

    /**
     * 发送消息
     * @param dto
     * @return
     */
    public SbsRsp<MessageVo> sendMessage(MessageDto dto) {
        String url = sbsProperty.getServerHost() + "/msg/v1/message";

        Map<String, String> header = new HashMap<>();

        header.put("Authorization", authO2.getAuthHeader());

        String body = JSONUtil.toJsonStr(dto);

        HttpRsp rsp = httpUtil.postRqt(url, null, header, body);

        SbsRsp<MessageVo> rst = new SbsRsp<>(rsp, new TypeReference<MessageVo>() {
        });

        return rst;
    }
}
