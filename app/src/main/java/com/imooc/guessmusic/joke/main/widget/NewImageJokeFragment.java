package com.imooc.guessmusic.joke.main.widget;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.MenuPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.imooc.guessmusic.joke.R;
import com.imooc.guessmusic.joke.adapter.MyImageAdapter;
import com.imooc.guessmusic.joke.entity.ImageJokeEntity;
import com.imooc.guessmusic.joke.entity.NewListEntity;
import com.imooc.guessmusic.joke.entity.TextJokeEntity;
import com.imooc.guessmusic.joke.main.presenter.JokePresenter;
import com.imooc.guessmusic.joke.main.view.JokeView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewImageJokeFragment extends Fragment implements JokeView,SwipeRefreshLayout.OnRefreshListener{

    private static final String KEY = "ce794dbe4521b1a4f92bc6a549559166";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MyImageAdapter mAdapter;
    private JokePresenter mJokePresenter;
    private List<ImageJokeEntity> mData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_image_joke,container,false);
        mData = new ArrayList<>();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.new_image_recycle_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.new_image_swipe_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,
                R.color.colorAccent,R.color.primaryLight,
                R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mJokePresenter = new JokePresenter(this);
        mJokePresenter.onCreate();
        mJokePresenter.getRandomImageJoke(KEY,"pic");
        return view;
    }

    @Override
    public void onRefresh() {
       mJokePresenter.getRandomImageJoke(KEY,"pic");
    }

    @Override
    public void onTextSuccess(NewListEntity<TextJokeEntity> mTextJoke) {

    }

    @Override
    public void onImageSuccess(NewListEntity<ImageJokeEntity> mImageJoke) {
        if(!mData.isEmpty()){
            mData.clear();
        }
        mData.addAll(mImageJoke.getResult());
        if(mAdapter == null){
            mAdapter = new MyImageAdapter(getContext(),mData);
            mRecyclerView.setAdapter(mAdapter);
        }
        mAdapter.setmData(mData);
    }

    @Override
    public void onError() {
        Toast.makeText(getContext(), "网络出错", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
       mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
      mSwipeRefreshLayout.setRefreshing(false);
    }
}
