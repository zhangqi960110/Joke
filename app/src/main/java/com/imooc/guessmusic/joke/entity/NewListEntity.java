package com.imooc.guessmusic.joke.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zhangqi on 2017-07-24.
 */
public class NewListEntity<T> {

    @SerializedName("reason")
    private String reason;
    @SerializedName("error_code")
    private int error_code;
    @SerializedName("result")
    private List<T> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
