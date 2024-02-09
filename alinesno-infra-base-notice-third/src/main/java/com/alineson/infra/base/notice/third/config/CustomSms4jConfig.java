package com.alineson.infra.base.notice.third.config;

import com.alinesno.infra.base.notice.entity.ConfigParamEntity;
import com.alinesno.infra.base.notice.service.IConfigParamService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.sms4j.core.factory.SmsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 启动加载配置
 */
@Slf4j
@Component
public class CustomSms4jConfig implements ApplicationRunner {

    @Autowired
    private IConfigParamService configParamService ;

    @Autowired
    private ReadConfig config;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<ConfigParamEntity> list = configParamService.list() ;
        for(ConfigParamEntity configParam : list){
            SmsFactory.createSmsBlend(config,configParam.getConfigId());
        }

    }
}