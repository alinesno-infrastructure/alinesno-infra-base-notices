package com.alinesno.infra.base.notice.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Project Entity
 * 
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@TableName("project")
@Data
public class ProjectEntity extends InfraBaseEntity {
 
	@TableField("type")
	@ColumnType(length=255)
	@ColumnComment("Project")
	private String type; // 应用类型

	@TableField("version")
	@ColumnType(length=2)
	@ColumnComment("版本")
	private String version; // 应用版本号

	@TableField("name")
	@ColumnType(length=255)
	@ColumnComment("无法确定")
	private String name; // 应用名称

	@TableField("banner")
	@ColumnType(length=255)
	@ColumnComment("横幅")
	private String banner; // 标识图标

	@TableField("icon")
	@ColumnType(length=50)
	@ColumnComment("图标")
	private String icon; // 应用icon

	@TableField("remark")
	@ColumnType(length=255)
	@ColumnComment("备注")
	private String remark; // 应用备注

	@TableField("open_key")
	@ColumnType(length=255)
	@ColumnComment("开放密钥")
	private String openKey; // 应用代码

	@TableField("code")
	@ColumnType(length=255)
	@ColumnComment("代码")
	private String code; // 应用代码
}
