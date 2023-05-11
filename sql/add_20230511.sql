

CREATE TABLE `tag_label_type` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tag_label` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '标签',
  `tag_value` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '标签值',
  `create_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dict_type` (`tag_value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='标签配置';


CREATE TABLE `tag_label_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sort` int(4) DEFAULT '0' COMMENT '排序',
  `type_label` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT 'type编码',
  `data_value` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '字典键值',
  `data_label` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '字典类型',
  `create_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='标签数据表';


-- `rouyi-vue`.tag_data_node definition

CREATE TABLE `tag_data_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sort` int(4) DEFAULT '0' COMMENT '排序',
  `data_label` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '上级data标签',
  `node_value` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '节点值',
  `node_type` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '节点类型price:金额,pic:图片,name:名称,info:介绍,original_price:原价；url:跳转地址,num:下单量',
  `create_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='标签数据表';


