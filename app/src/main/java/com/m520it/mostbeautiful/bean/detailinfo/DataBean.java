package com.m520it.mostbeautiful.bean.detailinfo;

import java.io.Serializable;
import java.util.List;

/**
 * @author SmRo
 * @time 2016/11/12  下午10:45
 * @desc ${TODD}
 */
public  class DataBean implements Serializable{

    private int unlike_user_num;
    /**
     * follow_num : 97
     * city : 纽约
     * concept : 色和橘色的项链总是让我想起加州的阳光
     * name : Sarah Magid
     * label : Sarah Magid 创始人
     * avatar_url : http://dstatic.zuimeia.com/designer/avatar/2016/11/8/68ae5327-4296-43aa-bb3a-575d67efc03e.jpg
     * is_followed : 0
     * id : 163
     * categories : [{"id":1,"name":"首饰"},{"id":17,"name":"纽约"},{"id":30,"name":"独立设计师"}]
     * description : Sarah Magid 是纽约的戏装珠宝设计师，她从活泼的半珍贵宝石颜色中获得灵感，并且以不同的方式去创造大胆，五彩缤纷的珠宝。她的灵感从明亮的颜色到现代艺术，甚至包括她的犹太祖母穿戴的丝巾，铭牌以及各种她的布鲁克林邻居街道艺术，还有她在阳光加州的童年回忆。她有15年的设计经验，曾经为 Henri Bendel，Coach, J. Crew, Etienne Aigner 等诸多大牌设计。她在 2013 年 创立自己的珠宝系列，因为她想把草稿本上的设想变成现实，而大部分草稿本上的设想和她服务过的大牌都不相合。粗犷的形状，明亮的颜色以及微妙的细节。这么多年在时尚产业闯荡让她结识了许多很好的团队和合作伙伴，让她的梦想能够成为现实。她对设计的爱也延伸到了食物。当她喜欢穿高跟胜过头套时，2009 年 她出版了一本厨艺书叫做：”有机的和雅致的”，用细节描述了受珠宝启发的蛋糕和各种有机处理方式。
     */


    private int id;
    private List<String> cover_images;//轮播图
    private String digest;//轮播图下的描述
    private String name;//商品名称
    private String desc;//商品描述
    private List<String> images;//商品图片
    private List<CommentsBean> comments;//评论
    private DesignerBean designer;
    private int comment_num;
    private int price;
    private int is_marked;
    private int like_type;
    private int like_user_num;
    private int mark_user_num;
    private long publish_at;
    /**
     * name : Sarah Magid | 旋波手镯
     * cover_images : ["http://dstatic.zuimeia.com/common/image/2016/11/8/ba774355-2a61-4576-b223-5107dfc3e8a7_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/8/f44e9443-b44c-406c-ae9c-3e2f19aa06e9_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/8/78c67be5-f6b4-4d11-9672-f967c6ce4bb2_891x891.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/8/dd4dbfae-815d-4fae-a066-a183e181388a_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/8/c62d560c-e911-415d-a360-d8983efcbbab_1000x1000.jpeg"]
     * price : 2000
     * mark_user_num : 10
     * images : ["http://dstatic.zuimeia.com/common/image/2016/11/8/6267743a-cd52-436a-9629-13f073f9fb01_800x800.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/8/887e6937-eef8-44f8-b385-ece7b3b00ba6_1000x1000.jpeg"]
     * publish_at : 1478620800000
     * id : 1489
     */

    private List<ReferProductsBean> refer_products;
    /**
     * content : 且精致
     * created_at : 1478936552000
     * id : 8089
     * author : {"username":"千泠。","avatar_url":"http://q.qlogo.cn/qqapp/1105321739/9973C4311C7E2FD401226EF7CE553BC0/100","id":12931,"sign":"遇见最美的自己"}
     */

    /**
     * shop_url : http://www.sarahmagid.com/collections/earrings/products/fringe-chain-chandelier
     * shop_name : Sarah Magid 官方网站
     */

    private List<ShopUrlsBean> shop_urls;
    private List<?> refer_articles;
    /**
     * desc : 适合风格：建筑感的现代几何风
     * image_url : http://dstatic.zuimeia.com/product/desctype/image/2016/9/28/a8fe369e-5ba3-4c83-a94b-e7dd3cdf51a4.png
     * id : 1
     * name : 关于人
     */

    private List<DescTypesBean> desc_types;

    public int getUnlike_user_num() {
        return unlike_user_num;
    }

    public void setUnlike_user_num(int unlike_user_num) {
        this.unlike_user_num = unlike_user_num;
    }

    public DesignerBean getDesigner() {
        return designer;
    }

    public void setDesigner(DesignerBean designer) {
        this.designer = designer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIs_marked() {
        return is_marked;
    }

    public void setIs_marked(int is_marked) {
        this.is_marked = is_marked;
    }

    public int getLike_type() {
        return like_type;
    }

    public void setLike_type(int like_type) {
        this.like_type = like_type;
    }

    public int getLike_user_num() {
        return like_user_num;
    }

    public void setLike_user_num(int like_user_num) {
        this.like_user_num = like_user_num;
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

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getCover_images() {
        return cover_images;
    }

    public void setCover_images(List<String> cover_images) {
        this.cover_images = cover_images;
    }

    public List<ReferProductsBean> getRefer_products() {
        return refer_products;
    }

    public void setRefer_products(List<ReferProductsBean> refer_products) {
        this.refer_products = refer_products;
    }

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public List<ShopUrlsBean> getShop_urls() {
        return shop_urls;
    }

    public void setShop_urls(List<ShopUrlsBean> shop_urls) {
        this.shop_urls = shop_urls;
    }

    public List<?> getRefer_articles() {
        return refer_articles;
    }

    public void setRefer_articles(List<?> refer_articles) {
        this.refer_articles = refer_articles;
    }

    public List<DescTypesBean> getDesc_types() {
        return desc_types;
    }

    public void setDesc_types(List<DescTypesBean> desc_types) {
        this.desc_types = desc_types;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
