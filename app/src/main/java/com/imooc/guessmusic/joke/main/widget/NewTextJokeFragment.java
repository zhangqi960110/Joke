package com.imooc.guessmusic.joke.main.widget;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.imooc.guessmusic.joke.R;
import com.imooc.guessmusic.joke.adapter.MyTextAdapter;
import com.imooc.guessmusic.joke.entity.ImageJokeEntity;
import com.imooc.guessmusic.joke.entity.ListEntity;
import com.imooc.guessmusic.joke.entity.NewListEntity;
import com.imooc.guessmusic.joke.entity.TextJokeEntity;
import com.imooc.guessmusic.joke.main.presenter.JokePresenter;
import com.imooc.guessmusic.joke.main.view.JokeView;
import com.imooc.guessmusic.joke.textjoke.presenter.TextJokePresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewTextJokeFragment extends Fragment implements JokeView, SwipeRefreshLayout.OnRefreshListener {

    private static final String KEY = "ce794dbe4521b1a4f92bc6a549559166";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private SwipeRefreshLayout mSwipeReflashLayout;
    private MyTextAdapter mAdapter;
    private JokePresenter mJokePresenter;
    private List<TextJokeEntity> mData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_text_joke, container, false);
        mData = new ArrayList<>();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.new_recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mSwipeReflashLayout = (SwipeRefreshLayout) view.findViewById(R.id.new_swipe_layout);
        mSwipeReflashLayout.setColorSchemeResources(R.color.colorAccent,
                R.color.colorAccent, R.color.primaryLight, R.color.colorPrimary);
        mSwipeReflashLayout.setOnRefreshListener(this);

        mJokePresenter = new JokePresenter(this);
        mJokePresenter.onCreate();
        mJokePresenter.getRandomTextJoke(KEY, null);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().onBackPressed();
    }

    @Override
    public void onRefresh() {
        mJokePresenter.getRandomTextJoke(KEY, null);
    }

    @Override
    public void onTextSuccess(NewListEntity<TextJokeEntity> mTextJoke) {
        if (!mData.isEmpty()) {
            mData.clear();
        }
        mData.addAll(mTextJoke.getResult());
        if (mAdapter == null) {
            mAdapter = new MyTextAdapter(getContext(), mData);
            mRecyclerView.setAdapter(mAdapter);
        }
        mAdapter.setmData(mData);
    }

    @Override
    public void onImageSuccess(NewListEntity<ImageJokeEntity> mImageJoke) {

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
