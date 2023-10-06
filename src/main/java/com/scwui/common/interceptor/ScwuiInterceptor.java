package com.scwui.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lena on 2017-06-28.
 */
@Component
public class ScwuiInterceptor extends HandlerInterceptorAdapter {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    // 임시

    //TODO 임시 테스트용 Auth 정보
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.debug("ScwuiInterceptor ::: preHandle");
        //TODO -- 임시 테스트용으로 Auth 정보 session 넣을까 고민중
//        Auth auth = new Auth(instanceId, userId, orgId);
        logger.info("##################### " + request.getServletPath());
        if (isLoginUrl(request)) {
            request.getSession().invalidate();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("ScwuiInterceptor ::: postHandle");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg) throws Exception {
        logger.debug("ScwuiInterceptor ::: afterCompletion");
    }

    public boolean isLoginUrl(HttpServletRequest request) {
        boolean logoutPlay = false;
        boolean allowedrange = false;
        String url = request.getRequestURI();
        logger.info("#######################################################");
        logger.info("#######################################################");
        logger.info("REQUEST URL : " + url);
        logger.info("#######################################################");
        logger.info("#######################################################");
        try {
            String urls[] = url.split("/");
            if (url.indexOf("/repositories/user/") > -1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }
}
