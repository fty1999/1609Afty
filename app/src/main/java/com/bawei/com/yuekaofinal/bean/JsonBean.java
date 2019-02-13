package com.bawei.com.yuekaofinal.bean;

import java.util.List;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/1/19 08:51:49
 * @Description:
 */
public class JsonBean {

    @Override
    public String toString() {
        return "JsonBean{" +
                "status=" + status +
                ", info='" + info + '\'' +
                ", data=" + data +
                '}';
    }

    private int status;
    private String info;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        public DataBean(String news_title) {

        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "news_id='" + news_id + '\'' +
                    ", news_title='" + news_title + '\'' +
                    ", news_summary='" + news_summary + '\'' +
                    ", pic_url='" + pic_url + '\'' +
                    '}';
        }

        private String news_id;
        private String news_title;
        private String news_summary;
        private String pic_url;

        public DataBean(String news_title, String pic_url) {
            this.news_title = news_title;
            this.pic_url = pic_url;
        }

        public String getNews_id() {
            return news_id;
        }

        public void setNews_id(String news_id) {
            this.news_id = news_id;
        }

        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public String getNews_summary() {
            return news_summary;
        }

        public void setNews_summary(String news_summary) {
            this.news_summary = news_summary;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }
    }
}
