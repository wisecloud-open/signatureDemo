package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.DeviceInstallApplicationsRequest;
import com.wiseasy.openapi.response.DeviceInstallApplicationsResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname DeviceInstallApplicationsTest
 * @Description 设备安装应用列表Test
 * @Date 2022/2/15 16:42
 * @Author DingJunLei
 */
public class DeviceInstallApplicationsTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void deviceInstallApplicationsTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        DeviceInstallApplicationsRequest params = new DeviceInstallApplicationsRequest();
        params.setVersion("v1.0");
        buildRequestParams(params);
        DeviceInstallApplicationsResponse result = null;
        try {
            result = openApiClient.execute(params);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(result));
    }

    private void buildRequestParams(DeviceInstallApplicationsRequest params) {
    }

}
