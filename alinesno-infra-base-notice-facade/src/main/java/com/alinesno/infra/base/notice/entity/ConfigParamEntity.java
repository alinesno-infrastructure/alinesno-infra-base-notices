package com.alinesno.infra.base.notice.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 配置参数
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Data
@TableName("config_params") // 配置参数
public class ConfigParamEntity extends InfraBaseEntity {

    @Column(comment = "类型工厂" , length = 64 , type = MySqlTypeConstant.VARCHAR)
    @TableField("factory")
    private String factory;

    @Column(comment = "连接密钥" , length = 64 , type = MySqlTypeConstant.VARCHAR)
    @TableField("access_key_id")
    private String accessKeyId;

    @Column(comment = "应用id" , length = 64 , type = MySqlTypeConstant.VARCHAR)
    @TableField("sdk_app_id")
    private String sdkAppId;

    @Column(comment = "应用密码" , length = 64 , type = MySqlTypeConstant.VARCHAR)
    @TableField("access_key_secret")
    private String accessKeySecret;

    @Column(comment = "签名信息" , length = 64 , type = MySqlTypeConstant.VARCHAR)
    @TableField("signature")
    private String signature;

    @Column(comment = "模板id" , length = 64 , type = MySqlTypeConstant.VARCHAR)
    @TableField("template_id")
    private String templateId;

    @Column(comment = "权重" , type = MySqlTypeConstant.INT)
    @TableField("weight")
    private Integer weight = 1;

    @Column(comment = "配置ID名称" , length = 64 , type = MySqlTypeConstant.VARCHAR)
    @TableField("config_id")
    private String configId;

    @Column(comment = "重试间隔" , type = MySqlTypeConstant.INT)
    @TableField("retry_interval")
    private int retryInterval = 5;

    @Column(comment = "最大重试次数" , type = MySqlTypeConstant.INT)
    @TableField("max_retries")
    private int maxRetries = 0;

    @Column(comment = "配置类型" , length = 64 , type = MySqlTypeConstant.VARCHAR)
    @TableField("config_type")
    private String configType;  // 配置类型

    @Column(comment = "短信类型" , length = 64 , type = MySqlTypeConstant.VARCHAR)
    @TableField("sms_type")
    private String smsType;  // 短信类型

    @Column(comment = "自定义参数" , length = 512, type = MySqlTypeConstant.VARCHAR)
    @TableField("params_json")
    private String paramsJson; // 自定义的json参数，以map的形式进行传递参数

}
