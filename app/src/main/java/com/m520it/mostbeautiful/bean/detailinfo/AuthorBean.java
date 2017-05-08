package com.m520it.mostbeautiful.bean.detailinfo;

/**
 * @author SmRo
 * @time 2016/11/12  下午11:01
 * @desc ${TODD}
 */
public  class AuthorBean {
    private String username;
    private String avatar_url;
    private int id;
    private String sign;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}