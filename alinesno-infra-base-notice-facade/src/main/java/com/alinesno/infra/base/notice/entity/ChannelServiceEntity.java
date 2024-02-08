package com.alinesno.infra.base.notice.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import lombok.EqualsAndHashCode;

/**
 * 渠道服务类
 * @author luoxiaodong
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("channel_service") // 指定数据库表名
@Data
public class ChannelServiceEntity extends InfraBaseEntity {

    // 渠道名称
    @TableField("channel_name")
	@ColumnType(length=50)
	@ColumnComment("渠道服务类")
    private String channelName;

    // 渠道代码
    @TableField("channel_code")
	@ColumnType(length=50)
	@ColumnComment("渠道代码")
    private String channelCode;

    // 渠道状态
    @TableField("channel_status")
	@ColumnType(length=10)
	@ColumnComment("频道状态")
    private Integer channelStatus;

    // 渠道访问量
    @TableField("channel_access_count")
	@ColumnType(length=10)
	@ColumnComment("频道访问次数")
    private Integer channelAccessCount;

    // 异常量
    @TableField("exception_count")
	@ColumnType(length=10)
	@ColumnComment("异常计数")
    private Integer exceptionCount;

    // 总请求量
    @TableField("total_request_count")
	@ColumnType(length=10)
	@ColumnComment("总请求数")
    private Integer totalRequestCount;
}
