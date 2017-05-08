package com.m520it.mostbeautiful.bean.paintpage;

import java.io.Serializable;
import java.util.List;

/**
 * @author ben
 * @time 2016/11/10  10:55
 * @desc ${TODD}
 */
public class PrintData implements Serializable{

    @Override
    public String toString() {
        return "PrintData{" +
                "data=" + data.toString() +
                ", result=" + result +
                '}';
    }

    /**
     * articles : [{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/9/24/ac99fa28-3e08-4067-b618-b9d63c0df7a6.jpg","id":16653,"sign":"一颗从金融学土壤中萌发的时尚之豆","username":"Mana Bean"},"favor_user_num":0,"id":106,"image_url":"http://dstatic.zuimeia.com/common/image/2016/11/9/4f4f36d9-30b0-45cc-8f25-6045ac2de8bb_675x675.jpeg","publish_at":1478707200000,"sub_title":"从模仿他人到取悦自我的心灵之旅","title":"从女孩到女人：美好的高跟鞋，伴你一同成长","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/11/07/7e8ae58a7b893867d1f6f10b4c509e61_200x200.jpg","id":70834,"sign":"听说是时尚界里最不时尚的土酷女孩","username":"独角兽"},"favor_user_num":5,"id":105,"image_url":"http://dstatic.zuimeia.com/common/image/2016/11/7/ef9249dd-6c74-4ce1-be20-8727565c8b29_640x640.jpeg","publish_at":1478620800000,"sub_title":"邪恶的性感，往往是一种致命的诱惑","title":"Amanda Thomas：一半是女人，一半是坏蛋","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/068b70d77304e910f9bbfcc732e2d774_463x450.jpg","id":46473,"sign":"贪恋一抹胭脂香气的败家子","username":"黎曦"},"favor_user_num":12,"id":103,"image_url":"http://dstatic.zuimeia.com/common/image/2016/11/7/0150113a-49bb-444b-bd6c-aea5b68291ab_960x1200.jpeg","publish_at":1478534400000,"sub_title":"世界上最性感的设计师的一天是怎么度过的","title":"Tom Ford：我的 24 小时","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/e49c5fa883f8475d55523b73e141a4e8_300x300.jpg","id":41383,"sign":"梦游也在和设计师唠嗑的拜访者 Z","username":"川枝"},"favor_user_num":10,"id":100,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/31/72278f4c-630f-4db0-b8c1-829a6a4df693_480x480.jpeg","publish_at":1478361600000,"sub_title":"如果不够有趣，那么还是不要做了","title":"如何在小物件上，架构自己的生活美学","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/5a069cd6278626c9a638bf46a8010837_450x450.jpg","id":41625,"sign":"迷失风向却沉浸在时尚海洋里的游鱼","username":"夏漱香菜"},"favor_user_num":13,"id":98,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/31/c87d16d0-3063-4946-9b6f-e02783e506bc_800x800.jpeg","publish_at":1478275200000,"sub_title":"向鲜艳的岁月和敢于恶搞的年龄致敬","title":"年轻人的特权：鲜活的人生不该被黑白灰所禁锢","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/24/cb72799c716b347da480261217298b56_224x224.jpg","id":44168,"sign":"能在烤鱼身上研究烟熏妆的时尚骨头","username":"鱼烬"},"favor_user_num":16,"id":99,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/31/8dce510a-882c-455a-b575-678f1f85341a_800x800.jpeg","publish_at":1478102400000,"sub_title":"Michal Golan：描绘一个七彩斑斓的童话世界","title":"把秘密花园涂在现实中，是不是就能开出七色花","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/29/0ce86625189bc5c071bdd4fc8ccabae9_170x170.jpg","id":29,"sign":"最美有物 创始人","username":"RainbowMe"},"favor_user_num":17,"id":101,"image_url":"http://dstatic.zuimeia.com/common/image/2016/11/2/308bfab3-da72-4282-a9cd-64d6c3045989_750x750.jpeg","publish_at":1478016000000,"sub_title":"毕竟女王更懂得如何用设计宠爱自己","title":"放弃粉色的公主梦之后，你才有机会活成一个金色的女王","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/d17e6a982c677b1e4b35726af80d6a50_254x255.jpg","id":30,"sign":"在光怪陆离的世界里记录时尚的梦旅人","username":"狐萝卜"},"favor_user_num":6,"id":97,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/31/192d53bc-69f2-4211-8fdc-c700d5d2ab99_800x800.jpeg","publish_at":1477929600000,"sub_title":"他和 McQueen 分别改变了珠宝界和时尚界","title":"和 Alexander McQueen 肩并肩战斗的男人","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/e49c5fa883f8475d55523b73e141a4e8_300x300.jpg","id":41383,"sign":"梦游也在和设计师唠嗑的拜访者 Z","username":"川枝"},"favor_user_num":12,"id":96,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/29/12644649-23ba-4c03-9473-8ab847c2a665_750x750.jpeg","publish_at":1477738020000,"sub_title":"皮具的良质，在于设计者自身的自在和诚实","title":"禅与皮具制造的艺术","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/a6743869c424b81b9a7faf5c283203db_225x226.jpg","id":44171,"sign":"设计故纸堆里的考古学徒","username":"苏潜"},"favor_user_num":18,"id":95,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/28/a0fc0c93-0c25-42b3-83d3-ca361fd8dcb3_750x750.jpeg","publish_at":1477622340000,"sub_title":"把喜欢的事做成了工作，谁说一定不会快乐？","title":"小岛上的金匠姑娘，找到了自己梦中的青鸟","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/5a069cd6278626c9a638bf46a8010837_450x450.jpg","id":41625,"sign":"迷失风向却沉浸在时尚海洋里的游鱼","username":"夏漱香菜"},"favor_user_num":23,"id":94,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/26/a9bc7ea9-2887-485b-b654-9b17e973e124_548x548.jpeg","publish_at":1477497600000,"sub_title":"献给我所深爱的大自然和你","title":"Todd Pownell：以山川之名，写一首情诗","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/e49c5fa883f8475d55523b73e141a4e8_300x300.jpg","id":41383,"sign":"梦游也在和设计师唠嗑的拜访者 Z","username":"川枝"},"favor_user_num":14,"id":93,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/26/f9ab4ecb-cf61-4e3a-9294-afff7c4d5120_944x944.jpeg","publish_at":1477453920000,"sub_title":"接近一无所有的透明里，才能看到云朵的倒影","title":"空到近于无，于是你看到了生活本来的样子","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/a6743869c424b81b9a7faf5c283203db_225x226.jpg","id":44171,"sign":"设计故纸堆里的考古学徒","username":"苏潜"},"favor_user_num":42,"id":91,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/17/462f6a13-b875-4958-9602-d0dcf1832b90_800x800.jpeg","publish_at":1477065600000,"sub_title":"长不大的设计师，做出了俏皮的童话首饰","title":"我想，我是忘记了长大","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/068b70d77304e910f9bbfcc732e2d774_463x450.jpg","id":46473,"sign":"贪恋一抹胭脂香气的败家子","username":"黎曦"},"favor_user_num":18,"id":90,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/17/2f720e4b-98bf-4222-a069-66fad8007d99_809x809.jpeg","publish_at":1476979200000,"sub_title":"素食主义者的设计之路","title":"为动物的自由而战","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/24/cb72799c716b347da480261217298b56_224x224.jpg","id":44168,"sign":"能在烤鱼身上研究烟熏妆的时尚骨头","username":"鱼烬"},"favor_user_num":19,"id":89,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/17/7ac855a9-5680-4368-8ded-68cccf1bd2e3_800x800.jpeg","publish_at":1476892800000,"sub_title":"KikaNY：还原一个包最应该有的简单状态","title":"当你不再试图从一个包中确定自己","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/09/19/bda1c2ac9234397c10982618f55562fe_199x200.jpg","id":36075,"sign":"在设计的世界撒欢儿的野马","username":"Phoebe"},"favor_user_num":11,"id":88,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/17/30f07a18-c4d3-434f-9d90-8833f7f86f94_505x505.jpeg","publish_at":1476720000000,"sub_title":"时尚是每个女人的事， 即使你选择同你的事业结婚","title":"为阿尔法女度身定制的时尚","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/d17e6a982c677b1e4b35726af80d6a50_254x255.jpg","id":30,"sign":"在光怪陆离的世界里记录时尚的梦旅人","username":"狐萝卜"},"favor_user_num":32,"id":86,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/13/74bea20e-c2f8-4031-9fcf-6eb7d304eef5_800x800.jpeg","publish_at":1476460800000,"sub_title":"在别人正襟危坐时，我偏要玩世不恭","title":"领带的文艺时代","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/24/cb72799c716b347da480261217298b56_224x224.jpg","id":44168,"sign":"能在烤鱼身上研究烟熏妆的时尚骨头","username":"鱼烬"},"favor_user_num":23,"id":87,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/12/ecae22a0-cf65-4843-b6a5-1ff50049294a_750x750.jpeg","publish_at":1476288000000,"sub_title":"她把爬过的山，都做成了戒指","title":"从小在祖父的地毯上捡黄金的女孩，用金子去描绘山峦温柔的曲线","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/09/19/bda1c2ac9234397c10982618f55562fe_199x200.jpg","id":36075,"sign":"在设计的世界撒欢儿的野马","username":"Phoebe"},"favor_user_num":13,"id":85,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/10/99162390-bb9a-41b9-86b5-9d13c5cff320_800x602.jpeg","publish_at":1476115200000,"sub_title":"她披上了时尚的铠甲，并让全世界都记住了她","title":"Donatella Versace：她为大牌续写着神话","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/5a069cd6278626c9a638bf46a8010837_450x450.jpg","id":41625,"sign":"迷失风向却沉浸在时尚海洋里的游鱼","username":"夏漱香菜"},"favor_user_num":51,"id":84,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/3/babb2f3b-d5f1-491b-9019-a7da864cd788_800x800.jpeg","publish_at":1475856000000,"sub_title":"把朴素的生活过成一幅画","title":"不愿涂脂抹粉，只愿扎根泥土","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/e49c5fa883f8475d55523b73e141a4e8_300x300.jpg","id":41383,"sign":"梦游也在和设计师唠嗑的拜访者 Z","username":"川枝"},"favor_user_num":87,"id":83,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/3/fc60867b-ac3e-4928-a7a1-640c290cf091_570x380.jpeg","publish_at":1475683200000,"sub_title":"把这个夏天的潮热和焦灼，风干在玻璃球里","title":"送给你，这一季的忧郁和花香","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/24/cb72799c716b347da480261217298b56_224x224.jpg","id":44168,"sign":"能在烤鱼身上研究烟熏妆的时尚骨头","username":"鱼烬"},"favor_user_num":45,"id":82,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/3/bb4a7e22-8a29-4943-a3de-504a1e55b660_800x800.jpeg","publish_at":1475510400000,"sub_title":"在这个女性化的年代，找寻男子汉失去的荣光","title":"一个男孩要走多少路，才能称得上是一个男人","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/a6743869c424b81b9a7faf5c283203db_225x226.jpg","id":44171,"sign":"设计故纸堆里的考古学徒","username":"苏潜"},"favor_user_num":84,"id":81,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/29/d0e52773-ad0e-40a6-a6bc-4f61cca9514b_800x800.jpeg","publish_at":1475251200000,"sub_title":"她把「冰与火」和「五十度灰」，都做成了首饰","title":"文学少女、珠宝设计和女巫的魔法首饰","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/9/24/ac99fa28-3e08-4067-b618-b9d63c0df7a6.jpg","id":16653,"sign":"一颗从金融学土壤中萌发的时尚之豆","username":"Mana Bean"},"favor_user_num":60,"id":80,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/28/8dfdc050-e5e4-44ac-a287-b47eefa6ea6b_667x667.jpeg","publish_at":1475078400000,"sub_title":"建筑师的跨界设计之旅","title":"让光影自由起舞","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/d17e6a982c677b1e4b35726af80d6a50_254x255.jpg","id":30,"sign":"在光怪陆离的世界里记录时尚的梦旅人","username":"狐萝卜"},"favor_user_num":28,"id":77,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/21/2658da4c-67a7-48c8-8c20-3da602b90bd7_800x800.jpeg","publish_at":1474905600000,"sub_title":"你愿意和这样的男人去探险吗","title":"新时代的左轮手枪，用细腻柔情直击你的心脏","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/e49c5fa883f8475d55523b73e141a4e8_300x300.jpg","id":41383,"sign":"梦游也在和设计师唠嗑的拜访者 Z","username":"川枝"},"favor_user_num":67,"id":79,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/21/8c185195-3317-4ee0-97f6-18d3e1df22dc_800x800.jpeg","publish_at":1474646400000,"sub_title":"设计的终极关怀是让所有人都更有尊严地生活","title":"让黑暗世界的人们，触摸到时间的流逝","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/09/19/bda1c2ac9234397c10982618f55562fe_199x200.jpg","id":36075,"sign":"在设计的世界撒欢儿的野马","username":"Phoebe"},"favor_user_num":17,"id":78,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/21/15a6b49f-e17d-4ab4-a387-e45e4af3977d_548x548.jpeg","publish_at":1474387200000,"sub_title":"挑战无限，乐趣无穷","title":"Jonathan Anderson：这个小哥有着开了挂的人生","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/09/19/bda1c2ac9234397c10982618f55562fe_199x200.jpg","id":36075,"sign":"在设计的世界撒欢儿的野马","username":"Phoebe"},"favor_user_num":15,"id":76,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/19/ae5960b2-7faa-4fa2-9c84-ac789d8d75f9_660x440.jpeg","publish_at":1474300800000,"sub_title":"看 Olsen 双生姐妹花玩转角色转换","title":"不想做设计师的演员不是好双生","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/a6743869c424b81b9a7faf5c283203db_225x226.jpg","id":44171,"sign":"设计故纸堆里的考古学徒","username":"苏潜"},"favor_user_num":42,"id":75,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/14/a34b59fb-a17e-488c-b04f-c27321ca8028_684x684.jpeg","publish_at":1474041600000,"sub_title":"旅途里都是对远方的祷告","title":"戴着你的许愿骨去流浪，流浪远方","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/068b70d77304e910f9bbfcc732e2d774_463x450.jpg","id":46473,"sign":"贪恋一抹胭脂香气的败家子","username":"黎曦"},"favor_user_num":23,"id":74,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/14/a7f046c8-6f01-4d77-b8ca-28ed8d4e3b4c_800x800.jpeg","publish_at":1473868800000,"sub_title":"我们爱着的，就是那个性感而优雅的世界","title":"月华如水，锆石和身体共婵娟的 N 种可能","web_url":""}]
     * has_next : 1
     */

