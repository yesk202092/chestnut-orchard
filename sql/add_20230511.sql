
CREATE TABLE `tag_data_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sort` int(4) DEFAULT '0' COMMENT '排序',
  `node_value` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '节点值',
  `node_type` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '节点类型\r\nprice:金额,pic:图片,name:名称,info:介绍,original_price\r\n:原价；url:跳转地址,num:观看量',
  `create_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `node_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '节点名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='标签数据表';


-- `rouyi-vue`.user_integral_log definition

CREATE TABLE `user_integral_log` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `commission_rate` tinyint(2) DEFAULT '3' COMMENT '分佣比例 百分比',
  `integral` decimal(10,2) DEFAULT '0.00' COMMENT '当前获得积分 消耗为负数，增加为正数',
  `create_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除标识:1删除 0正常',
  `user_no` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户编码',
  `order_no` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单号',
  `integral_source` tinyint(1) DEFAULT '0' COMMENT '积分获取来源 1.推荐 2.登录 3.评论返现 4.下单返现,5,下单消耗 6,结算',
  `integral_seq_no` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '积分流水编码',
  `integral_use_status` tinyint(1) DEFAULT '0' COMMENT '积分：0 获得，1 使用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dict_type` (`integral`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户积分流水';


-- `rouyi-vue`.user_recommend definition

CREATE TABLE `user_recommend` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `commission_rate` tinyint(2) DEFAULT '3' COMMENT '分佣比例 百分比',
  `integral` decimal(10,2) DEFAULT '0.00' COMMENT '1分就是1块钱',
  `create_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '删除标识:1删除 0正常',
  `user_name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称',
  `user_no` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户编码',
  `recommend_code` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐码',
  `accumulate_integral` decimal(10,2) DEFAULT '0.00' COMMENT '累计积分',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dict_type` (`integral`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户分销表';


-- `rouyi-vue`.user_recommend_log definition

CREATE TABLE `user_recommend_log` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `commission_rate` tinyint(2) DEFAULT '3' COMMENT '分佣比例 百分比',
  `create_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '删除标识:1删除 0正常',
  `target_user_name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '被推荐用户名称',
  `target_user_no` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '被推荐用户编码',
  `recommend_code` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐码',
  `target_order_no` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '被推荐人订单号',
  `target_order_sum` decimal(10,2) DEFAULT NULL COMMENT '目标支付金额',
  `integral_seq_no` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '积分流水编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户推荐流水';



