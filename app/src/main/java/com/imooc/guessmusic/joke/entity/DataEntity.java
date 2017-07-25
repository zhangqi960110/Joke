package com.imooc.guessmusic.joke.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zhangqi on 2017-07-18.
 */
public class DataEntity<T> extends BaseEntity{

    @SerializedName("data")
    private List<T> data ;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                "data=" + data +
                '}';
    }
}