    private DataBean data;
    /**
     * data : {"articles":[{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/9/24/ac99fa28-3e08-4067-b618-b9d63c0df7a6.jpg","id":16653,"sign":"一颗从金融学土壤中萌发的时尚之豆","username":"Mana Bean"},"favor_user_num":0,"id":106,"image_url":"http://dstatic.zuimeia.com/common/image/2016/11/9/4f4f36d9-30b0-45cc-8f25-6045ac2de8bb_675x675.jpeg","publish_at":1478707200000,"sub_title":"从模仿他人到取悦自我的心灵之旅","title":"从女孩到女人：美好的高跟鞋，伴你一同成长","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/11/07/7e8ae58a7b893867d1f6f10b4c509e61_200x200.jpg","id":70834,"sign":"听说是时尚界里最不时尚的土酷女孩","username":"独角兽"},"favor_user_num":5,"id":105,"image_url":"http://dstatic.zuimeia.com/common/image/2016/11/7/ef9249dd-6c74-4ce1-be20-8727565c8b29_640x640.jpeg","publish_at":1478620800000,"sub_title":"邪恶的性感，往往是一种致命的诱惑","title":"Amanda Thomas：一半是女人，一半是坏蛋","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/068b70d77304e910f9bbfcc732e2d774_463x450.jpg","id":46473,"sign":"贪恋一抹胭脂香气的败家子","username":"黎曦"},"favor_user_num":12,"id":103,"image_url":"http://dstatic.zuimeia.com/common/image/2016/11/7/0150113a-49bb-444b-bd6c-aea5b68291ab_960x1200.jpeg","publish_at":1478534400000,"sub_title":"世界上最性感的设计师的一天是怎么度过的","title":"Tom Ford：我的 24 小时","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/e49c5fa883f8475d55523b73e141a4e8_300x300.jpg","id":41383,"sign":"梦游也在和设计师唠嗑的拜访者 Z","username":"川枝"},"favor_user_num":10,"id":100,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/31/72278f4c-630f-4db0-b8c1-829a6a4df693_480x480.jpeg","publish_at":1478361600000,"sub_title":"如果不够有趣，那么还是不要做了","title":"如何在小物件上，架构自己的生活美学","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/5a069cd6278626c9a638bf46a8010837_450x450.jpg","id":41625,"sign":"迷失风向却沉浸在时尚海洋里的游鱼","username":"夏漱香菜"},"favor_user_num":13,"id":98,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/31/c87d16d0-3063-4946-9b6f-e02783e506bc_800x800.jpeg","publish_at":1478275200000,"sub_title":"向鲜艳的岁月和敢于恶搞的年龄致敬","title":"年轻人的特权：鲜活的人生不该被黑白灰所禁锢","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/24/cb72799c716b347da480261217298b56_224x224.jpg","id":44168,"sign":"能在烤鱼身上研究烟熏妆的时尚骨头","username":"鱼烬"},"favor_user_num":16,"id":99,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/31/8dce510a-882c-455a-b575-678f1f85341a_800x800.jpeg","publish_at":1478102400000,"sub_title":"Michal Golan：描绘一个七彩斑斓的童话世界","title":"把秘密花园涂在现实中，是不是就能开出七色花","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/29/0ce86625189bc5c071bdd4fc8ccabae9_170x170.jpg","id":29,"sign":"最美有物 创始人","username":"RainbowMe"},"favor_user_num":17,"id":101,"image_url":"http://dstatic.zuimeia.com/common/image/2016/11/2/308bfab3-da72-4282-a9cd-64d6c3045989_750x750.jpeg","publish_at":1478016000000,"sub_title":"毕竟女王更懂得如何用设计宠爱自己","title":"放弃粉色的公主梦之后，你才有机会活成一个金色的女王","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/d17e6a982c677b1e4b35726af80d6a50_254x255.jpg","id":30,"sign":"在光怪陆离的世界里记录时尚的梦旅人","username":"狐萝卜"},"favor_user_num":6,"id":97,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/31/192d53bc-69f2-4211-8fdc-c700d5d2ab99_800x800.jpeg","publish_at":1477929600000,"sub_title":"他和 McQueen 分别改变了珠宝界和时尚界","title":"和 Alexander McQueen 肩并肩战斗的男人","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/e49c5fa883f8475d55523b73e141a4e8_300x300.jpg","id":41383,"sign":"梦游也在和设计师唠嗑的拜访者 Z","username":"川枝"},"favor_user_num":12,"id":96,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/29/12644649-23ba-4c03-9473-8ab847c2a665_750x750.jpeg","publish_at":1477738020000,"sub_title":"皮具的良质，在于设计者自身的自在和诚实","title":"禅与皮具制造的艺术","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/a6743869c424b81b9a7faf5c283203db_225x226.jpg","id":44171,"sign":"设计故纸堆里的考古学徒","username":"苏潜"},"favor_user_num":18,"id":95,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/28/a0fc0c93-0c25-42b3-83d3-ca361fd8dcb3_750x750.jpeg","publish_at":1477622340000,"sub_title":"把喜欢的事做成了工作，谁说一定不会快乐？","title":"小岛上的金匠姑娘，找到了自己梦中的青鸟","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/5a069cd6278626c9a638bf46a8010837_450x450.jpg","id":41625,"sign":"迷失风向却沉浸在时尚海洋里的游鱼","username":"夏漱香菜"},"favor_user_num":23,"id":94,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/26/a9bc7ea9-2887-485b-b654-9b17e973e124_548x548.jpeg","publish_at":1477497600000,"sub_title":"献给我所深爱的大自然和你","title":"Todd Pownell：以山川之名，写一首情诗","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/e49c5fa883f8475d55523b73e141a4e8_300x300.jpg","id":41383,"sign":"梦游也在和设计师唠嗑的拜访者 Z","username":"川枝"},"favor_user_num":14,"id":93,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/26/f9ab4ecb-cf61-4e3a-9294-afff7c4d5120_944x944.jpeg","publish_at":1477453920000,"sub_title":"接近一无所有的透明里，才能看到云朵的倒影","title":"空到近于无，于是你看到了生活本来的样子","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/a6743869c424b81b9a7faf5c283203db_225x226.jpg","id":44171,"sign":"设计故纸堆里的考古学徒","username":"苏潜"},"favor_user_num":42,"id":91,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/17/462f6a13-b875-4958-9602-d0dcf1832b90_800x800.jpeg","publish_at":1477065600000,"sub_title":"长不大的设计师，做出了俏皮的童话首饰","title":"我想，我是忘记了长大","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/068b70d77304e910f9bbfcc732e2d774_463x450.jpg","id":46473,"sign":"贪恋一抹胭脂香气的败家子","username":"黎曦"},"favor_user_num":18,"id":90,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/17/2f720e4b-98bf-4222-a069-66fad8007d99_809x809.jpeg","publish_at":1476979200000,"sub_title":"素食主义者的设计之路","title":"为动物的自由而战","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/24/cb72799c716b347da480261217298b56_224x224.jpg","id":44168,"sign":"能在烤鱼身上研究烟熏妆的时尚骨头","username":"鱼烬"},"favor_user_num":19,"id":89,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/17/7ac855a9-5680-4368-8ded-68cccf1bd2e3_800x800.jpeg","publish_at":1476892800000,"sub_title":"KikaNY：还原一个包最应该有的简单状态","title":"当你不再试图从一个包中确定自己","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/09/19/bda1c2ac9234397c10982618f55562fe_199x200.jpg","id":36075,"sign":"在设计的世界撒欢儿的野马","username":"Phoebe"},"favor_user_num":11,"id":88,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/17/30f07a18-c4d3-434f-9d90-8833f7f86f94_505x505.jpeg","publish_at":1476720000000,"sub_title":"时尚是每个女人的事， 即使你选择同你的事业结婚","title":"为阿尔法女度身定制的时尚","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/d17e6a982c677b1e4b35726af80d6a50_254x255.jpg","id":30,"sign":"在光怪陆离的世界里记录时尚的梦旅人","username":"狐萝卜"},"favor_user_num":32,"id":86,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/13/74bea20e-c2f8-4031-9fcf-6eb7d304eef5_800x800.jpeg","publish_at":1476460800000,"sub_title":"在别人正襟危坐时，我偏要玩世不恭","title":"领带的文艺时代","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/24/cb72799c716b347da480261217298b56_224x224.jpg","id":44168,"sign":"能在烤鱼身上研究烟熏妆的时尚骨头","username":"鱼烬"},"favor_user_num":23,"id":87,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/12/ecae22a0-cf65-4843-b6a5-1ff50049294a_750x750.jpeg","publish_at":1476288000000,"sub_title":"她把爬过的山，都做成了戒指","title":"从小在祖父的地毯上捡黄金的女孩，用金子去描绘山峦温柔的曲线","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/09/19/bda1c2ac9234397c10982618f55562fe_199x200.jpg","id":36075,"sign":"在设计的世界撒欢儿的野马","username":"Phoebe"},"favor_user_num":13,"id":85,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/10/99162390-bb9a-41b9-86b5-9d13c5cff320_800x602.jpeg","publish_at":1476115200000,"sub_title":"她披上了时尚的铠甲，并让全世界都记住了她","title":"Donatella Versace：她为大牌续写着神话","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/5a069cd6278626c9a638bf46a8010837_450x450.jpg","id":41625,"sign":"迷失风向却沉浸在时尚海洋里的游鱼","username":"夏漱香菜"},"favor_user_num":51,"id":84,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/3/babb2f3b-d5f1-491b-9019-a7da864cd788_800x800.jpeg","publish_at":1475856000000,"sub_title":"把朴素的生活过成一幅画","title":"不愿涂脂抹粉，只愿扎根泥土","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/e49c5fa883f8475d55523b73e141a4e8_300x300.jpg","id":41383,"sign":"梦游也在和设计师唠嗑的拜访者 Z","username":"川枝"},"favor_user_num":87,"id":83,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/3/fc60867b-ac3e-4928-a7a1-640c290cf091_570x380.jpeg","publish_at":1475683200000,"sub_title":"把这个夏天的潮热和焦灼，风干在玻璃球里","title":"送给你，这一季的忧郁和花香","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/24/cb72799c716b347da480261217298b56_224x224.jpg","id":44168,"sign":"能在烤鱼身上研究烟熏妆的时尚骨头","username":"鱼烬"},"favor_user_num":45,"id":82,"image_url":"http://dstatic.zuimeia.com/common/image/2016/10/3/bb4a7e22-8a29-4943-a3de-504a1e55b660_800x800.jpeg","publish_at":1475510400000,"sub_title":"在这个女性化的年代，找寻男子汉失去的荣光","title":"一个男孩要走多少路，才能称得上是一个男人","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/a6743869c424b81b9a7faf5c283203db_225x226.jpg","id":44171,"sign":"设计故纸堆里的考古学徒","username":"苏潜"},"favor_user_num":84,"id":81,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/29/d0e52773-ad0e-40a6-a6bc-4f61cca9514b_800x800.jpeg","publish_at":1475251200000,"sub_title":"她把「冰与火」和「五十度灰」，都做成了首饰","title":"文学少女、珠宝设计和女巫的魔法首饰","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/9/24/ac99fa28-3e08-4067-b618-b9d63c0df7a6.jpg","id":16653,"sign":"一颗从金融学土壤中萌发的时尚之豆","username":"Mana Bean"},"favor_user_num":60,"id":80,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/28/8dfdc050-e5e4-44ac-a287-b47eefa6ea6b_667x667.jpeg","publish_at":1475078400000,"sub_title":"建筑师的跨界设计之旅","title":"让光影自由起舞","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/d17e6a982c677b1e4b35726af80d6a50_254x255.jpg","id":30,"sign":"在光怪陆离的世界里记录时尚的梦旅人","username":"狐萝卜"},"favor_user_num":28,"id":77,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/21/2658da4c-67a7-48c8-8c20-3da602b90bd7_800x800.jpeg","publish_at":1474905600000,"sub_title":"你愿意和这样的男人去探险吗","title":"新时代的左轮手枪，用细腻柔情直击你的心脏","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/e49c5fa883f8475d55523b73e141a4e8_300x300.jpg","id":41383,"sign":"梦游也在和设计师唠嗑的拜访者 Z","username":"川枝"},"favor_user_num":67,"id":79,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/21/8c185195-3317-4ee0-97f6-18d3e1df22dc_800x800.jpeg","publish_at":1474646400000,"sub_title":"设计的终极关怀是让所有人都更有尊严地生活","title":"让黑暗世界的人们，触摸到时间的流逝","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/09/19/bda1c2ac9234397c10982618f55562fe_199x200.jpg","id":36075,"sign":"在设计的世界撒欢儿的野马","username":"Phoebe"},"favor_user_num":17,"id":78,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/21/15a6b49f-e17d-4ab4-a387-e45e4af3977d_548x548.jpeg","publish_at":1474387200000,"sub_title":"挑战无限，乐趣无穷","title":"Jonathan Anderson：这个小哥有着开了挂的人生","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/09/19/bda1c2ac9234397c10982618f55562fe_199x200.jpg","id":36075,"sign":"在设计的世界撒欢儿的野马","username":"Phoebe"},"favor_user_num":15,"id":76,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/19/ae5960b2-7faa-4fa2-9c84-ac789d8d75f9_660x440.jpeg","publish_at":1474300800000,"sub_title":"看 Olsen 双生姐妹花玩转角色转换","title":"不想做设计师的演员不是好双生","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/a6743869c424b81b9a7faf5c283203db_225x226.jpg","id":44171,"sign":"设计故纸堆里的考古学徒","username":"苏潜"},"favor_user_num":42,"id":75,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/14/a34b59fb-a17e-488c-b04f-c27321ca8028_684x684.jpeg","publish_at":1474041600000,"sub_title":"旅途里都是对远方的祷告","title":"戴着你的许愿骨去流浪，流浪远方","web_url":""},{"author":{"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/08/27/068b70d77304e910f9bbfcc732e2d774_463x450.jpg","id":46473,"sign":"贪恋一抹胭脂香气的败家子","username":"黎曦"},"favor_user_num":23,"id":74,"image_url":"http://dstatic.zuimeia.com/common/image/2016/9/14/a7f046c8-6f01-4d77-b8ca-28ed8d4e3b4c_800x800.jpeg","publish_at":1473868800000,"sub_title":"我们爱着的，就是那个性感而优雅的世界","title":"月华如水，锆石和身体共婵娟的 N 种可能","web_url":""}],"has_next":1}
     * result : 1
     */

