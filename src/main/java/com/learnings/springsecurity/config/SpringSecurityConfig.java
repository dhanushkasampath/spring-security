package com.learnings.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * So WebSecurityConfigurerAdapter is deprecated
 * the developers of Spring framework encourage users to move towards a component-based security configuration.
 * <p>
 * This class will ask.
 * 1. Hey who you are?
 * 2. Are you authorized?
 * 3. Prove it?
 * 4. what's ur ip address?
 * 5. tell me your region?
 */
//this class is going to help with creating spring security filter chain
//@Configuration this is no need since EnableWebSecurity already contain it
@EnableWebSecurity(debug = true)//who creates the security filter chain. this annotation will create it
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    //I want to create some details for an user
    //username/password/role
    //i want to authenticate users using in memory authentication.
    //below method will be called automatically
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
           .inMemoryAuthentication()
           .withUser("dhanushka")
//           .password("$2a$12$YLVv/U5GDlU5ymyRdsXzIePTxx5CWjbtVSCcO8HP4sz0avCB3EGHK")
           .password(getPasswordEncoder().encode("abc@123"))
           .roles("admin");
    }

    @Bean
    PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();//this store the rawPassword
        return new BCryptPasswordEncoder();
    }

    /**
     * after doing below thing usernamePasswordAuthenticationFilter which is responsible for formbased Authentication
     * is removed
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }
}

//now register the security filter chain with our application; it will be done by other class, SecurityInitializer