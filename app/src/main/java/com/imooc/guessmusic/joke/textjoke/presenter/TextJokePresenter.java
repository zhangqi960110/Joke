package com.imooc.guessmusic.joke.textjoke.presenter;


import com.imooc.guessmusic.joke.entity.TextJokeEntity;
import com.imooc.guessmusic.joke.entity.ListEntity;
import com.imooc.guessmusic.joke.textjoke.model.TextJokeData;
import com.imooc.guessmusic.joke.textjoke.view.TextJokeView;


import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zhangqi on 2017-07-18.
 */
public class TextJokePresenter implements Presenter {

    private TextJokeData data;
    private CompositeSubscription mCompositeSubscription;
    private ListEntity<TextJokeEntity> listEntity;
    private TextJokeView mTextJokeView;

    public TextJokePresenter(TextJokeView mTextJokeView) {
        this.mTextJokeView = mTextJokeView;
    }

    @Override
    public void onCreate() {
        data = new TextJokeData();
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void getTextJoke(String key, int page, int pagesize) {
        mCompositeSubscription.add(data.getTextJoke(key, page, pagesize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListEntity<TextJokeEntity>>() {
                    @Override
                    public void onCompleted() {
                        mTextJokeView.onSuccess(listEntity);
                        mTextJokeView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mTextJokeView.onError();
                        mTextJokeView.hideProgress();
                    }

                    @Override
                    public void onNext(ListEntity<TextJokeEntity> textJokeEntityTextListEntity) {
                        listEntity = textJokeEntityTextListEntity;
                    }
                }));
    }

}
