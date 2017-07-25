package com.imooc.guessmusic.joke.utils;


import java.text.SimpleDateFormat;

/**
 * Created by zhangqi on 2017-07-24.
 */
public class TimeStamp {

    public static String MyDate(int stamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(stamp);
    }
}
