package com.alinesno.infra.base.notice;

import com.alineson.infra.base.notice.third.config.CustomSms4jConfig;
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
		ConfigurableApplicationContext context =  SpringApplication.run(BaseNoticeApplication.class, args);
		System.out.println("------->>>>>>>>>>>>>>>>> " + context.getBean(CustomSms4jConfig.class));
	}

}