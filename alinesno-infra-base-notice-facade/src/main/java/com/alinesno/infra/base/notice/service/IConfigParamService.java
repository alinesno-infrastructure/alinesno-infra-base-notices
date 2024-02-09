package com.alinesno.infra.base.notice.service;

import com.alinesno.infra.base.notice.entity.ConfigParamEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * 配置参数
 * 
 * @author LuoXiaoDong
 * @version 1.0.0
 */
public interface IConfigParamService extends IBaseService<ConfigParamEntity> {

    /**
     * 通过配置id获取到系统参数
     * @param configId
     * @return
     */
    ConfigParamEntity getByConfigId(String configId);

}