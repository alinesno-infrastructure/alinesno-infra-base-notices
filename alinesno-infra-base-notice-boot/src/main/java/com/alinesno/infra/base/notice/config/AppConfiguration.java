package com.alinesno.infra.base.notice.config;

import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.security.api.aspectj.RateLimiterAspect;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 统一配置类信息
 */
@EnableActable
@EnableInfraSsoApi
@MapperScan("com.alinesno.infra.base.notice.mapper")
@Configuration
public class AppConfiguration {

    /**
     * 初始化限流拦截配置
     * @return
     */
    @Bean
    public RateLimiterAspect getRateLimiterAspect(){
       return new RateLimiterAspect() ;
    }

}
