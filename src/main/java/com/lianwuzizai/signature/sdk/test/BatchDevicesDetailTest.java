package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.BatchDevicesDetailRequest;
import com.wiseasy.openapi.response.BatchDevicesDetailResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @Classname BatchDevicesDetailTest
 * @Description 批量查询设备信息请求Test
 * @Date 2022/2/9 19:19
 * @Author DingJunLei
 */
public class BatchDevicesDetailTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 新增导出任务
     */
    @Test
    public void batchDevicesDetailTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        BatchDevicesDetailRequest params = new BatchDevicesDetailRequest();
        params.setVersion("v1.0");
        buildRequestParams(params);
        BatchDevicesDetailResponse result = null;
        try {
            result = openApiClient.execute(params);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(result));

    }

    private void buildRequestParams(BatchDevicesDetailRequest params) {
        params.setSnList(Arrays.asList("PP12345612345612","PP35272108000480"));
    }

}
