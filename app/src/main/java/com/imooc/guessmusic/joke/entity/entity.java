package com.imooc.guessmusic.joke.entity;

import java.util.List;

/**
 * Created by zhangqi on 2017-07-24.
 */
public class entity {

    /**
     * reason : success
     * result : [{"content":"妹子睡的好好看呢","hashId":"EBCD4757ACF59C2E697DD64EC719941D","unixtime":"1437469477","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201507/21/EBCD4757ACF59C2E697DD64EC719941D.jpg"},{"content":"这样太舒服了","hashId":"EC0A36E1CE6931F9984E9C6C02B20F96","unixtime":"1437470003","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201507/21/EC0A36E1CE6931F9984E9C6C02B20F96.jpg"},{"content":"好尴尬的相遇啊","hashId":"9C4AB015AA65F7AF2A5E53AFD23FCC5E","unixtime":"1437470609","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201507/21/9C4AB015AA65F7AF2A5E53AFD23FCC5E.jpg"},{"content":"这到底发生了什么","hashId":"515F86DE9D937CCD30F56759F6CC7F7E","unixtime":"1437471214","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201507/21/515F86DE9D937CCD30F56759F6CC7F7E.jpg"},{"content":"多大仇啊","hashId":"D5427A04CB48E492F2742F2706229BBA","unixtime":"1437471214","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201507/21/D5427A04CB48E492F2742F2706229BBA.jpg"},{"content":"爆菊，那只是时间问题","hashId":"2225829C81DE797DC4A458BF76E476AF","unixtime":"1437472010","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201507/21/2225829C81DE797DC4A458BF76E476AF.jpg"},{"content":"这样的饭也是碉堡了","hashId":"40001DB6B4D8391ACF412D318FD678D8","unixtime":"1437472010","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201507/21/40001DB6B4D8391ACF412D318FD678D8.jpg"},{"content":"简直一模一样呢","hashId":"70DD35AB4C49EBF74A5B5E2C5E878ADD","unixtime":"1437472412","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201507/21/70DD35AB4C49EBF74A5B5E2C5E878ADD.jpg"},{"content":"车美人更美","hashId":"FA68A7C44FDFB3933EFCA70E36756BA4","unixtime":"1437472412","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201507/21/FA68A7C44FDFB3933EFCA70E36756BA4.jpg"},{"content":"这也算是去了趟仙境","hashId":"A2A9E4CA61EC18DB1EC0E4DD098068E9","unixtime":"1437473049","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201507/21/A2A9E4CA61EC18DB1EC0E4DD098068E9.jpg"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 妹子睡的好好看呢
         * hashId : EBCD4757ACF59C2E697DD64EC719941D
         * unixtime : 1437469477
         * url : http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201507/21/EBCD4757ACF59C2E697DD64EC719941D.jpg
         */

        private String content;
        private String hashId;
        private String unixtime;
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

        public String getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(String unixtime) {
            this.unixtime = unixtime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
