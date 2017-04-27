-- MySQL dump 10.13  Distrib 5.7.18, for macos10.12 (x86_64)
--
-- Host: localhost    Database: ebaodemo
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `T_ORDER_ADDRESS`
--

DROP TABLE IF EXISTS `T_ORDER_ADDRESS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_ORDER_ADDRESS` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `contactName` varchar(50) NOT NULL,
  `contactPhone` varchar(100) NOT NULL,
  `wechatOpenid` varchar(100) DEFAULT NULL,
  `defaultAddr` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `T_ORDER_ADDRESS`
--

LOCK TABLES `T_ORDER_ADDRESS` WRITE;
/*!40000 ALTER TABLE `T_ORDER_ADDRESS` DISABLE KEYS */;
INSERT INTO `T_ORDER_ADDRESS` VALUES (1,'中国上海市淞沪路270号创智天地广场3号楼','张晓霞','15888888888','QWERTYUIOP',0),(2,'中国上海市大渡河路138弄长风公园','李大庄','13056721342','QWERTYUIOP',1),(3,'美国华盛顿州金色大街','jack','01088888','QWERTYUIOP',0),(4,'小黄2的家','小黄2','13122223333','QWERTYUIOP',0);
/*!40000 ALTER TABLE `T_ORDER_ADDRESS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `T_PUB_CONFIG`
--

DROP TABLE IF EXISTS `T_PUB_CONFIG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `T_PUB_CONFIG` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `value` varchar(200) NOT NULL,
  `remark` varchar(100) NOT NULL,
  `insertDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `insertBy` varchar(20) DEFAULT 'admin',
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateBy` varchar(20) DEFAULT 'admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `T_PUB_CONFIG`
--

LOCK TABLES `T_PUB_CONFIG` WRITE;
/*!40000 ALTER TABLE `T_PUB_CONFIG` DISABLE KEYS */;
INSERT INTO `T_PUB_CONFIG` VALUES (1,'ORDER_DAY_TO','30','最大的不可下订单日期','2017-04-24 11:18:21','admin','2017-04-24 11:18:21','admin'),(2,'RECEIVER_EFF_YEAR','3','收礼人账户建立后的默认有效期','2017-04-24 11:18:21','admin','2017-04-24 11:18:21','admin'),(3,'WECHAT_SERVER_URL','http://localhost:8090/TryNewFruit/','微信后台的地址用于调用发短信接口','2017-04-24 11:18:21','admin','2017-04-24 12:29:00','test'),(4,'RECIVER_SMS_CONTENT','亲爱的用户，恭喜您收到水果啦，请到微信公众号xxx激活手机号并领取水果。','用户分配到水果后收到的短信内容','2017-04-24 11:18:21','admin','2017-04-24 11:18:21','admin');
/*!40000 ALTER TABLE `T_PUB_CONFIG` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `t_assign` VALUES (1,'15692132432',1,'收礼人小何',0,10,27,'QWERTYUIOP',3,'2020-03-19 16:00:00','remark','ext data','2017-03-01 16:00:00','admin','2017-04-27 11:58:03','unknown'),(2,'2',0,'虚拟收礼人lee',1,10,10,'NA',3,'2020-03-19 16:00:00','remark','ext data','2017-03-01 16:00:00','admin','2017-03-01 16:00:00','admin');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_assign_detail`
--

LOCK TABLES `t_assign_detail` WRITE;
/*!40000 ALTER TABLE `t_assign_detail` DISABLE KEYS */;
INSERT INTO `t_assign_detail` VALUES (1,1,10,'13045610339','送礼人小张','15692132432','收礼人小何',0,'小张来打电话给我们','2017-03-01 16:00:00','admin','2017-03-01 16:00:00','admin'),(2,1,10,'18712367445','送礼人小李','2','虚拟收礼人lee',1,'收礼人是虚拟号码','2017-03-01 16:00:00','admin','2017-03-01 16:00:00','admin'),(3,1,1,'111','111','15692132432','xiaohe',0,'111','2017-04-23 13:38:37','test','2017-04-23 13:38:37','test'),(4,1,1,'111','111','15692132432','xiaoxiaohe',0,'222','2017-04-23 13:42:31','test','2017-04-23 13:42:31','test'),(5,1,1,'222','222','15692132432','xiaohe3',0,'333','2017-04-24 11:26:51','test','2017-04-24 11:26:51','test'),(6,1,1,'44','44','15692132432','XIAOHE4',0,'444','2017-04-24 12:09:00','test','2017-04-24 12:09:00','test'),(7,1,1,'55','55','15692132432','xiaohe5',0,'555','2017-04-24 12:23:47','test','2017-04-24 12:23:47','test'),(8,1,6,'666','666','15692132432','xiaohe6',0,'666','2017-04-24 12:28:21','test','2017-04-24 12:28:21','test'),(9,1,7,'777','777','15692132432','xiaohe7',0,'777','2017-04-24 12:29:39','test','2017-04-24 12:29:39','test'),(10,1,8,'88','88','15692132432','xiaohe8',0,'88','2017-04-24 12:40:14','test','2017-04-24 12:40:14','test');
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
INSERT INTO `t_fruit_config` VALUES (1,'apple','shanghai','2017-04-27 11:54:27','2017-04-29 16:00:00',5,99,'this is remark','{name:\"tom\"}','2017-03-01 16:00:00','admin','2017-03-01 16:00:00','admin'),(2,'香蕉','shanghai','2017-04-13 08:40:47','2017-04-26 13:52:34',5,99,'this is remark','{name:\"jack\"}','2017-02-01 16:00:00','admin','2017-04-26 13:52:34','unknown'),(3,'111','222','2017-04-05 16:00:00','2017-04-05 16:00:00',2,2,'2','2','2017-04-27 01:33:55','unknown','2017-04-27 01:33:55','unknown');
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_login_log`
--

LOCK TABLES `t_login_log` WRITE;
/*!40000 ALTER TABLE `t_login_log` DISABLE KEYS */;
INSERT INTO `t_login_log` VALUES (1,1,'2017-03-21 16:00:00','127.0.0.1'),(2,2,'2017-04-13 08:29:56','0:0:0:0:0:0:0:1'),(3,2,'2017-04-20 03:06:25','0:0:0:0:0:0:0:1'),(4,2,'2017-04-20 05:04:49','0:0:0:0:0:0:0:1'),(5,2,'2017-04-20 10:53:04','0:0:0:0:0:0:0:1'),(6,2,'2017-04-23 13:37:14','0:0:0:0:0:0:0:1'),(7,2,'2017-04-23 13:42:04','0:0:0:0:0:0:0:1'),(8,2,'2017-04-24 11:26:12','0:0:0:0:0:0:0:1'),(9,2,'2017-04-24 12:08:32','0:0:0:0:0:0:0:1'),(10,2,'2017-04-24 12:23:21','0:0:0:0:0:0:0:1'),(11,2,'2017-04-24 12:26:46','0:0:0:0:0:0:0:1'),(12,2,'2017-04-24 12:39:48','0:0:0:0:0:0:0:1'),(13,2,'2017-04-26 08:57:48','0:0:0:0:0:0:0:1'),(14,2,'2017-04-26 11:57:58','0:0:0:0:0:0:0:1'),(15,2,'2017-04-26 12:07:38','0:0:0:0:0:0:0:1'),(16,2,'2017-04-26 12:15:29','0:0:0:0:0:0:0:1'),(17,2,'2017-04-26 12:16:02','0:0:0:0:0:0:0:1');
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
  `slaveName` varchar(100) DEFAULT NULL,
  `slavePhone` varchar(100) DEFAULT NULL,
  `assignId` int(10) NOT NULL,
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
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`statusId`) REFERENCES `t_order_status` (`id`),
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`assignId`) REFERENCES `t_assign` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (1,3,'收礼人小何','15692132432',1,'2017-04-27 09:31:03','中国上海市淞沪路270号创智天地广场3号楼','王小二','15888888888','2017-04-11 16:00:00','京东李大宝','货到付款','2017-04-12 16:00:00','张小妹','放在前台','remark','ext data','2017-03-01 16:00:00','admin','2017-03-01 16:00:00','admin'),(2,1,'收礼人小何','15692132432',1,'2017-04-27 09:31:05','浦东新区新桥镇','jacky chen','15689065432','2017-04-20 08:41:03','DeliveryBy','DeliveryRemark','2017-04-20 08:41:03','FinishBy','FinishRemark','记录下','extdata','2017-04-13 08:41:03','unknown','2017-04-27 09:30:27','unknown'),(3,1,'收礼人小何','15692132432',1,'2017-05-04 11:54:42','小黄2的家','小黄2','13122223333','2017-05-04 11:54:42','DeliveryBy','DeliveryRemark','2017-05-04 11:54:42','FinishBy','FinishRemark','default_remark','extdata','2017-04-27 11:54:42','unknown','2017-04-27 11:54:42','unknown'),(4,1,'收礼人小何','15692132432',1,'2017-05-04 11:58:03','小黄2的家','小黄2','13122223333','2017-05-04 11:58:03','DeliveryBy','DeliveryRemark','2017-05-04 11:58:03','FinishBy','FinishRemark','default_remark','extdata','2017-04-27 11:58:03','unknown','2017-04-27 11:58:03','unknown');
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_detail`
--

