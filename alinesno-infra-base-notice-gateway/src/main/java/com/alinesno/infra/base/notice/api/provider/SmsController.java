package com.alinesno.infra.base.notice.api.provider;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alinesno.infra.base.notice.api.dto.SmsSendDto;
import com.alinesno.infra.base.notice.api.provider.base.BaseProvider;
import com.alinesno.infra.base.notice.response.SmsNoticeResponse;
import com.alinesno.infra.common.security.api.annotation.RateLimiter;
import com.alinesno.infra.common.security.api.enums.LimitType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信发送接口
 */
@Slf4j
@RestController
@RequestMapping("/v1/base/notice/sms")
public class SmsController extends BaseProvider {

    // 发送短信
    @RateLimiter(key = "#smsSend.phone" ,count = 1 , time = 60 , limitType = LimitType.CLUSTER , message = "请求过于频繁请一分钟后尝试.")
    @PostMapping("/sendMessage")
    public SmsNoticeResponse sendMessage(@RequestBody SmsSendDto smsSend){
        return smsService.sendMessage(smsSend.getPhone(), smsSend.getMessage(), smsSend.getConfigId()) ;
    }

    // 发送短信
    @RateLimiter(key = "#smsSend.phone" ,count = 1 , limitType = LimitType.CLUSTER , message = "请求过于频繁请一分钟后尝试.")
    @PostMapping("/sendMessageMap")
    public SmsNoticeResponse sendMessageByMap(@RequestBody SmsSendDto smsSend){

        log.debug("smsSend = {}" , JSONUtil.toJsonPrettyStr(smsSend));

        return smsService.sendMessage(smsSend.getPhone(), smsSend.getMessageMap(), smsSend.getConfigId()) ;
    }

}
