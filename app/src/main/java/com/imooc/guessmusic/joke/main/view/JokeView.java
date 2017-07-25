package com.imooc.guessmusic.joke.main.view;

import com.imooc.guessmusic.joke.entity.ImageJokeEntity;
import com.imooc.guessmusic.joke.entity.ListEntity;
import com.imooc.guessmusic.joke.entity.NewListEntity;
import com.imooc.guessmusic.joke.entity.TextJokeEntity;

/**
 * Created by zhangqi on 2017-07-24.
 */
public interface JokeView {
    void onTextSuccess(NewListEntity<TextJokeEntity> mTextJoke);

    void onImageSuccess(NewListEntity<ImageJokeEntity> mImageJoke);

    void onError();

    void showProgress();

    void hideProgress();
}
