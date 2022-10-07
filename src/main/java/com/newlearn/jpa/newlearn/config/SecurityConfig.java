package com.newlearn.jpa.newlearn.config;

import com.newlearn.jpa.newlearn.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MemberService memberService;

    @Override
    //http 요청에 대한 보안 설정
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .usernameParameter("userId")
                .failureUrl("/main")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/content/main"))
                .logoutSuccessUrl("/main");
        http.authorizeHttpRequests()
                .mvcMatchers("main", "/newLearn/member/**", "newLearn/answer/**"
                        , "newLearn/choice/**", "newLearn/essay/**", "newLearn/quiz/**"
                        , "newLearn/room/**", "newLearn/student/**").permitAll()
//                .mvcMatchers().hasRole("user")
                .anyRequest().authenticated();
        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint());
        //인증되지 않은 사용자가 리소스에 접근하였을 때 수행하는 핸들러 *예외처리
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**", "images.common/**", "/js/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        //해시 암호화 저장
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(memberService)
                .passwordEncoder(passwordEncoder());
    }

}
