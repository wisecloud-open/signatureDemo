package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.DeviceSingleJoinNetworkRequest;
import com.wiseasy.openapi.response.DeviceSingleJoinNetworkResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname DeviceSingleJoinNetworkTest
 * @Description 单个设备入网Test
 * @Date 2022/2/16 17:33
 * @Author DingJunLei
 */
public class DeviceSingleJoinNetworkTest {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void deviceSingleJoinNetworkTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        DeviceSingleJoinNetworkRequest params = new DeviceSingleJoinNetworkRequest();
        params.setVersion("v1.0");
        buildRequestParams(params);
        DeviceSingleJoinNetworkResponse result = null;
        try {
            result = openApiClient.execute(params);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(result));
    }

    private void buildRequestParams(DeviceSingleJoinNetworkRequest params) {
        params.setSn("WNET5W20022111112");
    }

}
