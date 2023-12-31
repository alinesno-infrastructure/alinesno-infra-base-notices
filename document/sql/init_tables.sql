CREATE TABLE `channel_service` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `channel_name` VARCHAR(255) COMMENT '渠道名称',
  `channel_code` VARCHAR(255) COMMENT '渠道代码',
  `channel_status` INT COMMENT '渠道状态',
  `channel_access_count` INT COMMENT '渠道访问量',
  `exception_count` INT COMMENT '异常量',
  `total_request_count` INT COMMENT '总请求量',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='渠道服务类';


CREATE TABLE `notice_send` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` VARCHAR(255) COMMENT '通知状态',
  `content` VARCHAR(255) COMMENT '通知内容',
  `template_id` VARCHAR(255) COMMENT '模板ID',
  `send_time` DATETIME COMMENT '发送时间',
  `exception_time` DATETIME COMMENT '异常时间',
  `recipient` VARCHAR(255) COMMENT '接收人',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通知的基类';


CREATE TABLE `notice_summary` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `total_send_count` INT COMMENT '总发送数量',
  `success_send_count` INT COMMENT '成功发送数量',
  `failure_send_count` INT COMMENT '发送失败数量',
  `pending_send_count` INT COMMENT '待发送数量',
  `exception_count` INT COMMENT '异常数量',
  `last_send_time` DATETIME COMMENT '最后发送时间',
  `email_count` INT COMMENT '邮件发送数量',
  `sms_count` INT COMMENT '短信发送数量',
  `push_count` INT COMMENT '推送发送数量',
  `wechat_count` INT COMMENT '微信发送数量',
  `total_channel_count` INT COMMENT '总的渠道发送数量',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='统计基类';


CREATE TABLE `notice_template` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `template_code` VARCHAR(255) COMMENT '模板代码',
  `template_name` VARCHAR(255) COMMENT '模板名称',
  `template_content` VARCHAR(255) COMMENT '模板内容',
  `template_type` VARCHAR(255) COMMENT '模板类型',
  `business_type` VARCHAR(255) COMMENT '业务类型',
  `channel` VARCHAR(255) COMMENT '模板所属的渠道',
  `third_party_template_id` VARCHAR(255) COMMENT '第三方模板的关联ID',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通知模板表';


CREATE TABLE `project` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` VARCHAR(255) COMMENT '应用类型',
  `version` VARCHAR(255) COMMENT '应用版本号',
  `name` VARCHAR(255) COMMENT '应用名称',
  `banner` VARCHAR(255) COMMENT '标识图标',
  `icon` VARCHAR(255) COMMENT '应用icon',
  `remark` VARCHAR(255) COMMENT '应用备注',
  `open_key` VARCHAR(255) COMMENT '应用代码',
  `code` VARCHAR(255) COMMENT '应用代码',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Project Entity';


CREATE TABLE `manager_account_record` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_id` BIGINT COMMENT '所属项目',
  `config_id` BIGINT COMMENT '所属配置',
  `operation` VARCHAR(255) COMMENT '操作说明',
  `method_time` BIGINT COMMENT '执行时间',
  `method` VARCHAR(255) COMMENT '类方法',
  `params` TEXT COMMENT '请求参数',
  `method_desc` VARCHAR(255) COMMENT '方法描述',
  `record_type` VARCHAR(255) COMMENT '请求记录类型',
  `ip` VARCHAR(255) COMMENT '服务器IP',
  `url` VARCHAR(255) COMMENT '请求链接',
  `agent` VARCHAR(255) COMMENT '浏览器信息',
  `create_time` DATETIME COMMENT '添加时间',
  `account_id` VARCHAR(255) COMMENT '账户ID',
  `login_name` VARCHAR(255) COMMENT '登陆名',
  `account_name` VARCHAR(255) COMMENT '用户名',
  `role_power` VARCHAR(255) COMMENT '角色权限',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户操作记录和请求记录';


CREATE TABLE `strategy` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `strategy_name` VARCHAR(255) COMMENT '策略名称',
  `strategy_id` VARCHAR(255) COMMENT '策略ID',
  `retry_count` INT COMMENT '重复发送次数',
  `scheduled_task` VARCHAR(255) COMMENT '定时任务',
  `send_batch` VARCHAR(255) COMMENT '发送批次',
  `backup_message` TINYINT(1) COMMENT '消息是否备份',
  `delay_send_time` BIGINT COMMENT '延迟发送时间',
  `enable_alert` TINYINT(1) COMMENT '是否报警',
  `rate_limit` INT COMMENT '限流方式（每分钟发送的条数）',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='发送策略对象';


CREATE TABLE `send_task` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `task_name` VARCHAR(255) COMMENT '任务名称',
  `cron_expression` VARCHAR(255) COMMENT '定时CRON表达式',
  `is_running` TINYINT(1) COMMENT '是否运行',
  `status` VARCHAR(255) COMMENT '运行状态',
  `has_delete` INT COMMENT '是否删除(1删除|0正常|null正常)',
  `delete_manager` VARCHAR(255) COMMENT '删除的人',
  `application_id` BIGINT COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
  `application_name` VARCHAR(64) COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
  `tenant_id` BIGINT COMMENT '所属租户 , 租户权限',
  `field_id` BIGINT COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
  `department_id` BIGINT COMMENT '部门权限: 只能看到自己所在部门的数据',
  `field_prop` VARCHAR(255) COMMENT '字段属性',
  `add_time` DATETIME COMMENT '添加时间',
  `delete_time` DATETIME COMMENT '删除时间',
  `has_status` INT COMMENT '状态(0启用|1禁用)',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` BIGINT COMMENT '操作员 用户权限: 只能看到自己操作的数据',
  `last_update_operator_id` BIGINT COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='发送任务列表';
