package com.fc.springmvc.modules.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.fc.springmvc.utils.JwtUtils;
import com.fc.springmvc.utils.WebContextKit;
import io.jsonwebtoken.Claims;

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    public static final String USER_KEY = "userId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取用户凭证
        String token = request.getHeader(JwtUtils.header);
        if(StringUtils.isEmpty(token)){
            token = request.getParameter(JwtUtils.header);
        }
        if(StringUtils.isEmpty(token)){
        		token = WebContextKit.getCookie(request, JwtUtils.header);
        }
        //凭证为空
        if(StringUtils.isEmpty(token)){
        		WebContextKit.renderJson(response, "token 不能为空");
        		return false;
        }
        WebContextKit.setCookie(response, JwtUtils.header, token, JwtUtils.expire.intValue(), false);
        Claims claims = JwtUtils.getClaimByToken(token);
        if(claims == null || JwtUtils.isTokenExpired(claims.getExpiration())){
        		WebContextKit.renderJson(response, "sessionTimeOut");
        		return false;
        }
        //设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(USER_KEY, claims.getSubject());
        return true;
    }
}

