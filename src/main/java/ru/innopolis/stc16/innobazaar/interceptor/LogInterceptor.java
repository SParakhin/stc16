package ru.innopolis.stc16.innobazaar.interceptor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class LogInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger("requestLogger");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletRequest cachedWrappedRequest = new ContentCachingRequestWrapper(request);
        Map<String, String[]> requestParameters = cachedWrappedRequest.getParameterMap();

        System.out.println("=================================================");
        System.out.println("=================================================");
        System.out.println("=================================================");
        LOGGER.info("=====>>>>> method: " + cachedWrappedRequest.getMethod());
        LOGGER.info("=====>>>>> context path: " + cachedWrappedRequest.getContextPath());
        LOGGER.info("=====>>>>> path info: " + cachedWrappedRequest.getPathInfo());
        LOGGER.info("=====>>>>> path translated: " + cachedWrappedRequest.getPathTranslated());
        LOGGER.info("=====>>>>> query string: " + cachedWrappedRequest.getQueryString());
        LOGGER.info("=====>>>>> request URI: " + cachedWrappedRequest.getRequestURI());
        LOGGER.info("=====>>>>> servlet path: " + cachedWrappedRequest.getServletPath());
        LOGGER.info("=====>>>>> http servlet mapping: " + cachedWrappedRequest.getHttpServletMapping());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        LOGGER.info("=====>>>>> user: " + ((principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : principal));
        LOGGER.info("=====>>>>> authorities: " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());

        if (!requestParameters.isEmpty()) {
            for (Map.Entry<String, String[]> par : requestParameters.entrySet()) {
                if (!"_csrf".equals(par.getKey())) {
                    LOGGER.info("===>>> post parameter " + par.getKey() + " : " + Arrays.toString(par.getValue()));
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
