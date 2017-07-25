package com.imooc.guessmusic.joke.textjoke.widget;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.imooc.guessmusic.joke.R;
import com.imooc.guessmusic.joke.adapter.MyTextAdapter;
import com.imooc.guessmusic.joke.entity.TextJokeEntity;
import com.imooc.guessmusic.joke.entity.ListEntity;
import com.imooc.guessmusic.joke.textjoke.presenter.TextJokePresenter;
import com.imooc.guessmusic.joke.textjoke.view.TextJokeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextJokeFragment extends Fragment implements TextJokeView, SwipeRefreshLayout.OnRefreshListener {

    private static final String KEY = "ce794dbe4521b1a4f92bc6a549559166";
    private static final int MAX = 20000;
    private Random random = new Random();
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private SwipeRefreshLayout mSwipeReflashLayout;
    private MyTextAdapter mAdapter;
    private TextJokePresenter mTextJokePresenter;
    private List<TextJokeEntity> mData;
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_joke, container, false);

        mTextView = (TextView) view.findViewById(R.id.toolbar_title);
        mTextView.setText("段子大全");

        mData = new ArrayList<>();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mSwipeReflashLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_layout);
        mSwipeReflashLayout.setColorSchemeResources(R.color.colorAccent,
                R.color.colorAccent, R.color.primaryLight,
                R.color.colorPrimary);
        mSwipeReflashLayout.setOnRefreshListener(this);

        mTextJokePresenter = new TextJokePresenter(this);
        mTextJokePresenter.onCreate();
        mTextJokePresenter.getTextJoke(KEY, 1, 20);

        return view;
    }


    @Override
    public void onRefresh() {
        int page = random.nextInt(MAX) + 1;
        mTextJokePresenter.getTextJoke(KEY, page, 20);
    }

    @Override
    public void onSuccess(ListEntity<TextJokeEntity> mTextJoke) {
        if(!mData.isEmpty()){
            mData.clear();
        }
        mData.addAll(mTextJoke.getResult().getData());
        if(mAdapter == null){
            mAdapter = new MyTextAdapter(getContext(), mData);
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
