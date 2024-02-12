package com.alinesno.infra.base.notice;

import com.alinesno.infra.base.notice.entity.ConfigParamEntity;
import com.alinesno.infra.base.notice.service.IConfigParamService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
@SpringBootApplication
public class BaseNoticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseNoticeApplication.class, args);
	}

}