package com.alinesno.infra.base.notice.api.provider;

import com.alinesno.infra.base.notice.api.provider.base.BaseProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 短信发送接口
 */
@Slf4j
@Controller
@RequestMapping("/v1/base/notice/sms")
public class SmsProvider extends BaseProvider {

}
