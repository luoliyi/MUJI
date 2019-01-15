package com.nf.commons.MyUtils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    //输入密码返回md5字符串
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();

        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    //判断输入的密码newpasswd是否与数据库oldpasswd中的密码相等
    public static boolean checkpassword(String newpasswd, String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        try {
            /*加密*/
            String result = MD5Util.EncoderByMd5(".asamu.654");
            System.out.println("加密的结果：" + result);

            /*解密*/
            boolean b = MD5Util.checkpassword(".asamu.654", result);
            System.out.println(b);
            if (b)
                System.out.println("验证正确！");
            else
                System.out.println("验证失败！");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
