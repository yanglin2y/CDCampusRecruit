package com.ycode.cdcr.entcloud.config;

import com.ycode.cdcr.common.util.AESSimpleUtil;
import com.ycode.cdcr.entcloud.filter.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @author YangLin
 * @createTime 2022/01/11
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
  @Autowired
  private UserDetailsService userDetailsService;
  @Autowired
  PasswordEncoder passwordEncoder;
  @Autowired
  AuthenticationFailureHandler loginFailureHandler;
  @Autowired
  AuthenticationEntryPoint authenticationEntryPoint;
  @Autowired
  TokenFilter tokenFilter;
  @Autowired
  AuthenticationSuccessHandler authenticationSuccessHandler;
  @Autowired
  LogoutSuccessHandler logoutSuccessHandler;

  @Bean
  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)
        .passwordEncoder(new PasswordEncoder() {
          @Override
          public String encode(CharSequence charSequence) {
            return AESSimpleUtil.encrypt((String)charSequence);
          }

          @Override
          public boolean matches(CharSequence charSequence, String s) {
            return s.equals(AESSimpleUtil.encrypt((String)charSequence));
          }
        });
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.authorizeRequests()
        .antMatchers("/home","/user/register","/user/login").permitAll()
        .anyRequest().authenticated();
    http.formLogin()
        .loginPage("/login.html")
        .loginProcessingUrl("/user/login")
        .usernameParameter("account")
        .passwordParameter("password")
        .failureHandler(loginFailureHandler)
        .successHandler(authenticationSuccessHandler)
        .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
    http.logout().logoutUrl("/user/logout").logoutSuccessHandler(logoutSuccessHandler);
    http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
  }

}
