/*
Navicat MySQL Data Transfer

Source Server         : hk
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : tutorial

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2019-11-28 18:38:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `realname` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('83418e8a43323a7f9db44a3832f3c4a4', 'yunjisuan', '9bedadbb7771dacacf1a391cf138af43', 'yunjisuan');
INSERT INTO `admin` VALUES ('8b7c870ba5d6aca4a7db06b8e24b295b', 'admin', '7f3d0e8c0d7fba9d0b887a797ede072e', '123');

-- ----------------------------
-- Table structure for `admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `adminId` varchar(36) DEFAULT NULL COMMENT '管理员主键，外键到admin表',
  `roleId` varchar(45) DEFAULT NULL COMMENT '角色主键，外键到role表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('7cde5f8480b77da3000695b6ba80eec2', '83418e8a43323a7f9db44a3832f3c4a4', 'a7909a2f2a720c837efd306df7c62b06');
INSERT INTO `admin_role` VALUES ('cf9045aee0cf9b086381cbf96e71bd89', '8b7c870ba5d6aca4a7db06b8e24b295b', '99c4d7c6bd6405cf69e60b783dbd0d2a');

-- ----------------------------
-- Table structure for `good`
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(45) DEFAULT NULL COMMENT '商品名称',
  `price` double DEFAULT NULL COMMENT '价格',
  `productDate` date DEFAULT NULL COMMENT '生产日期',
  `expiration` int(11) DEFAULT NULL COMMENT '保质期，单位天',
  `production` varchar(45) DEFAULT NULL COMMENT '厂商',
  `goodTypeId` varchar(36) DEFAULT NULL COMMENT '商品类别主键，外键到good_type表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES ('307ec4d461f97d848c8dc05e611eb650', '123', '123', '2019-10-02', '123', '123', '1');
INSERT INTO `good` VALUES ('3d1b415fb4c7909ccb77f24cc819a915', 'hsha', '33.44', '2019-10-02', '33', '33', '1');
INSERT INTO `good` VALUES ('964b4dd1a47d3a637c4ba65abd64f109', 'ajka', '444.66', '2019-10-03', '55', 'bd', '3');
INSERT INTO `good` VALUES ('9863d49348f070e5d0a925beac619133', '华为', '9999', '2019-10-15', '4444', '华为', null);
INSERT INTO `good` VALUES ('c5210fc8bb60f5f75ae973e765d9447a', '小米', '2500', '2019-10-02', '3333', '小米', '1');

-- ----------------------------
-- Table structure for `good_type`
-- ----------------------------
DROP TABLE IF EXISTS `good_type`;
CREATE TABLE `good_type` (
  `id` varchar(36) NOT NULL COMMENT '商品类别主键',
  `name` varchar(45) DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good_type
-- ----------------------------
INSERT INTO `good_type` VALUES ('1', '日常用品');
INSERT INTO `good_type` VALUES ('2', '手机');
INSERT INTO `good_type` VALUES ('3', '笔记本');
INSERT INTO `good_type` VALUES ('4c6bf266cbf88b89d01a1c0d3140707e', 'sjai');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `text` varchar(100) DEFAULT NULL COMMENT '菜单文本',
  `iconCls` varchar(100) DEFAULT NULL COMMENT '菜单css',
  `url` varchar(100) DEFAULT NULL COMMENT '菜单地址',
  `parentId` varchar(36) DEFAULT NULL COMMENT '父菜单主键（外键到菜单表主键）',
  `position` int(11) DEFAULT NULL COMMENT '菜单位置，用于进行菜单排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('23fba606aa56d5554359e646f3d53d89', '商品管理', '', '', '', null);
INSERT INTO `menu` VALUES ('62002756-a664-4d9c-a1c5-cb368b8c3ab1', '菜单管理', '', '/view/right/menu', '765110e1-56f9-4d33-b7f5-68996544a874', '0');
INSERT INTO `menu` VALUES ('68be6612ae987ff983461f9d59b2cbd6', '商品维护', '', '/view/right/role', '23fba606aa56d5554359e646f3d53d89', null);
INSERT INTO `menu` VALUES ('765110e1-56f9-4d33-b7f5-68996544a874', '权限管理', null, null, null, '10');
INSERT INTO `menu` VALUES ('7892b2f2-d439-4476-89cf-27e6127b09ae', '用户管理', '', '/view/right/admin', '765110e1-56f9-4d33-b7f5-68996544a874', '1');
INSERT INTO `menu` VALUES ('b68bd155-d41a-43d1-99ea-f33c1afca2fa', '角色管理', '', '/view/right/role', '765110e1-56f9-4d33-b7f5-68996544a874', '2');
INSERT INTO `menu` VALUES ('ee2c58763eedd5555b87eaddce62c9b2', '商品管理01', '', '/view/index01', '23fba606aa56d5554359e646f3d53d89', '22');
INSERT INTO `menu` VALUES ('f1ed6fda45d7a959598d8618f66081c5', '123', '213', '123', '33cba7341390d72ba6da1af6eb782e36', '1223');
INSERT INTO `menu` VALUES ('fc26a423f8dd47a1bb281366b407db4b', '3432', '23423', null, '123', null);

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(36) NOT NULL COMMENT '角色主键',
  `name` varchar(45) DEFAULT NULL COMMENT '角色名称',
  `code` varchar(45) DEFAULT NULL COMMENT '角色代码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('99c4d7c6bd6405cf69e60b783dbd0d2a', '1', '1');
INSERT INTO `role` VALUES ('a7909a2f2a720c837efd306df7c62b06', '学生', 'XS');

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `roleId` varchar(36) DEFAULT NULL COMMENT '角色主键',
  `menuId` varchar(36) DEFAULT NULL COMMENT '菜单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('2e828fc1b719f722f428f835aa769eb5', '99c4d7c6bd6405cf69e60b783dbd0d2a', '62002756-a664-4d9c-a1c5-cb368b8c3ab1');
INSERT INTO `role_menu` VALUES ('36d7a634af745bb3fe89bd261feb2e44', 'a7909a2f2a720c837efd306df7c62b06', '68be6612ae987ff983461f9d59b2cbd6');
INSERT INTO `role_menu` VALUES ('3e4ef8faa5b9f755e49effab31fb0713', '99c4d7c6bd6405cf69e60b783dbd0d2a', '68be6612ae987ff983461f9d59b2cbd6');
INSERT INTO `role_menu` VALUES ('8c78e48cc562e0c83643594394b710c8', '99c4d7c6bd6405cf69e60b783dbd0d2a', '7892b2f2-d439-4476-89cf-27e6127b09ae');
INSERT INTO `role_menu` VALUES ('a7ed09bd2c952ff11f75f8f42bbd2d8c', '1', '62002756-a664-4d9c-a1c5-cb368b8c3ab1');
INSERT INTO `role_menu` VALUES ('a8911d490e024c5685fa6bd949ecae3c', '99c4d7c6bd6405cf69e60b783dbd0d2a', 'b68bd155-d41a-43d1-99ea-f33c1afca2fa');
INSERT INTO `role_menu` VALUES ('b73ec18b1880f93306545aeb2ea17d42', '99c4d7c6bd6405cf69e60b783dbd0d2a', '23fba606aa56d5554359e646f3d53d89');
INSERT INTO `role_menu` VALUES ('d6e5f1817c047c5f65e58f8dc92523a5', '99c4d7c6bd6405cf69e60b783dbd0d2a', 'ee2c58763eedd5555b87eaddce62c9b2');
INSERT INTO `role_menu` VALUES ('e18c3318896186fcfb1f5c310d529f38', '99c4d7c6bd6405cf69e60b783dbd0d2a', '765110e1-56f9-4d33-b7f5-68996544a874');
INSERT INTO `role_menu` VALUES ('e2cc027eed1613392b02547d431679c9', '1', '765110e1-56f9-4d33-b7f5-68996544a874');
INSERT INTO `role_menu` VALUES ('fb45bac9fe38fbd43821045848736263', 'a7909a2f2a720c837efd306df7c62b06', '23fba606aa56d5554359e646f3d53d89');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('c085ce9a293a9c62c11d5e3d5be96fbf', null, null, null, 'admin', 'admin');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('98a8da0f44db116d9f685e5d6703e1d8', 'jduah', null, '1997-11-11', null, null);
