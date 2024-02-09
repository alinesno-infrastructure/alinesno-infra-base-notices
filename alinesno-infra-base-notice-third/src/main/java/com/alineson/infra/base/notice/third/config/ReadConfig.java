package com.alineson.infra.base.notice.third.config;

import com.alinesno.infra.base.notice.entity.ConfigParamEntity;
import com.alinesno.infra.base.notice.service.IConfigParamService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.sms4j.aliyun.config.AlibabaConfig;
import org.dromara.sms4j.cloopen.config.CloopenConfig;
import org.dromara.sms4j.core.datainterface.SmsReadConfig;
import org.dromara.sms4j.ctyun.config.CtyunConfig;
import org.dromara.sms4j.dingzhong.config.DingZhongConfig;
import org.dromara.sms4j.emay.config.EmayConfig;
import org.dromara.sms4j.huawei.config.HuaweiConfig;
import org.dromara.sms4j.jdcloud.config.JdCloudConfig;
import org.dromara.sms4j.lianlu.config.LianLuConfig;
import org.dromara.sms4j.netease.config.NeteaseConfig;
import org.dromara.sms4j.provider.config.BaseConfig;
import org.dromara.sms4j.tencent.config.TencentConfig;
import org.dromara.sms4j.unisms.config.UniConfig;
import org.dromara.sms4j.yunpian.config.YunpianConfig;
import org.dromara.sms4j.zhutong.config.ZhutongConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.alinesno.infra.base.notice.enums.SmsProviderEnums.*;

/**
 * 读取配置信息
 */
@Slf4j
@Component
public class ReadConfig implements SmsReadConfig {

    @Autowired
    private IConfigParamService configParamService ;

    /**
     * 获取短信配置
     * @param configId
     * @return
     */
    @Override
    public BaseConfig getSupplierConfig(String configId) {

        ConfigParamEntity paramEntity = configParamService.getByConfigId(configId) ;
        Assert.notNull(paramEntity , "未配置接入短信参数");

        log.debug("param Entity = {}" , paramEntity);

        return convertConfigFromParam(paramEntity);
    }

    /**
     * 获取短信配置列表
     * @return
     */
    @Override
    public List<BaseConfig> getSupplierConfigList() {

        List<BaseConfig> configList = new ArrayList<>();

        List<ConfigParamEntity> list = configParamService.list() ;
        for(ConfigParamEntity configParam : list){
            BaseConfig baseConfig = convertConfigFromParam(configParam) ;
            configList.add(baseConfig) ;
        }

        return configList ;
    }

    /**
     * 配置转换成sms4j BaseConfig配置
     * @param paramEntity
     * @return
     */
    public static BaseConfig convertConfigFromParam(ConfigParamEntity paramEntity) {
        String type = paramEntity.getConfigType();

        if (type.equals(ALIYUN.getCode())) {
            // 阿里云配置
            AlibabaConfig alibabaConfig = new AlibabaConfig();

            BeanUtils.copyProperties(paramEntity , alibabaConfig);
            log.debug("alibaba config = {}" , alibabaConfig);

            return alibabaConfig ;
        } else if (type.equals(CLOOPEN.getCode())) {
            // 容联云配置
            return new CloopenConfig();
        } else if (type.equals(CTYUN.getCode())) {
            // 天翼云配置
            return new CtyunConfig();
        } else if (type.equals(EMAY.getCode())) {
            // 亿美软通配置
            return new EmayConfig();
        } else if (type.equals(HUAWEIYUN.getCode())) {
            // 华为云短信配置
            return new HuaweiConfig();
        } else if (type.equals(JDCLOUD.getCode())) {
            // 京东云短信配置
            return new JdCloudConfig();
        } else if (type.equals(NETEASE.getCode())) {
            // 网易云信配置
            return new NeteaseConfig();
        } else if (type.equals(TENCENT.getCode())) {
            // 腾讯云短信配置
            return new TencentConfig();
        } else if (type.equals(UNISMS.getCode())) {
            // 合一短信配置
            return new UniConfig();
        } else if (type.equals(YUNPIAN.getCode())) {
            // 云片短信配置
            return new YunpianConfig();
        } else if (type.equals(ZHUTONG.getCode())) {
            // 助通短信配置
            return new ZhutongConfig();
        } else if (type.equals(DINGZHONG.getCode())) {
            // 鼎众短信配置
            return new DingZhongConfig();
        } else if (type.equals(LIANLU.getCode())) {
            // 联麓短信配置
            return new LianLuConfig();
        } else {
            throw new IllegalArgumentException("不包含此类型的配置");
        }
    }

}
