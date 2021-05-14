package com.trustrace.RedditCloneApp.configuration;

import com.trustrace.RedditCloneApp.configuration.authconfig.MyUserDetailsService;
import com.trustrace.RedditCloneApp.jwt.JwtTokenVerifier;
import com.trustrace.RedditCloneApp.jwt.JwtUserNameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(PasswordEncoder.bCryptPasswordEncoder());
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                   .antMatchers("/api/auth" , "/api/auth/login")
                    .permitAll()
                  .antMatchers(HttpMethod.GET,"/api/subreddit","/api/posts").permitAll()
                .and()
                .addFilterAfter(new JwtTokenVerifier(), UsernamePasswordAuthenticationFilter.class)
                .formLogin();

    }
}
