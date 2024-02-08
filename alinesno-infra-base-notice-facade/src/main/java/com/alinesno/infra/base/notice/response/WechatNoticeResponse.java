package com.alinesno.infra.base.notice.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信返回信息
 */
@Data
public class WechatNoticeResponse implements Serializable {

    private boolean success;
    private Object data;
    private String configId;

}
