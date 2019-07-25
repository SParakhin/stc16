package ru.innopolis.stc16.innobazaar.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletRequest cachedWrappedRequest = new ContentCachingRequestWrapper(request);
        Map<String, String[]> requestParameters = cachedWrappedRequest.getParameterMap();

        Enumeration<String> enumeration = cachedWrappedRequest.getSession().getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String s = enumeration.nextElement();
            System.out.println("================>>>>>> : " + s);
        }

        for (Map.Entry<String, String[]> reqPar : requestParameters.entrySet()) {
            System.out.println("======>>>>>> " + reqPar.getKey() + " : " + Arrays.toString(reqPar.getValue()));
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
