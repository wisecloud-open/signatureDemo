package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.constant.TimeZoneEnum;
import com.wiseasy.openapi.request.WiseOsSettingPushRequest;
import com.wiseasy.openapi.response.WiseOsSettingPushResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname WiseOsSettingPushTest
 * @Description wiseOsSetting推送时区设置Test
 * @Date 2023/5/12 18:18
 * @Author DingJunLei
 */
public class WiseOsSettingPushTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * wiseOsSetting推送时区设置
     */
    @Test
    public void wiseOsSettingPushTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        WiseOsSettingPushRequest params = new WiseOsSettingPushRequest();
        params.setVersion("v1.0");
        buildRequestParams(params);
        logger.info("=========>"+JSONUtil.toJSONString(params));
        WiseOsSettingPushResponse result = null;
        try {
            result = openApiClient.execute(params);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(result));

    }

    private void buildRequestParams(WiseOsSettingPushRequest wiseOsSettingPushRequest) {
        Set<String> set = new HashSet<>();
        set.add("12qwreqw231412");
        set.add("265432123");
        wiseOsSettingPushRequest.setSnList(set);
        WiseOsSettingPushRequest.Params params = new WiseOsSettingPushRequest.Params();
        WiseOsSettingPushRequest.Params.SystemSettings systemSettings = new WiseOsSettingPushRequest.Params.SystemSettings();
        systemSettings.setTimeZone(TimeZoneEnum.Athens);
        params.setSystemSettings(systemSettings);
        wiseOsSettingPushRequest.setParams(params);
    }
}
