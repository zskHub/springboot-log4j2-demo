package com.zsk.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zarl
 * @time 2022-02-14   09:48
 */
@Data
@TableName("demo_info")
@Accessors(chain = true)
public class DemoEntity {

    private Long id;

    private String name;

    @TableField("is_deleted")
    private Integer deletedFlag;
}
