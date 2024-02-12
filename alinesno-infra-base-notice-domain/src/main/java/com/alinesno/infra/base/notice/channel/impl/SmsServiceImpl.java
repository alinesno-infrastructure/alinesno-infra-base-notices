package com.alinesno.infra.base.notice.channel.impl;

import com.alinesno.infra.base.notice.channel.SmsService;
import com.alinesno.infra.base.notice.response.SmsNoticeResponse;
import lombok.extern.slf4j.Slf4j;
import org.dromara.sms4j.api.SmsBlend;
import org.dromara.sms4j.api.entity.SmsResponse;
import org.dromara.sms4j.core.factory.SmsFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 发送短信服务
 */
@Slf4j
@Component
public class SmsServiceImpl implements SmsService {

    @Override
    public SmsNoticeResponse sendMessage(String phone, String message , String configId) {

        SmsBlend smsBlend = SmsFactory.getSmsBlend(configId);
        Assert.notNull(smsBlend , "短信服务配置["+configId+"]不存在");

        SmsResponse smsResponse = smsBlend.sendMessage(phone ,message);

        log.debug("smsResponse = {}" , smsResponse.getData());

        return convertSmsResponseToDto(smsResponse);
    }

    @Override
    public SmsNoticeResponse sendMessage(String phone, Map<String, String> messages , String configId) {

        LinkedHashMap<String , String> messageMap = new LinkedHashMap<>() ;
        for(String key : messages.keySet()){
            messageMap.put(key , messages.get(key)) ;
        }

        SmsBlend smsBlend = SmsFactory.getSmsBlend(configId);

        Assert.notNull(smsBlend , "短信服务配置["+configId+"]不存在");

        SmsResponse smsResponse = smsBlend.sendMessage(phone ,messageMap);

        log.debug("smsResponse = {}" , smsResponse.getData());

        return convertSmsResponseToDto(smsResponse);
    }

    @Override
    public SmsNoticeResponse sendMessage(String phone, String templateId, LinkedHashMap<String, String> messages) {
        return null;
    }

    @Override
    public SmsNoticeResponse massTexting(List<String> phones, String message) {
        return null;
    }

    @Override
    public SmsNoticeResponse massTexting(List<String> phones, String templateId, LinkedHashMap<String, String> messages) {
        return null;
    }

    /**
     * 将消息返回的信息转换成实体类信息
     * @param smsResponse
     * @return
     */
    private SmsNoticeResponse convertSmsResponseToDto(SmsResponse smsResponse) {

        SmsNoticeResponse noticeResponse = new SmsNoticeResponse() ;

        noticeResponse.setData(smsResponse.getData());
        noticeResponse.setSuccess(smsResponse.isSuccess());
        noticeResponse.setConfigId(smsResponse.getConfigId());

        return noticeResponse ;

    }

}
