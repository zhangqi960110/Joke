package com.imooc.guessmusic.joke.http;


import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangqi on 2017-07-17.
 */
public class RetrofitHelper {


    OkHttpClient client = new OkHttpClient();
    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            instance = new RetrofitHelper();
        }
        return instance;
    }

    public RetrofitHelper() {
        initRetrofit();
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://japi.juhe.cn/joke/")
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public RetrofitService getService() {
        return mRetrofit.create(RetrofitService.class);
    }
}
