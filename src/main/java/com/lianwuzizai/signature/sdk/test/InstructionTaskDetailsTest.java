package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.InstructionTaskDetailsRequest;
import com.wiseasy.openapi.response.InstructionTaskDetailsResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname InstructionTaskQueryTest
 * @Description 指令任务结果查询请求测试类
 * @Date 2022/1/27 14:10
 * @Author DingJunLei
 */
public class InstructionTaskDetailsTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 指令任务结果查询请求测试类
     */
    @Test
    public void instructionTaskPushTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        InstructionTaskDetailsRequest instructionTaskDetailsRequest = new InstructionTaskDetailsRequest();
        instructionTaskDetailsRequest.setVersion("v1.0");
        buildRequestParams(instructionTaskDetailsRequest);
        InstructionTaskDetailsResponse instructionTaskDetailsResponse = null;
        try {
            instructionTaskDetailsResponse = openApiClient.execute(instructionTaskDetailsRequest);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info(JSONUtil.toJSONString(instructionTaskDetailsResponse));

    }

    private void buildRequestParams(InstructionTaskDetailsRequest instructionTaskDetailsRequest) {
        instructionTaskDetailsRequest.setTraceId("61f2350864f16a0001a426e4");
    }

}
