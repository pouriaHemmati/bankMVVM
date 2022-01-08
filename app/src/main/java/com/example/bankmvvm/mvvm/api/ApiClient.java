package com.example.bankmvvm.mvvm.api;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private String baseUrl = "local/";
    private static final int TIME_OUT = 180;
    private static ApiClient instance;
    private static APIServiceRxjava apiServiceRxjavaInstance = null;


    public static ApiClient getInstance() {
        if (instance == null)
            instance = new ApiClient();
        return instance;
    }

    private static <S> S createService(Class<S> serviceClass, String baseURL) {


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

        Retrofit.Builder builder = new Retrofit
                .Builder()
                .client(client)
                .baseUrl(baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());


        Retrofit retrofit = builder.build();

        return retrofit.create(serviceClass);
    }

    public APIServiceRxjava getApiServiceRxjava() {

        if (apiServiceRxjavaInstance == null)
            apiServiceRxjavaInstance = createService(APIServiceRxjava.class, baseUrl);
        return apiServiceRxjavaInstance;
    }


}
