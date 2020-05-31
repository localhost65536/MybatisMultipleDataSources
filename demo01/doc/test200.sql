/*
 Navicat Premium Data Transfer

 Source Server         : mysql8_root
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : test200

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 13/05/2020 17:38:27
*/



-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32)  DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB ;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'zhangsan');
INSERT INTO `tb_user` VALUES (2, 'lisi');
INSERT INTO `tb_user` VALUES (3, 'wangwu');
INSERT INTO `tb_user` VALUES (4, 'zhaoliu');

SET FOREIGN_KEY_CHECKS = 1;
