-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bitcoindb
--

CREATE DATABASE IF NOT EXISTS bitcoindb;
USE bitcoindb;

--
-- Definition of table `tb_activitylog`
--

DROP TABLE IF EXISTS `tb_activitylog`;
CREATE TABLE `tb_activitylog` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `walletid` varchar(45) NOT NULL,
  `dt_created` datetime NOT NULL,
  `activity` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_activitylog`
--

/*!40000 ALTER TABLE `tb_activitylog` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_activitylog` ENABLE KEYS */;


--
-- Definition of table `tbl_coins`
--

DROP TABLE IF EXISTS `tbl_coins`;
CREATE TABLE `tbl_coins` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `walletid` varchar(45) NOT NULL,
  `noofcoins` int(10) unsigned NOT NULL,
  `status` int(10) unsigned NOT NULL,
  `dt_created` datetime NOT NULL,
  `type` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_coins`
--

/*!40000 ALTER TABLE `tbl_coins` DISABLE KEYS */;
INSERT INTO `tbl_coins` (`id`,`walletid`,`noofcoins`,`status`,`dt_created`,`type`) VALUES 
 (1,'maxku-75421-74794-27132',2,1,'2018-09-08 12:33:40',1),
 (2,'maxya-16671-17422-88633',1,1,'2018-09-16 16:59:06',1),
 (3,'maxya-16671-17422-88633',2,1,'2018-09-22 15:13:08',1),
 (4,'maxku-75421-74794-27132',1,0,'2018-09-23 14:35:23',2),
 (5,'maxku-75421-74794-27132',1,1,'2018-09-23 14:35:58',2),
 (6,'maxku-75421-74794-27132',1,1,'2018-09-24 14:03:23',3);
/*!40000 ALTER TABLE `tbl_coins` ENABLE KEYS */;


--
-- Definition of table `tbl_ledger`
--

DROP TABLE IF EXISTS `tbl_ledger`;
CREATE TABLE `tbl_ledger` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `walletid` varchar(415) NOT NULL,
  `date` datetime NOT NULL,
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `type` varchar(45) NOT NULL,
  `chainid` varchar(45) NOT NULL,
  `transaction` varchar(400) NOT NULL,
  `seckey` varchar(45) NOT NULL,
  `mainchainid` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_ledger`
--

/*!40000 ALTER TABLE `tbl_ledger` DISABLE KEYS */;
INSERT INTO `tbl_ledger` (`id`,`walletid`,`date`,`time`,`type`,`chainid`,`transaction`,`seckey`,`mainchainid`) VALUES 
 (6,'maxku-75421-74794-27132','2018-09-08 00:00:00','2018-09-08 14:32:28','Buy','1','Buy 2Bitcoins','22713296','maxku'),
 (7,'maxya-16671-17422-88633','2018-09-16 00:00:00','2018-09-16 17:29:13','Buy','1','Buy 1Bitcoins','28863396','maxya'),
 (10,'maxya-16671-17422-88633','2018-09-22 00:00:00','2018-09-22 15:14:32','Buy','1','Buy 2Bitcoins','28863396','maxya'),
 (11,'maxku-75421-74794-27132','2018-09-23 00:00:00','2018-09-23 14:45:00','Sell','1','Sell 1Bitcoins','22713296','maxku'),
 (12,'maxku-75421-74794-27132','2018-09-24 00:00:00','2018-09-24 18:13:51','Sell','1','Sell 1Bitcoins','22713296','maxku');
/*!40000 ALTER TABLE `tbl_ledger` ENABLE KEYS */;


--
-- Definition of table `tbl_register`
--

DROP TABLE IF EXISTS `tbl_register`;
CREATE TABLE `tbl_register` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `walletid` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `pwd` varchar(45) NOT NULL,
  `address` varchar(545) NOT NULL,
  `Mobile` varchar(45) NOT NULL,
  `State` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `dt_created` varchar(45) NOT NULL,
  `status` int(10) unsigned NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_register`
--

/*!40000 ALTER TABLE `tbl_register` DISABLE KEYS */;
INSERT INTO `tbl_register` (`id`,`walletid`,`email`,`pwd`,`address`,`Mobile`,`State`,`country`,`dt_created`,`status`,`name`) VALUES 
 (1,'papa724-287-129','paparao.n@gmail.com','12345','a','9985613074','AP','India','2018-08-30 14:45:25',1,'test'),
 (2,'papte-32712-74081-43672','paparao.n@gmail.com','1234','a','9985613074','AP','India','2018-08-30 14:49:51',1,'test'),
 (3,'papte-3382-21249-52743','paparao.n@gmail.com','testest','abcd','9985613074','AP','India','2018-08-30 15:07:42',1,'test'),
 (4,'papte-60947-65725-55230','paparao.n@gmail.com','testest','abcd','9985613074','AP','India','2018-08-30 15:09:47',1,'test'),
 (5,'papte-60535-13412-284','paparao.n@gmail.com','12345678','vsp','9985613074','AP','India','2018-08-30 15:51:33',1,'test'),
 (6,'maxku-75421-74794-27132','maxbulksms@gmail.com','12345678','vsp','9010758487','AP','India','2018-09-07 16:37:03',1,'kushi'),
 (7,'maxya-16671-17422-88633','maxbulksms@gmail.com','132','vsp','9010758487','ap','india','2018-09-16 16:56:02',1,'yashika'),
 (8,'StuSt-53694-85385-6786','Studentwaves9@gmail.com','12345','aruku','9985613074','aP','India','2018-09-24 15:27:59',1,'Studentwaves');
/*!40000 ALTER TABLE `tbl_register` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
