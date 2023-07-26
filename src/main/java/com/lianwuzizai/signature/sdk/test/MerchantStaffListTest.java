package com.lianwuzizai.signature.sdk.test;


import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.Constants;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.MerchantStaffListRequest;
import com.wiseasy.openapi.response.MerchantStaffListResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;

/**
 * Unit test for simple OpenApiClient.
 */
public class MerchantStaffListTest {

    @Test
    public void test() {
        //实例化客户端
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：pay.barcodepay
        MerchantStaffListRequest request = new MerchantStaffListRequest();
        //SDK已经封装了公共参数，这里只需要传入业务参数
        request.setSignType(Constants.SIGN_TYPE_MD5);
        // 此处只是演示，其他参数请根据接口定义进行传输
        request.setCurrentPosition(0);
        request.setSn("WPOSQT2070000091");

        request.setCurrentPosition(0);
        request.setSn("222323424");

        MerchantStaffListResponse response = null;
        try {
            response = openApiClient.execute(request);
        } catch (OpenApiException e) {
            // 调用失败，输出错误信息
            System.out.println("error:" + e.getCode() + "->>" + e.getMsg());
            return;
        }

        if(response.isSuccess()){
            if(response.getData() != null) {
                System.out.println(JSONUtil.toJSONString(response));
                System.out.println(response.getData().get(0).getStaffName());
            }
        }else{
            // 调用失败，输出错误信息
            System.out.println("error:" + response.getCode() + "->>" + response.getMsg());
        }

    }

}
