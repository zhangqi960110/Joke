package com.imooc.guessmusic.joke.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.imooc.guessmusic.joke.R;
import com.imooc.guessmusic.joke.entity.ImageJokeEntity;
import com.imooc.guessmusic.joke.utils.TimeStamp;

import java.util.List;

/**
 * Created by zhangqi on 2017-07-22.
 */
public class MyImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<ImageJokeEntity> mData;


    public MyImageAdapter(Context mContext, List<ImageJokeEntity> data) {
        this.mContext = mContext;
        this.mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewGroup) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_image, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //数据绑定
        if (holder instanceof ItemViewHolder) {
            String url = mData.get(position).getUrl().replace("\\","");
            String updateTime = TimeStamp.MyDate(mData.get(position).getUnixtime());
            ((ItemViewHolder) holder).title.setText(mData.get(position).getContent());
            ((ItemViewHolder) holder).image.setImageURI(Uri.parse(url));
            ((ItemViewHolder) holder).time.setText("更新时间: "+ updateTime);
        }
    }

    @Override
    public int getItemCount() {
        if(mData == null){
            return 0;
        }
        return mData.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public SimpleDraweeView image;
        public TextView time;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (SimpleDraweeView) itemView.findViewById(R.id.image);
            time = (TextView) itemView.findViewById(R.id.time);
        }
    }

    public List<ImageJokeEntity> getmData() {
        return mData;
    }

    public void setmData(List<ImageJokeEntity> mData) {
        this.mData = mData;
        this.notifyDataSetChanged();
    }

}
