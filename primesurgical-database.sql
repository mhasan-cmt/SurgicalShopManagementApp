/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.0.45-community-nt : Database - primesurgical
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`primesurgical` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `primesurgical`;

/*Table structure for table `activitylog` */

DROP TABLE IF EXISTS `activitylog`;

CREATE TABLE `activitylog` (
  `logId` int(100) NOT NULL auto_increment,
  `userName` varchar(200) default NULL,
  `role` varchar(100) default NULL,
  `activity` varchar(100) default NULL,
  `time` datetime default NULL,
  PRIMARY KEY  (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `activitylog` */

/*Table structure for table `bank accounts` */

DROP TABLE IF EXISTS `bank accounts`;

CREATE TABLE `bank accounts` (
  `bank_id` int(100) NOT NULL auto_increment,
  `bank_account_name` varchar(100) default NULL,
  `bank_account_number` varchar(100) default NULL,
  PRIMARY KEY  (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `bank accounts` */

insert  into `bank accounts`(`bank_id`,`bank_account_name`,`bank_account_number`) values (1,'Jamuna Bank','123321131'),(2,'sonali bank','12221'),(3,'Pubali Bank','989876767');

/*Table structure for table `bank data` */

DROP TABLE IF EXISTS `bank data`;

CREATE TABLE `bank data` (
  `sl_no` int(100) NOT NULL auto_increment,
  `bank_date` date default NULL,
  `bank_name` varchar(100) default NULL,
  `bank_account` varchar(100) default NULL,
  `bank_details` varchar(100) default NULL,
  `bank_status` varchar(100) default NULL,
  `bank_amount` varchar(100) default NULL,
  PRIMARY KEY  (`sl_no`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `bank data` */

insert  into `bank data`(`sl_no`,`bank_date`,`bank_name`,`bank_account`,`bank_details`,`bank_status`,`bank_amount`) values (1,'2021-02-05','Jamuna Bank','123321131','Purchase','Withdraw','0.00'),(2,'2021-02-05','Jamuna Bank','1222123233','Purchase','Withdraw','0.00'),(3,'2021-02-05','Select','1222123233','Purchase','Withdraw','200'),(4,'2021-02-05','Jamuna Bank','1222123233','Sales','Deposit','600'),(5,'2021-02-08','Pubali Bank','989876767','Purchase','Withdraw','300'),(6,'2021-02-09','Jamuna Bank','123321131','Transportation','Withdraw','1000.0'),(7,'2021-02-13','Pubali Bank','989876767','Purchase','Withdraw','2000'),(8,'2021-02-13','Jamuna Bank','1222123233','Purchase','Withdraw','600'),(9,'2021-02-15','Select','Select','Sales','Deposit','0.00');

/*Table structure for table `cash data` */

DROP TABLE IF EXISTS `cash data`;

CREATE TABLE `cash data` (
  `sl_no` int(100) NOT NULL auto_increment,
  `cash_date` date default NULL,
  `cash_details` varchar(100) default NULL,
  `cash_status` varchar(100) default NULL,
  `cash_amount` varchar(100) default NULL,
  PRIMARY KEY  (`sl_no`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=latin1;

/*Data for the table `cash data` */

insert  into `cash data`(`sl_no`,`cash_date`,`cash_details`,`cash_status`,`cash_amount`) values (1,'2020-12-23','Purchase','Debit','3000'),(2,'2020-12-23','Purchase','Debit','2000'),(3,'2020-12-23','Purchase','Debit','1500'),(5,'2020-12-24','Capital','Credit','50000'),(6,'2020-12-24','Current bill','debit','1578'),(7,'2020-12-25','SR comission','Debit','300.0'),(8,'2020-12-25','Purchase','Debit','200'),(9,'2020-12-26','Purchase','Debit','130'),(10,'2020-12-30','sales','credit','500'),(11,'2020-12-30','Personal','credit','100'),(12,'2021-01-01','test','credit','100'),(13,'2020-12-31','Bank Deposited','Debit','60'),(14,'2020-12-31','Bank Deposited','Debit','270.3'),(15,'2021-01-01','Purchase','Debit','440'),(16,'2021-01-01','Purchase Due','Debit','1244'),(17,'2021-01-01','Purchase Due','Debit','1000'),(18,'2021-01-01','Purchase Due','Debit','2000'),(19,'2021-01-01','Purchase Due','Debit','1000'),(20,'2021-01-01','Purchase Due','Debit','2000'),(21,'2021-01-01','Purchase','Debit','500'),(22,'2021-01-02','Purchase Due','Debit','230'),(25,'2021-01-05','Sales','Credit','5000'),(26,'2021-01-05','Purchase','Debit','3000'),(27,'2021-01-05','Purchase','Debit','15000'),(32,'2021-01-05','Purchase','Debit','3000'),(35,'2021-01-05','Sales','Credit','1000'),(42,'2021-01-07','Purchase Due','Debit','8000'),(44,'2021-01-07','Sales','Credit','13350'),(46,'2021-01-07','Sales','Credit','200'),(47,'2021-01-07','Sales','Credit','500'),(53,'2021-01-08','Purchase Due','Debit','3000'),(54,'2021-01-08','Purchase Due','Debit','3000'),(55,'2021-01-08','Purchase Due','Debit','3000'),(56,'2021-01-08','Sales','Credit','400'),(57,'2021-01-08','Sales','Credit','220'),(68,'2021-01-20','Arif cash','debit','3000'),(71,'2021-01-20','Purchase Due','Debit','3000'),(72,'2021-02-03','Sales','Credit','3140'),(73,'2021-02-03','Sales','Credit','510'),(74,'2021-02-03','Sales','Credit','200'),(75,'2021-02-04','Purchase Due','Debit','15000'),(76,'2021-02-04','Purchase Due','Debit','200'),(77,'2021-02-04','Bank Deposited','Debit','5000'),(78,'2021-02-04','Purchase Due','Debit','2000'),(79,'2021-02-04','Purchase Due','Debit','200'),(80,'2021-02-05','Purchase Due','Debit','200'),(81,'2021-02-04','Purchase Due','Debit','200'),(82,'2021-02-05','Purchase Due','Debit','2000'),(83,'2021-02-05','Purchase Due','Debit','2000'),(84,'2021-02-05','Purchase','Debit','0.00'),(85,'2021-02-05','Purchase','Debit','300'),(86,'2021-02-05','Purchase','Debit','1000'),(87,'2021-02-08','Purchase','Debit','0.00'),(88,'2021-02-08','Purchase','Debit','0.00'),(89,'2021-02-08','Purchase','Debit','200'),(90,'2021-02-09','Purchase Due','Debit','1000'),(91,'2021-02-09','Purchase Due','Debit','1000'),(92,'2021-02-15','Sales','Credit','200'),(93,'2021-02-15','Sales','Credit','200'),(94,'2021-02-15','Purchase','Debit','200'),(95,'2021-02-15','Purchase','Debit','100'),(96,'2021-02-15','Sales','Credit','10'),(97,'2021-02-16','Sales','Credit','30');

/*Table structure for table `cost data` */

DROP TABLE IF EXISTS `cost data`;

CREATE TABLE `cost data` (
  `sl_no` int(100) NOT NULL auto_increment,
  `cost_date` date default NULL,
  `cost_type` varchar(100) default NULL,
  `cost_bill` varchar(100) default NULL,
  `cost_details` varchar(100) default NULL,
  `cost_paid_by` varchar(100) default NULL,
  `cost_amount` varchar(100) default NULL,
  PRIMARY KEY  (`sl_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `cost data` */

insert  into `cost data`(`sl_no`,`cost_date`,`cost_type`,`cost_bill`,`cost_details`,`cost_paid_by`,`cost_amount`) values (1,'2020-12-25','Sales Cost','123','Home delivery','Arif (Staff)','370.0'),(2,'2020-12-25','Others Cost','11','staff salary','Owner','1200.0'),(5,'2021-01-04','Sales cost','1','SR Commision','N/A','20.2'),(6,'2021-02-09','Purchase Cost','32','Transportation','Owner','1000.0');

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `id` int(100) NOT NULL,
  `customer name` varchar(100) default NULL,
  `mobile` varchar(100) default NULL,
  `shop name` varchar(100) default NULL,
  `address` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `customers` */

insert  into `customers`(`id`,`customer name`,`mobile`,`shop name`,`address`) values (1,'Md Mahmud','121111','Mahmud Pharma','Uttara, Dhaka'),(3,'Md Ahnaf Hossain','012543232','Ahnaf Medical','Fulgazi, Feni'),(202,'Md Arif','01856675556','Arif Pharma','Silonia, Feni');

/*Table structure for table `product cateogory` */

DROP TABLE IF EXISTS `product cateogory`;

CREATE TABLE `product cateogory` (
  `cateogory_id` int(100) NOT NULL auto_increment,
  `cateogory` varchar(100) default NULL,
  PRIMARY KEY  (`cateogory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `product cateogory` */

insert  into `product cateogory`(`cateogory_id`,`cateogory`) values (1,'cough syrup'),(2,'pain killers'),(3,'first aid');

/*Table structure for table `product info` */

DROP TABLE IF EXISTS `product info`;

CREATE TABLE `product info` (
  `product_id` int(100) NOT NULL auto_increment,
  `product_name` varchar(100) default NULL,
  `product_price` varchar(100) default NULL,
  `product_details` varchar(100) default NULL,
  `product_category_id` int(100) default NULL,
  PRIMARY KEY  (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `product info` */

insert  into `product info`(`product_id`,`product_name`,`product_price`,`product_details`,`product_category_id`) values (1,'Alcolf','200','beximco inc.',1),(2,'bashok','190','glaxosmith inc.',1),(3,'napa','50','beximco inc',2),(4,'napa extra','70','beximco inc.',2),(5,'quick bandage','10','square inc',3),(6,'viodin','120','square inc',3),(7,'ointment','70','Arise pharma inc',2),(8,'5ml Syringe','15','Arisco pharmatical inc',3),(9,'Joinix','200','Bangladesh central pharma',2),(10,'pain killer 0010','200','Test',2),(11,'Loral 5','150','Aristo pharma',2);

/*Table structure for table `purchase accounts` */

DROP TABLE IF EXISTS `purchase accounts`;

CREATE TABLE `purchase accounts` (
  `bill_no` varchar(100) NOT NULL,
  `gr` varchar(100) default '',
  `date` date default NULL,
  `company` varchar(200) default NULL,
  `items` int(100) default NULL,
  `total` int(100) default NULL,
  `payment` varchar(200) default NULL,
  `discount` varchar(100) default NULL,
  `paid` varchar(100) default NULL,
  `due` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `purchase accounts` */

insert  into `purchase accounts`(`bill_no`,`gr`,`date`,`company`,`items`,`total`,`payment`,`discount`,`paid`,`due`) values ('1','12','2021-01-08','Arif Medical Supply',100,6000,'Cash','0.00','0.00','6000'),('1Arif','Due Paid','2021-01-08','Arif Medical Supply',0,0,'Cash','0','3000','3000.0'),('1','23','2021-01-18','Muruf Medical Supply',100,12000,'Cash','0.00','0.00','12000'),('2Arif','Due Paid','2021-01-20','Arif Medical Supply',0,0,'Cash','0','3000','0.0'),('1','33','2021-01-31','Mamun Medical Supply',12,18840,'Due','0.00','0.00','18840'),('1','11','2021-02-28','Mamun Medical Supply',20,1000,'Due','0.00','0.00','1000'),('1','21','2021-02-01','Arif Medical Supply',10,1700,'Due','0.00','0.00','1700'),('2','31','2021-02-01','Mamun Medical Supply',2,20,'Due','0.00','0.00','20'),('1','41','2021-02-03','Muruf Medical Supply',10,2400,'Due','0.00','0.00','2400'),('2','51','2021-02-03','Arif Medical Supply',100,1520,'Due','0.00','0.00','1520'),('1Mamun','Due Paid','2021-02-04','Mamun Medical Supply',0,0,'Cash','0','15000','4860.0'),('1221','Due Paid','2021-02-04','Mamun Medical Supply',0,0,'Cash','0','200','4660.0'),('21','Due Paid','2021-02-04','Muruf Medical Supply',0,0,'Cash','0','2000','12400.0'),('21','Due Paid','2021-02-04','Muruf Medical Supply',0,0,'Cash','0','200','12200.0'),('12','Due Paid','2021-02-05','Mamun Medical Supply',0,0,'Cash','0','200','4460.0'),('211','Due Paid','2021-02-04','Muruf Medical Supply',0,0,'Cash','0','200','12000.0'),('12','Due Paid','2021-02-01','Mamun Medical Supply',0,0,'Cash','0','2000','2460.0'),('20','Due Paid','2021-02-05','Muruf Medical Supply',0,0,'Cash','0','2000','10000.0'),('13','Due Paid','2021-02-05','Mamun Medical Supply',0,0,'Cash','0','2000','460.0'),('3','71','2021-02-05','Arif Medical Supply',10,2900,'Bank','100','2000','800.0'),('3','71','2021-02-05','Arif Medical Supply',10,2900,'Cash','100','2000','800.0'),('3','71','2021-02-05','Arif Medical Supply',10,2900,'Due','100','2000','800.0'),('4','81','2021-02-05','Mamun Medical Supply',10,2000,'Cash','10','200','1790.0'),('4','81','2021-02-05','Mamun Medical Supply',10,2000,'Due','10','200','1790.0'),('5','91','2021-02-05','Mamun Medical Supply',10,150,'Cash','0.00','0.00','150'),('6','101','2021-02-05','Mamun Medical Supply',10,1900,'Cash','0.00','0.00','1900'),('7','111','2021-02-05','Mamun Medical Supply',20,1400,'Bank','0.00','0.00','1400'),('8','121','2021-02-05','Mamun Medical Supply',20,4000,'Bank','0.00','0.00','4000'),('9','132','2021-02-05','Mamun Medical Supply',10,2000,'Bank','0.00','200','1800.0'),('10','143','2021-02-05','Mamun Medical Supply',20,4000,'Cash','0.00','300','3700.0'),('11','153','2021-02-05','Mamun Medical Supply',10,1900,'Cash','300','1000','600.0'),('12','163','2021-02-05','Mamun Medical Supply',10,1900,'Due','0.00','00','1900'),('13','173','2021-02-05','Mamun Medical Supply',10,1900,'Due','0.00','0.00','1900'),('4','183','2021-02-08','Arif Medical Supply',10,4000,'Due','0.00','0.00','4000'),('14','193','2021-02-08','Mamun Medical Supply',20,1400,'Cash','0.00','0.00','1400'),('15','203','2021-02-08','Mamun Medical Supply',2,240,'Cash','0.00','0.00','240'),('16','213','2021-02-08','Mamun Medical Supply',20,200,'Due','0.00','0.00','200'),('17','223','2021-02-08','Mamun Medical Supply',10,2000,'Due','0.00','0.00','2000'),('18','233','2021-02-08','Mamun Medical Supply',20,4000,'Due','0.00','0','4000.0'),('1','253','2021-02-08','test',20,2600,'Due','0.00','0','2600.0'),('20','263','2021-02-08','Mamun Medical Supply',20,1000,'Due','0.00','0','1000.0'),('21','273','2021-02-08','Mamun Medical Supply',20,3800,'Due','0.00','0','3800.0'),('22','283','2021-02-08','Mamun Medical Supply',20,4000,'Cash','0.00','200','3800.0'),('2','294','2021-02-08','Muruf Medical Supply',20,5520,'Bank','0.00','300','5220.0'),('23','306','2021-02-08','Mamun Medical Supply',40,6500,'Due','0.00','0.00','6500'),('2','Due Paid','2021-02-09','test',0,0,'Cash','0','1000','1600.0'),('3','Due Paid','2021-02-09','test',0,0,'Cash','0','1000','1600'),('24','316','2021-02-13','Mamun Medical Supply',20,4000,'Bank','0.00','2000','2000.0'),('25','326','2021-02-13','Mamun Medical Supply',10,700,'Bank','0.00','600','100.0'),('26','337','2021-02-15','Mamun Medical Supply',5,980,'Due','0.00','0.00','980'),('27','347','2021-02-15','Mamun Medical Supply',5,1000,'Due','0.00','0.00','1000'),('3','357','2021-02-15','Muruf Medical Supply',2,3040,'Cash','0.00','200','2840.0'),('4','368','2021-02-15','Muruf Medical Supply',2,4400,'Due','0.00','0','4400.0'),('5','379','2021-02-15','Muruf Medical Supply',3,720,'Due','0.00','0.00','720'),('6','389','2021-02-15','Muruf Medical Supply',2,140,'Due','0.00','0.00','140'),('2','399','2021-02-15','test',20,6920,'Cash','0.00','100','1300.0');

/*Table structure for table `purchase entry` */

DROP TABLE IF EXISTS `purchase entry`;

CREATE TABLE `purchase entry` (
  `purchase_id` int(100) NOT NULL auto_increment,
  `bill_no` int(100) default NULL,
  `company_name` varchar(200) default NULL,
  `purchase_date` date default NULL,
  `purchase_gr` int(200) default NULL,
  `category` varchar(100) default NULL,
  `product` varchar(200) default NULL,
  `price` varchar(100) default NULL,
  `quantity` varchar(200) default NULL,
  `total` varchar(1200) default NULL,
  PRIMARY KEY  (`purchase_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

/*Data for the table `purchase entry` */

insert  into `purchase entry`(`purchase_id`,`bill_no`,`company_name`,`purchase_date`,`purchase_gr`,`category`,`product`,`price`,`quantity`,`total`) values (1,1,'Mamun Medical Supply','2021-02-28',10,'pain killers','napa','50','20','1000.0'),(2,1,'Arif Medical Supply','2021-02-01',20,'pain killers','napa extra','70','10','700.0'),(3,2,'Mamun Medical Supply','2021-02-01',30,'first aid','quick bandage','10','2','20.0'),(4,1,'Muruf Medical Supply','2021-02-03',40,'pain killers','ointment','70','10','700.0'),(5,2,'Arif Medical Supply','2021-02-03',50,'first aid','5ml Syringe','15','100','1500.0'),(6,3,'Mamun Medical Supply','2021-02-03',60,'cough syrup','Alcolf','200','5','1000.0'),(7,3,'Arif Medical Supply','2021-02-05',70,'cough syrup','bashok','190','10','1900.0'),(8,4,'Mamun Medical Supply','2021-02-05',80,'cough syrup','Alcolf','200','10','2000.0'),(9,5,'Mamun Medical Supply','2021-02-05',90,'first aid','5ml Syringe','15','10','150.0'),(11,7,'Mamun Medical Supply','2021-02-05',110,'pain killers','napa extra','70','20','1400.0'),(12,8,'Mamun Medical Supply','2021-02-05',120,'cough syrup','Alcolf','200','20','4000.0'),(13,9,'Mamun Medical Supply','2021-02-05',131,'cough syrup','Alcolf','200','10','2000.0'),(14,10,'Mamun Medical Supply','2021-02-05',142,'cough syrup','Alcolf','200','20','4000.0'),(15,11,'Mamun Medical Supply','2021-02-05',152,'cough syrup','bashok','190','10','1900.0'),(16,12,'Mamun Medical Supply','2021-02-05',162,'cough syrup','bashok','190','10','1900.0'),(17,13,'Mamun Medical Supply','2021-02-05',172,'cough syrup','bashok','190','10','1900.0'),(18,4,'Arif Medical Supply','2021-02-08',182,'cough syrup','Alcolf','200','10','2000.0'),(19,14,'Mamun Medical Supply','2021-02-08',192,'pain killers','ointment','70','20','1400.0'),(20,15,'Mamun Medical Supply','2021-02-08',202,'first aid','viodin','120','2','240.0'),(21,16,'Mamun Medical Supply','2021-02-08',212,'first aid','quick bandage','10','20','200.0'),(22,17,'Mamun Medical Supply','2021-02-08',222,'cough syrup','Alcolf','200','10','2000.0'),(23,18,'Mamun Medical Supply','2021-02-08',232,'cough syrup','Alcolf','200','20','4000.0'),(24,19,'Mamun Medical Supply','2021-02-08',242,'pain killers','Joinix','200','10','2000.0'),(25,1,'test','2021-02-08',252,'first aid','quick bandage','10','20','200.0'),(26,20,'Mamun Medical Supply','2021-02-08',262,'pain killers','napa','50','20','1000.0'),(27,21,'Mamun Medical Supply','2021-02-08',272,'cough syrup','bashok','190','20','3800.0'),(28,22,'Mamun Medical Supply','2021-02-08',282,'cough syrup','Alcolf','200','20','4000.0'),(29,2,'Muruf Medical Supply','2021-02-08',293,'cough syrup','Alcolf','200','20','4000.0'),(30,23,'Mamun Medical Supply','2021-02-08',303,'cough syrup','Alcolf','200','10','2000.0'),(31,23,'Mamun Medical Supply','2021-02-08',304,'cough syrup','bashok','190','20','3800.0'),(32,23,'Mamun Medical Supply','2021-02-08',305,'pain killers','napa extra','70','10','700.0'),(33,24,'Mamun Medical Supply','2021-02-13',315,'pain killers','Joinix','200','20','4000.0'),(34,25,'Mamun Medical Supply','2021-02-13',325,'pain killers','napa extra','70','10','700.0'),(35,26,'Mamun Medical Supply','2021-02-15',335,'cough syrup','bashok','190','2','380.0'),(36,26,'Mamun Medical Supply','2021-02-15',336,'cough syrup','Alcolf','200','3','600.0'),(37,27,'Mamun Medical Supply','2021-02-15',346,'pain killers','pain killer 0010','200','5','1000.0'),(38,3,'Muruf Medical Supply','2021-02-15',356,'pain killers','napa extra','70','2','140.0'),(39,4,'Muruf Medical Supply','2021-02-15',367,'pain killers','pain killer 0010','200','2','400.0'),(40,5,'Muruf Medical Supply','2021-02-15',378,'cough syrup','bashok','190','3','570.0'),(41,6,'Muruf Medical Supply','2021-02-15',388,'pain killers','napa extra','70','1','70.0'),(42,2,'test','2021-02-15',398,'pain killers','ointment','70','20','1400.0');

/*Table structure for table `purchaseorder` */

DROP TABLE IF EXISTS `purchaseorder`;

CREATE TABLE `purchaseorder` (
  `orderId` int(100) default NULL,
  `supplier` varchar(200) default NULL,
  `orderDate` date default NULL,
  `deliveryDate` date default NULL,
  `category` varchar(100) default NULL,
  `productName` varchar(100) default NULL,
  `price` varchar(100) default NULL,
  `quantity` varchar(100) default NULL,
  `total` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `purchaseorder` */

insert  into `purchaseorder`(`orderId`,`supplier`,`orderDate`,`deliveryDate`,`category`,`productName`,`price`,`quantity`,`total`) values (1,'Md Mamun','2021-02-17','2021-02-18','cough syrup','Alcolf','200','3','600.0'),(2,'Md Mamun','2021-02-17','2021-02-18','cough syrup','Alcolf','200','2','400.0'),(3,'Md Mamun','2021-02-17','2021-02-18','cough syrup','bashok','190','2','380.0'),(4,'Maruf Ahmed','2021-02-17','2021-02-19','pain killers','Loral 5','150','3','450.0'),(5,'Md Mamun','2021-02-17','2021-02-18','pain killers','napa extra','70','2','140.0'),(6,'Md Ariful islam','2021-02-17','2021-02-19','first aid','5ml Syringe','15','2','30.0'),(7,'Md Ariful islam','2021-02-17','2021-02-19','first aid','5ml Syringe','15','2','30.0'),(8,'Md Ariful islam','2021-02-17','2021-02-19','first aid','5ml Syringe','15','2','30.0');

/*Table structure for table `sales accounts` */

DROP TABLE IF EXISTS `sales accounts`;

CREATE TABLE `sales accounts` (
  `bill_no` varchar(100) NOT NULL,
  `gr` varchar(100) default '',
  `date` date default NULL,
  `customer` varchar(200) default NULL,
  `items` int(100) default NULL,
  `total` int(100) default NULL,
  `payment` varchar(200) default NULL,
  `discount` varchar(100) default NULL,
  `paid` varchar(100) default NULL,
  `due` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sales accounts` */

insert  into `sales accounts`(`bill_no`,`gr`,`date`,`customer`,`items`,`total`,`payment`,`discount`,`paid`,`due`) values ('1','30','2021-01-20','Md Ahnaf hossain',22,1540,'Cash','0.00','0.00','1540.0'),('3','50','2021-01-20','Md Ahnaf Hossain',12,1440,'Bank','0.00','0.00','1440.0'),('4','60','2021-01-31','Md Mahmud',10,700,'Due','0.00','0.00','700.0'),('5','70','2021-01-31','Md Naeem',3,180,'Due','0.00','0.00','180.0'),('1','20','2021-02-01','Md Ahnaf Hossain',2,160,'Bank','0.00','0.00','160.0'),('1','20','2021-02-01','Md Arif',7,510,'Due','0.00','0.00','510.0'),('2','30','2021-02-01','Md Mahmud',4,200,'Due','0.00','0.00','200.0'),('3','40','2021-02-03','Ariful islam',1,30,'Due','0.00','0.00','30.0'),('1ahnaf','Due paid','2021-02-03','Md Ahnaf hossain',0,0,'Cash','0.00','3140','0.0'),('1Arif','Due paid','2021-02-03','Md Arif',0,0,'Cash','0.00','510','0.0'),('212','Due paid','2021-02-03','Md Mahmud',0,0,'Cash','0.00','200','700.0'),('1','20','2021-02-04','Md Ahnaf Hossain',27,1010,'Bank','0.00','200','810.0'),('2','30','2021-02-05','Md Ahnaf Hossain',6,640,'Bank','40','600','0.0'),('3','40','2021-02-05','Md Ahnaf Hossain',3,430,'Due','0.00','0.00','430.0'),('4','50','2021-02-08','Md Ahnaf Hossain',12,600,'Due','0.00','0.00','600.0'),('1','20','2021-02-15','Md Mahmud',29,1450,'Due','0.00','0.00','1450.0'),('1','20','2021-02-15','Md Ahnaf Hossain',34,2550,'Due','0.00','0.00','2550.0'),('5','60','2021-02-15','Md Ahnaf Hossain',10,1000,'Due','0.00','0.00','0.00'),('6','70','2021-02-15','Md Ahnaf Hossain',2,140,'Due','0.00','0.00','140.0'),('7','80','2021-02-15','Md Mahmud',3,210,'Bank','0.00','0.00','210.0'),('8','90','2021-02-15','Md Ahnaf Hossain',3,600,'Cash','0.00','200','400.0'),('9','100','2021-02-15','Md Arif',3,210,'Due','0.00','0.00','210.0'),('10','110','2021-02-15','Md Ahnaf Hossain',2,380,'Due','0.00','0.00','380.0'),('11','120','2021-02-15','Md Ahnaf Hossain',2,100,'Due','0.00','0.00','100.0'),('12','130','2021-02-15','Md Ahnaf Hossain',2,400,'Cash','0.00','200','200.0'),('13','140','2021-02-15','arif',2,140,'Cash','0.00','10','130.0'),('14','150','2021-02-15','Md Ahnaf Hossain',2,140,'Due','0.00','0.00','140.0'),('15','160','2021-02-15','Md Ahnaf Hossain',2,140,'Due','0.00','0.00','140.0'),('16','170','2021-02-15','Md Mahmud',2,140,'Due','0.00','0','140.0'),('17','180','2021-02-16','Md Mahmud',2,30,'Cash','0.00','30','0.0');

/*Table structure for table `sales entry` */

DROP TABLE IF EXISTS `sales entry`;

CREATE TABLE `sales entry` (
  `sales_id` int(100) NOT NULL auto_increment,
  `bill_no` int(100) default NULL,
  `customer_name` varchar(200) default NULL,
  `sales_date` date default NULL,
  `sales_gr` int(200) default NULL,
  `category` varchar(100) default NULL,
  `product` varchar(200) default NULL,
  `price` varchar(100) default NULL,
  `quantity` varchar(200) default NULL,
  `total` varchar(1200) default NULL,
  PRIMARY KEY  (`sales_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;

/*Data for the table `sales entry` */

insert  into `sales entry`(`sales_id`,`bill_no`,`customer_name`,`sales_date`,`sales_gr`,`category`,`product`,`price`,`quantity`,`total`) values (13,1,'Md Ahnaf Hossain','2021-02-28',10,'pain killers','napa','80.0','2','160.0'),(14,0,'0','0000-00-00',0,'pain killers','napa','0','0','0'),(19,0,'0',NULL,0,'pain killers','napa extra','0','0','0'),(20,1,'Md Arif','2021-02-01',10,'pain killers','napa extra','90.0','5','350.0'),(21,2,'Md Mahmud','2021-02-01',20,'pain killers','napa','60.0','4','200.0'),(22,3,'Ariful islam','2021-02-03',30,'pain killers','napa','30','1','30.0'),(23,0,'0','0000-00-00',0,'pain killers','ointment','0','0','0'),(24,0,'0','0000-00-00',0,'first aid','quick bandage','0','0','0'),(26,0,'0','0000-00-00',0,'first aid','5ml Syringe','0','0','0'),(27,0,'0','0000-00-00',0,'cough syrup','alcolf','0','0','0'),(28,1,'Md Ahnaf Hossain','2021-02-04',10,'first aid','5ml Syringe','25.0','20','500.0'),(29,2,'Md Ahnaf Hossain','2021-02-05',20,'cough syrup','Alcolf','220.0','2','440.0'),(30,3,'Md Ahnaf Hossain','2021-02-05',30,'cough syrup','Alcolf','200','2','400.0'),(31,4,'Md Ahnaf Hossain','2021-02-08',40,'pain killers','napa','50','12','600.0'),(32,0,'0','0000-00-00',0,'pain killers','Joinix','0','0','0'),(33,0,'0','0000-00-00',0,'cough syrup','bashok','0','0','0'),(34,0,'0','0000-00-00',0,'first aid','viodin','0','0','0'),(35,1,'Md Mahmud','2021-02-15',10,'cough syrup','Alcolf','220.0','2','440.0'),(36,0,'0','0000-00-00',0,'pain killers','pain killer 0010','0','0','0'),(37,1,'Md Ahnaf Hossain','2021-02-15',10,'cough syrup','Alcolf','220.0','5','1100.0'),(38,5,'Md Ahnaf Hossain','2021-02-15',50,'pain killers','ointment','100.0','10','1000.0'),(39,6,'Md Ahnaf Hossain','2021-02-15',60,'pain killers','napa extra','70','2','140.0'),(40,7,'Md Mahmud','2021-02-15',70,'pain killers','napa extra','70','3','210.0'),(41,8,'Md Ahnaf Hossain','2021-02-15',80,'cough syrup','Alcolf','200','3','600.0'),(42,9,'Md Arif','2021-02-15',90,'pain killers','napa extra','70','3','210.0'),(43,10,'Md Ahnaf Hossain','2021-02-15',100,'cough syrup','bashok','190','2','380.0'),(44,11,'Md Ahnaf Hossain','2021-02-15',110,'pain killers','napa','50','2','100.0'),(45,12,'Md Ahnaf Hossain','2021-02-15',120,'pain killers','Joinix','200','2','400.0'),(46,13,'arif','2021-02-15',130,'pain killers','napa extra','70','2','140.0'),(47,14,'Md Ahnaf Hossain','2021-02-15',140,'pain killers','napa extra','70','2','140.0'),(48,15,'Md Ahnaf Hossain','2021-02-15',150,'pain killers','napa extra','70','2','140.0'),(49,16,'Md Mahmud','2021-02-15',160,'pain killers','napa extra','70','2','140.0'),(50,17,'Md Mahmud','2021-02-16',170,'first aid','5ml Syringe','15','2','30.0'),(51,0,'0','0000-00-00',0,'pain killers','Loral 5','0','0','0');

/*Table structure for table `sales officer commision` */

DROP TABLE IF EXISTS `sales officer commision`;

CREATE TABLE `sales officer commision` (
  `c-id` int(200) NOT NULL auto_increment,
  `s-officer-id` int(100) NOT NULL,
  `c-date` date default NULL,
  `per` int(100) default NULL,
  `amount` varchar(200) default NULL,
  PRIMARY KEY  (`c-id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `sales officer commision` */

insert  into `sales officer commision`(`c-id`,`s-officer-id`,`c-date`,`per`,`amount`) values (9,1,'2021-01-04',5,'20.2');

/*Table structure for table `salesofficer` */

DROP TABLE IF EXISTS `salesofficer`;

CREATE TABLE `salesofficer` (
  `id` int(100) NOT NULL,
  `sales_name` varchar(100) default NULL,
  `sales_mobile` varchar(100) default NULL,
  `sales_address` varchar(100) default NULL,
  `sales_salary` varchar(100) default NULL,
  `sales_position` varchar(100) default NULL,
  `sales_joining` varchar(100) default NULL,
  `sales_ref` varchar(100) default NULL,
  `sales_ref_mobile` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `salesofficer` */

insert  into `salesofficer`(`id`,`sales_name`,`sales_mobile`,`sales_address`,`sales_salary`,`sales_position`,`sales_joining`,`sales_ref`,`sales_ref_mobile`) values (1,'Md arif','0187596111','Dagonbhuiyan, Feni','4000','staff','2020-12-23','N/A','N/A'),(2,'jokeed','1222312133','dfadf','1000','staff','2020-12-23','N/A','N/A'),(3,'asdf','sdf','adf','adf','adfa','2021-02-08','N/A','N/A');

/*Table structure for table `salesorder` */

DROP TABLE IF EXISTS `salesorder`;

CREATE TABLE `salesorder` (
  `orderId` int(100) NOT NULL,
  `customerName` varchar(200) default NULL,
  `orderDate` date default NULL,
  `deliveryDate` date default NULL,
  `category` varchar(100) default NULL,
  `productName` varchar(100) default NULL,
  `stockQuantity` varchar(100) default NULL,
  `purchasePrice` varchar(100) default NULL,
  `salesPrice` varchar(100) default NULL,
  `quantity` varchar(100) default NULL,
  `total` varchar(100) default NULL,
  `gr` varchar(100) default 'Pur',
  PRIMARY KEY  (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `salesorder` */

/*Table structure for table `suppliers` */

DROP TABLE IF EXISTS `suppliers`;

CREATE TABLE `suppliers` (
  `supplier_id` int(100) NOT NULL,
  `supplier_name` varchar(200) default NULL,
  `supplier_company_name` varchar(200) default NULL,
  `supplier_mobile` varchar(20) default NULL,
  `supplier_address` varchar(100) default NULL,
  PRIMARY KEY  (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `suppliers` */

insert  into `suppliers`(`supplier_id`,`supplier_name`,`supplier_company_name`,`supplier_mobile`,`supplier_address`) values (1,'Md Mamun','Mamun Medical Supply','01829928373','Tongi, Gazipur'),(2,'test','test','test','test'),(3,'test','test','test','test'),(102,'Maruf Ahmed','Muruf Medical Supply','0199283332','Uttara, Dhaka'),(103,'Md Ariful islam','Arif Medical Supply','0012098983','Agargao, Chittagong');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(100) NOT NULL auto_increment,
  `user_name` varchar(100) default NULL,
  `user_password` varchar(100) default NULL,
  `user_mobile` varchar(100) default NULL,
  `user_email` varchar(100) default NULL,
  `user_role` varchar(100) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`user_id`,`user_name`,`user_password`,`user_mobile`,`user_email`,`user_role`) values (1,'shafin','123','01875965178','mh@123','Admin'),(2,'Md Mustofa arif','4321','01854578102','mustofa@arif.mail','Staff-001'),(6,'Mustafiz','321','01558433','mu.mail@yahoo.com','staff-01');

/*Table structure for table `purchaseq` */

DROP TABLE IF EXISTS `purchaseq`;

/*!50001 DROP VIEW IF EXISTS `purchaseq` */;
/*!50001 DROP TABLE IF EXISTS `purchaseq` */;

/*!50001 CREATE TABLE  `purchaseq`(
 `product` varchar(200) ,
 `purchaseQuantity` double 
)*/;

/*Table structure for table `salesprofit` */

DROP TABLE IF EXISTS `salesprofit`;

/*!50001 DROP VIEW IF EXISTS `salesprofit` */;
/*!50001 DROP TABLE IF EXISTS `salesprofit` */;

/*!50001 CREATE TABLE  `salesprofit`(
 `product` varchar(200) ,
 `puPrice` varchar(100) ,
 `saPrice` varchar(100) ,
 `sQ` varchar(200) ,
 `unitProfit` double 
)*/;

/*Table structure for table `salesq` */

DROP TABLE IF EXISTS `salesq`;

/*!50001 DROP VIEW IF EXISTS `salesq` */;
/*!50001 DROP TABLE IF EXISTS `salesq` */;

/*!50001 CREATE TABLE  `salesq`(
 `product` varchar(200) ,
 `salesQuantity` double 
)*/;

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

/*!50001 DROP VIEW IF EXISTS `stock` */;
/*!50001 DROP TABLE IF EXISTS `stock` */;

/*!50001 CREATE TABLE  `stock`(
 `product` varchar(200) ,
 `purchaseQuantity` double ,
 `salesQuantity` double ,
 `stock` double 
)*/;

/*View structure for view purchaseq */

/*!50001 DROP TABLE IF EXISTS `purchaseq` */;
/*!50001 DROP VIEW IF EXISTS `purchaseq` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `purchaseq` AS (select `purchase entry`.`product` AS `product`,sum(`purchase entry`.`quantity`) AS `purchaseQuantity` from `purchase entry` group by `purchase entry`.`product`) */;

/*View structure for view salesprofit */

/*!50001 DROP TABLE IF EXISTS `salesprofit` */;
/*!50001 DROP VIEW IF EXISTS `salesprofit` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `salesprofit` AS (select `sales entry`.`product` AS `product`,`purchase entry`.`price` AS `puPrice`,`sales entry`.`price` AS `saPrice`,`sales entry`.`quantity` AS `sQ`,sum(((`sales entry`.`price` - `purchase entry`.`price`) * `sales entry`.`quantity`)) AS `unitProfit` from (`sales entry` left join `purchase entry` on((`sales entry`.`product` = `purchase entry`.`product`))) where (`sales entry`.`price` > 0) group by `sales entry`.`sales_id`) */;

/*View structure for view salesq */

/*!50001 DROP TABLE IF EXISTS `salesq` */;
/*!50001 DROP VIEW IF EXISTS `salesq` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `salesq` AS (select `sales entry`.`product` AS `product`,sum(`sales entry`.`quantity`) AS `salesQuantity` from `sales entry` group by `sales entry`.`product`) */;

/*View structure for view stock */

/*!50001 DROP TABLE IF EXISTS `stock` */;
/*!50001 DROP VIEW IF EXISTS `stock` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stock` AS (select `purchaseq`.`product` AS `product`,`purchaseq`.`purchaseQuantity` AS `purchaseQuantity`,`salesq`.`salesQuantity` AS `salesQuantity`,sum((`purchaseq`.`purchaseQuantity` - `salesq`.`salesQuantity`)) AS `stock` from (`purchaseq` left join `salesq` on((`purchaseq`.`product` = `salesq`.`product`))) group by `purchaseq`.`product`) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
