package com.solin.zuoye;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientHelper {
    public static void main(String[] args) {
        System.out.println(sendGet());
    }
    
    public static String sendGet() {
        HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        GetMethod getMethod = new GetMethod("http://127.0.0.1:9999/test");
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        getMethod.addRequestHeader("Connection", "keep-alive");
        String result = null;
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode == HttpStatus.SC_OK) {
                /*result = getMethod.getResponseBodyAsString();*/
                InputStream inputStream = getMethod.getResponseBodyAsStream();  
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));  
                StringBuffer stringBuffer = new StringBuffer();  
                String str= "";  
                while((str = br.readLine()) != null){  
                    stringBuffer.append(str );  
                }
                result = stringBuffer.toString();
            }else {
                result = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            getMethod.releaseConnection();
        }
        return result;
    }
}
