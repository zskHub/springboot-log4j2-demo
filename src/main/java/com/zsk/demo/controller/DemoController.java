package com.zsk.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : zsk
 * @CreateTime : 2021-09-19   13:54
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("getDemo")
    public String getDemo(){
        for (int i = 0; i < 1; i ++){
            log.debug("demo debug");
            log.info("getDemo  info");
            log.warn("getDemo  warn");
            log.error("getDemo  error, {}", i);
        }
        return "success";
    }
}
