package com.lqm.manage;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * IntelliJ IDEA
 * Author:Liqm
 * Date:23/7/23 3:55 PM
 */
public class RSAUtil {

    private static String ALGORITHM_NAME = "RSA";
    private static String SIGN_ALGORITHM = "MD5withRSA";

    private static String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC8TNkM4Hra/EU/pHJT56fGg6tbb8vF7fTjdUgl9rdAsDxbKXi9hzKGDnW9iYPOuuQ6wjBsb+2a4LCeGfMurzDovx89XWR+yfCbULaaWce9JqWzYq7gmIrNkqELHd2AENu4zKMLdlqvqYDtWIN9z7LH8FHFluSYRABUJpnnsDzoFQIDAQAB\n";

    private static String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALxM2Qzgetr8RT+kclPnp8aDq1tvy8Xt9ON1SCX2t0CwPFspeL2HMoYOdb2Jg8665DrCMGxv7ZrgsJ4Z8y6vMOi/Hz1dZH7J8JtQtppZx70mpbNiruCYis2SoQsd3YAQ27jMowt2Wq+pgO1Yg33PssfwUcWW5JhEAFQmmeewPOgVAgMBAAECgYEAiDNd3D6THsrSnBIq0B4D8UdULzNSRby1IcG3ih5GtvfC8H2y5ARiuyzCZXKOcH4mj4ne1NCxIRHdLr6+c8osqS+4u01mTLZLR59q6conL3te5vIdsDOHYAY6tFl4+olIkFyYb0VGVF9k5fkLG9eLIhg93Kd6OAgdIdXsxOcQSwECQQDhh8OKqK2r6uuWhaqipfYeNrnvmE5F4t0plEhQQDd3UBJ3OErf6AvNJoRSNY2VEYNiRBdeODQJKiNRPLXRk9LFAkEA1b1vYMxlPGTfxrTUNfiTEUFyitixNN6ogwALmXYIlQkf0IUbXqn5b9HyJAs/5x+25THAFCExmtPj9WgcI7bVEQJAGqHIkogmsgV0unqgUsKcVKcLv+JRY+lNSoqrG2bp5dn7xD5OgTBKrHge6gJO7Mp7pE/8HnEum+Jw9zffFJeLLQJANMJS6NDrOFIqDpF6RGw8WSkPjghZDZTcgaGUO2gwTCF5ce45SE+qm5h2LcF9H57rdX2nTRC4fuBIx73QHFy4EQJAL9CRou1J8EaN8jbZImA3ICXj1csmY8TrRkgvKz8fa9IaoCBvml/w6+MJXgYWlSBZu1LTb9N/KVeJF1h+682+ZQ==";
    private static String PRIVATE_KEY1 = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAIpB4x9I8Yb3uuIHFhsB/QCFVeuLO4LzgAdVMeya4J6QvjpTZwNQkkA6zB56BaqTSQUE+5uCYpEmH9gEBggiDOKS1WnVkCaE+2wXMwFVpJrNb60o1gmsh4tJkNkSHqjFlYOk0j+soQPf8WcmoyDaxc+Vp+QWD0zPVaJsaUN0sLPZAgMBAAECgYEAhQrcHSnbSc6v5nt9OSYTqWGliZElBmF9TREdhpqPFechNw007sqkwewSqi0vsLIkrRDbcgzo/tYaBIvypfbmP98TSG4hiVvSs8p+gsaWW9p7+iqhllP6wNjysO1Nlt/itVKNOlTcydFWdkqUkSYEym31joyCR9G6AR5eeX4IzgUCQQDcFjml2LLrg1Ji8TpK99EBmgJx1OAp97bLc6nVRTYj2hQuRTSuyxB06yRLMrirVmeDLJ0TvxlEbg7t+6T8Z6nrAkEAoNFeKAUyiiD4EWRzc73KeIB6zvznc14WiemGvXVO3xYQBQnUmb64g1ONQ5jrgFuPC+0DUNltyAnWWV1F1C7ESwJBAMFO+CV2V3jK6KMlFDliv35zonAPNTFHdZPvrJ05ZFtLIeyeNq7Mh1DadA9kppU/mD28At+kOvJC5PQc0oYsGy8CQA4JOAaWLYsQxZX/BnSbpAhQbmeSe0D+fUkcML5odrHR4yQNb5jbpI8Rw8qaljNlyl5oGVn9IC/Na//wvB+A1XECQQCO4x/M2QJ5oRqny8OnoFiTzetfL1sEvyDAYSGOzS4O8Y3vzwp5RDM/qHpai+K1xow+oUbadlgLx4+i/KGB5p9j";


    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * 生成蜜月对
     * @return
     */
    public static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024);
            return generator.generateKeyPair();
        } catch (Exception e) {
            throw new RuntimeException("generate key exception", e);
        }
    }

    /**
     * 获取公钥
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String publicKey){
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_NAME);
            byte[] decodedKey = Base64.decodeBase64(publicKey.getBytes());
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
            return keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            throw new RuntimeException("get public key exception", e);
        }
    }

    /**
     * 获取私钥
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String privateKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_NAME);
            byte[] decodedKey = Base64.decodeBase64(privateKey.getBytes());
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
            return keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            throw new RuntimeException("get private key exception", e);
        }

    }

    /**
     * 加密
     * @param data
     * @return
     */
    public static String encrypt(String data,Key key) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE,key);

            int inputLen = data.getBytes().length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offset = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offset > 0) {
                if (inputLen - offset > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data.getBytes(), offset, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data.getBytes(), offset, inputLen - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            out.close();
            return new String(Base64.encodeBase64String(encryptedData));
        } catch (Exception e) {
            throw new RuntimeException("encrypt exception:", e);
        }
    }

    /**
     * 解密
     * @param data
     * @return
     */
    public static String decrypt(String data,Key key) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] dataBytes = Base64.decodeBase64(data);
            int inputLen = dataBytes.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offset = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offset > 0) {
                if (inputLen - offset > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(dataBytes, offset, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(dataBytes, offset, inputLen - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            // 解密后的内容
            return new String(decryptedData, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException("encrypt exception:", e);
        }
    }

    /**
     * 签名
     *
     * @param data 待签名数据
     * @param privateKey 私钥
     * @return 签名
     */
    public static String sign(String data, Key privateKey) {
        try {
            byte[] keyBytes = privateKey.getEncoded();
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_NAME);
            PrivateKey key = keyFactory.generatePrivate(keySpec);
            // 实例化签名
            Signature signature = Signature.getInstance(SIGN_ALGORITHM);
            signature.initSign(key);
            signature.update(data.getBytes());
            return new String(Base64.encodeBase64(signature.sign()));
        } catch (Exception e) {
            throw new RuntimeException("sing exception", e);
        }
    }

    /**
     * 验签
     *
     * @param srcData 原始字符串
     * @param publicKey 公钥
     * @param sign 签名
     * @return 是否验签通过
     */
    public static boolean verify(String srcData, PublicKey publicKey, String sign) {
        try {
            byte[] keyBytes = publicKey.getEncoded();
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_NAME);
            PublicKey key = keyFactory.generatePublic(keySpec);
            Signature signature = Signature.getInstance(SIGN_ALGORITHM);
            signature.initVerify(key);
            signature.update(srcData.getBytes());
            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("verify sing exception", e);
        }
    }

    public static void main(String[] args) {

        /**生成密钥对*/
        KeyPair keyPair = generateKeyPair();
        String private_key = "";
        String public_key1 = "";
        String public_key2 = "";
        System.out.println(public_key1 = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded())));
        System.out.println(public_key2 = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded())));
        System.out.println(private_key = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded())));


        System.out.println("---------私钥加密，公钥解密---------");
        /**加解密*/
        String data = "Java加解密";
        String encryptStr = "";
        System.out.println("私钥加密：" + (encryptStr = encrypt(data, getPrivateKey(private_key))));

        System.out.println("解密（public_key1）：" + decrypt(encryptStr, getPublicKey(public_key1)));
        System.out.println("解密（public_key2）:" + decrypt(encryptStr, getPublicKey(public_key2)));


        /**加签，验签*/
//        String sign = sign(data, getPrivateKey(PRIVATE_KEY));
//        System.out.println("签名：" + sign);
//        System.out.println(verify(data, getPublicKey(PUBLIC_KEY), sign));

//        System.out.println("---------公钥加密，私钥解密---------");
//        String data = "Java加解密";
//        String encryptStr = "";
//        System.out.println("加密串：" + (encryptStr = encrypt(data, getPublicKey(PUBLIC_KEY))));
//        System.out.println("解密后：" + decrypt(encryptStr, getPrivateKey(PRIVATE_KEY)));

    }

}
