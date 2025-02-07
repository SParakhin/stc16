package ru.innopolis.stc16.innobazaar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ru.innopolis.stc16.innobazaar.interceptor.LogInterceptor;
import ru.innopolis.stc16.innobazaar.interceptor.MenuInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ru.innopolis.stc16.innobazaar.controller"})
public class WebMvcConfig implements WebMvcConfigurer {

    private MenuInterceptor menuInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(menuInterceptor);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/**", "/webjars/**", "/resources/**")
                .addResourceLocations("/", "/webjars/", "/resources/");

    }

    @Autowired
    private void setMenuInterceptor(MenuInterceptor menuInterceptor) {
        this.menuInterceptor = menuInterceptor;
    }

}