package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.SynchronizationDeviceInfoRequest;
import com.wiseasy.openapi.response.SynchronizationDeviceInfoResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname DeviceInfoSyncTest
 * @Description 设备信息同步测试类
 * @Date 2022/1/26 17:11
 * @Author DingJunLei
 */
public class SynchronizationDeviceInfoTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 新增应用
     */
    @Test
    public void synchronizationDeviceInfoTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        SynchronizationDeviceInfoRequest deviceInfoSyncRequest = new SynchronizationDeviceInfoRequest();
        deviceInfoSyncRequest.setVersion("v1.0");
        buildRequestParams(deviceInfoSyncRequest);
        SynchronizationDeviceInfoResponse deviceInfoSyncResponse = null;
        try {
            deviceInfoSyncResponse = openApiClient.execute(deviceInfoSyncRequest);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info(JSONUtil.toJSONString(deviceInfoSyncResponse));

    }

    private void buildRequestParams(SynchronizationDeviceInfoRequest synchronizationDeviceInfoRequest) {

    }

}
