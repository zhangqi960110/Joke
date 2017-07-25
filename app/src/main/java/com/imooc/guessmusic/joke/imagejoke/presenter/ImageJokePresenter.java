package com.imooc.guessmusic.joke.imagejoke.presenter;

import com.imooc.guessmusic.joke.entity.ImageJokeEntity;
import com.imooc.guessmusic.joke.entity.ListEntity;
import com.imooc.guessmusic.joke.imagejoke.model.ImageJokeData;
import com.imooc.guessmusic.joke.imagejoke.view.ImageJokeView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zhangqi on 2017-07-22.
 */
public class ImageJokePresenter implements Presenter{

    private ImageJokeData data;
    private CompositeSubscription mCompositeSubscription;
    private ListEntity<ImageJokeEntity> listEntity;
    private ImageJokeView mImageJokeView;

    public ImageJokePresenter(ImageJokeView mImageJokeView) {
        this.mImageJokeView = mImageJokeView;
    }

    public void getImageJoke(String key, int page, int pagesize){
        mCompositeSubscription.add(data.getImageJoke(key,page,pagesize)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<ListEntity<ImageJokeEntity>>() {
            @Override
            public void onCompleted() {
                mImageJokeView.onSuccess(listEntity);
                mImageJokeView.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                mImageJokeView.onError();
                mImageJokeView.hideProgress();
            }

            @Override
            public void onNext(ListEntity<ImageJokeEntity> imageJokeEntityListEntity) {
                 listEntity = imageJokeEntityListEntity;
            }
        }));
    }


    @Override
    public void onCreate() {
        data = new ImageJokeData();
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }
}
