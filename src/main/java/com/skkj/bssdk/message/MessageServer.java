package com.skkj.bssdk.message;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.skkj.bssdk.auth.AuthO2;
import com.skkj.bssdk.dtovo.SbsRsp;
import com.skkj.bssdk.dtovo.SbsRspStr;
import com.skkj.bssdk.message.dtovo.MessageDto;
import com.skkj.bssdk.message.dtovo.MessageVo;
import com.skkj.bssdk.message.dtovo.TemplateVo;
import com.skkj.bssdk.property.SbsProperty;
import com.skkj.bssdk.util.HttpRsp;
import com.skkj.bssdk.util.HttpUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
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
    public SbsRspStr sendMessageOrg(MessageDto dto) {
        String url = sbsProperty.getServerHost() + "/msg/v1/message";

        Map<String, String> header = new HashMap<>();

        header.put("Authorization", authO2.getAuthHeader());

        String body = JSONUtil.toJsonStr(dto);

        HttpRsp rsp = httpUtil.postRqt(url, null, header, body);

        SbsRspStr rspData = new SbsRspStr(rsp);

        // 成功
        if (rspData.isSuc()) {
            return rspData;
        }

        // 授权失败，重新授权
        if (rspData.isOutAuth()) {
            authO2.authValid();

            return sendMessageOrg(dto);
        }

        return rspData;
    }

    /**
     * 发送消息
     * @param dto
     * @return
     */
    public SbsRsp<MessageVo> sendMessage(MessageDto dto) {
        SbsRspStr rspData = sendMessageOrg(dto);

        // 成功
        if (rspData.isSuc()) {
            SbsRsp<MessageVo> rst = JSONUtil.toBean(rspData.getData(), new TypeReference<SbsRsp<MessageVo>>() {
            }, true);

            return rst;
        }

        SbsRsp<MessageVo> rst = new SbsRsp<>(rspData.getCode(), rspData.getMsg());

        return rst;
    }

    /**
     * 模板列表
     * @return
     */
    public SbsRspStr getTemplateListOrg() {
        String url = sbsProperty.getServerHost() + "/msg/v1/template/list";

        Map<String, String> header = new HashMap<>();

        header.put("Authorization", authO2.getAuthHeader());

        HttpRsp rsp = httpUtil.getRqt(url, null, header);

        SbsRspStr rspData = new SbsRspStr(rsp);

        // 成功
        if (rspData.isSuc()) {
            return rspData;
        }

        // 授权失败，重新授权
        if (rspData.isOutAuth()) {
            authO2.authValid();

            return getTemplateListOrg();
        }

        return rspData;
    }

    public SbsRsp<List<TemplateVo>> getTemplateList() {
        SbsRspStr rspData = getTemplateListOrg();

        // 成功
        if (rspData.isSuc()) {
            SbsRsp<List<TemplateVo>> rst = JSONUtil.toBean(rspData.getData(), new TypeReference<SbsRsp<List<TemplateVo>>>() {
            }, true);

            return rst;
        }

        SbsRsp<List<TemplateVo>> rst = new SbsRsp<>(rspData.getCode(), rspData.getMsg());

        return rst;
    }
}
