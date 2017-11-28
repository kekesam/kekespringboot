/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : springmvc

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2017-11-26 21:03:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for keke_user
-- ----------------------------
DROP TABLE IF EXISTS `keke_user`;
CREATE TABLE `keke_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `intro` varchar(600) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `province` varchar(10) DEFAULT NULL,
  `hobbys` varchar(10) DEFAULT NULL,
  `male` int(1) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of keke_user
-- ----------------------------
INSERT INTO `keke_user` VALUES ('1', '徐柯', 'xuke', '123456', '长得帅', '31', '2017-11-26', '10001', '1,2,3', '1', '2017-11-26 14:42:46');
