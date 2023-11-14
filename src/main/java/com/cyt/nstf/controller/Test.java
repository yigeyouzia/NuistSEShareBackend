package com.cyt.nstf.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyt
 * @date 2023/11/9 23:23
 * @desc
 */
@RestController
@RequestMapping("/test")
public class Test {

    @GetMapping("/hi")
    public void test() {
        System.out.println(1111);
    }
}
