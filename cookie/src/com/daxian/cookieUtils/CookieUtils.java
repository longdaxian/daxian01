package com.daxian.cookieUtils;

import javax.servlet.http.Cookie;

public class CookieUtils {
   public static Cookie createCookie(String name,String value,int time,String path){
       Cookie cookie=new Cookie(name,value);
       cookie.setMaxAge(time);
       cookie.setPath(path);
       return cookie;
   }
   public static String getCookie(Cookie[] cookies,String name){
       String value=null;
       if (cookies!=null) {
           for(Cookie cookie:cookies){
               if (cookie.getName().equals(name)) {
                   value=cookie.getValue();
               }
           }
       }
       return value;
   }

}
