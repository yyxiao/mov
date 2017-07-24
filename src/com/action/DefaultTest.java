package com.action;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.ZhimaCustomerCertificationCertifyRequest;
import com.alipay.api.request.ZhimaCustomerCertificationInitializeRequest;
import com.alipay.api.response.ZhimaCustomerCertificationCertifyResponse;
import com.alipay.api.response.ZhimaCustomerCertificationInitializeResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * DefaultAlipayClient
 * com.action
 *
 * @author xiaoyy
 * 芝麻认证Demo
 * @Date 2017-07-24 上午11:53
 * The word 'impossible' is not in my dictionary.
 */
public class DefaultTest {

    private static String ALI_URL = "https://openapi.alipaydev.com/gateway.do";
    private static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCtPCttvBc89E10xJP4tD1LalbAcU4hLV5X4trESmManJj9ukoKTeqtOgi7KHJ66BWFqM7KKq0cLRGd1B90fKdXMx/q4pqMP5ny/jOr0K3qePGkgraxBDf6DbchmUUjVA2c3c/eT8xpccBjwx+LYpYpQ6u4b0k658Bi5N13HJFmEXEDdRNTK4yyf3A3WiH/slXuwL17fW6huzdbQO+U/ZEW8wa/acQ+ap8dSVvqMcmOebJTlGVWt4g2gc7Wk0Dfo46e0+wFlHAtCnmPm5/AjUJs2WHR2coAeRpuhT7GGvcL5uiANi74Cbia3eXDpdVVstQpWiZA84JdrGRRuhgPOLRzAgMBAAECggEAfUZS3ZM0dtbwoG172FF3Ne9bduU5K9LkM8gQjfyBOIBgPrQV0OfRup2KLNYuG2V0EuklSZuc/hA1eh4o9RMj7HJDNZfTTXK9ALUFZs2Mx0/Y5y/Dr7UuSbzbXwe4sLia84KQTOMGHoatKzeyuxh7ILIYH1MS8O8g+CMraHSXTOg/nGEbxXqciwQuJ/Rwd7o7Ppio6+2TxWf9tROGUK49R2EIkcAii4mrsRDCg66u8GlpkluEKnNY6kUfXxDDOR6br03kYv9gU6dxq3JZF9r7jBtD6OMxAT0I6aC0wN9OLnhDQFheJLdrXihaHC/C2HntAB81GwJOoVst58CX7I+QWQKBgQD/+h72jyfKBOQn6mr+7ZmKffyV8Yx28JwGfTZRkI2qrujuX79BguSkkh4aA4T6zhK99fphoT9C956neFsijh+TcAeaQBufaQzKxI+ASjNor305B+TIeqaqemkjiTWxr5DLcDGkc9pG68vYGAJmJQVEylkf/DGJ8XrFCkEYXgIUhQKBgQCtQCX6PvsiSKgjLJ+qb1d0MbEYO5k8V2hCHq0fn4rRDkdW3G3rOqI02FASZuzV1+nikYbxoTdeJ5nDfDrh7F2FxfA3CgwL2Tyhu4oFfXhNhf0gz1IBsBhVcE/R1POUYIq3Wg4AirD21Mqstqcu0qnjxuMiz0fTNQcka1IWTXxSlwKBgQDCGsif7q4dYtgf7IJ2DXYArsh6a1A4YPvvb8Ng1lyWsUuwdqpw4vC+Wo646zJLfTh5E61pmvx9q4eDNqDk8yC+jJU3QqWvm9k3aRXoElwpZelu9a1m2JrJa0mOyN0OgDMsEUeTjMZYQTWyB4LKMghswYQT3QkzsQmHoN77u02YgQKBgGW+EU93oxXMI2mcsBtwDaS/9edsQJ4uGp0R1MuIbwY8Y2rAQpDsuwtbqRJVfWpLxR94JQ5Lhe92RBeIIjBBFd8UkfBQpyhiJ/g24WQ9/eNQ94lIFznEh1XNgiKQ84bEd1IbwbNRv4EFEA0DqwSVVI3eY88yeVSwhIQ/vlI4qPT7AoGBAOaeO1tXAdcnFmVgS5TmH5cseihZsYSAfBb9TCPiRenu/IoXCqY6Gwq8YUjRQ7Aa1T+6rHdRKN/ZhaUstn9PIRPjSdL3FnCKwWAp6DhEWbazb9YeUVm3EPyF6JeCI7tCpyDhBDR9G6Y5PgOnT23lgxP3In1wiqaTw/2VifS2M4bi";
    private static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvQ3PULEX5K0qs/dKBZGYgbf84vx9HM8ZHP/jtUqC5QybkZT8LtcjVBCiZt1v8RBq3z891EPU9ral0OUSIn8VD5DWk5NXyqMh+nVqYvb7Mv2peT8IBtNT1wBEIpXnwXSC29AVkNAD3mVeLBECYrdEt1fY4ePJgI2Kv6ovTj1poOp52etwahpW+Qv2Eb0ZnPDFpj+ktvKzjr5T2VH6IOy5fNDY9KdCIiEFtMM7GJ4wHKUBBz59ERHQfe2N+Lua7Dc72hdKal9PY06idrRQOHrRyug/nc4/lvSlsusx2UkwEq5gH43YZ9MUvDlz1P1DKYks3E6JOHvve07+1LFrwLDbcwIDAQAB";

    /**用于生成TransactionId的自增器*/
    private static AtomicLong transAutoIncIdx   = new AtomicLong(1000000000000l);

    public static void main(String[] args) throws AlipayApiException {
        // "transaction_id" 是代表一笔请求的唯一标志，该标识作为对账的关键信息，
        // 对于相同 transaction_id 的查询，芝麻在一天（86400秒）内返回首次查询数据，
        // 超过有效期的查询即为无效并返回异常（错误码:TRANSACTION_ID_EXPIRED），
        // 有效期内的重复查询不重新计费。
        String transactionId = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
                + transAutoIncIdx.getAndDecrement();
        String bizNo = null;
        // 获取bizNo
        AlipayClient alipayClient = new DefaultAlipayClient(ALI_URL,"2016080500171059",APP_PRIVATE_KEY,"json","GBK",ALIPAY_PUBLIC_KEY,"RSA2");
        ZhimaCustomerCertificationInitializeRequest request = new ZhimaCustomerCertificationInitializeRequest();
        request.setBizContent("{" +
                "\"transaction_id\":\"" +transactionId+ "\"," +
                "\"product_code\":\"w1010100000000002978\"," +
                "\"biz_code\":\"FACE\"," +
                "\"identity_param\":\"{\\\"identity_type\\\":\\\"CERT_INFO\\\",\\\"cert_type\\\":\\\"IDENTITY_CARD\\\",\\\"cert_name\\\":\\\"肖阳阳\\\",\\\"cert_no\\\":\\\"6224211992304100014\\\"}\"," +
                "\"ext_biz_param\":\"{}\"" +
                "  }");
        ZhimaCustomerCertificationInitializeResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
            bizNo = response.getBizNo();
            System.out.println(bizNo);
        } else {
            System.out.println("调用失败");
        }

        //开始认证
        ZhimaCustomerCertificationCertifyRequest request1 = new ZhimaCustomerCertificationCertifyRequest();
        request1.setBizContent("{" +
                "\"biz_no\":\"" + bizNo +
                "\"" +
                "  }");
        ZhimaCustomerCertificationCertifyResponse response1 = alipayClient.execute(request1);
        if(response1.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }



    }
}
