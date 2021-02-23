package sercret;

import org.junit.Test;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AES {

    private String SECRET_KEY = "jO149njrTj4kEx6ZbUH8Zc53bfQJctINWaEzTWIsOoxSDNwK2I";


    public String encrypt(String content){
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

            keyGenerator.init(128,new SecureRandom(SECRET_KEY.getBytes()));

            SecretKey secretKey = keyGenerator.generateKey();

            byte[] encoded = secretKey.getEncoded();

            SecretKey key  = new SecretKeySpec(encoded,"AES");

            Cipher aes = Cipher.getInstance("AES");

            aes.init(Cipher.ENCRYPT_MODE,key);

            byte[] bytes = content.getBytes("UTF-8");

            byte[] bytes1 = aes.doFinal(bytes);

            String s = new String(new BASE64Encoder().encode(bytes1));

            return s;

        }catch (Exception e){
            e.printStackTrace();
        }



        return null;
    }

    public  String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        sKey = pad(sKey);
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }

        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
        return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }


    public String pad(String text){
        int pad = 16 - text.length()%16;

        return text + pad * (char)(pad);
    }

    @Test
    public void fun() throws Exception {
        System.out.println(Encrypt("200706Qiu",this.SECRET_KEY));
    }



}
