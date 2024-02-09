package com.alinesno.infra.base.notice.channel.impl;

import com.alinesno.infra.base.notice.channel.SmsService;
import com.alinesno.infra.base.notice.response.SmsNoticeResponse;
import lombok.extern.slf4j.Slf4j;
import org.dromara.sms4j.api.SmsBlend;
import org.dromara.sms4j.api.entity.SmsResponse;
import org.dromara.sms4j.core.factory.SmsFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 发送短信服务
 */
@Slf4j
@Component
public class SmsServiceImpl implements SmsService {

    @Override
    public SmsNoticeResponse sendMessage(String phone, String message , String configId) {

        SmsBlend smsBlend = SmsFactory.getSmsBlend(configId);
        SmsResponse smsResponse = smsBlend.sendMessage(phone ,message);

        return convertSmsResponseToDto(smsResponse);
    }

    /**
     * 将消息返回的信息转换成实体类信息
     * @param smsResponse
     * @return
     */
    private SmsNoticeResponse convertSmsResponseToDto(SmsResponse smsResponse) {

        SmsNoticeResponse noticeResponse = new SmsNoticeResponse() ;
        BeanUtils.copyProperties(smsResponse , noticeResponse);

        return noticeResponse ;

    }

    @Override
    public SmsNoticeResponse sendMessage(String phone, LinkedHashMap<String, String> messages) {
        return null;
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
}
