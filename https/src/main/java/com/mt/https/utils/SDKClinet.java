package com.mt.https.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jcp.xml.dsig.internal.dom.Utils;
import org.springframework.beans.factory.annotation.Value;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.security.KeyStore;
import java.security.SecureRandom;

/**
 * author: liqm
 * 2019-11-27
 */
public class SDKClinet {

//    @Value("${certificate.filePath}")
//    private String path;
//    @Value("${certificate.fileName}")
//    private String name;
//    @Value("${certificate.keyPassword}")
//    private String keyPassword;

    private static final String KEY_STORE_TYPE_JKS = "jks";
    private static final String KEY_STORE_TYPE_P12 = "PKCS12";
    private static final String SCHEME_HTTPS = "https";
    private static final int HTTPS_PORT = 443;
    private static final String HTTPS_URL = "https://www.test.com/app/test?username=李四";
    private static final String KEY_STORE_CLIENT_PATH = "/Users/ktjr/Desktop/work/2019dev/test/https/src/main/resources/certificate/client.p12";
    private static final String KEY_STORE_TRUST_PATH = "/Users/ktjr/Desktop/work/2019dev/test/https/src/main/resources/certificate/server-cert.cer";
    private static final String KEY_STORE_PASSWORD = "111111";
    private static final String KEY_STORE_TRUST_PASSWORD = "111111";

    /**
     * 发送https请求
     * 为双向请求
     * @return
     */
    public static void ssl1() throws Exception {

        HttpClient httpClient = new DefaultHttpClient();
        try {
            KeyStore keyStore  = KeyStore.getInstance(KEY_STORE_TYPE_P12);
            KeyStore trustStore  = KeyStore.getInstance(KEY_STORE_TYPE_JKS);

            InputStream ksIn = new FileInputStream(KEY_STORE_CLIENT_PATH);
            //InputStream tsIn = new FileInputStream(new File(KEY_STORE_TRUST_PATH));
            try {
                keyStore.load(ksIn, KEY_STORE_PASSWORD.toCharArray());
                //trustStore.load(tsIn, null);
            } finally {
                try { ksIn.close(); } catch (Exception ignore) {}
                //try { tsIn.close(); } catch (Exception ignore) {}
            }

            SSLSocketFactory socketFactory = new SSLSocketFactory(keyStore, KEY_STORE_PASSWORD, trustStore);
            Scheme sch = new Scheme(SCHEME_HTTPS, HTTPS_PORT, socketFactory);
            httpClient.getConnectionManager().getSchemeRegistry().register(sch);
            HttpGet httpget = new HttpGet(HTTPS_URL);
            System.out.println("executing request" + httpget.getRequestLine());
            HttpResponse response = httpClient.execute(httpget);
            HttpEntity entity = response.getEntity();
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
                String text;
                while ((text = bufferedReader.readLine()) != null) {
                    System.out.println(text);
                }
                bufferedReader.close();
            }
            EntityUtils.consume(entity);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }


    public static void ssl2() throws Exception {

        InputStream certificate = new FileInputStream(new File(KEY_STORE_TRUST_PATH));

        KeyStore keyStore = KeyStore.getInstance("jks");

        keyStore.load(certificate,null);

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());

        kmf.init(keyStore, null);

        try{

            if(certificate != null)

                certificate.close();

        } catch(IOException e) {

            e.printStackTrace();

        }

        KeyStore clientKeyStore = KeyStore.getInstance(KEY_STORE_TYPE_P12);

        InputStream inputStream = new FileInputStream(KEY_STORE_CLIENT_PATH);

        clientKeyStore.load(inputStream, "111111".toCharArray());

        SSLContext sslContext = SSLContext.getInstance("SSL");

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

        trustManagerFactory.init(clientKeyStore);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());

        keyManagerFactory.init(clientKeyStore, "111111".toCharArray());

        sslContext.init(kmf.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());

        javax.net.ssl.SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();


    }



    public static void main(String[] args) throws Exception {

        ssl2();
    }



}
