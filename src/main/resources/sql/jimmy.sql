/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jimmy

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-23 23:14:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_resources`;
CREATE TABLE `sys_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `res_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `res_type` varchar(255) DEFAULT NULL COMMENT '资源类型[menu|button]',
  `res_url` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `parent_id` int(11) DEFAULT NULL COMMENT '父编号',
  `available` int(1) DEFAULT NULL COMMENT '是否可用',
  `res_sort` int(3) DEFAULT NULL COMMENT '排序值',
  `tenant_id` bigint(11) DEFAULT NULL COMMENT '租户ID',
  `is_enable` bigint(1) NOT NULL DEFAULT '1' COMMENT '是否删除 1正常 0删除',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resources
-- ----------------------------
INSERT INTO `sys_resources` VALUES ('1', '系统管理', 'menu', null, null, '1', '1', '1', '1', '2018-08-23 13:34:48', '1', '2018-08-23 13:34:54', '1');
INSERT INTO `sys_resources` VALUES ('2', '用户管理', 'menu', null, null, '1', '2', '1', '1', '2018-08-23 13:36:10', '1', '2018-08-23 13:36:10', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `available` tinyint(1) DEFAULT NULL COMMENT '是否可用',
  `tenant_id` bigint(11) DEFAULT NULL COMMENT '租户ID',
  `is_enable` bigint(1) NOT NULL DEFAULT '1' COMMENT '是否删除 1正常 0删除',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '1', '1', '1', '2018-08-23 13:33:03', '1', '2018-08-23 13:33:09', '1');
INSERT INTO `sys_role` VALUES ('2', '系统管理员', '1', '1', '1', '2018-08-23 13:33:03', '1', '2018-08-23 13:33:09', '1');

-- ----------------------------
-- Table structure for sys_role_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resources`;
CREATE TABLE `sys_role_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resources_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `tenant_id` bigint(11) DEFAULT NULL COMMENT '租户ID',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_resources
-- ----------------------------
INSERT INTO `sys_role_resources` VALUES ('1', '1', '1', '1', '2018-08-23 13:59:46', '1', '2018-08-23 13:59:53', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `username` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) DEFAULT NULL COMMENT '密码盐',
  `state` bigint(1) DEFAULT NULL COMMENT '账号状态',
  `tenant_id` bigint(11) DEFAULT NULL COMMENT '租户ID',
  `is_enable` bigint(1) NOT NULL DEFAULT '1' COMMENT '是否删除 1正常 0删除',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '超级管理员', 'admin', '1', 'admin', '1', '1', '1', '2018-08-23 13:31:54', '1', '2018-08-23 13:31:54', '1');
INSERT INTO `sys_user` VALUES ('2', '王忠元', 'jimmy', '1', 'jimmy', '1', '1', '1', '2018-08-23 13:31:58', null, '2018-08-23 13:31:58', null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `tenant_id` bigint(11) DEFAULT NULL COMMENT '租户ID',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', '1', '2018-08-23 13:56:41', '1', '2018-08-23 13:56:47', '1');
