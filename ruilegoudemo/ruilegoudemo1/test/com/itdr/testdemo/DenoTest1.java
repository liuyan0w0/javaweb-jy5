package com.itdr.testdemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DenoTest1 {
    //测试与数据库是否连接
    //单例模式，创建十个对象之后，第十一个就不嫩创建了。通过设置方法保证连接池有且只有一个。

    @Test
    public void test1() throws Exception {
        ComboPooledDataSource co=new ComboPooledDataSource();
        Connection connection = co.getConnection( );
        String sql="select * from users";
        PreparedStatement ps = connection.prepareStatement(sql );
        ResultSet rs = ps.executeQuery( );
        while(rs.next()){
            System.out.println(rs.getString(2) );
        }

    }
}
