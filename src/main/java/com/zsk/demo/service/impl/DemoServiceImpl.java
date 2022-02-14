package com.zsk.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsk.demo.entity.DemoEntity;
import com.zsk.demo.mapper.DemoDao;
import com.zsk.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zarl
 * @time 2022-02-14   09:43
 */
@Slf4j
@Service
public class DemoServiceImpl extends ServiceImpl<DemoDao, DemoEntity> implements DemoService {
    @Autowired
    private DemoDao demoDao;

    @Override
    public List<DemoEntity> queryDemoList() {
        log.debug("开始查询");
        List<DemoEntity> demoEntityList = demoDao.selectList(new QueryWrapper<DemoEntity>().lambda()
                .eq(DemoEntity::getDeletedFlag, 0));
        log.debug("查询结束");
        return  demoEntityList;
    }
}
