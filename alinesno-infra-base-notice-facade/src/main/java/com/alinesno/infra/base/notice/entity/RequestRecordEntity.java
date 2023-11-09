package com.alinesno.infra.base.notice.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import java.util.Date;

/**
 * 用户操作记录和请求记录
 * 
 * @author WeiXiaoJin
 * @since 2019年4月8日 下午10:15:43
 */
@EqualsAndHashCode(callSuper = true)
@TableName("request_record")
@Data
public class RequestRecordEntity extends InfraBaseEntity {
	
	@TableField(value = "project_id")
	@ColumnType(length=255)
	@ColumnComment("用户操作记录和请求记录")
	private Long projectId ; //  所属项目
  
	@TableField(value = "config_id")
	@ColumnType(length=255)
	@ColumnComment("configId")
	private Long configId ; //  所属配置
	
	/* @Excel(name = "操作说明") */
	@TableField
	@ColumnType(length=255)
	@ColumnComment("操作")
	private String operation;

	@Excel(name = "执行时间")
	@TableField("method_time")
	@ColumnType(length=8)
	@ColumnComment("方法时间")
	private long methodTime;

	@Excel(name = "类方法")
	@TableField("method")
	@ColumnType(length=255)
	@ColumnComment("方法")
	private String method;

	@Excel(name = "请求参数")
	@Lob
	@TableField("params")
	@Basic(fetch = FetchType.LAZY)
	@ColumnType(length=255)
	@ColumnComment("参数")
	private String params;

	@Excel(name = "方法描述")
	@TableField("method_desc")
	@ColumnType(length=255)
	@ColumnComment("方法描述")
	private String methodDesc;

	@Excel(name = "请求记录")
	@TableField("record_type")
	@ColumnType(length=10)
	@ColumnComment("记录类型")
	private String recordType; // 记录类型

	@Excel(name = "服务器IP")
	@TableField("ip")
	@ColumnType(length=15)
	@ColumnComment("IP地址")
	private String ip; // 服务器ip

	@Excel(name = "请求链接")
	@TableField("url")
	@ColumnType(length=255)
	@ColumnComment("链接地址")
	private String url; // 请求链接

	@Excel(name = "浏览器信息")
	@TableField("agent")
	@ColumnType(length=255)
	@ColumnComment("浏览器信息")
	private String agent; // 浏览器信息

	@TableField("create_time")
	@ColumnType(length=19)
	@ColumnComment("创建时间")
	private Date createTime;

	@TableField("account_id")
	@ColumnType(length=10)
	@ColumnComment("账户ID")
	private String accountId;

	@Excel(name = "登陆名")
	@TableField("login_name")
	@ColumnType(length=50)
	@ColumnComment("登录名")
	private String loginName;

	@Excel(name = "用户名")
	@TableField("account_name")
	@ColumnType(length=50)
	@ColumnComment("账户名称")
	private String accountName;

	@TableField("role_power")
	@ColumnType(length=10)
	@ColumnComment("角色权限")
	private String rolePower;
}
