package com.board.example.util;

import com.board.example.domain.BoardDomain;
import lombok.Data;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil extends BoardDomain {
    public static void setCookie(HttpServletResponse response, String jwt) {
        Cookie cookie = new Cookie("JWT_COOKIE", jwt);
        response.addCookie(cookie);
    }
}
