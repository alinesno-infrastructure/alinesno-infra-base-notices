package com.alinesno.infra.base.notice.api.provider;

import com.alinesno.infra.base.notice.api.provider.base.BaseProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 发送企业微信通知
 */
@Slf4j
@Controller
@RequestMapping("/v1/base/notice/wechat")
public class WechatProvider extends BaseProvider {

}

