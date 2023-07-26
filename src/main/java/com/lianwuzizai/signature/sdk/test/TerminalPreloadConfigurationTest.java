package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.constant.PreloadConfigurationFlagEnum;
import com.wiseasy.openapi.request.TerminalPreloadConfigurationRequest;
import com.wiseasy.openapi.response.TerminalPreloadConfigurationResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname TerminalSettingAddTest
 * @Description 批量新增/删除预装应用配置请求Test
 * @Date 2022/2/25 10:05
 * @Author DingJunLei
 */
public class TerminalPreloadConfigurationTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void terminalPreloadConfigurationTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        TerminalPreloadConfigurationRequest params = new TerminalPreloadConfigurationRequest();
        params.setVersion("v1.0");
        buildRequestParams(params);
        TerminalPreloadConfigurationResponse result = null;
        try {
            result = openApiClient.execute(params);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(result));
    }

    private void buildRequestParams(TerminalPreloadConfigurationRequest params) {
        params.setSnList(Arrays.asList("PP35542108000157","P327701702000683"));
        params.setFlag(PreloadConfigurationFlagEnum.ADD_FLAG);
        List<TerminalPreloadConfigurationRequest.AppVersion> list = new ArrayList<>();
        TerminalPreloadConfigurationRequest.AppVersion appVersion = new TerminalPreloadConfigurationRequest.AppVersion();
        appVersion.setVersionMD5("65f52b3d200c41458858f6c721fed7d1");
        appVersion.setVersionNumber(1467L);
        list.add(appVersion);
        params.setAppList(list);
    }
}
