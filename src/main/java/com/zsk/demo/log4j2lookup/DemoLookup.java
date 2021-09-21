package com.zsk.demo.log4j2lookup;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;

/**
 * 自定义lookup
 * 使用的时候就是：${thread:name}
 *
 * @Author : zsk
 * @CreateTime : 2021-09-21   13:58
 */
@Plugin(name = "thread", category = "Lookup")
public class DemoLookup implements StrLookup {
    @Override
    public String lookup(String key) {
        return Thread.currentThread().getName();
    }

    @Override
    public String lookup(LogEvent event, String key) {
        return event.getThreadName() == null ? Thread.currentThread().getName() : event.getThreadName();
    }
}
