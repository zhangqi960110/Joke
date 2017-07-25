package com.imooc.guessmusic.joke.imagejoke.model;

import android.media.Image;

import com.imooc.guessmusic.joke.entity.ImageJokeEntity;
import com.imooc.guessmusic.joke.entity.ListEntity;
import com.imooc.guessmusic.joke.http.RetrofitHelper;
import com.imooc.guessmusic.joke.http.RetrofitService;

import java.util.List;

import rx.Observable;

/**
 * Created by zhangqi on 2017-07-22.
 */
public class ImageJokeData {
    private RetrofitService mRetrofitService;

    public ImageJokeData() {
        this.mRetrofitService = RetrofitHelper.getInstance().getService();
    }

    public Observable<ListEntity<ImageJokeEntity>> getImageJoke(String key, int page, int pagesize) {
        return mRetrofitService.getImageJoke(key, page, pagesize);
    }
}
