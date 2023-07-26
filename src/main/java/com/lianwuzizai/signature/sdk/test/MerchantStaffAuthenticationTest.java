package com.lianwuzizai.signature.sdk.test;


import com.wiseasy.openapi.client.Config;
import com.wiseasy.openapi.client.DefaultOpenApiClient;
import com.wiseasy.openapi.client.OpenApiClient;
import com.wiseasy.openapi.client.OpenApiException;
import com.wiseasy.openapi.constant.Constants;
import com.wiseasy.openapi.constant.EndpointUrlEnum;
import com.wiseasy.openapi.request.MerchantStaffAuthenticationRequest;
import com.wiseasy.openapi.response.MerchantStaffAuthenticationResponse;
import com.wiseasy.openapi.response.MerchantStaffListResponse;
import com.wiseasy.openapi.utils.JSONUtil;
import org.junit.Test;

/**
 * Unit test for simple OpenApiClient.
 */
public class MerchantStaffAuthenticationTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void test() {
        //实例化客户端
        Config config = new Config("accessKeyId", "accessKeySecret")
                .setEndpointUrl(EndpointUrlEnum.LONDON); //the default endpoint is London if not set
        OpenApiClient openApiClient = new DefaultOpenApiClient(config);
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：pay.barcodepay
        MerchantStaffAuthenticationRequest request = new MerchantStaffAuthenticationRequest();
        //SDK已经封装了公共参数，这里只需要传入业务参数
        request.setSignType(Constants.SIGN_TYPE_MD5);
        // 此处只是演示，其他参数请根据接口定义进行传输
        request.setPosFirstLogin(1);

        //pre
        request.setLoginAccount("0988303036");
        request.setSn("WPOSQT2070000091");

        //dev
//        request.setLoginAccount("1232145677");
//        request.setSn("222323424");

        MerchantStaffAuthenticationResponse response = null;
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
                System.out.println(response.getData().getStaffName());
            }
        }else{
            // 调用失败，输出错误信息
            System.out.println("error:" + response.getCode() + "->>" + response.getMsg());
        }

    }


    public static void main(String[] args) {
        String jsonstr = "{\"msg\":\"success\",\"code\":0,\"data\":[{\"lastLoginTime\":\"2022-01-26T11:00:47.000+00:00\",\"loginAccount\":\"1232145677\",\"partnerCode\":\"0\",\"firstLogin\":1,\"createTime\":\"2021-12-30T02:07:41.000+00:00\",\"staffName\":\"test1\",\"updateTime\":\"2022-01-26T11:00:47.000+00:00\",\"id\":30,\"position\":0,\"merchantNo\":\"800000000549\",\"status\":1}],\"count\":1,\"timestamp\":1643264584848,\"signatureValue\":\"5e8661a4f252abede833cd9f20633685\"}";

//        jsonstr = "{\"msg\":\"success\",\"code\":0,\"data\":{\"firstLogin\":1,\"staffName\":\"test1\",\"position\":0},\"timestamp\":1643264986206,\"signatureValue\":\"9df2d52b39d43e7d36fd63ef3fa8f359\"}";
        Object o = JSONUtil.toJavaObject(jsonstr, MerchantStaffListResponse.class);
        System.out.println(o);
        System.out.println(JSONUtil.toJSONString(o));
    }
}
