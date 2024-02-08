package com.alineson.infra.base.notice.third.config;

import org.dromara.sms4j.core.datainterface.SmsReadConfig;
import org.dromara.sms4j.provider.config.BaseConfig;
import org.dromara.sms4j.unisms.config.UniConfig;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 读取配置信息
 */
@Component
public class ReadConfig implements SmsReadConfig {

    @Override
    public BaseConfig getSupplierConfig(String configId) {

        //此处仅为示例，实际环境中，数据可以来自任意位置

        return new UniConfig();
    }

    @Override
    public List<BaseConfig> getSupplierConfigList() {

        //此处仅为示例，实际环境中，数据可以来自任意位置，



        return null;
    }
}
