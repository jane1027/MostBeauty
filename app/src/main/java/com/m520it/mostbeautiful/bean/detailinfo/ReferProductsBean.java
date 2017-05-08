package com.m520it.mostbeautiful.bean.detailinfo;

import java.util.List;

/**
 * @author SmRo
 * @time 2016/11/12  下午11:00
 * @desc ${TODD}
 */
public  class ReferProductsBean {
    private String name;
    private int price;
    private int mark_user_num;
    private long publish_at;
    private int id;
    private List<String> cover_images;
    private List<String> images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMark_user_num() {
        return mark_user_num;
    }

    public void setMark_user_num(int mark_user_num) {
        this.mark_user_num = mark_user_num;
    }

    public long getPublish_at() {
        return publish_at;
    }

    public void setPublish_at(long publish_at) {
        this.publish_at = publish_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getCover_images() {
        return cover_images;
    }

    public void setCover_images(List<String> cover_images) {
        this.cover_images = cover_images;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}