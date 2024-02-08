package com.alinesno.infra.base.notice.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 钉钉返回信息
 */
@Data
public class DingtalkNoticeResponse implements Serializable {

    private boolean success;
    private Object data;
    private String configId;

}