    private int result;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public static class DataBean implements Serializable{

        @Override
        public String toString() {
            return "DataBean{" +
                    "has_next=" + has_next +
                    ", articles=" + articles.size() +
                    '}';
        }

        private int has_next;
        /**
         * author : {"avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/9/24/ac99fa28-3e08-4067-b618-b9d63c0df7a6.jpg","id":16653,"sign":"一颗从金融学土壤中萌发的时尚之豆","username":"Mana Bean"}
         * favor_user_num : 0
         * id : 106
         * image_url : http://dstatic.zuimeia.com/common/image/2016/11/9/4f4f36d9-30b0-45cc-8f25-6045ac2de8bb_675x675.jpeg
         * publish_at : 1478707200000
         * sub_title : 从模仿他人到取悦自我的心灵之旅
         * title : 从女孩到女人：美好的高跟鞋，伴你一同成长
         * web_url :
         */

        private List<ArticlesBean> articles;

        public int getHas_next() {
            return has_next;
        }

        public void setHas_next(int has_next) {
            this.has_next = has_next;
        }

        public List<ArticlesBean> getArticles() {
            return articles;
        }

        public void setArticles(List<ArticlesBean> articles) {
            this.articles = articles;
        }

        public static class ArticlesBean implements Serializable{
            @Override
            public String toString() {
                return "ArticlesBean{" +
                        "author=" + author +
                        ", favor_user_num=" + favor_user_num +
                        ", id=" + id +
                        ", image_url='" + image_url + '\'' +
                        ", publish_at=" + publish_at +
                        ", sub_title='" + sub_title + '\'' +
                        ", title='" + title + '\'' +
                        ", web_url='" + web_url + '\'' +
                        '}';
            }

            /**
             * avatar_url : http://dstatic.zuimeia.com/user/avatar/2016/9/24/ac99fa28-3e08-4067-b618-b9d63c0df7a6.jpg
             * id : 16653
             * sign : 一颗从金融学土壤中萌发的时尚之豆
             * username : Mana Bean
             */
            private AuthorBean author;
            private int favor_user_num;
            private int id;
            private String image_url;
            private long publish_at;
            private String sub_title;
            private String title;
            private String web_url;

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public int getFavor_user_num() {
                return favor_user_num;
            }

            public void setFavor_user_num(int favor_user_num) {
                this.favor_user_num = favor_user_num;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public long getPublish_at() {
                return publish_at;
            }

            public void setPublish_at(long publish_at) {
                this.publish_at = publish_at;
            }

            public String getSub_title() {
                return sub_title;
            }

            public void setSub_title(String sub_title) {
                this.sub_title = sub_title;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }

            public static class AuthorBean implements Serializable{

                @Override
                public String toString() {
                    return "AuthorBean{" +
                            "avatar_url='" + avatar_url + '\'' +
                            ", id=" + id +
                            ", sign='" + sign + '\'' +
                            ", username='" + username + '\'' +
                            '}';
                }

                private String avatar_url;
                private int id;
                private String sign;
                private String username;

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

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }
            }
        }
    }
}
