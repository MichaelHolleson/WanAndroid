package com.michael.wanandroid.core.bean;

public class Tag {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "TagsBean{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
