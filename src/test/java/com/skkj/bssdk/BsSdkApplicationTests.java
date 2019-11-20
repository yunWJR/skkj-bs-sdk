package com.skkj.bssdk;

import com.skkj.bssdk.auth.AuthO2;
import com.skkj.bssdk.dtovo.SbsRsp;
import com.skkj.bssdk.message.MessageDto;
import com.skkj.bssdk.message.MessageServer;
import com.skkj.bssdk.message.MessageVo;
import com.skkj.bssdk.property.SbsProperty;
import com.skkj.bssdk.util.HttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class BsSdkApplicationTests {

    @Test
    public void contextLoads() {
        SbsProperty sbsProperty = new SbsProperty();
        HttpUtil httpUtil = new HttpUtil();

        AuthO2 authO2 = new AuthO2(sbsProperty, httpUtil);

        MessageServer msg = new MessageServer(sbsProperty, httpUtil, authO2);

        MessageDto dto = new MessageDto();
        dto.setTemplateId(2L);
        List<String> tg = new ArrayList<>();
        tg.add("13678099615");
        tg.add("18080878762");
        dto.setTargetList(tg);

        dto.setParaMap(new HashMap<>());
        dto.getParaMap().put("templateParam", "{code:123321}");
        dto.getParaMap().put("param", "bbca,32123");

        SbsRsp<MessageVo> vo = msg.sendMessage(dto);
    }
}
