package com;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception
 {
  auth.inMemoryAuthentication().withUser("admin").password("{noop}admin123").authorities("admin");
  auth.inMemoryAuthentication().withUser("sumit").password("{noop}sumit123").authorities("prodmgr");
  auth.inMemoryAuthentication().withUser("ajay").password("{noop}ajay123").authorities("sermgr");
 }
@Override
 protected void configure(HttpSecurity http) throws Exception
 {
   http.authorizeRequests()
   //URLS
   .antMatchers(HttpMethod.GET,"/login").permitAll()
   .antMatchers("/abtus").permitAll()
   .antMatchers("/cntus").permitAll()
   .antMatchers("/product").hasAuthority("prodmgr")
   .antMatchers("/service").hasAuthority("sermgr")
   .antMatchers("/help").permitAll()
   .antMatchers("/home").hasAnyAuthority("admin","sermgr","prodmgr")

   //Login form details
   .and() 
   .formLogin()
   .defaultSuccessUrl("/home",true)

   //Logout Details
   .and() 
   .logout()    
   .logoutRequestMatcher(new AntPathRequestMatcher("/login")) 

   //Exception Details
   .and()
   .exceptionHandling()
   .accessDeniedPage("/denied"); 
   
 }
 
}