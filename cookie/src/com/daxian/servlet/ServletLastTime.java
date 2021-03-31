package com.daxian.servlet;

import com.daxian.cookieUtils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ServletLastTime")
public class ServletLastTime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String currentTime=new SimpleDateFormat("YYYY-MM-dd/HH-mm-ss").format(new Date());
        Cookie[] cookies = request.getCookies();
        String lastTime=CookieUtils.getCookie(cookies,"lastTime");
        Cookie lastTime1 = CookieUtils.createCookie("lastTime", currentTime, 60 * 60, request.getContextPath());
        response.addCookie(lastTime1);
        if (lastTime!=null) {
            response.getWriter().write(lastTime);
        }else {
            response.getWriter().write("first访问");
        }
    }
}
