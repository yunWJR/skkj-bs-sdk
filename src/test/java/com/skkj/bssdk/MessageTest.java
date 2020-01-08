package com.skkj.bssdk;

import com.skkj.bssdk.auth.AuthO2;
import com.skkj.bssdk.dtovo.SbsRsp;
import com.skkj.bssdk.message.MessageServer;
import com.skkj.bssdk.message.dtovo.MessageDto;
import com.skkj.bssdk.message.dtovo.MessageTargetDto;
import com.skkj.bssdk.message.dtovo.MessageVo;
import com.skkj.bssdk.message.dtovo.TemplateVo;
import com.skkj.bssdk.property.SbsProperty;
import com.skkj.bssdk.util.HttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yun
 * @createdOn: 2019/11/20 12:14.
 */

public class MessageTest {
    public static void main(String[] args) throws Exception {
        SbsProperty sbsProperty = new SbsProperty();
        HttpUtil httpUtil = new HttpUtil();

        AuthO2 authO2 = new AuthO2(sbsProperty, httpUtil);

        MessageServer msg = new MessageServer(sbsProperty, httpUtil, authO2);

        MessageDto dto = new MessageDto();
        dto.setTemplateId(2L);

        List<MessageTargetDto> tgs = new ArrayList<>();

        MessageTargetDto tg1 = new MessageTargetDto();
        tg1.setName("yun");
        Map tg1Map= new HashMap();
        tg1Map.put(2,"13678099615");

        tg1.setTypeTarget(tg1Map);

        tgs.add(tg1);

        dto.setTargets(tgs);

        dto.setParaMap(new HashMap<>());
        dto.getParaMap().put("templateParam", "{code:123321}");
        dto.getParaMap().put("param", "bbca,32123");

        SbsRsp<MessageVo> vo = msg.sendMessage(dto);
        SbsRsp<List<TemplateVo>> list = msg.getTemplateList();
    }
}
