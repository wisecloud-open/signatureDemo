package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.constant.ExportExcelTypeEnum;
import com.wiseasy.openapi.request.ExportTaskAddRequest;
import com.wiseasy.openapi.response.ExportTaskAddResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname ExportTaskAddTest
 * @Description 添加导出任务Test
 * @Date 2022/1/24 15:35
 * @Author DingJunLei
 */
public class ExportTaskAddTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 新增导出任务
     */
    @Test
    public void exportTaskAddTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        ExportTaskAddRequest exportTaskAddRequest = new ExportTaskAddRequest();
        exportTaskAddRequest.setVersion("v1.0");
        buildRequestParams(exportTaskAddRequest);
        ExportTaskAddResponse exportTaskAddResponse = null;
        try {
            exportTaskAddResponse = openApiClient.execute(exportTaskAddRequest);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(exportTaskAddResponse));

    }

    private void buildRequestParams(ExportTaskAddRequest exportTaskAddRequest) {
        exportTaskAddRequest.setTaskType(ExportExcelTypeEnum.APP_INSTALLED_DEVICE);
        ExportTaskAddRequest.Parameter parameter = new ExportTaskAddRequest.Parameter();
        parameter.setVersionMD5("2657633996c71ebc508d2ee177e78009");
        exportTaskAddRequest.setParam(parameter);
//        exportTaskAddRequest.setTaskName("导出任务"+System.currentTimeMillis());
    }

}
