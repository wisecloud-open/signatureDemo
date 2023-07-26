package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.constant.FormatType;
import com.wiseasy.openapi.request.CommonRequest;
import com.wiseasy.openapi.response.CommonResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * @Classname AppAddTest
 * @Description 上传app
 * @Date 2022/1/24 15:35
 * @Author DingJunLei
 */
public class CommonTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 新增应用
     */
    @Test
    public void saveAppTest(){
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        CommonRequest commonRequest = new CommonRequest("device/service/api/app/upload")
                .putByteArrayFileParameter("Settings.apk", buildRequestParams())
                .setFormatValue(FormatType.FILE);
        CommonResponse commonResponse = null;
        try {
            commonResponse = openApiClient.execute(commonRequest);
        } catch (OpenApiException e) {
            e.printStackTrace();
            logger.error("error:" + e.getCode() + "->>" + e.getMsg());
        }
        logger.info(JSONUtil.toJSONString(commonResponse));

    }

    private byte[] buildRequestParams() {
        byte[] fileData = new byte[0];
        try {
            FileInputStream in = new FileInputStream("E:\\TEST-REPO\\Settings.apk");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }

            fileData = out.toByteArray();
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileData;
    }

}
