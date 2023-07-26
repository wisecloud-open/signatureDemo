package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.constant.InstructionTypeEnum;
import com.wiseasy.openapi.constant.InstructionsKeyEnum;
import com.wiseasy.openapi.request.InstructionTaskPushRequest;
import com.wiseasy.openapi.response.InstructionTaskPushResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @Classname InstructionTaskPushTest
 * @Description 批量，单个指令推送请求测试类
 * @Date 2022/1/26 18:44
 * @Author DingJunLei
 */
public class InstructionTaskPushTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 新增应用
     */
    @Test
    public void instructionTaskPushTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        InstructionTaskPushRequest instructionTaskPushRequest = new InstructionTaskPushRequest();
        instructionTaskPushRequest.setVersion("v1.0");
        buildRequestParams(instructionTaskPushRequest, InstructionTypeEnum.BATCH_PUSH);
        InstructionTaskPushResponse instructionTaskPushResponse = null;
        try {
            logger.info("========》{}", JSONUtil.toJSONString(instructionTaskPushRequest));
            instructionTaskPushResponse = openApiClient.execute(instructionTaskPushRequest);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info(JSONUtil.toJSONString(instructionTaskPushResponse));

    }

    private void buildRequestParams(InstructionTaskPushRequest instructionTaskPushRequest, InstructionTypeEnum type) {
        instructionTaskPushRequest.setInstructionKey(InstructionsKeyEnum.voiceTypeSetting);

        System.out.println("=================="+ type);
        Object target = null;
        Map<String, Object> targetJson = new HashMap<>();
        switch (type){
            case SINGLE_PUSH:
                instructionTaskPushRequest.setType(InstructionTypeEnum.getByCode(88));
                targetJson.put("sn","PP12345612345612");
                target = targetJson;
                break;
            case BATCH_PUSH:
                instructionTaskPushRequest.setType(type);
                target = Arrays.asList("864529051251026");
                break;
            case TAG_PUSH:
                instructionTaskPushRequest.setType(type);
                targetJson.put("tag","testLabel");
                target = targetJson;
                break;
            default:
                break;
        }
        instructionTaskPushRequest.setTarget(target);
        Map<String, Object> params = new HashMap<>();
        params.put("voiceType", "CN");
        instructionTaskPushRequest.setParam(params);
    }

}
