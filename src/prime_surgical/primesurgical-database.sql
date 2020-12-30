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

/*Table structure for table `bank accounts` */

DROP TABLE IF EXISTS `bank accounts`;

CREATE TABLE `bank accounts` (
  `bank_id` int(100) NOT NULL auto_increment,
  `bank_account_name` varchar(100) default NULL,
  `bank_account_number` varchar(100) default NULL,
  PRIMARY KEY  (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `bank accounts` */

insert  into `bank accounts`(`bank_id`,`bank_account_name`,`bank_account_number`) values (1,'Jamuna Bank','123321131'),(2,'sonali bank','12221'),(3,'Jamuna bank','1222123233'),(4,'Pubali Bank','989876767');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `bank data` */

insert  into `bank data`(`sl_no`,`bank_date`,`bank_name`,`bank_account`,`bank_details`,`bank_status`,`bank_amount`) values (1,'2020-12-23','Jamuna bank','1222123233','Purchase','Withdraw','3000'),(3,'2020-12-23','sonali bank','12221','Purchase','Withdraw','200'),(4,'2020-12-23','Jamuna Bank','1222123233','Capital','Deposit','50000'),(5,'2020-12-25','Jamuna bank','1222123233','staff salary','Withdraw','1200.0'),(6,'2020-12-26','Jamuna bank','1222123233','Withdraw','Deposit','10000');

/*Table structure for table `cash data` */

DROP TABLE IF EXISTS `cash data`;

CREATE TABLE `cash data` (
  `sl_no` int(100) NOT NULL auto_increment,
  `cash_date` date default NULL,
  `cash_details` varchar(100) default NULL,
  `cash_status` varchar(100) default NULL,
  `cash_amount` varchar(100) default NULL,
  PRIMARY KEY  (`sl_no`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `cash data` */

insert  into `cash data`(`sl_no`,`cash_date`,`cash_details`,`cash_status`,`cash_amount`) values (1,'2020-12-23','Purchase','Debit','3000'),(2,'2020-12-23','Purchase','Debit','2000'),(3,'2020-12-23','Purchase','Debit','1500'),(4,'2020-12-23','Purchase','Debit','0.00'),(5,'2020-12-24','Capital','Credit','50000'),(6,'2020-12-24','Current bill','debit','1578'),(7,'2020-12-25','SR comission','Debit','300.0'),(8,'2020-12-25','Purchase','Debit','200'),(9,'2020-12-26','Purchase','Debit','130');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `cost data` */

insert  into `cost data`(`sl_no`,`cost_date`,`cost_type`,`cost_bill`,`cost_details`,`cost_paid_by`,`cost_amount`) values (1,'2020-12-25','Sales Cost','123','Home delivery','Arif (Staff)','370.0'),(2,'2020-12-25','Others Cost','11','staff salary','Owner','1200.0'),(3,'2020-12-25','Others Cost','22','SR comission','Shop Owner','300.0');

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

insert  into `customers`(`id`,`customer name`,`mobile`,`shop name`,`address`) values (1,'Md Mahmud','121111','Mahmud Pharma','Uttara, Dhaka');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `product info` */

insert  into `product info`(`product_id`,`product_name`,`product_price`,`product_details`,`product_category_id`) values (1,'Alcolf','200','beximco inc.',1),(2,'bashok','190','glaxosmith inc.',1),(3,'napa','50','beximco inc',2),(4,'napa extra','70','beximco inc.',2),(5,'quick bandage','10','square inc',3),(6,'viodin','120','square inc',3);

/*Table structure for table `purchase accounts` */

DROP TABLE IF EXISTS `purchase accounts`;

CREATE TABLE `purchase accounts` (
  `bill_no` int(100) NOT NULL,
  `gr` int(100) NOT NULL,
  `date` date default NULL,
  `company` varchar(200) default NULL,
  `items` int(100) default NULL,
  `total` int(100) default NULL,
  `payment` varchar(200) default NULL,
  `discount` varchar(100) default NULL,
  `paid` varchar(100) default NULL,
  `due` varchar(100) default NULL,
  PRIMARY KEY  (`gr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `purchase accounts` */

insert  into `purchase accounts`(`bill_no`,`gr`,`date`,`company`,`items`,`total`,`payment`,`discount`,`paid`,`due`) values (17,172,'2020-12-22','Mamun Medical Supply',1,380,'Cash','0.00',NULL,'380'),(18,181,'2020-12-23','Mamun Medical Supply',1,400,'Cash','10','300','90.0'),(19,191,'2020-12-23','Mamun Medical Supply',1,400,'Cash','0.00','300','100.0'),(20,201,'2020-12-23','Mamun Medical Supply',1,100,'Cash','0.00','100','0.0'),(21,211,'2020-12-23','test',1,210,'Cash','10','200','0.0'),(22,221,'2020-12-23','Mamun Medical Supply',1,600,'Cash','100','400','100.0'),(23,231,'2020-12-23','Mamun Medical Supply',1,200,'Cash','0.00','200','0.0'),(24,242,'2020-12-23','Mamun Medical Supply',1,6100,'Cash','0.00','3000','3100.0'),(25,252,'2020-12-23','Mamun Medical Supply',1,4370,'Cash','300','2000','2070.0'),(26,262,'2020-12-23','test',1,2000,'Cash','0.00','1500','500.0'),(27,272,'2020-12-23','Select',1,4370,'Bank','0.00','0.00','4370.0'),(28,282,'2020-12-23','Mamun Medical Supply',1,5000,'Bank','0.00','3000','2000.0'),(29,292,'2020-12-23','Mamun Medical Supply',1,0,'Cash','0.00','0.00','0'),(30,302,'2020-12-23','Mamun Medical Supply',1,2400,'Bank','0','200','2200.0'),(31,312,'2020-12-25','test',1,360,'Cash','10','200','150.0'),(100,322,'2020-12-26','Mamun Medical Supply',1,140,'Cash','10','130','0.0');

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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

/*Data for the table `purchase entry` */

insert  into `purchase entry`(`purchase_id`,`bill_no`,`company_name`,`purchase_date`,`purchase_gr`,`category`,`product`,`price`,`quantity`,`total`) values (1,1,'Mamun Medical Supply','2020-12-21',10,'cough syrup','Alcolf','200','1','200.0'),(2,2,'Mamun Medical Supply','2020-12-22',20,'cough syrup','Alcolf','200','2','400.0'),(3,3,'Mamun Medical Supply','2020-12-22',30,'pain killers','napa extra','70','1','70.0'),(4,4,'Mamun Medical Supply','2020-12-22',40,'pain killers','napa','50','3','150.0'),(5,5,'Mamun Medical Supply','2020-12-22',50,'cough syrup','bashok','190','2','380.0'),(6,6,'Select','2020-12-22',60,'pain killers','napa extra','70','2','140.0'),(7,7,'Mamun Medical Supply','2020-12-22',70,'pain killers','napa extra','70','2','140.0'),(8,8,'Mamun Medical Supply','2020-12-22',80,'pain killers','napa extra','70','2','140.0'),(9,9,'Mamun Medical Supply','2020-12-22',90,'cough syrup','bashok','190','2','380.0'),(10,10,'Mamun Medical Supply','2020-12-22',100,'pain killers','napa extra','70','2','140.0'),(11,11,'Mamun Medical Supply','2020-12-22',110,'pain killers','napa','50','12','600.0'),(12,12,'Mamun Medical Supply','2020-12-22',120,'cough syrup','Alcolf','200','2','400.0'),(13,13,'Mamun Medical Supply','2020-12-22',130,'cough syrup','Alcolf','200','2','400.0'),(14,14,'Select','2020-12-22',140,'pain killers','napa extra','70','2','140.0'),(15,15,'Mamun Medical Supply','2020-12-22',150,'cough syrup','bashok','190','2','380.0'),(16,16,'Mamun Medical Supply','2020-12-22',160,'pain killers','napa extra','70','02','140.0'),(17,17,'Select','2020-12-22',170,'cough syrup','bashok','190','2','380.0'),(18,18,'Mamun Medical Supply','2020-12-23',180,'cough syrup','Alcolf','200','2','400.0'),(19,19,'Mamun Medical Supply','2020-12-23',190,'cough syrup','Alcolf','200','2','400.0'),(20,20,'Mamun Medical Supply','2020-12-23',200,'pain killers','napa','50','2','100.0'),(21,21,'test','2020-12-23',210,'pain killers','napa extra','70','3','210.0'),(22,22,'Mamun Medical Supply','2020-12-23',220,'cough syrup','Alcolf','200','03','600.0'),(23,23,'Mamun Medical Supply','2020-12-23',230,'first aid','quick bandage','10','20','200.0'),(24,23,'Mamun Medical Supply','2020-12-23',231,'Select','Select','','0','0.00'),(25,24,'Mamun Medical Supply','2020-12-23',241,'pain killers','napa','50','122','6100.0'),(26,25,'Mamun Medical Supply','2020-12-23',251,'cough syrup','bashok','190','23','4370.0'),(27,26,'test','2020-12-23',261,'cough syrup','Alcolf','200','10','2000.0'),(28,27,'Select','2020-12-23',271,'cough syrup','bashok','190','23','4370.0'),(29,28,'Mamun Medical Supply','2020-12-23',281,'pain killers','napa','50','100','5000.0'),(30,29,'Mamun Medical Supply','2020-12-23',291,'pain killers','napa','50','0','0.00'),(31,30,'Mamun Medical Supply','2020-12-23',301,'cough syrup','Alcolf','200','12','2400.0'),(32,31,'test','2020-12-25',311,'first aid','viodin','120','3','360.0'),(33,100,'Mamun Medical Supply','2020-12-26',321,'pain killers','napa extra','70','02','140.0');

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sales entry` */

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

insert  into `salesofficer`(`id`,`sales_name`,`sales_mobile`,`sales_address`,`sales_salary`,`sales_position`,`sales_joining`,`sales_ref`,`sales_ref_mobile`) values (1,'Md arif','0187596111','Dagonbhuiyan, Feni','4000','staff','2020-12-23','N/A','N/A'),(2,'jokeed','1222312133','dfadf','1000','staff','2020-12-23','N/A','N/A');

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

insert  into `suppliers`(`supplier_id`,`supplier_name`,`supplier_company_name`,`supplier_mobile`,`supplier_address`) values (1,'Md Mamun','Mamun Medical Supply','01829928373','Tongi, Gazipur'),(2,'test','test','test','test'),(3,'test','test','test','test');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(100) NOT NULL,
  `user_name` varchar(100) default NULL,
  `user_password` varchar(100) default NULL,
  `user_mobile` varchar(100) default NULL,
  `user_email` varchar(100) default NULL,
  `user_role` varchar(100) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`user_id`,`user_name`,`user_password`,`user_mobile`,`user_email`,`user_role`) values (1,'shafin','123','01875965178','mh@123','developer');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
