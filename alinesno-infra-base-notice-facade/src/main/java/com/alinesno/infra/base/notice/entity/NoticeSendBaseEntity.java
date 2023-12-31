package com.alinesno.infra.base.notice.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDateTime;

/**
 * 通知的基类
 * @author luoxiaodong
 * @since 1.0.0
 */
@Data
public class NoticeSendBaseEntity extends InfraBaseEntity {

    @TableField("status")
	@ColumnType(length=1)
	@ColumnComment("通知的基类")
    private String status; // 通知状态

    @TableField("content")
	@ColumnType(length=255)
	@ColumnComment("内容")
    private String content; // 通知内容

    @TableField("template_id")
	@ColumnType(length=50)
	@ColumnComment("模板ID")
    private String templateId; // 模板ID

    @TableField("send_time")
	@ColumnType(length=19)
	@ColumnComment("发送时间")
    private LocalDateTime sendTime; // 发送时间

    @TableField("exception_time")
	@ColumnType(length=19)
	@ColumnComment("异常时间")
    private LocalDateTime exceptionTime; // 异常时间

    @TableField("recipient")
	@ColumnType(length=255)
	@ColumnComment("收件人")
    private String recipient; // 接收人
}
