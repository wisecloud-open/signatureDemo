package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.DeviceOnlineRecordRequest;
import com.wiseasy.openapi.response.DeviceOnlineRecordResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname DeviceOnlineRecord
 * @Description 设备上下线记录接口Test
 * @Date 2022/2/16 14:28
 * @Author DingJunLei
 */
public class DeviceOnlineRecordTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void deviceOnlineRecordTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        DeviceOnlineRecordRequest params = new DeviceOnlineRecordRequest();
        params.setVersion("v1.0");
        buildRequestParams(params);
        DeviceOnlineRecordResponse result = null;
        try {
            result = openApiClient.execute(params);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(result));
    }

    private void buildRequestParams(DeviceOnlineRecordRequest params) {
        params.setSn("PP352720C1003990");
        params.setOperationTime(1);
    }

}
