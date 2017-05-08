package com.m520it.mostbeautiful.cons;

import android.util.Log;

/**
 * @author jane
 * @time 2016/11/7  20:40
 * @desc ${TODD}
 */
public class NetWorkUrl {
    public static final String BASE_URL="http://design.zuimeia.com";
    //有物
    public static final String HAVETHING_BASE_URL="http://design.zuimeia.com/api/v1/products/";

    //Daily
    public static final String HAVETHING_DAILY_URL=HAVETHING_BASE_URL+"daily/?timestamp=1478880000000&device_id=866654026715018&platform=android&lang=zh&appVersion=1.2.4&appVersionCode=10240&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    public static String getHaveThingDailyUrl(int page,int page_size){
        return HAVETHING_BASE_URL+"category/3/?page="+page+"&page_size="+page_size+"&device_id=866654026715018&platform=android&lang=zh&appVersion=1.2.4&appVersionCode=10240&systemVersion=22&countryCode=CN&user_id=80066&token=4gy-12a5a9e312f6c288c57f&package_name=com.zuiapps.zuiworld";
    }
    //首饰
    public static final String HAVETHING_HEADGEAR_URL = HAVETHING_BASE_URL+"category/3/?page=1&page_size=30&device_id=866654026715018&platform=android&lang=zh&appVersion=1.2.4&appVersionCode =10240&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    public static String getHaveThingHeardEarUrl(int page,int page_size){
        String hh =  HAVETHING_BASE_URL+"category/3/?page="+page+"&page_size="+page_size+"&device_id=866654026715018&platform=android&lang=zh&appVersion=1.2.4&appVersionCode=10240&systemVersion=22&countryCode=CN&user_id=80066&token=4gy-12a5a9e312f6c288c57f&package_name=com.zuiapps.zuiworld";
        Log.i("===hh",hh);
        return hh;
    }

    //包袋
    public static final String HAVETHING_BAG_URL = HAVETHING_BASE_URL+"daily/?timestamp=1478448000000&device_id=866654026715018&platform=android&lang=zh&appVersion=1.2.4&appVersionCode=10240&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //鞋履
    public static final String HAVETHING_SHOE_URL=HAVETHING_BASE_URL+"category/2/?page=1&page_size=30&device_id=866654026715018&platform=android&lang=zh&appVersion=1.2.4&appVersionCode=10240&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //MEN
    public static final String HAVETHING_MEN_URL=HAVETHING_BASE_URL+"category/65/?page=1&page_size=30&device_id=866654026715018&platform=android&lang=zh&appVersion=1.2.4&appVersionCode=10240&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //配饰 ornament
    public static final String HAVETHING_ORNAMENT_URL=HAVETHING_BASE_URL+"category/4/?page=1&page_size=30&device_id=866654026715018&platform=android&lang=zh&appVersion=1.2.4&appVersionCode=10240&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //其它 else
    public static final String HAVETHING_ELSE_URL=HAVETHING_BASE_URL+"category/54/?page=1&page_size=30&device_id=866654026715018&platform=android&lang=zh&appVersion=1.2.4&appVersionCode=10240&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //头部点击数据
    public static final String HAVETHING_TOP_URL=BASE_URL+"/api/v1/product/categories/?device_id=866654026715018&platform=android&lang=zh&appVersion=1.2.4&appVersionCode=10240&systemVersion=22&countryCode=CN&user_id=80066&token=4gy-12a5a9e312f6c288c57f&package_name=com.zuiapps.zuiworld";

    public static final String PAINT_URL=BASE_URL+"/api/v1/articles/daily/simple/";
    //设计师

    public static final String DESGIN_RECOMM_URL="http://design.zuimeia.com/api/v1/designers/recommend/";

    public static final String DESGIN_RECOMMITEM_URL ="http://design.zuimeia.com/api/v1/designers/category/";

    public static final String DESIGN_MOSTFAVOR_URL=BASE_URL+"/api/v1/designers/mostfavor/";

    public static final String DESIGN_SINGLE_URL=BASE_URL+"/api/v1/designers/category/30/";

    public static final String DESIGN_BRAND_URL=BASE_URL+"/api/v1/designers/category/31/";

    public static final String DESIGN_DETAIL_URL="http://design.zuimeia.com/api/v1/designer/";


    public static final String HAVETHING_DETAIL_BASE_URL="http://design.zuimeia.com/api/v1/product/";
    public static final String HAVETHING_DETAIL_URL = "/?device_id=866654026715018&platform=android&lang=zh&appVersion=1.2.4&appVersionCode=10240&systemVersion=22&countryCode=CN&user_id=80066&token=4gy-12a5a9e312f6c288c57f&package_name=com.zuiapps.zuiworld";
}
