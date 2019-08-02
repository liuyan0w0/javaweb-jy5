package com.itdr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//创建一个工具类
public class Poolutil {
    public static final  ComboPooledDataSource co=new ComboPooledDataSource();
    public static ComboPooledDataSource getCom(){
        return co;

    }
}
