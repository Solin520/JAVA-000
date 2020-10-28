package com.solin.zuoye;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHelper {
    public static void main(String[] args) {
        System.out.println(sendGet());
    }
    
    public static String sendGet() {
        String result = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .get()
            .url("http://127.0.0.1:9999/test")
            .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
