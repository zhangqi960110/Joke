package com.imooc.guessmusic.joke.main.presenter;


import com.imooc.guessmusic.joke.entity.ImageJokeEntity;
import com.imooc.guessmusic.joke.entity.ListEntity;
import com.imooc.guessmusic.joke.entity.NewListEntity;
import com.imooc.guessmusic.joke.entity.TextJokeEntity;
import com.imooc.guessmusic.joke.main.model.JokeData;
import com.imooc.guessmusic.joke.main.view.JokeView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class JokePresenter implements Presenter {

    private JokeData data;
    private CompositeSubscription mCompositeSubscription;
    private JokeView mJokeView;
    private NewListEntity<TextJokeEntity> listTextEntity;
    private NewListEntity<ImageJokeEntity> listImageEntity;

    public JokePresenter(JokeView mJokeView) {
        this.mJokeView = mJokeView;
    }

    @Override
    public void onCreate() {
        data = new JokeData();
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void getRandomTextJoke(String key, String type){
        mCompositeSubscription.add(data.getRandomTextJoke(key,type)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<NewListEntity<TextJokeEntity>>() {
            @Override
            public void onCompleted() {
                mJokeView.onTextSuccess(listTextEntity);
                mJokeView.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                mJokeView.onError();
                mJokeView.hideProgress();
            }

            @Override
            public void onNext(NewListEntity<TextJokeEntity> textJokeEntityListEntity) {
                listTextEntity = textJokeEntityListEntity;
            }
        }));
    }

    public void getRandomImageJoke(String key,String type){
        mCompositeSubscription.add(data.getRandomImageJoke(key,type)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<NewListEntity<ImageJokeEntity>>() {
            @Override
            public void onCompleted() {
                mJokeView.onImageSuccess(listImageEntity);
                mJokeView.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                mJokeView.onError();
                mJokeView.hideProgress();
            }

            @Override
            public void onNext(NewListEntity<ImageJokeEntity> imageJokeEntityNewListEntity) {
                listImageEntity = imageJokeEntityNewListEntity;
            }
        }));
    }
}
