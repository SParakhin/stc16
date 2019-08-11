package ru.innopolis.stc16.innobazaar.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.stc16.innobazaar.entity.Category;
import ru.innopolis.stc16.innobazaar.service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MenuInterceptor implements HandlerInterceptor {

    @Autowired
    private CategoryService categoryService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

        if (modelAndView == null) return;

        Map<String, String> catsContainer = new TreeMap<>();
        List<Category> catsList =(categoryService != null) ? categoryService.getAllCategories() : null;

        if (catsList == null || catsList.isEmpty()) {
            catsContainer.put("категорий нет", "#");
        } else {
            for (Category cat : catsList) {
                catsContainer.put(cat.getName(), cat.getName());
            }
        }

        modelAndView.addObject("cats", catsContainer);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

}
