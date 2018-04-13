/*
 Navicat Premium Data Transfer

 Source Server         : g6
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : g6_atm

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 13/04/2018 10:21:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id，自增长',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '0:正常1:锁定2:注销',
  `balance` double(10, 0) NOT NULL DEFAULT 0 COMMENT '账户余额，默认为0',
  `userID` bigint(20) NOT NULL COMMENT '用户id',
  `freezeTimeStamp` timestamp(0) NULL DEFAULT NULL COMMENT '冻结时间戳，三次输入密码错误，修改此字段值为最后输入密码错误时间，冻结时间为24小时',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_ACCOUNT_USER`(`userID`) USING BTREE,
  CONSTRAINT `FK_ACCOUNT_USER` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '账户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '3dc3699f08d283209840eb1423611dd7', 0, 100000, 1, NULL);

-- ----------------------------
-- Table structure for atm
-- ----------------------------
DROP TABLE IF EXISTS `atm`;
CREATE TABLE `atm`  (
  `ATM_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ATM编号,自增长',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ATM客户端系统密码，即客户端登录之后才能使用系统',
  `balance` double(10, 0) NOT NULL DEFAULT 0 COMMENT '余额',
  `balanceLimit` double(10, 0) NOT NULL COMMENT '金额上限',
  `depositable` int(11) NOT NULL DEFAULT 1 COMMENT '是否可存款，1：是，0：否，默认1',
  `withdrawable` int(11) NOT NULL DEFAULT 1 COMMENT '是否可取款，1：是，0：否，默认1',
  `depositLimit` double(10, 0) NOT NULL COMMENT '单次存款上限',
  `withdrawLimit` double(10, 0) NOT NULL COMMENT '单次取款上限',
  `transferLimit` double(10, 0) NOT NULL COMMENT '单次转账上限',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '是否启用，1：是，0：否，默认1',
  PRIMARY KEY (`ATM_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'ATM' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of atm
-- ----------------------------
INSERT INTO `atm` VALUES (1, '123', 500000, 50000, 1, 1, 10000, 10000, 50000, 1);

-- ----------------------------
-- Table structure for buss_log
-- ----------------------------
DROP TABLE IF EXISTS `buss_log`;
CREATE TABLE `buss_log`  (
  `id` bigint(20) NOT NULL COMMENT 'id，自增长',
  `opType` int(11) NOT NULL COMMENT '操作类型，0：取款，1：存款，2：转账',
  `timeStamp` datetime(0) NOT NULL COMMENT '时间戳',
  `userCardNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户卡号',
  `payeeCardNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收款人卡号，业务类型为转账时有效',
  `ATM_ID` bigint(20) NOT NULL COMMENT 'ATM编号',
  `amount` double NOT NULL COMMENT '操作金额',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_LOG_ATM`(`ATM_ID`) USING BTREE,
  INDEX `FK_LOG_USER_CARD`(`userCardNumber`) USING BTREE,
  INDEX `FK_LOG_PAYEE_CARD`(`payeeCardNumber`) USING BTREE,
  CONSTRAINT `FK_LOG_ATM` FOREIGN KEY (`ATM_ID`) REFERENCES `atm` (`ATM_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_LOG_PAYEE_CARD` FOREIGN KEY (`payeeCardNumber`) REFERENCES `card` (`cardNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_LOG_USER_CARD` FOREIGN KEY (`userCardNumber`) REFERENCES `card` (`cardNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '交易记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card`  (
  `cardNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卡号',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '状态，0：有效，1：失效',
  PRIMARY KEY (`cardNumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '银行卡' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('6228481174357860016', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增长',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `birthdate` date NOT NULL COMMENT '出生日期',
  `gender` int(11) NOT NULL COMMENT '性别 0：女1：男',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `ID_Card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `cardNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_USER_CARD`(`cardNumber`) USING BTREE,
  CONSTRAINT `FK_USER_CARD` FOREIGN KEY (`cardNumber`) REFERENCES `card` (`cardNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '溶酶菌', '2018-02-27', 1, '13824865025', '44982199508011234', '6228481174357860016');

SET FOREIGN_KEY_CHECKS = 1;
