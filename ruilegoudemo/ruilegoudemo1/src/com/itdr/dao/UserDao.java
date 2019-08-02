package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.Poolutil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

//数据层
public class UserDao {
    //查找所有用户
    public List <Users> selectAll(String pageSize, String pageNum) {
        // ComboPooledDataSource co=Poolutil.getCom();//获取连接池
        QueryRunner qr = new QueryRunner(Poolutil.getCom( ));
        String sql = "select * from users ";//分页
        List <Users> li = null;
        try {
            li = qr.query(sql, new BeanListHandler <Users>(Users.class));//修改第一处
        } catch (SQLException e) {
            e.printStackTrace( );
        }
        return li;
    }

    //根据用户名和密码查找用户
    public Users selectOne(String username, String password) {
        // ComboPooledDataSource co=Poolutil.getCom();//获取连接池
        QueryRunner qr = new QueryRunner(Poolutil.getCom( ));
        String sql = "select * from users where uname=? and psd=?";//分页
        Users u = null;
        try {
            u = qr.query(sql, new BeanHandler <Users>(Users.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace( );
        }
        return u;
    }

    //根据ID查找一个用户
    public Users selectOne(Integer uid) {
        // ComboPooledDataSource co=Poolutil.getCom();//获取连接池
        QueryRunner qr = new QueryRunner(Poolutil.getCom( ));
        String sql = "select * from users where id=? ";//分页
        Users u = null;
        try {
            u = qr.query(sql, new BeanHandler <Users>(Users.class), uid);
        } catch (SQLException e) {
            e.printStackTrace( );
        }
        return u;
    }

    //根据ID禁用用户
    public int updateByUid(Integer uid) {
        // ComboPooledDataSource co=Poolutil.getCom();//获取连接池
        QueryRunner qr = new QueryRunner(Poolutil.getCom( ));
        String sql = "update  users set stats =1 where id=? ";//分页

        int row = 0;
        try {
            row = qr.update(sql, uid);
        } catch (SQLException e) {
            e.printStackTrace( );
        }
        return row;
    }

}


