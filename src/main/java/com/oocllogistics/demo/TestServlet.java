package com.oocllogistics.demo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by FANAN3 on 10/10/2016.
 */
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = URLEncoder.encode("我是cookie","UTF-8");
        resp.addCookie(new Cookie("hi", value));

        Cookie[] cooks = req.getCookies();
        String cookValue = URLDecoder.decode(cooks[0].getValue(),"UTF-8");
        resp.getWriter().write("你好！"+ cookValue);
    }
}
