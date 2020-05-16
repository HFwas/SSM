/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-05-16 10:54:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for money
-- ----------------------------
DROP TABLE IF EXISTS `money`;
CREATE TABLE `money` (
  `uid` int(11) NOT NULL,
  `balance` int(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of money
-- ----------------------------
INSERT INTO `money` VALUES ('1001', '20');
