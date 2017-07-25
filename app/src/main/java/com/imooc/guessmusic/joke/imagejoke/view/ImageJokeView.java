package com.imooc.guessmusic.joke.imagejoke.view;


import com.imooc.guessmusic.joke.entity.ImageJokeEntity;
import com.imooc.guessmusic.joke.entity.ListEntity;

/**
 * Created by zhangqi on 2017-07-22.
 */
public interface ImageJokeView {

    void onSuccess(ListEntity<ImageJokeEntity> mImageJoke);

    void onError();

    void showProgress();

    void hideProgress();
}
