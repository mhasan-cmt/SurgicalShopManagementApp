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

/*Table structure for table `adminpower` */

DROP TABLE IF EXISTS `adminpower`;

CREATE TABLE `adminpower` (
  `powerId` int(100) NOT NULL,
  `admin_username` varchar(200) default NULL,
  `admin_password` varchar(100) default NULL,
  PRIMARY KEY  (`powerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `adminpower` */

insert  into `adminpower`(`powerId`,`admin_username`,`admin_password`) values (0,'shafin','123');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `bank data` */

insert  into `bank data`(`sl_no`,`bank_date`,`bank_name`,`bank_account`,`bank_details`,`bank_status`,`bank_amount`) values (1,'2020-12-23','Jamuna bank','1222123233','Purchase','Withdraw','3000'),(3,'2020-12-23','sonali bank','12221','Purchase','Withdraw','200'),(4,'2020-12-23','Jamuna Bank','1222123233','Capital','Deposit','50000'),(5,'2020-12-25','Jamuna bank','1222123233','staff salary','Withdraw','1200.0'),(6,'2020-12-26','Jamuna bank','1222123233','Withdraw','Deposit','10000'),(7,'2020-12-26','Jamuna Bank','1222123233','From Cash','Deposit','104.0'),(8,'2020-12-31','Pubali Bank','989876767','From Cash','Deposit','30'),(9,'2020-12-31','Jamuna Bank','1222123233','From Cash','Deposit','60'),(10,'2020-12-31','Pubali Bank','989876767','From Cash','Deposit','270.3'),(11,'2021-12-01','Jamuna Bank','1222123233','Sales','Deposit','1200');

/*Table structure for table `cash data` */

DROP TABLE IF EXISTS `cash data`;

CREATE TABLE `cash data` (
  `sl_no` int(100) NOT NULL auto_increment,
  `cash_date` date default NULL,
  `cash_details` varchar(100) default NULL,
  `cash_status` varchar(100) default NULL,
  `cash_amount` varchar(100) default NULL,
  PRIMARY KEY  (`sl_no`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

/*Data for the table `cash data` */

insert  into `cash data`(`sl_no`,`cash_date`,`cash_details`,`cash_status`,`cash_amount`) values (1,'2020-12-23','Purchase','Debit','3000'),(2,'2020-12-23','Purchase','Debit','2000'),(3,'2020-12-23','Purchase','Debit','1500'),(4,'2020-12-23','Purchase','Debit','0.00'),(5,'2020-12-24','Capital','Credit','50000'),(6,'2020-12-24','Current bill','debit','1578'),(7,'2020-12-25','SR comission','Debit','300.0'),(8,'2020-12-25','Purchase','Debit','200'),(9,'2020-12-26','Purchase','Debit','130'),(10,'2020-12-30','sales','credit','500'),(11,'2020-12-30','Personal','credit','100'),(12,'2021-01-01','test','credit','100'),(13,'2020-12-31','Bank Deposited','Debit','60'),(14,'2020-12-31','Bank Deposited','Debit','270.3'),(15,'2021-01-01','Purchase','Debit','440'),(16,'2021-01-01','Purchase Due','Debit','1244'),(17,'2021-01-01','Purchase Due','Debit','1000'),(18,'2021-01-01','Purchase Due','Debit','2000'),(19,'2021-01-01','Purchase Due','Debit','1000'),(20,'2021-01-01','Purchase Due','Debit','2000'),(21,'2021-01-01','Purchase','Debit','500'),(22,'2021-01-02','Purchase Due','Debit','230'),(23,'2021-01-02','Purchase','Debit','0.00'),(24,'2021-01-02','Purchase','Debit','0.00'),(25,'2021-01-05','Sales','Credit','5000'),(26,'2021-01-05','Purchase','Debit','3000'),(27,'2021-01-05','Purchase','Debit','15000'),(28,'2021-01-05','Purchase','Debit','0'),(29,'2021-01-05','Purchase','Debit','0.00'),(30,'2021-01-05','Purchase','Debit','0.00'),(31,'2021-01-05','Purchase','Debit','0.00'),(32,'2021-01-05','Purchase','Debit','3000'),(33,'2021-01-05','Sales','Credit','0'),(34,'2021-01-05','Sales','Credit','0'),(35,'2021-01-05','Sales','Credit','1000'),(36,'2021-01-05','Sales','Credit','0.00'),(37,'2021-01-05','Sales','Credit','0.00'),(38,'2021-01-05','Sales','Credit','0.00'),(39,'2021-01-05','Sales','Credit','0.00'),(40,'2021-01-05','Sales','Credit','0.00'),(41,'2021-01-05','Sales','Credit','0.00');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `cost data` */

insert  into `cost data`(`sl_no`,`cost_date`,`cost_type`,`cost_bill`,`cost_details`,`cost_paid_by`,`cost_amount`) values (1,'2020-12-25','Sales Cost','123','Home delivery','Arif (Staff)','370.0'),(2,'2020-12-25','Others Cost','11','staff salary','Owner','1200.0'),(5,'2021-01-04','Sales cost','1','SR Commision','N/A','20.2');

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

insert  into `customers`(`id`,`customer name`,`mobile`,`shop name`,`address`) values (1,'Md Mahmud','121111','Mahmud Pharma','Uttara, Dhaka'),(202,'Md Arif','01856675556','Arif Pharma','Feni');

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

insert  into `purchase accounts`(`bill_no`,`gr`,`date`,`company`,`items`,`total`,`payment`,`discount`,`paid`,`due`) values ('1','13','2021-01-01','Mamun Medical Supply',7,760,'Cash','30','500','230.0'),('1Mamun','Due Paid','2021-01-02','Mamun Medical Supply',0,230,'Cash','0','230','0.0'),('2','23','2021-01-02','Mamun Medical Supply',2,380,'Cash','0.00','0.00','380'),('3','33','2021-01-02','test',300,3000,'Cash','0.00','0.00','3000'),('6','110','2021-01-05','Mahmud Pharma',57,14410,'Cash','150','5000','9260.0'),('1','12','2021-01-05','Mamun Medical Supply',32,6200,'Cash','100','3000','3100.0'),('2','23','2021-01-05','Mamun Medical Supply',250,23000,'Cash','0','15000','23000.0'),('2','33','2021-01-05','Mamun Medical Supply',273,24610,'Cash','0.00','0','24610.0'),('1','43','2021-01-05','test',42,6900,'Cash','0.00','0.00','6900'),('1','43','2021-01-05','test',42,6300,'Cash','0.00','0.00','6300'),('3','65','2021-01-05','Mamun Medical Supply',110,2200,'Cash','0.00','0.00','2200'),('3','75','2021-01-05','test',130,6200,'Cash','100','3000','3100.0'),('1','30','2021-01-05','Mahmud Pharma',25,13350,'Cash','0','0','13350.0'),('2','40','2021-01-05','Mahmud Pharma',10,3000,'Cash','10','1000','1990.0'),('3','50','2021-01-05','Mahmud Pharma',10,1500,'Cash','0.00','0.00','1500.0'),('4','60','2021-01-05','Mahmud Pharma',2,2400,'Cash','0.00','0.00','2400.0'),('5','70','2021-01-05','Arif Pharma',3,510,'Cash','0.00','0.00','510.0'),('6','80','2021-01-05','Mahmud Pharma',3,246,'Cash','0.00','0.00','246.0'),('7','100','2021-01-05','Nayeem',10,1300,'Cash','0.00','0.00','1300.0'),('8','110','2021-01-05','Nayeem',5,650,'Cash','0.00','0.00','650.0');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `purchase entry` */

insert  into `purchase entry`(`purchase_id`,`bill_no`,`company_name`,`purchase_date`,`purchase_gr`,`category`,`product`,`price`,`quantity`,`total`) values (1,1,'Mamun Medical Supply','2021-01-05',10,'cough syrup','Alcolf','200','12','2400.0'),(2,1,'Mamun Medical Supply','2021-01-05',11,'cough syrup','bashok','190','20','3800.0'),(3,2,'Mamun Medical Supply','2021-01-05',21,'pain killers','napa','50','100','5000.0'),(4,2,'Mamun Medical Supply','2021-01-05',22,'first aid','viodin','120','150','18000.0'),(5,2,'Mamun Medical Supply','2021-01-05',32,'pain killers','napa extra','70','23','1610.0'),(6,1,'test','2021-01-05',42,'first aid','quick bandage','10','10','100.0'),(7,2,'test','2021-01-05',52,'pain killers','napa','50','10','500.0'),(8,2,'test','2021-01-05',53,'cough syrup','Alcolf','200','12','2400.0'),(9,3,'Mamun Medical Supply','2021-01-05',63,'first aid','quick bandage','10','100','1000.0'),(10,3,'Mamun Medical Supply','2021-01-05',64,'first aid','viodin','120','10','1200.0'),(11,3,'test','2021-01-05',74,'cough syrup','Alcolf','200','20','4000.0');

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `sales entry` */

insert  into `sales entry`(`sales_id`,`bill_no`,`customer_name`,`sales_date`,`sales_gr`,`category`,`product`,`price`,`quantity`,`total`) values (1,1,'Md Mahmud','2021-01-05',10,'cough syrup','Alcolf','300.0','20','12000.0'),(2,1,'Md Mahmud','2021-01-05',20,'pain killers','napa extra','270.0','5','1350.0'),(3,2,'Md Mahmud','2021-01-05',30,'cough syrup','Alcolf','300.0','10','3000.0'),(4,3,'Md Mahmud','2021-01-05',40,'pain killers','napa','150.0','10','1500.0'),(5,4,'Md Mahmud','2021-01-05',50,'cough syrup','Alcolf','300.0','2','2400.0'),(6,5,'Md Arif','2021-01-05',60,'pain killers','napa extra','170.0','3','510.0'),(7,6,'Md Mahmud','2021-01-05',70,'pain killers','napa extra','82.0','3','246.0'),(8,7,'Nayeem','2021-01-05',80,'first aid','quick bandage','20.0','5','100.0'),(9,7,'Nayeem','2021-01-05',90,'first aid','viodin','240.0','5','1200.0'),(10,8,'Nayeem','2021-01-05',100,'first aid','viodin','130.0','5','650.0');

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

insert  into `salesofficer`(`id`,`sales_name`,`sales_mobile`,`sales_address`,`sales_salary`,`sales_position`,`sales_joining`,`sales_ref`,`sales_ref_mobile`) values (1,'Md arif','0187596111','Dagonbhuiyan, Feni','4000','staff','2020-12-23','N/A','N/A'),(2,'jokeed','1222312133','dfadf','1000','staff','2020-12-23','N/A','N/A');

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `stock_id` int(100) NOT NULL auto_increment,
  `category` varchar(100) default NULL,
  `product` varchar(100) default NULL,
  `total_purchase` varchar(100) default NULL,
  `total_sales` varchar(100) default NULL,
  PRIMARY KEY  (`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `stock` */

insert  into `stock`(`stock_id`,`category`,`product`,`total_purchase`,`total_sales`) values (3,'pain killers','napa extra','23','0'),(4,'pain killers','napa extra','10','0'),(5,'first aid','quick bandage','10','0'),(6,'pain killers','napa','10','0'),(7,'cough syrup','Alcolf','12','0'),(8,'first aid','quick bandage','100','0'),(9,'first aid','viodin','10','0'),(10,'cough syrup','Alcolf','20','0'),(11,'cough syrup','Alcolf','0','20'),(12,'pain killers','napa extra','0','5'),(13,'cough syrup','Alcolf','0','10'),(14,'pain killers','napa','0','10'),(15,'cough syrup','Alcolf','0','2'),(16,'pain killers','napa extra','0','3'),(17,'pain killers','napa extra','0','3'),(18,'first aid','quick bandage','0','5'),(19,'first aid','viodin','0','5'),(20,'first aid','viodin','0','5');

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

/*Table structure for table `finalstock` */

DROP TABLE IF EXISTS `finalstock`;

/*!50001 DROP VIEW IF EXISTS `finalstock` */;
/*!50001 DROP TABLE IF EXISTS `finalstock` */;

/*!50001 CREATE TABLE  `finalstock`(
 `category` varchar(100) ,
 `product` varchar(100) ,
 `total_purchase` double ,
 `total_sales` double 
)*/;

/*Table structure for table `stockfinal` */

DROP TABLE IF EXISTS `stockfinal`;

/*!50001 DROP VIEW IF EXISTS `stockfinal` */;
/*!50001 DROP TABLE IF EXISTS `stockfinal` */;

/*!50001 CREATE TABLE  `stockfinal`(
 `category` varchar(100) ,
 `product` varchar(100) ,
 `total_purchase` double ,
 `total_sales` double ,
 `total` double 
)*/;

/*View structure for view finalstock */

/*!50001 DROP TABLE IF EXISTS `finalstock` */;
/*!50001 DROP VIEW IF EXISTS `finalstock` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `finalstock` AS (select `stock`.`category` AS `category`,`stock`.`product` AS `product`,sum(`stock`.`total_purchase`) AS `total_purchase`,sum(`stock`.`total_sales`) AS `total_sales` from `stock` group by `stock`.`product`) */;

/*View structure for view stockfinal */

/*!50001 DROP TABLE IF EXISTS `stockfinal` */;
/*!50001 DROP VIEW IF EXISTS `stockfinal` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stockfinal` AS (select `finalstock`.`category` AS `category`,`finalstock`.`product` AS `product`,`finalstock`.`total_purchase` AS `total_purchase`,`finalstock`.`total_sales` AS `total_sales`,(sum(`finalstock`.`total_purchase`) - sum(`finalstock`.`total_sales`)) AS `total` from `finalstock` group by `finalstock`.`product`) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
