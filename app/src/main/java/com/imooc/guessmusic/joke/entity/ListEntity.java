package com.imooc.guessmusic.joke.entity;


import com.google.gson.annotations.SerializedName;

/**
 * Created by zhangqi on 2017-07-18.
 */
public class ListEntity<T> extends BaseEntity {

    @SerializedName("error_code")
    private int error_code;
    @SerializedName("reason")
    private String reason;
    @SerializedName("result")
    private DataEntity<T> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public DataEntity<T> getResult() {
        return result;
    }

    public void setResult(DataEntity<T> result) {
        this.result = result;
    }

}
