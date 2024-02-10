package com.alineson.infra.base.notice.third.config;

import cn.hutool.json.JSONUtil;
import com.alinesno.infra.base.notice.entity.ConfigParamEntity;
import com.alinesno.infra.base.notice.service.IConfigParamService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.dromara.sms4j.core.factory.SmsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 启动加载配置
 */
@Slf4j
@Component
public class CustomSms4jConfig {

    @Autowired
    private IConfigParamService configParamService ;

    @Autowired
    private ReadConfig config;

    @PostConstruct
    public void initSms4j() {

        List<ConfigParamEntity> list = configParamService.list() ;
        log.debug("list.size = {}" , list.size());

        for(ConfigParamEntity configParam : list){
            log.debug("config param = {}" , JSONUtil.toJsonPrettyStr(configParam));
            SmsFactory.createSmsBlend(config,configParam.getConfigId());
        }

    }
}