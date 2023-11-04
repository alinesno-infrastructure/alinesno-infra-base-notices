package com.alinesno.infra.base.notice.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;

/**
 * 发送策略对象
 * @author luoxiaodong
 * @since 1.0.0
 */
@TableName("strategy") // 指定数据库表名
@Data
public class StrategyEntity extends InfraBaseEntity {

    // 策略名称
    @TableField("strategy_name")
	@ColumnType(length=50)
	@ColumnComment("策略名称")
    private String strategyName;

    // 策略ID
    @TableField("strategy_id")
	@ColumnType(length=10)
	@ColumnComment("策略ID")
    private String strategyId;

    // 重复发送次数
    @TableField("retry_count")
	@ColumnType(length=2)
	@ColumnComment("重试次数")
    private Integer retryCount;

    // 定时任务
    @TableField("scheduled_task")
	@ColumnType(length=255)
	@ColumnComment("定时任务")
    private String scheduledTask;

    // 发送批次
    @TableField("send_batch")
	@ColumnType(length=10)
	@ColumnComment("发送批次")
    private String sendBatch;

    // 消息是否备份
    @TableField("backup_message")
	@ColumnType(length=255)
	@ColumnComment("备份消息")
    private Boolean backupMessage;

    // 延迟发送时间
    @TableField("delay_send_time")
	@ColumnType(length=8)
	@ColumnComment("延迟发送时间")
    private Long delaySendTime;

    // 是否报警
    @TableField("enable_alert")
	@ColumnType(length=1)
	@ColumnComment("启用警报")
    private Boolean enableAlert;

    // 限流方式（每分钟发送的条数）
    @TableField("rate_limit")
	@ColumnType(length=10)
	@ColumnComment("速率限制")
    private Integer rateLimit;
}
