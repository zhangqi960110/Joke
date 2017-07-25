package com.imooc.guessmusic.joke.main.model;

import com.imooc.guessmusic.joke.entity.ImageJokeEntity;
import com.imooc.guessmusic.joke.entity.NewListEntity;
import com.imooc.guessmusic.joke.entity.TextJokeEntity;
import com.imooc.guessmusic.joke.http.RetrofitHelper2;
import com.imooc.guessmusic.joke.http.RetrofitService;

import rx.Observable;

/**
 * Created by zhangqi on 2017-07-24.
 */
public class JokeData {

    private RetrofitService mRetrofitService;

    public JokeData() {
        this.mRetrofitService = RetrofitHelper2.getInstance().getService();
    }


    public Observable<NewListEntity<TextJokeEntity>> getRandomTextJoke(String key, String type) {
        return mRetrofitService.getRandomTextJoke(key, type);
    }

    public Observable<NewListEntity<ImageJokeEntity>> getRandomImageJoke(String key, String type) {
        return mRetrofitService.getRandomImageJoke(key, type);
    }

}
