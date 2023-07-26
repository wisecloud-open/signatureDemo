package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.AppPreStatusEnum;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.DeviceAppPreInstallationsRequest;
import com.wiseasy.openapi.response.DeviceAppPreInstallationsResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname DeviceAppPreInstallationsTest
 * @Description 设备预装应用请求Test
 * @Date 2022/2/16 16:25
 * @Author DingJunLei
 */
public class DeviceAppPreInstallationsTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void deviceInstallApplicationsTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        DeviceAppPreInstallationsRequest params = new DeviceAppPreInstallationsRequest();
        params.setVersion("v1.0");
        buildRequestParams(params);
        DeviceAppPreInstallationsResponse result = null;
        try {
            result = openApiClient.execute(params);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(result));
    }

    private void buildRequestParams(DeviceAppPreInstallationsRequest params) {
        params.setSn("WNET5W2004000029");
        params.setPreStatus(AppPreStatusEnum.INSTALLED_STATUS);
    }

}
