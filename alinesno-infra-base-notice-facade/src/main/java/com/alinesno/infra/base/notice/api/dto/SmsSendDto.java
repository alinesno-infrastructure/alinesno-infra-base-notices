package com.alinesno.infra.base.notice.api.dto;

import com.alinesno.infra.base.notice.api.NoticeRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SmsSendDto extends NoticeRequestDto {

    private String phone ;
    private String message ;
}
