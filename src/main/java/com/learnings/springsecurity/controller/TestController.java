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
}