package com.action;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;

/**
 * AliOauthAction
 * com.action
 *
 * @author xiaoyy
 * 测试支付宝登陆
 * @Date 2017-09-20 上午10:28
 * The word 'impossible' is not in my dictionary.
 */
public class AliOauthAction {


    private static String APP_ID = "2016080500171059";
    private static String CHARSET = "GBK";
    private static String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDWaS71UfDyuXsKbjn5jFr6lm9ja7r7U0Ae1j3xU5+RyAS9gHnsxDVUIOiNGHuBhNJ78H9p2MVB5AEKsRhTAkCKzcvocVvYJaNljkISndNM1BoZD2M9NFSndI6FduiYrB3RXbnM6XThTezpWHCOG6tsgWb5C7YXzWsSPbr7bwUv+uHwu2zvc2AvjoIEnOS1ZDpy945i7rsfsmLU+NCitAu0O2XzW6D/FgMOEZ/gUPbl2kUhCqxsetorKikaIuO3ojOE+zP8oXEPAnlj48zEvXka30drX6xp+KurPYLkE3yXGkkUZUohuFHUP6urTKfantchp4vG8QevId16dRz5Iso5AgMBAAECggEACjhxWJhTV/6nctPWR6L9IzzQini0LQ7G27FyunI2BQj30OCy7ypbMGtxKmikWoQuVGIecLk4je+EbTIL6skMspEkyyu8KQ2CQHELjT+gtuTVaaRmIqC/+EuCD7KfW8e4lCZXmQD35VWFmYnxs5R2E3IHqo94WqIcHH58z0d3g9XnW8YdDcBM0PjgY9Upi7CZ7L2j1+FIeFoZRndkaa2ngJ2Ok2lZmNB1OBHCYL4EOgJXHXDpt3PXc9amL55tcIUocm4bawoB8sGK8d/9qbydOONBHxaKnyj+qbN3FlwsBaSIjH/mDydGrjkW0CNUIdR6BWWCbEQ/iswzd4+wU4hfkQKBgQD0yQB2P5o49475zgBsnGNM7neKb1Q7uiO2EFb8jirfqL39t1BZ67/DhX+uCVTlPNTDD7Bl9a+vISi5sWw7sx9Jm6B1yIrbO1UBUg96ntIyLSiuNu9NTPwo7XflxoOUCEdCEsphths5BMS9FO4V255rSbNvgGMbp3ZPUDNofP67BwKBgQDgO+6vkZTDd8cKnRSnOpbrxMgUi0aOV0CHWrPyzeSG+6tdArASH/O+/6PFtiyAcw3wOK89lXpLhBjeq4gGLZlznW1Gd9KnIwsTfMZDlYHQzY0iBueLjXKxENra6tDxQmepgL+85xRCpOMVKlpJdfALUkF7g/WEhzMSnBEzurDAvwKBgQCz0UBMnVZeiMT4DvNS1eNAbWFVSYkYQxnescwkxQ8Ls/q1ecdF9x+sstHjeClsKK6nCExt6fh/7xzqpEI87M2MFg3e2E3g1IoSaUTDsA37HB9pMyPBpk8Khb9xBM49nYMzL3iKJOuEjFM2Dz0Cw41xhPeSbj7f3rnTc7gABupdWwKBgQDR+g1nRxJhgHZZEANZHdpZ6ana4xktDbOVjHBZ/Ef1xxIPRQcP0e/0eXspF5DQr+zreIlRR/p/YLHRQhtcfbLmuxKrHGWcsYobs4oNm6E2oGV66bBF1C0Edl4bBiym36Im7jOed11XkwQ6u7BUfiZM07gSK93rPpeq446QPFBsDQKBgQCuBscwn/VJk0GQqLT280yvM0ejuST5nUMNZiKNFKX8Xpd5dbNZbAy20YYCEVRguPjxisXx07p4tbQkC3Bt+KBmK3CAI5Q1nsTkvhwcBKlvS+RvEbbXTio6t9Vbe4YtQLCrN/5Vzhak4OGv+zErQKjQ13ZNY3kOvFlVQoPQ/YMqdQ==";
    private static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvQ3PULEX5K0qs/dKBZGYgbf84vx9HM8ZHP/jtUqC5QybkZT8LtcjVBCiZt1v8RBq3z891EPU9ral0OUSIn8VD5DWk5NXyqMh+nVqYvb7Mv2peT8IBtNT1wBEIpXnwXSC29AVkNAD3mVeLBECYrdEt1fY4ePJgI2Kv6ovTj1poOp52etwahpW+Qv2Eb0ZnPDFpj+ktvKzjr5T2VH6IOy5fNDY9KdCIiEFtMM7GJ4wHKUBBz59ERHQfe2N+Lua7Dc72hdKal9PY06idrRQOHrRyug/nc4/lvSlsusx2UkwEq5gH43YZ9MUvDlz1P1DKYks3E6JOHvve07+1LFrwLDbcwIDAQAB";


    public static void main(String[] args) {
        String appId = args[0];
        String authCode = args[1];
        System.out.println("<AliOauth接口>接收到请求内容:" + appId);
        boolean flag = false; //标志
        if (!appId.isEmpty()) {
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", appId, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, "RSA2");
            AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
            request.setCode(authCode);
            request.setGrantType("authorization_code");
            try {
                // 获取userId
                AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);
                System.out.println(oauthTokenResponse.getAccessToken());
                AlipayUserInfoShareRequest userInfoShareRequest = new AlipayUserInfoShareRequest();
                // 获取用户信息
                AlipayUserInfoShareResponse userinfoShareResponse = alipayClient.execute(userInfoShareRequest, oauthTokenResponse.getAccessToken());
                System.out.println(userinfoShareResponse.getBody());
            }catch (AlipayApiException e) {
                //处理异常
                e.printStackTrace();
            }
        }
//        return flag;
    }
}