DROP TABLE IF EXISTS `t_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fruitId` int(10) NOT NULL,
  `fruitName` varchar(100) NOT NULL,
  `orderId` int(5) NOT NULL,
  `orderUnit` int(10) NOT NULL,
  `insertDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `insertBy` varchar(20) DEFAULT 'admin',
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateBy` varchar(20) DEFAULT 'admin',
  PRIMARY KEY (`id`),
  KEY `orderId` (`orderId`),
  KEY `fruitId` (`fruitId`),
  CONSTRAINT `t_order_detail_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `t_order` (`id`),
  CONSTRAINT `t_order_detail_ibfk_2` FOREIGN KEY (`fruitId`) REFERENCES `t_fruit_config` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_detail`
--

LOCK TABLES `t_order_detail` WRITE;
/*!40000 ALTER TABLE `t_order_detail` DISABLE KEYS */;
INSERT INTO `t_order_detail` VALUES (1,1,'apple',1,5,'2017-04-01 16:00:00','admin','2017-04-01 16:00:00','admin'),(2,1,'apple',2,2,'2017-04-12 16:00:00','unknown','2017-04-12 16:00:00','unknown'),(3,2,'香蕉',2,3,'2017-04-12 16:00:00','unknown','2017-04-12 16:00:00','unknown'),(4,1,'apple',3,2,'2017-04-26 16:00:00','unknown','2017-04-26 16:00:00','unknown'),(5,1,'apple',4,2,'2017-04-26 16:00:00','unknown','2017-04-26 16:00:00','unknown');
/*!40000 ALTER TABLE `t_order_detail` ENABLE KEYS */;
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
INSERT INTO `t_order_status` VALUES (1,'待派送','2017-04-13 04:02:06','admin','2017-04-13 04:02:06','admin'),(2,'派送中','2017-04-13 04:02:07','admin','2017-04-13 04:02:07','admin'),(3,'派送成功','2017-04-13 04:02:07','admin','2017-04-13 04:02:07','admin'),(4,'用户取消','2017-04-13 04:02:07','admin','2017-04-13 04:02:07','admin'),(5,'派送失败','2017-04-13 04:02:07','admin','2017-04-13 04:02:07','admin');
/*!40000 ALTER TABLE `t_order_status` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','admin','admin@admin.com','2017-04-13 04:01:59','admin','2017-04-13 04:01:59','admin'),(2,'test','test','test@test.com','2017-04-13 04:01:59','admin','2017-04-13 04:01:59','admin');
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

-- Dump completed on 2017-04-27 20:05:00
