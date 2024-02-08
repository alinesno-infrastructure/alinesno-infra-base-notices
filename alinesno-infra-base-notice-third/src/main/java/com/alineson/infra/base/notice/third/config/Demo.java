package com.alineson.infra.base.notice.third.config;

import org.dromara.sms4j.core.factory.SmsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Demo {
    @Autowired
    ReadConfig config;

    @EventListener
    public void init(ContextRefreshedEvent event){
        // 创建SmsBlend 短信实例
        SmsFactory.createSmsBlend(config,"在配置中定义的configId");
    }
}