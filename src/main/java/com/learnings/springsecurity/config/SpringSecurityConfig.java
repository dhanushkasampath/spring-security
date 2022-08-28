package com.learnings.springsecurity.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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


}

//now register the security filter chain with our application; it will be done by other class, SecurityInitializer