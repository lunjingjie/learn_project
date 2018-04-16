/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : strutssshlearn

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2018-04-16 17:44:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(255) NOT NULL,
  `mn` varchar(255) DEFAULT NULL,
  `device_name` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `device_unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `device_id` (`device_id`),
  KEY `mn` (`mn`),
  CONSTRAINT `device_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `history` (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '52820000001MNKPM25', '52820000001MN', 'PM2.5', 'KPM25', 'ug/m3');
INSERT INTO `device` VALUES ('2', '52820000001MNKPM10', '52820000001MN', 'PM10', 'KPM10', 'ug/m3');
INSERT INTO `device` VALUES ('3', '52820000001MNKB01', '52820000001MN', '噪声', 'KB01', '');
INSERT INTO `device` VALUES ('4', '52820000002MNKPM25', '52820000002MN', 'PM2.5', 'KPM25', 'ug/m3');
INSERT INTO `device` VALUES ('5', '52820000002MNKPM10', '52820000002MN', 'PM10', 'KPM10', 'ug/m3');

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enterprise_code` varchar(255) DEFAULT NULL,
  `mn` varchar(255) DEFAULT NULL,
  `enterpridse_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mn` (`mn`),
  CONSTRAINT `enterprise_ibfk_1` FOREIGN KEY (`mn`) REFERENCES `device` (`mn`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise
-- ----------------------------
INSERT INTO `enterprise` VALUES ('1', '52820000001', '52820000001MN', '测试公司1');
INSERT INTO `enterprise` VALUES ('2', '52820000002', '52820000002MN', '测试公司2');

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datatime` datetime DEFAULT NULL,
  `device_id` varchar(255) DEFAULT NULL,
  `data_type` varchar(255) DEFAULT NULL,
  `data_value` varchar(255) DEFAULT NULL,
  `device_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `device_id` (`device_id`),
  CONSTRAINT `history_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `device` (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES ('1', '2018-04-16 16:18:24', '52820000001MNKPM25', 'KPM25', '78.4', 'PM2.5');
INSERT INTO `history` VALUES ('2', '2018-04-16 16:18:24', '52820000001MNKPM10', 'KPM10', '69.5', 'PM10');
INSERT INTO `history` VALUES ('3', '2018-04-16 16:18:24', '52820000001MNKB01', 'KB01', '20.5', '噪声');
INSERT INTO `history` VALUES ('4', '2018-04-16 16:18:24', '52820000002MNKPM25', 'KPM25', '11.1', 'PM2.5');
INSERT INTO `history` VALUES ('5', '2018-04-16 16:18:24', '52820000002MNKPM10', 'KPM10', '22.2', 'PM10');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(20) DEFAULT NULL,
  `resource_path` varchar(200) DEFAULT NULL,
  `resource_icon` varchar(20) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_deleted` varchar(1) DEFAULT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '功能菜单', null, null, '2018-04-09 14:57:33', null, 'N', '0');
INSERT INTO `resource` VALUES ('2', '数据管理', null, null, '2018-04-09 14:57:33', null, 'N', '1');
INSERT INTO `resource` VALUES ('3', '辅助管理', null, null, '2018-04-09 14:57:33', null, 'N', '1');
INSERT INTO `resource` VALUES ('4', '权限管理', null, null, '2018-04-09 14:57:33', null, 'N', '1');
INSERT INTO `resource` VALUES ('5', '实时数据', 'CURRENT', null, '2018-04-09 14:57:33', null, 'N', '2');
INSERT INTO `resource` VALUES ('6', '历史数据', 'HISTORY', null, '2018-04-09 14:57:33', null, 'N', '2');
INSERT INTO `resource` VALUES ('7', '汇总GIS', 'INDEX', null, '2018-04-09 14:57:33', null, 'N', '3');
INSERT INTO `resource` VALUES ('8', '轨迹管理', 'TRACK', null, '2018-04-09 14:57:33', null, 'N', '3');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_desc` varchar(50) DEFAULT NULL,
  `insertTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  `is_deleted` varchar(1) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', null, '2018-04-09 14:50:31', '2018-04-09 14:50:33', 'N');
INSERT INTO `role` VALUES ('2', '用户权限', null, '2018-04-10 09:23:50', '2018-04-10 09:23:52', 'N');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `resource_id` (`resource_id`),
  CONSTRAINT `role_resource_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `role_resource_ibfk_2` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('1', '1', '1');
INSERT INTO `role_resource` VALUES ('2', '1', '2');
INSERT INTO `role_resource` VALUES ('3', '1', '3');
INSERT INTO `role_resource` VALUES ('4', '1', '4');
INSERT INTO `role_resource` VALUES ('5', '1', '5');
INSERT INTO `role_resource` VALUES ('6', '1', '6');
INSERT INTO `role_resource` VALUES ('7', '1', '7');
INSERT INTO `role_resource` VALUES ('8', '1', '8');
INSERT INTO `role_resource` VALUES ('9', '2', '1');
INSERT INTO `role_resource` VALUES ('10', '2', '2');
INSERT INTO `role_resource` VALUES ('11', '2', '5');
INSERT INTO `role_resource` VALUES ('12', '2', '6');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `userPassword` varchar(255) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `isDeleted` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lunjingjie', '123456', '1', null, null, 'N');
INSERT INTO `user` VALUES ('2', 'dami', '1234', '2', null, null, 'N');
INSERT INTO `user` VALUES ('3', '123', '213', '1', null, '2018-04-10 14:40:53', 'Y');
INSERT INTO `user` VALUES ('5', 'cle', '81dc9bdb52d04dc20036dbd8313ed055', '2', null, '2018-04-10 14:24:19', 'N');
INSERT INTO `user` VALUES ('6', '事务测试', '111', '1', null, null, 'N');
INSERT INTO `user` VALUES ('7', '测试MD5', '202cb962ac59075b964b07152d234b70', '1', null, null, 'N');
INSERT INTO `user` VALUES ('8', 'MD5', 'd9b1d7db4cd6e70935368a1efb10e377', '1', null, null, 'N');
INSERT INTO `user` VALUES ('9', 'knicks', 'ec6a6536ca304edf844d1d248a4f08dc', '2', '2018-04-10 11:53:23', null, 'N');
INSERT INTO `user` VALUES ('10', 'testqwe', '827ccb0eea8a706c4c34a16891f84e7b', '2', '2018-04-12 17:23:30', '2018-04-12 17:24:59', 'Y');
