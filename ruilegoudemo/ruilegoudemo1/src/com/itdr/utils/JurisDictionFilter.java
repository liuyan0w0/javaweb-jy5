package com.itdr.utils;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "JurisDictionFilter",value = "/manage/*")
public class JurisDictionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
//统一返回对象
        ResponseCode rs = new  ResponseCode();
        //转型使用子类的更多方法
        HttpServletRequest request=( HttpServletRequest ) req;
//获取路径
        String pathInfo=request.getPathInfo();
        //判断是否登录。登录就放行
        if(pathInfo.equals("/login.do")){
            chain.doFilter(req, resp);
            return;
        }

        //其他信息处理，验证session是否有用户信息
        HttpSession session=request.getSession();
        Users user=(Users) session.getAttribute("user");

        if(user==null){
            rs.setStatus(3);
            rs.setMag("请登录都操作");
            //当有页面后重定向到登录页面
            resp.getWriter().write(toString());
            return;
        }
        if(user.getType()!=1){
            rs.setStatus(3);
            rs.setMag("没有操作权限");
            resp.getWriter().write(toString());
            return;
        }
        chain.doFilter(req, resp);
        return;

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
