
-- 机构表（名称、头像（1张）、座机、手机号、详细地址） （医生只能通过已确认订单看到机构信息）
DROP TABLE IF EXISTS `t_organization`;
CREATE TABLE `t_organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(100) NOT NULL COMMENT '机构名称',
  `avatar` VARCHAR(100) COMMENT '机构头像',
  `telephone` VARCHAR(20) COMMENT '座机',
  `mobile` VARCHAR(20) COMMENT '手机',
  `address` VARCHAR(1000) COMMENT '详细地址',
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '机构信息';

-- 医生表（姓名、头像、年龄、性别、从业时间、手机号、擅长手术类型（多个）、医师认证-头衔）
DROP TABLE IF EXISTS `t_doctor`;
CREATE TABLE `t_doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(100) NOT NULL COMMENT '医生姓名',
  `avatar` VARCHAR(100) COMMENT '头像',
  `age` INT(3) COMMENT '年龄',
  `gender` INT(1) COMMENT '性别：1-男，0-女',
  `working_years` INT(2) COMMENT '从业时间',
  `mobile` VARCHAR(20) COMMENT '手机',
  `surgery_type` VARCHAR(500) COMMENT '擅长手术类型id（多个以逗号隔开）',
  `doctor_title` VARCHAR(50) COMMENT '医师认证',
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '医生信息';

-- 字典表（常量类型、常量名称、常量描述）
DROP TABLE IF EXISTS `t_dictionary`;
CREATE TABLE `t_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `type` INT(11) NOT NULL COMMENT '常量类型：1-手术类型',
  `name` VARCHAR(50) NOT NULL COMMENT '常量名称',
  `description` VARCHAR(200) COMMENT '描述',
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '字典信息';


-- 手术表（项目名称、手术类别、金额、客户性别、客户身高、客户体重、术前照片（多张）、手术时间）（与订单表1：n）
DROP TABLE IF EXISTS `t_surgery`;
CREATE TABLE `t_surgery` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(200) NOT NULL COMMENT '手术项目名称',
  `type` int(3) NOT NULL COMMENT '手术类型ID',
  `amount` DECIMAL(18,2) NOT NULL COMMENT '手术价格',
  `client_gender` INT(1) NOT NULL DEFAULT 1 COMMENT '客户性别：1-男，0-女',
  `client_height` VARCHAR(10) NOT NULL COMMENT '客户身高：单位cm',
  `client_weight` VARCHAR(10) NOT NULL COMMENT '客户身高：单位kg',
  `preoperative_photos` VARCHAR(1000)  COMMENT '术前照片（多张以逗号隔开)',
  `surgery_time` timestamp not null  COMMENT '手术时间',
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '手术信息';

-- 订单表（手术城市、手术id、机构id、状态（已发布、已接单、已完成、已取消））
DROP TABLE IF EXISTS `t_orders`;
CREATE TABLE `t_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `surgery_id` INT(11) NOT NULL COMMENT '手术id',
  `surgery_city` VARCHAR(20) NOT NULL COMMENT '手术城市',
  `organization_id` INT(11) NOT NULL COMMENT '机构id',
  `status` TINYINT(1) NOT NULL COMMENT '订单状态：1-已发布，2-已接单，3-已完成，4-已取消',
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '订单信息';

-- 订单关联接单医生表（医生id、订单id、状态（选中、未选中））
DROP TABLE IF EXISTS `t_receive_doctor`;
CREATE TABLE `t_receive_doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_id` INT(11) NOT NULL COMMENT '订单id',
  `doctor_id` INT(11) NOT NULL COMMENT '接单医生id',
  `status` TINYINT(1) NOT NULL COMMENT '接单状态：1-被选中，0-未被选中',
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '订单关联接单医生信息';

-- 评价表（订单id、评价内容、评价医生id、评价时间）（订单：评价 1：1）（订单完成以后，医生评价机构）
DROP TABLE IF EXISTS `t_evaluation`;
CREATE TABLE `t_evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_id` INT(11) NOT NULL COMMENT '订单id',
  `doctor_id` INT(11) NOT NULL COMMENT '评价医生id',
  `content` VARCHAR(500) COMMENT '评价内容',
  `evaluate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评价时间',
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '评价信息';

-- 审核表（类型-机构/医生、审核人id、审核人姓名、审核时间、图片1（机构-营业执照；医生-职业资格证）、图片2（机构-卫生许可证；医生-职称证书））
DROP TABLE IF EXISTS `t_check`;
CREATE TABLE `t_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `check_type` INT(1) NOT NULL COMMENT '审核类型：1-机构，2-医生',
  `check_id` INT(11) NOT NULL COMMENT '审核人id-后台用户',
  `check_name` VARCHAR(20) COMMENT '审核人姓名',
  `check_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '审核时间',
  `picture1` VARCHAR(200) COMMENT '图片1（机构-营业执照；医生-职业资格证）',
  `picture2` VARCHAR(200) COMMENT '图片2（机构-卫生许可证；医生-职称证书）',
  `state` INT(1) DEFAULT 0 COMMENT '审核状态：0-待审核，1-已通过',
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '审核信息';

-- 支付表（）TODO


