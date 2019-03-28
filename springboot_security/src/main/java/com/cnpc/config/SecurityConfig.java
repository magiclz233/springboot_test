package com.cnpc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * @EnableWebSecurity，开启 Spring Security 权限控制和认证功能。
     * antMatchers("/", "/home").permitAll()，配置不用登录可以访问的请求。
     * anyRequest().authenticated()，表示其他的请求都必须要有权限认证。
     * formLogin()，定制登录信息。
     * loginPage("/login")，自定义登录地址，若注释掉则使用默认登录页面。
     * logout()，退出功能，Spring Security 自动监控了了 /logout。
     * ignoringAntMatchers("/logout")，Spring Security 默认启用了了同源请求控制，
     * 在这里选择忽略退出请求的同源限制
     * @param http
     * @throws Exception
     */
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers( "/","/home" ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage( "/login" )
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf()
                .ignoringAntMatchers( "/logout" );
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
        auth.inMemoryAuthentication()
                .passwordEncoder( new BCryptPasswordEncoder(  ) )
                .withUser( "admin" )
                .password( new BCryptPasswordEncoder(  ).encode( "123456" ) )
                .roles( "ADMIN" );
    }
}
