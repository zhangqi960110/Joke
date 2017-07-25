package com.imooc.guessmusic.joke.http;


import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangqi on 2017-07-24.
 */
public class RetrofitHelper2 {

    OkHttpClient client = new OkHttpClient();
    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    private Retrofit mRetrofit = null;
    private static RetrofitHelper2 instance = null;

    public static RetrofitHelper2 getInstance() {
        if (instance == null) {
            instance = new RetrofitHelper2();
        }
        return instance;
    }

    public RetrofitHelper2() {
        initRetrofit();
    }

    public RetrofitService getService() {
        return mRetrofit.create(RetrofitService.class);
    }

    public void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/joke/")
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
