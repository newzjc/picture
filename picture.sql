/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.21 : Database - picture
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`picture` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `picture`;

/*Table structure for table `tab_navigation` */

DROP TABLE IF EXISTS `tab_navigation`;

CREATE TABLE `tab_navigation` (
  `nid` int NOT NULL,
  `content` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tab_navigation` */

insert  into `tab_navigation`(`nid`,`content`) values (1,'锦集'),(2,'文章'),(3,'项目'),(4,'画册社'),(5,'信息');

/*Table structure for table `tab_portfolio` */

DROP TABLE IF EXISTS `tab_portfolio`;

CREATE TABLE `tab_portfolio` (
  `pid` int NOT NULL AUTO_INCREMENT COMMENT '作品号',
  `pname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '作品名',
  `view` int DEFAULT '0' COMMENT '观看数',
  `like` int DEFAULT '0' COMMENT '收藏数',
  `comment` int DEFAULT '0' COMMENT '评论数',
  `organization` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组织',
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '作者',
  `img` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '作品路径',
  `date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tab_portfolio` */

insert  into `tab_portfolio`(`pid`,`pname`,`view`,`like`,`comment`,`organization`,`author`,`img`,`date`) values (10,'图一一',1500,800,999,'极光','二点','img/ad/ad1.jpg','2021-06-17 08:50:23'),(11,'图一二',0,0,0,NULL,NULL,'img/ad/ad2.jpg','2021-06-09 08:50:25'),(12,'图一三',0,0,0,NULL,NULL,'img/ad/ad3.jpg','2021-06-15 08:50:28'),(13,'图一四',60,0,0,NULL,NULL,'img/ad/ad4.jpg','2021-06-18 08:50:32'),(14,'图二一',2000,0,0,NULL,NULL,'img/ad/ad5.jpg','2021-06-09 08:50:34'),(15,'图二二',90,0,0,NULL,NULL,'img/ad/ad6.jpg','2021-06-16 08:50:37'),(16,'图二三',0,0,0,NULL,NULL,'img/ad/ad7.jpg','2021-06-15 08:50:40'),(17,'图二四',30,0,0,NULL,NULL,'img/ad/ad8.jpg','2021-06-14 08:50:43'),(18,'图二五',0,0,0,NULL,NULL,'img/ad/ad9.jpg','2021-06-08 08:50:46'),(19,'图七',20,0,0,NULL,NULL,'img/ad/ad10.jpg','2021-06-29 08:50:48'),(20,'图八',0,0,0,NULL,NULL,'img/ad/ad11.jpg','2021-06-15 08:50:53'),(21,'图三一',20,0,0,NULL,NULL,'img/ad/ad12.jpg','2021-06-22 08:50:50'),(22,'图三二',0,0,0,NULL,NULL,'img/ad/ad13.jpg','2021-06-13 08:50:55'),(23,'图三三',0,0,0,NULL,NULL,'img/ad/ad14.jpg','2021-06-17 08:50:53'),(24,'图三四',10,0,0,NULL,NULL,'img/ad/ad15.jpg','2021-06-17 08:51:04'),(25,'图三',0,0,0,NULL,NULL,'img/ad/ad16.jpg','2021-06-17 08:51:05'),(26,'图四',0,0,0,NULL,NULL,NULL,'2021-07-07 12:39:24'),(27,'图五',0,0,0,NULL,NULL,NULL,'2021-07-15 12:39:24'),(28,'图六',0,0,0,NULL,NULL,NULL,'2021-07-07 12:39:24'),(29,'图七',0,0,0,NULL,NULL,NULL,'2021-07-07 12:39:24'),(30,'图八',0,0,0,NULL,NULL,NULL,'2021-07-07 12:39:24'),(31,'图九',0,0,0,NULL,NULL,NULL,'2021-07-07 12:39:24'),(32,'图十',0,0,0,NULL,NULL,NULL,'2021-07-07 12:39:24'),(33,'图十一',0,0,0,NULL,NULL,NULL,'2021-07-07 12:39:24'),(34,'图十二',0,0,0,NULL,NULL,NULL,'2021-07-07 12:39:24'),(35,'图图',0,0,0,NULL,NULL,NULL,'2021-07-07 12:39:24'),(36,'图',0,0,0,NULL,NULL,NULL,'2021-07-07 12:39:24'),(37,'图图图',0,0,0,NULL,NULL,NULL,NULL);

/*Table structure for table `tab_user` */

DROP TABLE IF EXISTS `tab_user`;

CREATE TABLE `tab_user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `statue` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'N',
  `code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tab_user` */

insert  into `tab_user`(`uid`,`username`,`password`,`email`,`statue`,`code`) values (15,'张三','123456zjc','111111@qq.com','N',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
