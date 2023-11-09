package com.alinesno.infra.base.notice.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 统计基类
 * @author luoxiaodong
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("notice_summary") // 指定数据库表名
@Data
public class NoticeSummaryEntity extends InfraBaseEntity {

    // 总发送数量
    @TableField("total_send_count")
	@ColumnType(length=10)
	@ColumnComment("统计基类")
    private Integer totalSendCount;

    // 成功发送数量
    @TableField("success_send_count")
	@ColumnType(length=10)
	@ColumnComment("成功发送数量")
    private Integer successSendCount;

    // 发送失败数量
    @TableField("failure_send_count")
	@ColumnType(length=255)
	@ColumnComment("发送失败次数")
    private Integer failureSendCount;

    // 待发送数量
    @TableField("pending_send_count")
	@ColumnType(length=10)
	@ColumnComment("待发送数量")
    private Integer pendingSendCount;

    // 异常数量
    @TableField("exception_count")
	@ColumnType(length=10)
	@ColumnComment("异常计数")
    private Integer exceptionCount;

    // 最后发送时间
    @TableField("last_send_time")
	@ColumnType(length=19)
	@ColumnComment("最后发送时间")
    private Date lastSendTime;

    // 邮件发送数量
    @TableField("email_count")
	@ColumnType(length=255)
	@ColumnComment("电子邮件数量")
    private Integer emailCount;

    // 短信发送数量
    @TableField("sms_count")
	@ColumnType(length=255)
	@ColumnComment("短信数量")
    private Integer smsCount;

    // 推送发送数量
    @TableField("push_count")
	@ColumnType(length=10)
	@ColumnComment("推送次数")
    private Integer pushCount;

    // 微信发送数量
    @TableField("wechat_count")
	@ColumnType(length=10)
	@ColumnComment("微信数量")
    private Integer wechatCount;

    // 总的渠道发送数量
    @TableField("total_channel_count")
	@ColumnType(length=10)
	@ColumnComment("总频道数量")
    private Integer totalChannelCount;
}
