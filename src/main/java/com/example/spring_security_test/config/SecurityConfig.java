package com.example.spring_security_test.config;

import com.example.spring_security_test.config.auth.PrincipalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PrincipalDetailService principalDetailService;

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()  //csfr 토큰 비활성화
                .authorizeRequests()
                  .antMatchers("/", "/main", "/auth/**", "/js/**", "/css/**", "/image/**").permitAll()
                  .antMatchers("/h2-console").permitAll()
                  .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/auth/loginForm")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/auth/loginProc")
                    .defaultSuccessUrl("/")
                    .failureUrl("/auth/loginErrorForm");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(encoder());
    }
}
