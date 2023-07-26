package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.DeviceVerifySnRequest;
import com.wiseasy.openapi.response.DeviceVerifySnResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname DeviceVerifySnTest
 * @Description 批量校验设备snTest
 * @Date 2023/5/11 17:51
 * @Author DingJunLei
 */
public class DeviceVerifySnTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 批量校验设备snTest
     */
    @Test
    public void deviceVerifySnTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        DeviceVerifySnRequest params = new DeviceVerifySnRequest();
        params.setVersion("v1.0");
        buildRequestParams(params);
        DeviceVerifySnResponse result = null;
        try {
            result = openApiClient.execute(params);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(result));

    }

    private void buildRequestParams(DeviceVerifySnRequest params) {
        Set<String> set = new HashSet<>();
        set.add("12qwreqw231412");
        set.add("265432123");
        set.add("tttttttttt");
        params.setSnList(set);
    }

}
