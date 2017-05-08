package com.m520it.mostbeautiful.bean.detailinfo;

/**
 * @author SmRo
 * @time 2016/11/12  下午10:48
 * @desc ${TODD}
 */
public  class CommentsBean {
    private String content;
    private long created_at;
    private int id;
    /**
     * username : 千泠。
     * avatar_url : http://q.qlogo.cn/qqapp/1105321739/9973C4311C7E2FD401226EF7CE553BC0/100
     * id : 12931
     * sign : 遇见最美的自己
     */

    private AuthorBean author;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }
}