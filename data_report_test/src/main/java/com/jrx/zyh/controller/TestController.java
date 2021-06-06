package com.jrx.zyh.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Java实习-张永恒
 * @date 2021/6/5 20:48
 * @describe
 */
@RestController
public class TestController {

    @PostMapping("/hello")
    public String hello(){
        return "hello";
    }

}
