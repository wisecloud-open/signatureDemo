package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.constant.UploadTypeEnum;
import com.wiseasy.openapi.request.TerminalSettingAddRequest;
import com.wiseasy.openapi.response.TerminalSettingAddResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @Classname TerminalSettingAddTest
 * @Description 保存终端系统设置任务请求Test
 * @Date 2022/2/25 10:05
 * @Author DingJunLei
 */
public class TerminalSettingAddTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void terminalSettingAddTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        TerminalSettingAddRequest params = new TerminalSettingAddRequest();
        params.setVersion("v1.0");
        buildRequestParams(params);
        TerminalSettingAddResponse result = null;
        try {
            result = openApiClient.execute(params);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info("响应结果："+ JSONUtil.toJSONString(result));
    }

    private void buildRequestParams(TerminalSettingAddRequest params) {
        params.setUploadType(UploadTypeEnum.WALLPAPER);
        params.setDownloadPath("https://wisecloud3-oss.wiseasy.com/service/dms/wiseos/preview/78044e7384334831b6e946fa2bf49460.png");
        params.setSnList(Arrays.asList("PP35542108000157","P327701702000683"));
        params.setMd5("e96dbe96d81629ae2c1cb07262f375ea");
        params.setDisplayResolution("720*1280");
        params.setFilesize(1340574);
    }
}
