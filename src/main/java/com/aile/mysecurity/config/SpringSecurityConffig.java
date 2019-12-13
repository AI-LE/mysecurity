package com.aile.mysecurity.config;

import com.aile.mysecurity.security.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author aile
 * @Date 2019/12/13 11:31
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConffig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SysUserServiceImpl userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout().permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/css/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService); //user Details Service验证

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(myAuthenticationProvider);
//
//        /*
//  放弃以前的认证方式
//  auth.userDetailsService(userService).passwordEncoder(new MyPasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
//            }
//            *//**
//         * @param charSequence 明文
//         * @param s 密文
//         * @return
//         *//*
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                System.err.println("matches--------->：" + charSequence);
//                //如果s密码输入为空
//                return !StringUtils.isEmpty(s) && s.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes()));
//            }
//            @Override
//            public void getUsername(String username) {
//                System.err.println("username--------->：" + username);
//            }
//        });*/
//    }

}
