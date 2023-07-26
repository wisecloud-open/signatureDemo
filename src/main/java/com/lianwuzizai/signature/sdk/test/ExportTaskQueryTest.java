package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.constant.ExportExcelTypeEnum;
import com.wiseasy.openapi.constant.ExportTaskEnum;
import com.wiseasy.openapi.request.ExportTaskQueryRequest;
import com.wiseasy.openapi.response.ExportTaskQueryResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname ExportTaskAddTest
 * @Description 查询导出任务列表Test
 * @Date 2022/1/24 15:35
 * @Author DingJunLei
 */
public class ExportTaskQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 查询导出任务列表
     */
    @Test
    public void exportTaskQueryTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        ExportTaskQueryRequest exportTaskQueryRequest = new ExportTaskQueryRequest();
        exportTaskQueryRequest.setVersion("v1.0");
        buildRequestParams(exportTaskQueryRequest);
        ExportTaskQueryResponse exportTaskQueryResponse = null;
        try {
            exportTaskQueryResponse = openApiClient.execute(exportTaskQueryRequest);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(exportTaskQueryResponse));

    }

    private void buildRequestParams(ExportTaskQueryRequest exportTaskQueryRequest) {
        exportTaskQueryRequest.setTaskType(ExportExcelTypeEnum.APP_INSTALLED_DEVICE);
        exportTaskQueryRequest.setTaskStatus(ExportTaskEnum.end);
        exportTaskQueryRequest.setTaskSepNo("621dcacac8ca2f0001267146");
    }

}
