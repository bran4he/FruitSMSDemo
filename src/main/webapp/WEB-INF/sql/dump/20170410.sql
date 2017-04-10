-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: localhost    Database: ebaodemo
-- ------------------------------------------------------
-- Server version	5.6.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_assign`
--

DROP TABLE IF EXISTS `t_assign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_assign` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `slavePhone` varchar(100) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT NULL,
  `slaveName` varchar(100) DEFAULT NULL,
  `isVirtual` tinyint(1) DEFAULT NULL,
  `initialUnit` int(10) NOT NULL,
  `balanceUnit` int(10) NOT NULL,
  `wechatOpenid` varchar(100) DEFAULT NULL,
  `effectivePeriod` int(10) NOT NULL,
  `expireDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(200) DEFAULT NULL,
  `extendData` varchar(1000) DEFAULT NULL,
  `insertDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `insertBy` varchar(20) DEFAULT 'admin',
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateBy` varchar(20) DEFAULT 'admin',
  PRIMARY KEY (`id`),
  UNIQUE KEY `slaveKey` (`slavePhone`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_assign`
--

LOCK TABLES `t_assign` WRITE;
/*!40000 ALTER TABLE `t_assign` DISABLE KEYS */;
INSERT INTO `t_assign` VALUES (1,'15692132432',1,'收礼人小何',0,10,3,'QWERTYUIOP',3,'2017-04-10 06:04:47','remark','ext data','2017-03-01 16:00:00','admin','2017-04-10 07:06:53','unknown'),(2,'2',0,'虚拟收礼人lee',1,10,10,'NA',3,'2020-03-19 16:00:00','remark','ext data','2017-03-01 16:00:00','admin','2017-03-01 16:00:00','admin');
/*!40000 ALTER TABLE `t_assign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_assign_detail`
--

DROP TABLE IF EXISTS `t_assign_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_assign_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `assignId` int(5) NOT NULL,
  `unitUpdate` int(10) NOT NULL,
  `masterPhone` varchar(100) DEFAULT NULL,
  `masterName` varchar(100) DEFAULT NULL,
  `slavePhone` varchar(100) DEFAULT NULL,
  `slaveName` varchar(100) DEFAULT NULL,
  `isVirtual` tinyint(1) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `insertDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `insertBy` varchar(20) DEFAULT 'admin',
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateBy` varchar(20) DEFAULT 'admin',
  PRIMARY KEY (`id`),
  KEY `assignId` (`assignId`),
  CONSTRAINT `t_assign_detail_ibfk_1` FOREIGN KEY (`assignId`) REFERENCES `t_assign` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_assign_detail`
--

LOCK TABLES `t_assign_detail` WRITE;
/*!40000 ALTER TABLE `t_assign_detail` DISABLE KEYS */;
INSERT INTO `t_assign_detail` VALUES (1,1,10,'13045610339','送礼人小张','15692132432','收礼人小何',0,'小张来打电话给我们','2017-03-01 16:00:00','admin','2017-03-01 16:00:00','admin'),(2,1,10,'18712367445','送礼人小李','2','虚拟收礼人lee',1,'收礼人是虚拟号码','2017-03-01 16:00:00','admin','2017-03-01 16:00:00','admin');
/*!40000 ALTER TABLE `t_assign_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_fruit_config`
--

DROP TABLE IF EXISTS `t_fruit_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_fruit_config` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fruitName` varchar(100) NOT NULL,
  `fruitArea` varchar(100) NOT NULL,
  `fruitMonth` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `maxOrderDay` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `maxOrderNum` int(10) NOT NULL,
  `maxProvNum` int(10) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `extendData` varchar(1000) DEFAULT NULL,
  `insertDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `insertBy` varchar(20) DEFAULT 'admin',
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateBy` varchar(20) DEFAULT 'admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_fruit_config`
--

LOCK TABLES `t_fruit_config` WRITE;
/*!40000 ALTER TABLE `t_fruit_config` DISABLE KEYS */;
INSERT INTO `t_fruit_config` VALUES (1,'apple','shanghai','2017-03-01 16:00:00','2017-04-24 16:00:00',5,99,'this is remark','{name:\"tom\"}','2017-03-01 16:00:00','admin','2017-03-01 16:00:00','admin'),(2,'香蕉','shanghai','2017-02-01 16:00:00','2017-02-24 16:00:00',5,99,'this is remark','{name:\"jack\"}','2017-02-01 16:00:00','admin','2017-02-01 16:00:00','admin'),(3,'芒果','菲律宾','2017-04-09 16:00:00','2017-04-28 16:00:00',2,100,'default_remark','{name:value}','2017-04-10 07:04:55','unknown','2017-04-10 07:04:55','unknown');
/*!40000 ALTER TABLE `t_fruit_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_login_log`
--

DROP TABLE IF EXISTS `t_login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_login_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) NOT NULL,
  `loginDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `loginIP` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `t_login_log_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_login_log`
--

LOCK TABLES `t_login_log` WRITE;
/*!40000 ALTER TABLE `t_login_log` DISABLE KEYS */;
INSERT INTO `t_login_log` VALUES (1,1,'2017-03-21 16:00:00','127.0.0.1'),(2,1,'2017-03-23 03:56:58','0:0:0:0:0:0:0:1'),(3,1,'2017-03-23 05:20:22','0:0:0:0:0:0:0:1'),(4,1,'2017-03-24 02:00:45','0:0:0:0:0:0:0:1'),(5,1,'2017-03-24 02:06:30','0:0:0:0:0:0:0:1'),(6,1,'2017-03-24 02:08:07','0:0:0:0:0:0:0:1'),(7,1,'2017-03-24 03:52:58','0:0:0:0:0:0:0:1'),(8,1,'2017-03-24 06:18:40','0:0:0:0:0:0:0:1'),(9,1,'2017-03-24 06:46:17','0:0:0:0:0:0:0:1'),(10,1,'2017-03-24 09:23:15','0:0:0:0:0:0:0:1'),(11,1,'2017-03-24 13:25:55','0:0:0:0:0:0:0:1'),(12,1,'2017-03-24 15:00:50','0:0:0:0:0:0:0:1'),(13,1,'2017-03-27 01:45:55','0:0:0:0:0:0:0:1'),(14,1,'2017-03-27 02:20:50','0:0:0:0:0:0:0:1'),(15,1,'2017-03-27 03:46:34','0:0:0:0:0:0:0:1'),(16,1,'2017-03-27 03:48:02','0:0:0:0:0:0:0:1'),(17,1,'2017-03-27 03:54:20','0:0:0:0:0:0:0:1'),(18,1,'2017-03-27 04:00:47','0:0:0:0:0:0:0:1'),(19,1,'2017-03-27 04:01:31','0:0:0:0:0:0:0:1'),(20,1,'2017-03-27 04:02:44','0:0:0:0:0:0:0:1'),(21,1,'2017-03-27 04:03:15','0:0:0:0:0:0:0:1'),(22,1,'2017-03-27 05:45:44','0:0:0:0:0:0:0:1'),(23,1,'2017-03-27 05:46:57','0:0:0:0:0:0:0:1'),(24,1,'2017-03-27 05:47:39','0:0:0:0:0:0:0:1'),(25,1,'2017-03-27 05:48:06','0:0:0:0:0:0:0:1'),(26,1,'2017-03-27 09:01:19','0:0:0:0:0:0:0:1'),(27,1,'2017-03-27 10:04:00','0:0:0:0:0:0:0:1'),(28,1,'2017-03-28 01:52:45','0:0:0:0:0:0:0:1'),(29,1,'2017-03-28 02:57:40','0:0:0:0:0:0:0:1'),(30,15,'2017-03-28 02:59:13','0:0:0:0:0:0:0:1'),(31,1,'2017-03-28 03:16:48','0:0:0:0:0:0:0:1'),(32,1,'2017-03-28 05:21:59','0:0:0:0:0:0:0:1'),(33,1,'2017-03-28 07:10:09','0:0:0:0:0:0:0:1'),(34,1,'2017-03-29 03:22:24','0:0:0:0:0:0:0:1'),(35,1,'2017-03-29 03:33:30','0:0:0:0:0:0:0:1'),(36,15,'2017-03-29 03:33:53','0:0:0:0:0:0:0:1'),(37,1,'2017-03-29 06:24:04','0:0:0:0:0:0:0:1'),(38,15,'2017-03-29 06:51:41','0:0:0:0:0:0:0:1'),(39,1,'2017-03-29 07:47:45','0:0:0:0:0:0:0:1'),(40,15,'2017-03-29 07:48:44','172.18.29.132'),(41,1,'2017-03-29 07:53:53','172.18.29.132'),(42,15,'2017-03-29 07:54:07','172.18.3.6'),(43,1,'2017-03-29 09:02:15','0:0:0:0:0:0:0:1'),(44,15,'2017-03-29 09:58:10','172.18.3.6'),(45,1,'2017-03-30 02:12:07','0:0:0:0:0:0:0:1'),(46,1,'2017-03-30 02:34:57','0:0:0:0:0:0:0:1'),(47,1,'2017-03-30 05:26:09','0:0:0:0:0:0:0:1'),(48,1,'2017-03-30 06:15:11','0:0:0:0:0:0:0:1'),(49,1,'2017-03-30 09:42:47','0:0:0:0:0:0:0:1'),(50,1,'2017-03-30 09:59:49','0:0:0:0:0:0:0:1'),(51,1,'2017-03-30 10:36:56','0:0:0:0:0:0:0:1'),(52,1,'2017-03-31 03:55:19','0:0:0:0:0:0:0:1'),(53,1,'2017-03-31 07:05:13','0:0:0:0:0:0:0:1'),(54,1,'2017-03-31 07:16:22','0:0:0:0:0:0:0:1');
/*!40000 ALTER TABLE `t_login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `statusId` int(5) NOT NULL,
  `assignId` int(10) NOT NULL,
  `fruitId` int(10) NOT NULL,
  `fruitName` varchar(100) NOT NULL,
  `orderUnit` int(10) NOT NULL,
  `planDeliveryDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `address` varchar(100) NOT NULL,
  `contactName` varchar(100) NOT NULL,
  `contactPhone` varchar(100) NOT NULL,
  `deliveryDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `deliveryBy` varchar(100) DEFAULT NULL,
  `deliveryRemark` varchar(100) DEFAULT NULL,
  `finishDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `finishBy` varchar(100) DEFAULT NULL,
  `finishRemark` varchar(100) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `extendData` varchar(1000) DEFAULT NULL,
  `insertDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `insertBy` varchar(20) DEFAULT 'admin',
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateBy` varchar(20) DEFAULT 'admin',
  PRIMARY KEY (`id`),
  KEY `statusId` (`statusId`),
  KEY `assignId` (`assignId`),
  KEY `fruitId` (`fruitId`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`statusId`) REFERENCES `t_order_status` (`id`),
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`assignId`) REFERENCES `t_assign` (`id`),
  CONSTRAINT `t_order_ibfk_3` FOREIGN KEY (`fruitId`) REFERENCES `t_fruit_config` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (1,2,1,1,'apple',5,'2017-04-01 16:00:00','中国上海市淞沪路270号创智天地广场3号楼','王小二','15888888888','2017-04-11 16:00:00','京东李大宝','货到付款','2017-04-12 16:00:00','张小妹','放在前台','remark','ext data','2017-03-01 16:00:00','admin','2017-03-01 16:00:00','admin'),(2,1,1,1,'apple',2,'2017-04-17 07:06:53','中国上海市杨浦区大学城','tom','13045610339','2017-04-17 07:06:53','DeliveryBy','DeliveryRemark','2017-04-17 07:06:53','FinishBy','FinishRemark','remark','extdata','2017-04-10 07:06:53','unknown','2017-04-10 07:06:53','unknown');
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_address`
--

DROP TABLE IF EXISTS `t_order_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_address` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `contactName` varchar(50) NOT NULL,
  `contactPhone` varchar(100) NOT NULL,
  `wechatOpenid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_address`
--

LOCK TABLES `t_order_address` WRITE;
/*!40000 ALTER TABLE `t_order_address` DISABLE KEYS */;
INSERT INTO `t_order_address` VALUES (1,'中国上海市淞沪路270号创智天地广场3号楼','张晓霞','15888888888','QWERTYUIOP'),(2,'中国上海市大渡河路138弄长风公园','李大庄','13056721342','QWERTYUIOP'),(3,'中国上海市杨浦区大学城','tom','13045610339','QWERTYUIOP');
/*!40000 ALTER TABLE `t_order_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_status`
--

DROP TABLE IF EXISTS `t_order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_status` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `insertDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `insertBy` varchar(20) DEFAULT 'admin',
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateBy` varchar(20) DEFAULT 'admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_status`
--

LOCK TABLES `t_order_status` WRITE;
/*!40000 ALTER TABLE `t_order_status` DISABLE KEYS */;
INSERT INTO `t_order_status` VALUES (1,'待派送','2017-04-10 02:55:44','admin','2017-04-10 02:55:44','admin'),(2,'派送中','2017-04-10 02:55:45','admin','2017-04-10 02:55:45','admin'),(3,'派送成功','2017-04-10 02:55:45','admin','2017-04-10 02:55:45','admin'),(4,'用户取消','2017-04-10 02:55:45','admin','2017-04-10 02:55:45','admin'),(5,'派送失败','2017-04-10 02:55:45','admin','2017-04-10 02:55:45','admin');
/*!40000 ALTER TABLE `t_order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pub_config`
--

DROP TABLE IF EXISTS `t_pub_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pub_config` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `value` varchar(20) NOT NULL,
  `remark` varchar(20) NOT NULL,
  `insertDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `insertBy` varchar(20) DEFAULT 'admin',
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateBy` varchar(20) DEFAULT 'admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pub_config`
--

LOCK TABLES `t_pub_config` WRITE;
/*!40000 ALTER TABLE `t_pub_config` DISABLE KEYS */;
INSERT INTO `t_pub_config` VALUES (1,'ORDER_DAY_TO','25','最大的不可下订单日期','2017-04-10 02:26:52','admin','2017-04-10 02:26:52','admin'),(2,'RECEIVER_EFF_YEAR','3','收礼人账户建立后的默认有效期','2017-04-10 02:26:52','admin','2017-04-10 02:26:52','admin');
/*!40000 ALTER TABLE `t_pub_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `insertDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `insertBy` varchar(20) DEFAULT 'admin',
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateBy` varchar(20) DEFAULT 'admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','admin','admin@admin.com','2017-03-23 03:08:14','admin','2017-03-23 03:08:14','admin'),(15,'test','test','test@test.com','2017-03-28 02:16:15','admin','2017-03-28 02:16:15','admin'),(25,'guang','guang','guangjun_li@126.com','2017-03-29 07:57:16','test','2017-03-29 07:57:16','test');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-10 17:05:06
