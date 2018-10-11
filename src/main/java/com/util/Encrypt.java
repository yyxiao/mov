package com.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Encrypt
 * com.util
 *
 * @author xiaoyy
 * 加密工具类
 * @Date 2017-08-16 下午3:43
 * The word 'impossible' is not in my dictionary.
 */
public class Encrypt {


    public static String md5Encrypt(String groupParamertStr) throws UnsupportedEncodingException {

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(groupParamertStr.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = md5Encrypt("asdf1234&8a92e107454fdcc101454fec25ea0001");
        System.out.println(a);
        //09c71dead011efbc05224d9e902f91dc
        //d98e19e5513cd4c4edaa67666cb07d4a
    }
}
