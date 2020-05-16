/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-05-16 10:55:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` int(11) NOT NULL,
  `bname` varchar(255) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'Java从入门到放弃', '50');
INSERT INTO `book` VALUES ('2', 'jvm', '100');
