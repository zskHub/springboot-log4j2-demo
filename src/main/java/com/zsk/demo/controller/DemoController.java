package com.zsk.demo.controller;

import com.zsk.demo.entity.DemoEntity;
import com.zsk.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author : zsk
 * @CreateTime : 2021-09-19   13:54
 */
@Slf4j
@RestController
@RequestMapping("/demo")
@Api(tags = "测试demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @ApiOperation("打印日志信息")
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

    @ApiOperation("打印sql信息")
    @GetMapping("getSqlLogDemo")
    public String getSqlLogDemo(){
        List<DemoEntity> demoEntityList = demoService.queryDemoList();
        return "success";
    }
}
