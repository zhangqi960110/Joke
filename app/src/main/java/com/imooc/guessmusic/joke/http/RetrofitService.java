package com.imooc.guessmusic.joke.http;



import com.imooc.guessmusic.joke.entity.ImageJokeEntity;
import com.imooc.guessmusic.joke.entity.NewListEntity;
import com.imooc.guessmusic.joke.entity.TextJokeEntity;
import com.imooc.guessmusic.joke.entity.ListEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zhangqi on 2017-07-18.
 */
public interface RetrofitService {

    @GET("content/text.from")
    Observable<ListEntity<TextJokeEntity>> getTextJoke(@Query("key") String key, @Query("page") int page, @Query("pagesize") int pagesize);

    @GET("img/text.from")
    Observable<ListEntity<ImageJokeEntity>> getImageJoke(@Query("key") String key, @Query("page") int page, @Query("pagesize") int pagesize);

    @GET("randJoke.php")
    Observable<NewListEntity<TextJokeEntity>> getRandomTextJoke(@Query("key") String key, @Query("type") String type);

    @GET("randJoke.php")
    Observable<NewListEntity<ImageJokeEntity>> getRandomImageJoke(@Query("key") String key, @Query("type") String type);

}
