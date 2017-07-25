package com.imooc.guessmusic.joke.imagejoke.widget;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.imooc.guessmusic.joke.R;
import com.imooc.guessmusic.joke.adapter.MyImageAdapter;
import com.imooc.guessmusic.joke.adapter.MyTextAdapter;
import com.imooc.guessmusic.joke.entity.ImageJokeEntity;
import com.imooc.guessmusic.joke.entity.ListEntity;
import com.imooc.guessmusic.joke.entity.TextJokeEntity;
import com.imooc.guessmusic.joke.imagejoke.presenter.ImageJokePresenter;
import com.imooc.guessmusic.joke.imagejoke.view.ImageJokeView;
import com.imooc.guessmusic.joke.textjoke.presenter.TextJokePresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageJokeFragment extends Fragment implements ImageJokeView,SwipeRefreshLayout.OnRefreshListener {

    private static final String KEY = "ce794dbe4521b1a4f92bc6a549559166";
    private static final int MAX = 6000;
    private Random random = new Random();
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private SwipeRefreshLayout mSwipeReflashLayout;
    private MyImageAdapter mAdapter;
    private ImageJokePresenter mImageJokePresenter;
    private List<ImageJokeEntity> mData;
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_joke, container, false);

        mTextView = (TextView) view.findViewById(R.id.toolbar_title);
        mTextView.setText("内涵趣图");

        mData = new ArrayList<>();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.image_recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mSwipeReflashLayout = (SwipeRefreshLayout) view.findViewById(R.id.image_swipe_layout);
        mSwipeReflashLayout.setColorSchemeResources(R.color.colorAccent,
                R.color.colorAccent, R.color.primaryLight,
                R.color.colorPrimary);
        mSwipeReflashLayout.setOnRefreshListener(this);

        mImageJokePresenter = new ImageJokePresenter(this);
        mImageJokePresenter.onCreate();
        mImageJokePresenter.getImageJoke(KEY, 1, 20);
        return view;
    }


    @Override
    public void onRefresh() {
        int page = random.nextInt(MAX) + 1;
        mImageJokePresenter.getImageJoke(KEY, page, 20);
    }

    @Override
    public void onSuccess(ListEntity<ImageJokeEntity> mImageJoke) {
        mData = mImageJoke.getResult().getData();
        if (mData == null){
            Toast.makeText(getContext(), "kong", Toast.LENGTH_SHORT).show();
        }
        if(mAdapter == null){
            mAdapter = new MyImageAdapter(getContext(), mData);
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
        mSwipeReflashLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mSwipeReflashLayout.setRefreshing(false);
    }
}
