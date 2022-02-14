package com.zsk.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsk.demo.entity.DemoEntity;

import java.util.List;

/**
 * @author zarl
 * @time 2022-02-14   09:37
 */
public interface DemoService extends IService<DemoEntity> {
    List<DemoEntity> queryDemoList();
}
