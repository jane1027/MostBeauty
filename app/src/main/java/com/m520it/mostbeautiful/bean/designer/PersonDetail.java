package com.m520it.mostbeautiful.bean.designer;

import java.util.List;

/**
 * @author jane
 * @time 2016/11/13  14:47
 * @desc ${TODD}
 */
public class PersonDetail {
    private   String avatar_url;//头像
    private   String categories;//标签
    private   String city;//城市
    private   String concept;//描述
    private   String description;//描述
    private   int follow_num;//关注着
    private   long id;//id
    private   String label;//便签(名字下面的)
    private   String name;//名字
    private List<String> recommend_images;//大图片地址
    private List<String> introduce_images;//大图片地址

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFollow_num() {
        return follow_num;
    }

    public void setFollow_num(int follow_num) {
        this.follow_num = follow_num;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRecommend_images() {
        return recommend_images;
    }

    public void setRecommend_images(List<String> recommend_images) {
        this.recommend_images = recommend_images;
    }

    public List<String> getIntroduce_images() {
        return introduce_images;
    }

    public void setIntroduce_images(List<String> introduce_images) {
        this.introduce_images = introduce_images;
    }
}
