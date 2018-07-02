-- 医生管理
INSERT INTO cikers.sys_menu (parent_id, name, url, perms, type, icon, order_num)
VALUES (0, '医生管理', null, null, 0, 'fa fa-cog', 10);
set @parentId = @@identity;
-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '医生信息', 'modules/business/doctor.html', NULL, '1', 'fa fa-file-e-o', '6';

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '查看', null, 'business:doctor:list,business:doctor:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '新增', null, 'business:doctor:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '修改', null, 'business:doctor:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '删除', null, 'business:doctor:delete', '2', null, '6';

-- 机构管理
INSERT INTO cikers.sys_menu (parent_id, name, url, perms, type, icon, order_num)
VALUES (0, '机构管理', null, null, 0, 'fa fa-cog', 20);

set @parentId = @@identity;
-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '机构信息', 'modules/business/organization.html', NULL, '1', 'fa fa-file-e-o', '6';

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '查看', null, 'business:organization:list,business:organization:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '新增', null, 'business:organization:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '修改', null, 'business:organization:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '删除', null, 'business:organization:delete', '2', null, '6';

-- 审核管理
-- 菜单SQL
INSERT INTO cikers.sys_menu (parent_id, name, url, perms, type, icon, order_num)
VALUES (0, '审核管理', null, null, 0, 'fa fa-cog', 30);
set @parentId = @@identity;

INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
VALUES (@parentId, '审核信息', 'modules/business/check.html', NULL, '1', 'fa fa-file-e-o', '6');

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '查看', null, 'business:check:list,business:check:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '新增', null, 'business:check:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '修改', null, 'business:check:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '删除', null, 'business:check:delete', '2', null, '6';

-- 订单管理
-- 菜单SQL
INSERT INTO cikers.sys_menu (parent_id, name, url, perms, type, icon, order_num)
VALUES (0, '订单管理', null, null, 0, 'fa fa-cog', 40);
set @parentId = @@identity;

INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
VALUES (@parentId, '订单信息', 'modules/business/orders.html', NULL, '1', 'fa fa-file-e-o', '10');

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '查看', null, 'business:orders:list,business:orders:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '新增', null, 'business:orders:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '修改', null, 'business:orders:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '删除', null, 'business:orders:delete', '2', null, '6';

-- 手术信息
-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
SELECT  (select menu_id from sys_menu where name = '订单管理'),
  '手术信息', 'modules/business/surgery.html', NULL, '1', 'fa fa-file-e-o', '20';

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '查看', null, 'business:surgery:list,business:surgery:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '新增', null, 'business:surgery:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '修改', null, 'business:surgery:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '删除', null, 'business:surgery:delete', '2', null, '6';



-- 订单关联接单医生信息
-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
SELECT (select menu_id from sys_menu where name = '订单管理'),
  '接单医生信息', 'modules/business/receivedoctor.html', NULL, '1', 'fa fa-file-e-o', '30';

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '查看', null, 'business:receivedoctor:list,business:receivedoctor:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '新增', null, 'business:receivedoctor:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '修改', null, 'business:receivedoctor:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '删除', null, 'business:receivedoctor:delete', '2', null, '6';

-- 评价管理
-- 菜单SQL
INSERT INTO cikers.sys_menu (parent_id, name, url, perms, type, icon, order_num)
VALUES (0, '评价管理', null, null, 0, 'fa fa-cog', 50);
set @parentId = @@identity;

INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
VALUES (@parentId, '评价信息', 'modules/business/evaluation.html', NULL, '1', 'fa fa-file-e-o', '6');

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '查看', null, 'business:evaluation:list,business:evaluation:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '新增', null, 'business:evaluation:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '修改', null, 'business:evaluation:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '删除', null, 'business:evaluation:delete', '2', null, '6';

-- 字典管理
-- 菜单SQL
INSERT INTO cikers.sys_menu (parent_id, name, url, perms, type, icon, order_num)
VALUES (0, '字典管理', null, null, 0, 'fa fa-cog', 60);
set @parentId = @@identity;

INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
VALUES (@parentId, '字典信息', 'modules/business/dictionary.html', NULL, '1', 'fa fa-file-e-o', '6');

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '查看', null, 'business:dictionary:list,business:dictionary:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '新增', null, 'business:dictionary:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '修改', null, 'business:dictionary:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
  SELECT @parentId, '删除', null, 'business:dictionary:delete', '2', null, '6';
