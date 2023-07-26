package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.SpecialDeviceStatusRequest;
import com.wiseasy.openapi.response.SpecialDeviceStatusResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 导出smartpay查询测试
 * @Author pengkai
 */
public class SpecialDeviceStatusTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 导出smartpay 文件
     */
    @Test
    public void specialDeviceStatusTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        SpecialDeviceStatusRequest params = new SpecialDeviceStatusRequest();
        params.setVersion("v1.0");
        buildRequestParams(params);
        logger.info("=========>"+JSONUtil.toJSONString(params));
        SpecialDeviceStatusResponse result = null;
        try {
            result = openApiClient.execute(params);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(result));

    }

    private void buildRequestParams(SpecialDeviceStatusRequest specialDeviceStatusRequest) {
        specialDeviceStatusRequest.setQueryTime("2023-06-13");
    }
}
