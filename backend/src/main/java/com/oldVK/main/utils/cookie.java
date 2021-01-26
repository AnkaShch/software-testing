package com.oldVK.main.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class cookie {
    public static String Get(HttpServletRequest request, String cookie_name) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookie_name)) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }
}
