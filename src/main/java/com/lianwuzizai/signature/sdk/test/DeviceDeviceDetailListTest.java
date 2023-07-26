package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.DeviceDeviceDetailListRequest;
import com.wiseasy.openapi.response.DeviceDeviceDetailListResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DeviceDeviceDetailListTest {


    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 消息云发送消息
     *
     */
    @Test
    public void deviceDeviceDetailListTest() {
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        DeviceDeviceDetailListRequest detailListRequest = new DeviceDeviceDetailListRequest();
        detailListRequest.setVersion("v1.0");
        buildRequestParams(detailListRequest);
        DeviceDeviceDetailListResponse detailListResponse = null;
        try {
            detailListResponse = openApiClient.execute(detailListRequest);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info(JSONUtil.toJSONString(detailListResponse));
    }

    private void buildRequestParams(DeviceDeviceDetailListRequest detailListRequest) {
        List<String> snList = new ArrayList<>();
        snList.add("WNET5W2004000029");
        snList.add("WPOSQT2070000289");
        snList.add("WQRJ002235000269");
        detailListRequest.setSnList(snList);
    }
}
