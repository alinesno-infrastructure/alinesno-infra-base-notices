package com.alinesno.infra.base.notice.service.impl;

import com.alinesno.infra.base.notice.entity.ConfigParamEntity;
import com.alinesno.infra.base.notice.mapper.ConfigParamMapper;
import com.alinesno.infra.base.notice.service.IConfigParamService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Slf4j
@Service
public class ConfigParamServiceImpl extends IBaseServiceImpl<ConfigParamEntity, ConfigParamMapper> implements IConfigParamService  {

    @Override
    public ConfigParamEntity getByConfigId(String configId) {

        LambdaQueryWrapper<ConfigParamEntity> wrapper = new LambdaQueryWrapper<>() ;
        wrapper.eq(ConfigParamEntity::getConfigId , configId) ;

        return this.getOne(wrapper) ;
    }
}