package com.chestnut.common.utils;


import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yesk
 */
public class HttpClientUtil {
    /**
     * @param url     发送请求的 URL
     * @param jsonStr 需要post的数据
     * @param headers 请求头
     * @return 所代表远程资源的响应结果
     */
    public static String postParam(String url, String jsonStr, Map<String, String> headers) {
        HttpPost post = new HttpPost();
        HttpResponse response = null;
        try {
            post.setURI(new URI(url));
            if (StringUtils.isNotEmpty(jsonStr)) {
                post.setEntity(new StringEntity(jsonStr, "UTF-8"));
            }
            if (null != headers && headers.size() > 0) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            } else {
                headers.put("Content-Type", "application/json; charset=utf-8");
            }
            HttpClient httpClient = HttpClients.createDefault();
            response = httpClient.execute(post);
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException("got an error from HTTP for url:" + url, e);
        } finally {
            if (response != null) {
                EntityUtils.consumeQuietly(response.getEntity());
            }
            post.releaseConnection();
        }
    }

    /**
     * @param url     发送请求的 URL
     * @param jsonStr 需要post的数据
     * @return 所代表远程资源的响应结果
     */
    public static String postParam(String url, String jsonStr) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        return postParam(url, jsonStr, headers);
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", "7ATCVdwZ3Jqk0aglNP4XGFiNS+1rXCeg21ctLGRQXw6h+cQEZVlyqCT+O8QWRQRVKqa+1N57EwBPLEYPq3eYnQ==");
        jsonObject.put("timeStamp", "1513158330");
        jsonObject.put("seq", "20171213174531");
        jsonObject.put("sign", "D4C86864BE69E26B2DF4DBC0EBF27237");
        //生成需要post的json字符串
        String jsonStr = jsonObject.toJSONString();
        //请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        //进行http的post请求
        System.out.println(postParam("http://test.com/queryToken", jsonStr, headers));
    }

}