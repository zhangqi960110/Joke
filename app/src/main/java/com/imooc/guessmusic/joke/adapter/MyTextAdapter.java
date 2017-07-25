package com.imooc.guessmusic.joke.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.imooc.guessmusic.joke.R;
import com.imooc.guessmusic.joke.entity.TextJokeEntity;
import com.imooc.guessmusic.joke.utils.TimeStamp;

import java.util.List;

/**
 * Created by zhangqi on 2017-07-14.
 */
public class MyTextAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<TextJokeEntity> mData;


    public MyTextAdapter(Context mContext, List<TextJokeEntity> data) {
        this.mContext = mContext;
        this.mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewGroup) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_text, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //数据绑定
        if (holder instanceof ItemViewHolder) {
            String updateTime = TimeStamp.MyDate(mData.get(position).getUnixtime());
            ((ItemViewHolder) holder).textJoke.setText(mData.get(position).getContent());
            ((ItemViewHolder) holder).updateTime.setText("更新时间: "+ updateTime);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView textJoke;
        public TextView updateTime;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textJoke = (TextView) itemView.findViewById(R.id.text_joke);
            updateTime = (TextView) itemView.findViewById(R.id.update_time);
        }
    }

    public List<TextJokeEntity> getmData() {
        return mData;
    }

    public void setmData(List<TextJokeEntity> mData) {
        this.mData = mData;
        this.notifyDataSetChanged();
    }

//    public class FooterViewHolder extends RecyclerView.ViewHolder {
//
//        public FooterViewHolder(View itemView) {
//            super(itemView);
//        }
//    }

//    public class ViewHolder extends RecyclerView.ViewHolder{
//
//        public TextView textJoke;
//        public TextView updateTime;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            textJoke = (TextView) itemView.findViewById(R.id.text_joke);
//            updateTime = (TextView) itemView.findViewById(R.id.update_time);
//        }
//    }

}
