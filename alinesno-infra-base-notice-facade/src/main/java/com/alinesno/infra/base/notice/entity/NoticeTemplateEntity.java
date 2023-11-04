package com.alinesno.infra.base.notice.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;

/**
 * 通知模板表
 */
@TableName("notice_template") // 指定数据库表名
@Data
public class NoticeTemplateEntity extends InfraBaseEntity {

    // 模板代码
    @TableField("template_code")
	@ColumnType(length=50)
	@ColumnComment("通知模板表")
    private String templateCode;

    // 模板名称
    @TableField("template_name")
	@ColumnType(length=50)
	@ColumnComment("模板名称")
    private String templateName;

    // 模板内容
    @TableField("template_content")
	@ColumnType(length=255)
	@ColumnComment("模板内容")
    private String templateContent;

    // 模板类型
    @TableField("template_type")
	@ColumnType(length=20)
	@ColumnComment("模板类型")
    private String templateType;

    // 业务类型
    @TableField("business_type")
	@ColumnType(length=20)
	@ColumnComment("业务类型")
    private String businessType;

    // 模板所属的渠道
    @TableField("channel")
	@ColumnType(length=255)
	@ColumnComment("频道")
    private String channel;

    // 第三方模板的关联ID
    @TableField("third_party_template_id")
	@ColumnType(length=50)
	@ColumnComment("第三方模板ID")
    private String thirdPartyTemplateId;
}
