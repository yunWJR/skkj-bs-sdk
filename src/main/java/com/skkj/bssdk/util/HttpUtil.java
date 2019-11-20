package com.skkj.bssdk.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * HttpClient工具类
 * @author: yun
 * @createdOn: 2019/9/4 23:16.
 */
@Component
public class HttpUtil {

    /**
     * 请求编码
     */
    private final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 执行HTTP POST请求
     * @param url   url
     * @param param 参数
     * @return
     */
    public HttpRsp postRqt(String url, Map<String, String> param, Map<String, String> header, String body) {
        HttpRsp rsp = new HttpRsp();

        CloseableHttpClient client = null;
        try {
            if (url == null || url.trim().length() == 0) {
                throw new Exception("URL is null");
            }
            if (param != null) {
                boolean isFirst = true;
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> pEt : param.entrySet()) {
                    if (StringUtils.isEmpty(pEt.getKey())) {
                        continue;
                    }

                    if (isFirst) {
                        sb.append("?");
                        isFirst = false;
                    } else {
                        sb.append("&");
                    }

                    sb.append(getEncoder(pEt.getKey()));
                    sb.append("=");
                    sb.append(getEncoder(pEt.getValue()));
                }

                url = url + sb.toString();
            }

            HttpPost httpPost = new HttpPost(url);

            // 默认 header
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

            if (header != null) {
                for (String hKey : header.keySet()) {
                    httpPost.setHeader(hKey, header.get(hKey));
                }

                if (body == null) {
                    body = "";
                }

                //解决中文乱码问题
                StringEntity entity = new StringEntity(body, DEFAULT_CHARSET);
                entity.setContentEncoding(DEFAULT_CHARSET);
                entity.setContentType("application/json;charset=UTF-8");
                httpPost.setEntity(entity);
            }

            client = HttpClients.createDefault();
            HttpResponse resp = client.execute(httpPost);
            if (resp.getStatusLine().getStatusCode() == 200) {
                rsp.setRsp(EntityUtils.toString(resp.getEntity(), DEFAULT_CHARSET));
            } else {
                rsp.setErr(resp.getStatusLine().getStatusCode(), EntityUtils.toString(resp.getEntity(), DEFAULT_CHARSET));
            }
        } catch (Exception e) {
            e.printStackTrace();

            rsp.setErr(-1, e.getMessage());
        } finally {
            close(client);
        }

        return rsp;
    }

    /**
     * 执行HTTP GET请求
     * @param url   url
     * @param param 参数
     * @return
     */
    public HttpRsp getRqt(String url, Map<String, String> param, Map<String, String> header) {
        HttpRsp rsp = new HttpRsp();

        CloseableHttpClient client = null;
        try {
            if (url == null || url.trim().length() == 0) {
                throw new Exception("URL is null");
            }
            if (param != null) {
                boolean isFirst = true;
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> pEt : param.entrySet()) {
                    if (StringUtils.isEmpty(pEt.getKey())) {
                        continue;
                    }

                    if (isFirst) {
                        sb.append("?");
                        isFirst = false;
                    } else {
                        sb.append("&");
                    }

                    sb.append(getEncoder(pEt.getKey()));
                    sb.append("=");
                    sb.append(getEncoder(pEt.getValue()));
                }

                url = url + sb.toString();
            }

            // if (param != null) {
            //     StringBuffer sb = new StringBuffer("?");
            //     for (String key : param.keySet()) {
            //         sb.append(key).append("=").append(param.get(key)).append("&");
            //     }
            //     url = url.concat(sb.toString());
            //     url = url.substring(0, url.length() - 1);
            // }

            HttpGet httpGet = new HttpGet(url);

            httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
            if (header != null) {
                for (String hKey : header.keySet()) {
                    httpGet.setHeader(hKey, header.get(hKey));
                }
            }

            client = HttpClients.createDefault();
            HttpResponse resp = client.execute(httpGet);
            if (resp.getStatusLine().getStatusCode() == 200) {
                rsp.setRsp(EntityUtils.toString(resp.getEntity(), DEFAULT_CHARSET));
            } else {
                rsp.setErr(resp.getStatusLine().getStatusCode(), EntityUtils.toString(resp.getEntity(), DEFAULT_CHARSET));
            }
        } catch (Exception e) {
            e.printStackTrace();

            rsp.setErr(-1, e.getMessage());
        } finally {
            close(client);
        }

        return rsp;
    }

    /**
     * 关闭HTTP请求
     * @param client
     */
    private void close(CloseableHttpClient client) {
        if (client == null) {
            return;
        }
        try {
            client.close();
        } catch (Exception e) {
        }
    }

    private String getEncoder(String org) {
        String result = "";
        if (null == org) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(org, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}