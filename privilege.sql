/*
SQLyog Ultimate v8.32 
MySQL - 8.0.18 : Database - ssm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ssm`;

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(20) NOT NULL,
  `orderTime` varchar(50) DEFAULT NULL,
  `peopleCount` int(11) DEFAULT NULL,
  `orderDesc` varchar(500) DEFAULT NULL,
  `payType` int(11) DEFAULT NULL,
  `orderStatus` int(11) DEFAULT NULL,
  `productId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `orderNum` (`orderNum`),
  KEY `productId` (`productId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`orderNum`,`orderTime`,`peopleCount`,`orderDesc`,`payType`,`orderStatus`,`productId`) values (1,'001','2020-06-20',2,'aaa',0,1,1),(2,'002','2020-06-20 23:55',2,'很好',0,1,1);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productNum` varchar(50) NOT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `cityName` varchar(50) DEFAULT NULL,
  `departureTime` varchar(50) DEFAULT NULL,
  `productPrice` decimal(8,2) DEFAULT NULL,
  `productDesc` varchar(500) DEFAULT NULL,
  `productStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `productNum` (`productNum`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`productNum`,`productName`,`cityName`,`departureTime`,`productPrice`,`productDesc`,`productStatus`) values (1,'1','广州三日游','广州','2020-06-20 15:25','1.00','好玩',1),(5,'2','广州三日游','广州','2020-06-20 15:25','1.00','好玩',1),(6,'3','广州三日游','广州','2020-06-20 15:25','1.00','好玩',1),(7,'4','广州三日游','广州','2020-06-20 15:25','1.00','好玩',1),(8,'5','广州三日游','广州','2020-06-20 15:25','1.00','好玩',1),(9,'6','广州三日游','广州','2020-06-20 15:25','1.00','好玩',1);

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `visitTime` date DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `method` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `sys_log` */

insert  into `sys_log`(`id`,`visitTime`,`username`,`ip`,`method`) values (1,'2020-06-23','dd','127.0.0.1','com.sise.controller.UserController.findAll'),(2,'2020-06-23','ee','127.0.0.1','com.sise.controller.ProductController.findAll'),(3,'2020-06-23','dd','127.0.0.1','com.sise.controller.OrderController.findAll'),(4,'2020-06-23','dd','127.0.0.1','com.sise.controller.OrderController.findAll'),(5,'2020-06-23','dd','127.0.0.1','com.sise.controller.OrderController.findAll'),(6,'2020-06-23','dd','127.0.0.1','com.sise.controller.OrderController.findAll'),(7,'2020-06-23','dd','127.0.0.1','com.sise.controller.ProductController.findAll'),(8,'2020-06-23','dd','127.0.0.1','com.sise.controller.ProductController.findAll'),(9,'2020-06-23','dd','127.0.0.1','com.sise.controller.ProductController.findAll'),(10,'2020-06-23','dd','127.0.0.1','com.sise.controller.ProductController.findAll'),(11,'2020-06-23','dd','127.0.0.1','com.sise.controller.ProductController.findAll'),(12,'2020-06-23','dd','127.0.0.1','com.sise.controller.ProductController.findAll'),(13,'2020-06-24','dd','127.0.0.1','com.sise.controller.ProductController.findAll'),(14,'2020-06-24','admin','127.0.0.1','com.sise.controller.ProductController.findAll'),(15,'2020-06-24','admin','127.0.0.1','com.sise.controller.OrderController.findAll'),(16,'2020-06-24','admin','127.0.0.1','com.sise.controller.ProductController.findAll'),(17,'2020-06-24','admin','127.0.0.1','com.sise.controller.OrderController.findAll'),(18,'2020-06-24','admin','127.0.0.1','com.sise.controller.UserController.findAll'),(19,'2020-06-24','admin','127.0.0.1','com.sise.controller.RoleController.findAll'),(20,'2020-06-24','admin','127.0.0.1','com.sise.controller.RoleController.findAll'),(21,'2020-06-24','admin','127.0.0.1','com.sise.controller.PermissionController.findAll'),(22,'2020-06-24','admin','127.0.0.1','com.sise.controller.RoleController.findAll'),(23,'2020-06-24','admin','127.0.0.1','com.sise.controller.RoleController.addPermissionsToRoleUI'),(24,'2020-06-24','admin','127.0.0.1','com.sise.controller.RoleController.findAll'),(25,'2020-06-24','admin','127.0.0.1','com.sise.controller.PermissionController.findAll'),(26,'2020-06-24','admin','127.0.0.1','com.sise.controller.UserController.findAll'),(27,'2020-06-24','admin','127.0.0.1','com.sise.controller.UserController.addRoleToUserUI'),(28,'2020-06-24','admin','127.0.0.1','com.sise.controller.UserController.findAll'),(29,'2020-06-24','admin','127.0.0.1','com.sise.controller.UserController.details');

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

insert  into `sys_permission`(`id`,`permissionName`,`url`,`pid`) values (1,'系统管理',NULL,0),(2,'订单管理','/order/findAll',1),(3,'产品管理','/product/findAll',2);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) DEFAULT NULL,
  `roleDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`roleName`,`roleDesc`) values (1,'ADMIN','管理员'),(3,'USER','普通用户');

/*Table structure for table `sys_role_permission` */

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `permissionId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`permissionId`,`roleId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `sys_role_permission_ibfk_1` FOREIGN KEY (`permissionId`) REFERENCES `sys_permission` (`id`),
  CONSTRAINT `sys_role_permission_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_permission` */

insert  into `sys_role_permission`(`permissionId`,`roleId`) values (2,1),(3,1),(1,3),(2,3);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(80) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`email`,`PASSWORD`,`phoneNum`,`STATUS`) values (1,'aa','1@qq.com','123','123',0),(2,'bb','cc','456','456',1),(3,'cc','cc@qq.com','111','12323',1),(5,'admin','dd@qq.com','$2a$10$gLNMipDaE.E3.X6jG8BMDuYKwwGuqvh6x.Uha9rsal2FXWb/EG0jy','123',1),(6,'ee','ee@qq.com','$2a$10$SDQNDEIvW0/nToSnHiz9/uwrDfNznNer4ojLqNeh/5rKgeLK24Smy','123',1),(7,'jack','jack@qq.com','$2a$10$i.gRPUxJ8YYoTMufWeABu.MQ17B0ifip43OhteW/wXlNcl0KGI6X.','123',1);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`userId`,`roleId`) values (5,1),(1,3),(5,3),(6,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
