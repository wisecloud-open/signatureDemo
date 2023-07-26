package com.lianwuzizai.signature.sdk.test;

import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.DeviceDetailsRequest;
import com.wiseasy.openapi.response.DeviceDetailsResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname DeviceDetails
 * @Description 设备详情测试类
 * @Date 2022/2/15 14:52
 * @Author DingJunLei
 */
public class DeviceDetailsTest {

   private Logger logger = LoggerFactory.getLogger(this.getClass());

   @Test
   public void deviceDetailsTest(){
      Config config = new Config("accessKeyId", "accessKeySecret")
              .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
      OpenApiClient openApiClient = new DefaultOpenApiClient(config);
      DeviceDetailsRequest params = new DeviceDetailsRequest();
      params.setVersion("v1.0");
      buildRequestParams(params);
      DeviceDetailsResponse result = null;
      try {
         result = openApiClient.execute(params);
      } catch (OpenApiException e) {
         e.printStackTrace();
         logger.error("error:" + e.getCode() + "->>" + e.getMsg());
      }
      logger.info("响应结果："+ JSONUtil.toJSONString(result));
   }

   private void buildRequestParams(DeviceDetailsRequest params) {
      params.setSn("PP35272121000050");
   }

}
