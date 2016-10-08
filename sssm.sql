/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.6.28-log : Database - sssm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sssm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sssm`;

/*Table structure for table `organization` */

DROP TABLE IF EXISTS `organization`;

CREATE TABLE `organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `code` varchar(64) NOT NULL,
  `icon` varchar(64) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `seq` tinyint(2) NOT NULL,
  `careate_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `organization` */

/*Table structure for table `resource` */

DROP TABLE IF EXISTS `resource`;

CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `url` varchar(64) NOT NULL,
  `description` varchar(64) DEFAULT NULL,
  `resource_type` tinyint(2) NOT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `seq` tinyint(2) NOT NULL,
  `create_time` datetime NOT NULL,
  `status` tinyint(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=227 DEFAULT CHARSET=utf8;

/*Data for the table `resource` */

insert  into `resource`(`id`,`name`,`url`,`description`,`resource_type`,`icon`,`pid`,`seq`,`create_time`,`status`) values (1,'系统管理','','系统管理',0,'icon-company',NULL,0,'2014-02-19 01:00:00',0),(11,'资源管理','/resource/manager','资源管理',0,'icon-folder',1,1,'2014-02-19 01:00:00',0),(12,'角色管理','/role/manager','角色管理',0,'icon-folder',1,2,'2014-02-19 01:00:00',0),(13,'用户管理','/user/manager','用户管理',0,'icon-folder',1,3,'2014-02-19 01:00:00',0),(14,'部门管理','/organization/manager','部门管理',0,'icon-folder',1,4,'2014-02-19 01:00:00',0),(111,'列表','/resource/treeGrid','资源列表',1,'icon-list',11,0,'2014-02-19 01:00:00',0),(112,'添加','/resource/add','资源添加',1,'icon-add',11,0,'2014-02-19 01:00:00',0),(113,'编辑','/resource/edit','资源编辑',1,'icon-edit',11,0,'2014-02-19 01:00:00',0),(114,'删除','/resource/delete','资源删除',1,'icon-del',11,0,'2014-02-19 01:00:00',0),(121,'列表','/role/dataGrid','角色列表',1,'icon-list',12,0,'2014-02-19 01:00:00',0),(122,'添加','/role/add','角色添加',1,'icon-add',12,0,'2014-02-19 01:00:00',0),(123,'编辑','/role/edit','角色编辑',1,'icon-edit',12,0,'2014-02-19 01:00:00',0),(124,'删除','/role/delete','角色删除',1,'icon-del',12,0,'2014-02-19 01:00:00',0),(125,'授权','/role/grant','角色授权',1,'icon-ok',12,0,'2014-02-19 01:00:00',0),(131,'列表','/user/dataGrid','用户列表',1,'icon-list',13,0,'2014-02-19 01:00:00',0),(132,'添加','/user/add','用户添加',1,'icon-add',13,0,'2014-02-19 01:00:00',0),(133,'编辑','/user/edit','用户编辑',1,'icon-edit',13,0,'2014-02-19 01:00:00',0),(134,'删除','/user/delete','用户删除',1,'icon-del',13,0,'2014-02-19 01:00:00',0),(141,'列表','/organization/treeGrid','用户列表',1,'icon-list',14,0,'2014-02-19 01:00:00',0),(142,'添加','/organization/add','部门添加',1,'icon-add',14,0,'2014-02-19 01:00:00',0),(143,'编辑','/organization/edit','部门编辑',1,'icon-edit',14,0,'2014-02-19 01:00:00',0),(144,'删除','/organization/delete','部门删除',1,'icon-del',14,0,'2014-02-19 01:00:00',0),(221,'日志管理','/sysLog/manager',NULL,0,'icon-company',NULL,2,'2015-12-01 11:44:20',0),(222,'视频教程','',NULL,0,'icon-company',NULL,1,'2015-12-06 12:40:42',0),(223,'官方网站','http://www.dreamlu.net/',NULL,0,'icon-folder',222,0,'2015-12-06 12:42:42',0),(224,'jfinal视频','http://blog.dreamlu.net/blog/79',NULL,0,'icon-folder',222,1,'2015-12-06 12:45:28',0),(226,'修改密码','/user/editPwdPage',NULL,1,'icon-edit',NULL,3,'2015-12-07 20:23:06',0);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `seq` tinyint(2) NOT NULL DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `status` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`seq`,`description`,`status`) values (1,'超级管理员',0,'超级管理员',0),(2,'技术部经理',0,'技术部经理',0),(7,'产品部经理',0,'产品部经理',0),(8,'测试账户',0,'测试账户',0);

/*Table structure for table `role_resource` */

DROP TABLE IF EXISTS `role_resource`;

CREATE TABLE `role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=409 DEFAULT CHARSET=utf8;

