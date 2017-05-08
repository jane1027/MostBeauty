package com.m520it.mostbeautiful.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.cons.Consts;

/**
 * @author SmRo
 */
public class SPUtil {

    private static SharedPreferences getSp(Context context){
        SharedPreferences sp = context.getSharedPreferences(Consts.SPFILENAME, Context.MODE_PRIVATE);
        return sp;
    }

    public static void putString(Context context,String key,String values){
        getSp(context).edit().putString(key,values).commit();
    }

    public static String getString(Context context,String key){
        return getSp(context).getString(key, "");
    }
    public static void putInt(Context context,String key,int values){
        getSp(context).edit().putInt(key,values).commit();
    }

    public static int getInt(Context context,String key){
        return getSp(context).getInt(key, R.drawable.ic_mine_portrait);
    }
}
