package com.skkj.bssdk.auth;

import cn.hutool.core.lang.TypeReference;
import com.skkj.bssdk.auth.dtovo.AuthO2Dto;
import com.skkj.bssdk.auth.dtovo.AuthO2Vo;
import com.skkj.bssdk.dtovo.SbsRsp;
import com.skkj.bssdk.exception.SbsException;
import com.skkj.bssdk.property.SbsProperty;
import com.skkj.bssdk.util.HttpRsp;
import com.skkj.bssdk.util.HttpUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * 授权工具
 * @author: yun
 * @createdOn: 2019-02-25 17:38.
 */
@Component
@Slf4j
@AllArgsConstructor
public class AuthO2 {
    private final SbsProperty sbsProperty;

    private final HttpUtil httpUtil;

    public static void main(String[] args) throws Exception {
        SbsProperty sbsProperty = new SbsProperty();
        HttpUtil httpUtil = new HttpUtil();
        AuthO2 authO2 = new AuthO2(sbsProperty, httpUtil);

        AuthO2Dto dto = new AuthO2Dto();
        dto.setUsername("MTkuMC41YzQ0YjQ5ZC1lODZlLTQ3NWQtOTUxNy1iNDY2YzBmOWI5ODA=");
        dto.setPassword("cc784e70-03e4-4238-ba4b-74bded8db6d6");
        authO2.auth(dto);
    }

    public SbsRsp<AuthO2Vo> auth(AuthO2Dto dto) {
        String url = sbsProperty.getServerUrl() + "/auth/oauth/token";

        Map<String, String> header = new HashMap<>();

        header.put("Authorization", getAuthHeader(dto));

        Map<String, String> param = new HashMap<>();
        param.put("grant_type", dto.getGrantType());

        HttpRsp rsp = httpUtil.postRqt(url, param, header, null);

        SbsRsp<AuthO2Vo> rst = new SbsRsp<>(rsp, new TypeReference<AuthO2Vo>() {
        });

        return rst;
    }

    // region --private method

    private String getAuthHeader(AuthO2Dto dto) {
        if (dto.getAuthType().toLowerCase().equals("basic")) {
            // Base64(username:password)
            try {
                String au = dto.getUsername() + ":" + dto.getPassword();

                Base64.Encoder encoder = Base64.getEncoder();
                byte[] textByte = au.getBytes("UTF-8");
                String authBase = encoder.encodeToString(textByte);

                return dto.getAuthType() + " " + authBase;
            } catch (Exception e) {
                e.printStackTrace();

                throw SbsException.cmpEp("授权参数解析失败:" + e.getMessage());
            }
        }

        throw SbsException.cmpEp("不支持的授权类型:" + dto.getAuthType());
    }

    // endregion
}