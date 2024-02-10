package com.alinesno.infra.base.notice.api.provider;

import com.alinesno.infra.base.notice.api.dto.SmsSendDto;
import com.alinesno.infra.base.notice.api.provider.base.BaseProvider;
import com.alinesno.infra.base.notice.core.ratelimiter.RateLimiter;
import com.alinesno.infra.base.notice.response.SmsNoticeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 短信发送接口
 */
@Slf4j
@Controller
@RequestMapping("/v1/base/notice/sms")
public class SmsProvider extends BaseProvider {

    // 发送短信
    @PostMapping("/sendMessage")
    public SmsNoticeResponse sendMessage(@RequestBody SmsSendDto smsSend){
        return smsService.sendMessage(smsSend.getPhone(), smsSend.getMessage(), smsSend.getConfigId()) ;
    }

    // 发送短信
    @RateLimiter(key = "#smsSend.phone")
    @PostMapping("/sendMessageMap")
    public SmsNoticeResponse sendMessageByMap(@RequestBody SmsSendDto smsSend){
        return smsService.sendMessage(smsSend.getPhone(), smsSend.getMessageMap(), smsSend.getConfigId()) ;
    }

}
