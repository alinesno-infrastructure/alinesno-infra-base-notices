package com.alinesno.infra.base.notice.api.provider;

import com.alinesno.infra.base.notice.api.provider.base.BaseProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送企业微信通知
 */
@Slf4j
@RestController
@RequestMapping("/v1/base/notice/wechat")
public class WechatController extends BaseProvider {

}

