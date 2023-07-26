package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EmployeeStatusEnum;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.MerchantStaffUpdateStatusRequest;
import com.wiseasy.openapi.response.MerchantStaffUpdateStatusResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MerchantStaffUpdateStatusTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 消息云发送消息
     *
     */
    @Test
    public void merchantStaffUpdateStatusTest() {
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        MerchantStaffUpdateStatusRequest updateStatusRequest = new MerchantStaffUpdateStatusRequest();
        updateStatusRequest.setVersion("v1.0");
        updateStatusRequest.setSignType("hmacsha256");
        buildRequestParams(updateStatusRequest);
        MerchantStaffUpdateStatusResponse addResponse = null;

        try {
            addResponse = openApiClient.execute(updateStatusRequest);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info(JSONUtil.toJSONString(addResponse));
    }

    private void buildRequestParams(MerchantStaffUpdateStatusRequest updateStatusRequest) {
        updateStatusRequest.setId(599);
        updateStatusRequest.setSn("WISEBOT000010");
        updateStatusRequest.setStatus(EmployeeStatusEnum.manager);
    }
}
