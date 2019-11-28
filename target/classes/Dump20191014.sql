-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: tutorial
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `realname` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('83418e8a43323a7f9db44a3832f3c4a4','yunjisuan','9bedadbb7771dacacf1a391cf138af43','yunjisuan'),('8b7c870ba5d6aca4a7db06b8e24b295b','admin','7f3d0e8c0d7fba9d0b887a797ede072e','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_role`
--

DROP TABLE IF EXISTS `admin_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_role` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `adminId` varchar(36) DEFAULT NULL COMMENT '管理员主键，外键到admin表',
  `roleId` varchar(45) DEFAULT NULL COMMENT '角色主键，外键到role表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_role`
--

LOCK TABLES `admin_role` WRITE;
/*!40000 ALTER TABLE `admin_role` DISABLE KEYS */;
INSERT INTO `admin_role` VALUES ('7cde5f8480b77da3000695b6ba80eec2','83418e8a43323a7f9db44a3832f3c4a4','a7909a2f2a720c837efd306df7c62b06'),('cf9045aee0cf9b086381cbf96e71bd89','8b7c870ba5d6aca4a7db06b8e24b295b','99c4d7c6bd6405cf69e60b783dbd0d2a');
/*!40000 ALTER TABLE `admin_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `good`
--

DROP TABLE IF EXISTS `good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `good` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(45) DEFAULT NULL COMMENT '商品名称',
  `price` double DEFAULT NULL COMMENT '价格',
  `productDate` date DEFAULT NULL COMMENT '生产日期',
  `expiration` int(11) DEFAULT NULL COMMENT '保质期，单位天',
  `production` varchar(45) DEFAULT NULL COMMENT '厂商',
  `goodTypeId` varchar(36) DEFAULT NULL COMMENT '商品类别主键，外键到good_type表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good`
--

LOCK TABLES `good` WRITE;
/*!40000 ALTER TABLE `good` DISABLE KEYS */;
INSERT INTO `good` VALUES ('01cda1665cb9f983369c716219d59aaf','小牛n1s',7000,'2019-10-14',365,'小牛','b450d48c1b90e6c0c11ab809439280ef'),('1d7345bcc97e96970372a8a528566adb','猪肉',20,'2019-10-14',2,'双汇','b450d48c1b90e6c0c11ab809439280ef'),('b2fdd7ab4f5311e13664da2d28e7f083','新大洲本田',10000,'2019-10-14',100,'新大洲本田','6046b7f658c724d9c76152123ea8df59');
/*!40000 ALTER TABLE `good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `good_type`
--

DROP TABLE IF EXISTS `good_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `good_type` (
  `id` varchar(36) NOT NULL COMMENT '商品类别主键',
  `name` varchar(45) DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good_type`
--

LOCK TABLES `good_type` WRITE;
/*!40000 ALTER TABLE `good_type` DISABLE KEYS */;
INSERT INTO `good_type` VALUES ('0913f413d5ef9ec9f3e81b0dd483c542','摩托车'),('6046b7f658c724d9c76152123ea8df59','蔬菜'),('b450d48c1b90e6c0c11ab809439280ef','电动车');
/*!40000 ALTER TABLE `good_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `text` varchar(100) DEFAULT NULL COMMENT '菜单文本',
  `iconCls` varchar(100) DEFAULT NULL COMMENT '菜单css',
  `url` varchar(100) DEFAULT NULL COMMENT '菜单地址',
  `parentId` varchar(36) DEFAULT NULL COMMENT '父菜单主键（外键到菜单表主键）',
  `position` int(11) DEFAULT NULL COMMENT '菜单位置，用于进行菜单排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES ('22547e70e095c2cc6420b061813ae3e8','商品维护','','','',NULL),('3c8f99d1f8125fac29c6cc89cca01c4c','商品管理','','/view/commerce/good','22547e70e095c2cc6420b061813ae3e8',NULL),('62002756-a664-4d9c-a1c5-cb368b8c3ab1','菜单管理','','/view/right/menu','765110e1-56f9-4d33-b7f5-68996544a874',0),('765110e1-56f9-4d33-b7f5-68996544a874','权限管理',NULL,NULL,NULL,10),('7892b2f2-d439-4476-89cf-27e6127b09ae','用户管理','','/view/right/admin','765110e1-56f9-4d33-b7f5-68996544a874',1),('9bbeeddc8b35eb586ae1b21be36d76c7','商品管理','','/view/right/role','23fba606aa56d5554359e646f3d53d89',NULL),('9c7de345efd26222563764fbf23a968f','商品类别管理','','/view/commerce/goodType','22547e70e095c2cc6420b061813ae3e8',NULL),('b68bd155-d41a-43d1-99ea-f33c1afca2fa','角色管理','','/view/right/role','765110e1-56f9-4d33-b7f5-68996544a874',2),('f1ed6fda45d7a959598d8618f66081c5','123','213','123','33cba7341390d72ba6da1af6eb782e36',1223),('fc26a423f8dd47a1bb281366b407db4b','3432','23423',NULL,'123',NULL);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` varchar(36) NOT NULL COMMENT '角色主键',
  `name` varchar(45) DEFAULT NULL COMMENT '角色名称',
  `code` varchar(45) DEFAULT NULL COMMENT '角色代码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('99c4d7c6bd6405cf69e60b783dbd0d2a','1','1'),('a7909a2f2a720c837efd306df7c62b06','学生','XS');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_menu`
--

DROP TABLE IF EXISTS `role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_menu` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `roleId` varchar(36) DEFAULT NULL COMMENT '角色主键',
  `menuId` varchar(36) DEFAULT NULL COMMENT '菜单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_menu`
--

LOCK TABLES `role_menu` WRITE;
/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
INSERT INTO `role_menu` VALUES ('28fcd1ce7e66d5a6ad65bbd068cff523','99c4d7c6bd6405cf69e60b783dbd0d2a','62002756-a664-4d9c-a1c5-cb368b8c3ab1'),('36d7a634af745bb3fe89bd261feb2e44','a7909a2f2a720c837efd306df7c62b06','68be6612ae987ff983461f9d59b2cbd6'),('886ef350baed253507584a825b9c0884','99c4d7c6bd6405cf69e60b783dbd0d2a','b68bd155-d41a-43d1-99ea-f33c1afca2fa'),('a7ed09bd2c952ff11f75f8f42bbd2d8c','1','62002756-a664-4d9c-a1c5-cb368b8c3ab1'),('b2e66cbda039efb5817c5236aa16c684','99c4d7c6bd6405cf69e60b783dbd0d2a','765110e1-56f9-4d33-b7f5-68996544a874'),('c5b25f50c80ee924f814b98987f82be0','99c4d7c6bd6405cf69e60b783dbd0d2a','9c7de345efd26222563764fbf23a968f'),('e2cc027eed1613392b02547d431679c9','1','765110e1-56f9-4d33-b7f5-68996544a874'),('eb75353773a2d5f116d2c5f2b67845f5','99c4d7c6bd6405cf69e60b783dbd0d2a','3c8f99d1f8125fac29c6cc89cca01c4c'),('f3c76e80f2e47304354143a37c67c4b8','99c4d7c6bd6405cf69e60b783dbd0d2a','22547e70e095c2cc6420b061813ae3e8'),('fb45bac9fe38fbd43821045848736263','a7909a2f2a720c837efd306df7c62b06','23fba606aa56d5554359e646f3d53d89'),('fe0b8faca802e2fe0c78b5b250d1fce9','99c4d7c6bd6405cf69e60b783dbd0d2a','7892b2f2-d439-4476-89cf-27e6127b09ae');
/*!40000 ALTER TABLE `role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('c085ce9a293a9c62c11d5e3d5be96fbf',NULL,NULL,NULL,'admin','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-14 15:39:22
