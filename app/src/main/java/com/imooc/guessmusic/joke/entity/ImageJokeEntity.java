package com.imooc.guessmusic.joke.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhangqi on 2017-07-22.
 */
public class ImageJokeEntity {

    @SerializedName("content")
    private String content;
    @SerializedName("hashId")
    private String hashId;
    @SerializedName("unixtime")
    private int unixtime;
    @SerializedName("updatetime")
    private String updatetime;
    @SerializedName("url")
    private String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public int getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(int unixtime) {
        this.unixtime = unixtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
