/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2019/1/3 21:35:17
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) NOT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `infos` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `itid` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `zhaiyao` varchar(255) DEFAULT NULL,
  `picurls` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`),
  KEY `t_blog_ibfk_1` (`itid`),
  CONSTRAINT `t_blog_ibfk_1` FOREIGN KEY (`itid`) REFERENCES `t_items` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_items
-- ----------------------------
DROP TABLE IF EXISTS `t_items`;
CREATE TABLE `t_items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `urls` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `infos` longtext,
  `brand` varchar(255) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `sells` int(11) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` varchar(255) NOT NULL,
  `infos` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `reply` varchar(255) DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `t_message_ibfk_1` (`uid`),
  CONSTRAINT `t_message_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `infos` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `itid` bigint(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `postno` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `paytype` varchar(255) DEFAULT NULL,
  `infos` varchar(255) DEFAULT NULL,
  `urls` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `t_order_ibfk_1` (`uid`),
  KEY `t_order_ibfk_2` (`itid`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`itid`) REFERENCES `t_items` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_pingjia
-- ----------------------------
DROP TABLE IF EXISTS `t_pingjia`;
CREATE TABLE `t_pingjia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '用户名\r\n',
  `infos` varchar(255) DEFAULT NULL,
  `addtime` varchar(255) DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  `itid` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `t_pingjia_ibfk_1` (`uid`),
  KEY `t_pingjia_ibfk_2` (`itid`),
  CONSTRAINT `t_pingjia_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_pingjia_ibfk_2` FOREIGN KEY (`itid`) REFERENCES `t_items` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `t_shopcar`;
CREATE TABLE `t_shopcar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `urls` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  `itid` bigint(20) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shopcar_ibfk_1` (`uid`),
  KEY `shopcar_ibfk_2` (`itid`),
  CONSTRAINT `shopcar_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `shopcar_ibfk_2` FOREIGN KEY (`itid`) REFERENCES `t_items` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) NOT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birth` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_wish
-- ----------------------------
DROP TABLE IF EXISTS `t_wish`;
CREATE TABLE `t_wish` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `urls` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  `itid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `wish_ibfk_1` (`uid`),
  KEY `wish_ibfk_2` (`itid`),
  CONSTRAINT `wish_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `wish_ibfk_2` FOREIGN KEY (`itid`) REFERENCES `t_items` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin1', '123', '李勇', 'liyong@126.com', '1222222'), ('2', 'admin2', '1234', '王芳', 'wangfang@qq.com', '13333333333');
INSERT INTO `t_notice` VALUES ('2', '天冷请注意保暖', '<i>注意保暖~</i>', '2018-12-13 04:12:29');
INSERT INTO `t_user` VALUES ('1', 'user3', '123', '张杰', '4908@126.com', '489465', '45', '1988-6-5', 'user1', '123'), ('2', 'user1', '123', '李明', '156@qq.com', '156489163', '20', '1998-6-18', 'user1', '123'), ('3', 'user2', '123', '王盘', '156@qq.com', '1648946', '26', '1999-12-5', 'user1', '123');
