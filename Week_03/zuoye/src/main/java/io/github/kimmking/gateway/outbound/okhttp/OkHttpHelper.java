package io.github.kimmking.gateway.outbound.okhttp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.netty.handler.codec.http.FullHttpRequest;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class OkHttpHelper {
    public static String sendGet(String url, FullHttpRequest inbound) {
        String result = null;
        OkHttpClient client = new OkHttpClient();
        Builder builder = new Request.Builder()
        .get()
        .url(url);
        inbound.headers().forEach((header) -> builder.addHeader(header.getKey(), header.getValue()));
        Request request = builder.build();
        
        /*Map<String, String> headerMap = new HashMap<>();
        inbound.headers().entries().stream().forEach(
            entry -> {
                headerMap.put(entry.getKey(), entry.getValue());
            }
            );*/
        System.out.println(request.header("nio")+"--------------------------");
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
