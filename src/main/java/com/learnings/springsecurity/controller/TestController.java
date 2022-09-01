package com.learnings.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * This is a Test Controller
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String testMethod() {
        log.info("test method started");
        return "Spring - Security is cool";
    }

    //assume we want to secure this /hello endpoint. we have to by-pass the sign in form
    @GetMapping(value = "/hello")
    public String helloMethod() {
        log.info("hello method started");
        return "Hello endpoint called";
    }

    //assume we want to secure this /bye endpoint. we have to by-pass the sign in form
    @GetMapping(value = "/bye")
    public String byeMethod() {
        log.info("bye method started");
        return "Bye endpoint called";
    }
}