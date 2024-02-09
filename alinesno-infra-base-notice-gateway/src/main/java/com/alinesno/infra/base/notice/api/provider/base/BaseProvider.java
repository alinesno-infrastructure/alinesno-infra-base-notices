package com.alinesno.infra.base.notice.api.provider.base;

import com.alinesno.infra.base.notice.channel.SmsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 对外基础类
 */
public abstract class BaseProvider {

    @Autowired
    protected SmsService smsService ;

}