/*Data for the table `role_resource` */

insert  into `role_resource`(`id`,`role_id`,`resource_id`) values (158,3,1),(159,3,11),(160,3,111),(161,3,112),(162,3,113),(163,3,114),(164,3,12),(165,3,121),(166,3,122),(167,3,123),(168,3,124),(169,3,125),(170,3,13),(171,3,131),(172,3,132),(173,3,133),(174,3,134),(175,3,14),(176,3,141),(177,3,142),(178,3,143),(179,3,144),(349,2,1),(350,2,13),(351,2,131),(352,2,132),(353,2,133),(354,2,222),(355,2,223),(356,2,224),(357,2,221),(358,2,226),(359,7,1),(360,7,14),(361,7,141),(362,7,142),(363,7,143),(364,7,222),(365,7,223),(366,7,224),(367,7,221),(368,7,226),(369,1,1),(370,1,11),(371,1,111),(372,1,112),(373,1,113),(374,1,114),(375,1,12),(376,1,121),(377,1,122),(378,1,123),(379,1,124),(380,1,125),(381,1,13),(382,1,131),(383,1,132),(384,1,133),(385,1,134),(386,1,14),(387,1,141),(388,1,142),(389,1,143),(390,1,144),(391,1,222),(392,1,223),(393,1,224),(394,1,221),(395,1,226),(396,8,1),(397,8,11),(398,8,111),(399,8,12),(400,8,121),(401,8,13),(402,8,131),(403,8,14),(404,8,141),(405,8,222),(406,8,223),(407,8,224),(408,8,221);

/*Table structure for table `syslog` */

DROP TABLE IF EXISTS `syslog`;

CREATE TABLE `syslog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(64) NOT NULL,
  `role_name` varchar(64) NOT NULL,
  `op_content` varchar(100) NOT NULL,
  `client_ip` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `syslog` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `birthday` date DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `age` tinyint(2) DEFAULT NULL,
  `usertype` tinyint(2) NOT NULL,
  `status` tinyint(2) NOT NULL,
  `organization_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`loginname`,`name`,`password`,`birthday`,`sex`,`age`,`usertype`,`status`,`organization_id`,`create_time`,`phone`) values (1,'123','123','123','2016-10-04',1,13,1,0,1,'2016-10-04 00:25:37',NULL),(2,'admin','管理员','098f6bcd4621d373cade4e832627b4f6',NULL,0,25,0,0,1,'2015-12-06 13:14:05','18707173376'),(13,'snoopy','snoopy','098f6bcd4621d373cade4e832627b4f6',NULL,0,25,1,0,3,'2015-10-01 13:12:07','18707173376'),(14,'dreamlu','dreamlu','098f6bcd4621d373cade4e832627b4f6',NULL,0,25,1,0,5,'2015-10-11 23:12:58','18707173376'),(15,'test','test','d41d8cd98f00b204e9800998ecf8427e',NULL,0,25,1,0,6,'2015-12-06 13:13:03','18707173376');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`) values (63,13,2),(64,14,7),(68,1,1),(69,1,2),(70,1,7),(75,15,8);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
