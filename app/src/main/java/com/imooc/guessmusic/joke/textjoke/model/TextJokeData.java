package com.imooc.guessmusic.joke.textjoke.model;



import com.imooc.guessmusic.joke.entity.TextJokeEntity;
import com.imooc.guessmusic.joke.entity.ListEntity;
import com.imooc.guessmusic.joke.http.RetrofitHelper;
import com.imooc.guessmusic.joke.http.RetrofitService;

import rx.Observable;

/**
 * Created by zhangqi on 2017-07-18.
 */
public class TextJokeData {
    private RetrofitService mRetrofitService;

    public TextJokeData() {
        this.mRetrofitService = RetrofitHelper.getInstance().getService();
    }


    public Observable<ListEntity<TextJokeEntity>> getTextJoke(String key, int page, int pagesize) {
        return mRetrofitService.getTextJoke(key, page, pagesize);
    }

}
