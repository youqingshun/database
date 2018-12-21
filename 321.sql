/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.20 : Database - aa_hzp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`aa_hzp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `aa_hzp`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`id`,`no`,`pwd`,`name`,`email`,`tel`) values (1,'admin','admin','admin','admin@qq.com','13300990092'),(2,'admin020','admin020','管理员','1@qq.com','13204895232');

/*Table structure for table `t_blog` */

DROP TABLE IF EXISTS `t_blog`;

CREATE TABLE `t_blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `infos` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `urls` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `zhaiyao` varchar(255) DEFAULT NULL,
  `picurls` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_blog` */

insert  into `t_blog`(`id`,`title`,`infos`,`time`,`urls`,`type`,`zhaiyao`,`picurls`) values (1,'博客111','的撒点击哦怕是看大盘【ask打开【大嫂派【偶读<br>没多少了怕看大盘【爱上恐怕【打算看的撒<br>的撒空老婆的，哎说【跑得快老婆【】氨氯地平【爱上了的','2018-05-21 09:05:00','picurl/1.jpg','商品介绍','摘要摘要',NULL);

/*Table structure for table `t_items` */

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_items` */

insert  into `t_items`(`id`,`name`,`urls`,`type`,`price`,`infos`,`brand`,`no`,`sells`,`category`) values (1,'SKII神仙水','picurl/2.jpg','护肤',0,'的撒纪录片看到是','直接用','CN001932',42,'护肤'),(2,'YSL口红','picurl/01.jpg','彩妆',0,'<b>刚才猫碰劳了键盘。。。</b>','擦','CN099',32,'美妆');

/*Table structure for table `t_message` */

DROP TABLE IF EXISTS `t_message`;

CREATE TABLE `t_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `infos` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `reply` varchar(255) DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_message` */

insert  into `t_message`(`id`,`infos`,`state`,`reply`,`uid`) values (1,'为什么会打雷下雨','置顶','不知道！！！！',2);

/*Table structure for table `t_news` */

DROP TABLE IF EXISTS `t_news`;

CREATE TABLE `t_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `infos` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `newnum` int(11) DEFAULT NULL,
  `urls` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `zhaiyao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_news` */

insert  into `t_news`(`id`,`title`,`infos`,`time`,`newnum`,`urls`,`category`,`zhaiyao`) values (1,'新闻','撒大苏打','2018-05-21 09:05:32',0,'picurl/1.jpg','财经','喜欢');

/*Table structure for table `t_notice` */

DROP TABLE IF EXISTS `t_notice`;

CREATE TABLE `t_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `infos` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_notice` */

insert  into `t_notice`(`id`,`title`,`infos`,`time`) values (1,'站内公告','<b>站内公告站内公告站内公告站内公告</b>','2018-05-21 09:05:18');

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `itmname` varchar(255) DEFAULT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`uid`,`username`,`itmname`,`price`,`address`,`state`,`postno`,`tel`,`paytype`,`infos`,`urls`,`province`,`city`) values (1,2,'User002','YSL口红*2,SKII神仙水*1,',0,'珠江路地铁站','已发货','392993821890','13099982201','在线支付',NULL,NULL,'江苏省','南京市');

/*Table structure for table `t_pingjia` */

DROP TABLE IF EXISTS `t_pingjia`;

CREATE TABLE `t_pingjia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `infos` varchar(255) DEFAULT NULL,
  `addtime` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `itid` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_pingjia` */

/*Table structure for table `t_shopcar` */

DROP TABLE IF EXISTS `t_shopcar`;

CREATE TABLE `t_shopcar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `urls` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  `cid` bigint(20) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_shopcar` */

insert  into `t_shopcar`(`id`,`urls`,`name`,`num`,`price`,`uid`,`cid`,`state`) values (1,'picurl/01.jpg','YSL口红',1,0,2,2,'OK'),(2,'picurl/2.jpg','SKII神仙水',1,0,2,1,'OK');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `birth` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`no`,`pwd`,`name`,`email`,`tel`,`age`,`birth`,`role`,`address`) values (1,'user0021','111','张三','12@qq.com','111','11','14-09-2013','user1','1123'),(2,'User002','User002','User002',NULL,'User002',NULL,NULL,'user1',NULL);

/*Table structure for table `t_wish` */

DROP TABLE IF EXISTS `t_wish`;

CREATE TABLE `t_wish` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `urls` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  `cid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_wish` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
