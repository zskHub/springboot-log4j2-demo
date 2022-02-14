package com.zsk.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsk.demo.entity.DemoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zarl
 * @time 2022-02-14   11:28
 */
@Mapper
public interface DemoDao extends BaseMapper<DemoEntity> {
}
