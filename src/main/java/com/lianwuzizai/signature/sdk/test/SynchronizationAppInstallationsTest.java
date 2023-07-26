package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.SynchronizationAppInstallationsRequest;
import com.wiseasy.openapi.response.SynchronizationAppInstallationsResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname AppInstallSyncTest
 * @Description 已安装应用同步测试类
 * @Date 2022/1/26 17:11
 * @Author DingJunLei
 */
public class SynchronizationAppInstallationsTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 新增应用
     */
    @Test
    public void synchronizationAppInstallationsTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        SynchronizationAppInstallationsRequest appInstallSyncRequest = new SynchronizationAppInstallationsRequest();
        appInstallSyncRequest.setVersion("v1.0");
        buildRequestParams(appInstallSyncRequest);
        SynchronizationAppInstallationsResponse appInstallSyncResponse = null;
        try {
            appInstallSyncResponse = openApiClient.execute(appInstallSyncRequest);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info(JSONUtil.toJSONString(appInstallSyncResponse));

    }

    private void buildRequestParams(SynchronizationAppInstallationsRequest appInstallSyncRequest) {

    }

}
