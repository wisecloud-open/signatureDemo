package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.DeviceBatchJoinNetworkRequest;
import com.wiseasy.openapi.response.DeviceBatchJoinNetworkResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @Classname DeviceBatchJoinNetwork
 * @Description 设备批量入网Test
 * @Date 2022/2/16 16:58
 * @Author DingJunLei
 */
public class DeviceBatchJoinNetworkTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void deviceBatchJoinNetworkTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        DeviceBatchJoinNetworkRequest params = new DeviceBatchJoinNetworkRequest();
        params.setVersion("v1.0");
        buildRequestParams(params);
        DeviceBatchJoinNetworkResponse result = null;
        try {
            result = openApiClient.execute(params);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(result));
    }

    private void buildRequestParams(DeviceBatchJoinNetworkRequest params) {
        params.setSnList(Arrays.asList("WNET5W20040111112","WNET5W200402222222"));
    }

}
