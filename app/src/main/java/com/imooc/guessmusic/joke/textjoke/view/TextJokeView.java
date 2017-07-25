package com.imooc.guessmusic.joke.textjoke.view;


import com.imooc.guessmusic.joke.entity.TextJokeEntity;
import com.imooc.guessmusic.joke.entity.ListEntity;


/**
 * Created by zhangqi on 2017-07-18.
 */
public interface TextJokeView {
    void onSuccess(ListEntity<TextJokeEntity> mTextJoke);

    void onError();

    void showProgress();

    void hideProgress();

}
