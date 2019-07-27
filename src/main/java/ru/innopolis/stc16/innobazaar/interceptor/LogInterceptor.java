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

        String method = cachedWrappedRequest.getMethod();
        if ("post".equalsIgnoreCase(method) || !requestParameters.isEmpty()) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : (String) principal);
            String role = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
            StringBuilder sb = new StringBuilder();
            sb.append("user: ").append(username);
            sb.append(" | role: ").append(role);
            sb.append(" | servlet path: ").append(cachedWrappedRequest.getServletPath());
            sb.append(" | method: ").append(method);
            if (!requestParameters.isEmpty()) {
                sb.append(" with param(s):");
                for (Map.Entry<String, String[]> par : requestParameters.entrySet()) {
                    if (!"_csrf".equalsIgnoreCase(par.getKey())) {
                        if (!"password".equalsIgnoreCase(par.getKey())) {
                            sb.append(" ").append(par.getKey()).append(" = ").append(Arrays.toString(par.getValue()));
                        }
                    }
                }
            }
            LOGGER.info(sb.toString());
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
