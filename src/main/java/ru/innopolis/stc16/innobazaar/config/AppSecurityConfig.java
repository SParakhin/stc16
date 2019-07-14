package ru.innopolis.stc16.innobazaar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("master").password("qwe123").roles("ADMIN"))
                .withUser(userBuilder.username("user").password("qwe123").roles("USER"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        Фильтр для кодировки символов
         */
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        http.addFilterBefore(characterEncodingFilter, CsrfFilter.class);

        /*
        Конфигурирование доступа
         */
        http.authorizeRequests()
                .antMatchers("/listUsers").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/authenticateTheUser").permitAll()
                .and()
                .logout().permitAll();
    }
}
