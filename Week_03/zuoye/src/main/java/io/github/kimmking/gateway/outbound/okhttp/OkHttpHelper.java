package io.github.kimmking.gateway.outbound.okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHelper {
    public static String sendGet(String url) {
        String result = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .get()
            .url(url)
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
