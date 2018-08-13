/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jimmy

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-13 22:50:23
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `tenant_id` bigint(11) DEFAULT NULL,
  `is_enable` bigint(1) NOT NULL DEFAULT '1',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` bigint(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '12', '12', '12', '12', '1', '1', '1', '2018-08-13 17:53:45', '1', '2018-08-13 17:53:51', '1');
INSERT INTO `sys_user` VALUES ('2', '王忠元', 'admin', null, 'admin', '1', '1', '1', null, null, null, null);
