package com.alinesno.infra.base.notice.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 邮件返回信息
 */
@Data
public class EmailNoticeResponse implements Serializable {

    private boolean success;
    private Object data;
    private String configId;

}
