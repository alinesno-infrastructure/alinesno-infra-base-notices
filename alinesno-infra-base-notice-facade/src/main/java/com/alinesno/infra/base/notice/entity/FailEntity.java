package com.alinesno.infra.base.notice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 失败消息实体
 * @author luoxiaodong
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("notice_fail") // 指定数据库表名
@Data
public class FailEntity extends NoticeSendBaseEntity {
}