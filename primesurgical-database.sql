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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

/*Data for the table `bank data` */

insert  into `bank data`(`sl_no`,`bank_date`,`bank_name`,`bank_account`,`bank_details`,`bank_status`,`bank_amount`) values (1,'2020-12-23','Jamuna bank','1222123233','Purchase','Withdraw','3000'),(3,'2020-12-23','sonali bank','12221','Purchase','Withdraw','200'),(4,'2020-12-23','Jamuna Bank','1222123233','Capital','Deposit','50000'),(5,'2020-12-25','Jamuna bank','1222123233','staff salary','Withdraw','1200.0'),(6,'2020-12-26','Jamuna bank','1222123233','Withdraw','Deposit','10000'),(7,'2020-12-26','Jamuna Bank','1222123233','From Cash','Deposit','104.0'),(8,'2020-12-31','Pubali Bank','989876767','From Cash','Deposit','30'),(9,'2020-12-31','Jamuna Bank','1222123233','From Cash','Deposit','60'),(10,'2020-12-31','Pubali Bank','989876767','From Cash','Deposit','270.3'),(11,'2021-12-01','Jamuna Bank','1222123233','Sales','Deposit','1200'),(12,'2021-01-20','sonali bank','12221','Staff salary','Debit','30000'),(13,'2021-01-20','sonali bank','12221','House rent','Debit','3000'),(14,'2021-01-20','Jamuna Bank','1222123233','Stealed money','Withdraw','5000'),(15,'2021-01-20','Jamuna Bank','1222123233','personal','Withdraw','5000'),(16,'2021-01-20','Jamuna Bank','1222123233','personal','Withdraw','3000');

/*Table structure for table `cash data` */

DROP TABLE IF EXISTS `cash data`;

CREATE TABLE `cash data` (
  `sl_no` int(100) NOT NULL auto_increment,
  `cash_date` date default NULL,
  `cash_details` varchar(100) default NULL,
  `cash_status` varchar(100) default NULL,
  `cash_amount` varchar(100) default NULL,
  PRIMARY KEY  (`sl_no`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=latin1;

/*Data for the table `cash data` */

insert  into `cash data`(`sl_no`,`cash_date`,`cash_details`,`cash_status`,`cash_amount`) values (1,'2020-12-23','Purchase','Debit','3000'),(2,'2020-12-23','Purchase','Debit','2000'),(3,'2020-12-23','Purchase','Debit','1500'),(5,'2020-12-24','Capital','Credit','50000'),(6,'2020-12-24','Current bill','debit','1578'),(7,'2020-12-25','SR comission','Debit','300.0'),(8,'2020-12-25','Purchase','Debit','200'),(9,'2020-12-26','Purchase','Debit','130'),(10,'2020-12-30','sales','credit','500'),(11,'2020-12-30','Personal','credit','100'),(12,'2021-01-01','test','credit','100'),(13,'2020-12-31','Bank Deposited','Debit','60'),(14,'2020-12-31','Bank Deposited','Debit','270.3'),(15,'2021-01-01','Purchase','Debit','440'),(16,'2021-01-01','Purchase Due','Debit','1244'),(17,'2021-01-01','Purchase Due','Debit','1000'),(18,'2021-01-01','Purchase Due','Debit','2000'),(19,'2021-01-01','Purchase Due','Debit','1000'),(20,'2021-01-01','Purchase Due','Debit','2000'),(21,'2021-01-01','Purchase','Debit','500'),(22,'2021-01-02','Purchase Due','Debit','230'),(25,'2021-01-05','Sales','Credit','5000'),(26,'2021-01-05','Purchase','Debit','3000'),(27,'2021-01-05','Purchase','Debit','15000'),(32,'2021-01-05','Purchase','Debit','3000'),(35,'2021-01-05','Sales','Credit','1000'),(42,'2021-01-07','Purchase Due','Debit','8000'),(44,'2021-01-07','Sales','Credit','13350'),(46,'2021-01-07','Sales','Credit','200'),(47,'2021-01-07','Sales','Credit','500'),(53,'2021-01-08','Purchase Due','Debit','3000'),(54,'2021-01-08','Purchase Due','Debit','3000'),(55,'2021-01-08','Purchase Due','Debit','3000'),(56,'2021-01-08','Sales','Credit','400'),(57,'2021-01-08','Sales','Credit','220'),(68,'2021-01-20','Arif cash','debit','3000'),(71,'2021-01-20','Purchase Due','Debit','3000'),(72,'2021-02-03','Sales','Credit','3140'),(73,'2021-02-03','Sales','Credit','510'),(74,'2021-02-03','Sales','Credit','200');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `product info` */

insert  into `product info`(`product_id`,`product_name`,`product_price`,`product_details`,`product_category_id`) values (1,'Alcolf','200','beximco inc.',1),(2,'bashok','190','glaxosmith inc.',1),(3,'napa','50','beximco inc',2),(4,'napa extra','70','beximco inc.',2),(5,'quick bandage','10','square inc',3),(6,'viodin','120','square inc',3),(7,'ointment','70','Arise pharma inc',2),(8,'5ml Syringe','15','Arisco pharmatical inc',3);

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

insert  into `purchase accounts`(`bill_no`,`gr`,`date`,`company`,`items`,`total`,`payment`,`discount`,`paid`,`due`) values ('1','12','2021-01-08','Arif Medical Supply',100,6000,'Cash','0.00','0.00','6000'),('1Arif','Due Paid','2021-01-08','Arif Medical Supply',0,0,'Cash','0','3000','3000.0'),('1','23','2021-01-18','Muruf Medical Supply',100,12000,'Cash','0.00','0.00','12000'),('2Arif','Due Paid','2021-01-20','Arif Medical Supply',0,0,'Cash','0','3000','0.0'),('1','33','2021-01-31','Mamun Medical Supply',12,18840,'Due','0.00','0.00','18840'),('1','11','2021-02-28','Mamun Medical Supply',20,1000,'Due','0.00','0.00','1000'),('1','21','2021-02-01','Arif Medical Supply',10,1700,'Due','0.00','0.00','1700'),('2','31','2021-02-01','Mamun Medical Supply',2,20,'Due','0.00','0.00','20'),('1','41','2021-02-03','Muruf Medical Supply',10,2400,'Due','0.00','0.00','2400'),('2','51','2021-02-03','Arif Medical Supply',100,1520,'Due','0.00','0.00','1520');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `purchase entry` */

insert  into `purchase entry`(`purchase_id`,`bill_no`,`company_name`,`purchase_date`,`purchase_gr`,`category`,`product`,`price`,`quantity`,`total`) values (1,1,'Mamun Medical Supply','2021-02-28',10,'pain killers','napa','50','20','1000.0'),(2,1,'Arif Medical Supply','2021-02-01',20,'pain killers','napa extra','70','10','700.0'),(3,2,'Mamun Medical Supply','2021-02-01',30,'first aid','quick bandage','10','2','20.0'),(4,1,'Muruf Medical Supply','2021-02-03',40,'pain killers','ointment','70','10','700.0'),(5,2,'Arif Medical Supply','2021-02-03',50,'first aid','5ml Syringe','15','100','1500.0'),(6,3,'Mamun Medical Supply','2021-02-03',60,'cough syrup','Alcolf','200','5','1000.0');

/*Table structure for table `purchaseorder` */

DROP TABLE IF EXISTS `purchaseorder`;

CREATE TABLE `purchaseorder` (
  `orderId` int(100) NOT NULL,
  `company` varchar(200) default NULL,
  `orderDate` date default NULL,
  `deliveryDate` date default NULL,
  `category` varchar(100) default NULL,
  `productName` varchar(100) default NULL,
  `price` varchar(100) default NULL,
  `quantity` varchar(100) default NULL,
  `total` varchar(100) default NULL,
  `gr` varchar(100) default 'Pur',
  PRIMARY KEY  (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `purchaseorder` */

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

insert  into `sales accounts`(`bill_no`,`gr`,`date`,`customer`,`items`,`total`,`payment`,`discount`,`paid`,`due`) values ('1','30','2021-01-20','Md Ahnaf hossain',22,1540,'Cash','0.00','0.00','1540.0'),('3','50','2021-01-20','Md Ahnaf Hossain',12,1440,'Bank','0.00','0.00','1440.0'),('4','60','2021-01-31','Md Mahmud',10,700,'Due','0.00','0.00','700.0'),('5','70','2021-01-31','Md Naeem',3,180,'Due','0.00','0.00','180.0'),('1','20','2021-02-01','Md Ahnaf Hossain',2,160,'Bank','0.00','0.00','160.0'),('1','20','2021-02-01','Md Arif',7,510,'Due','0.00','0.00','510.0'),('2','30','2021-02-01','Md Mahmud',4,200,'Due','0.00','0.00','200.0'),('3','40','2021-02-03','Ariful islam',1,30,'Due','0.00','0.00','30.0'),('1ahnaf','Due paid','2021-02-03','Md Ahnaf hossain',0,0,'Cash','0.00','3140','0.0'),('1Arif','Due paid','2021-02-03','Md Arif',0,0,'Cash','0.00','510','0.0'),('212','Due paid','2021-02-03','Md Mahmud',0,0,'Cash','0.00','200','700.0');

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

/*Data for the table `sales entry` */

insert  into `sales entry`(`sales_id`,`bill_no`,`customer_name`,`sales_date`,`sales_gr`,`category`,`product`,`price`,`quantity`,`total`) values (13,1,'Md Ahnaf Hossain','2021-02-28',10,'pain killers','napa','80.0','2','160.0'),(14,0,'0','0000-00-00',0,'pain killers','napa','0','0','0'),(19,0,'0',NULL,0,'pain killers','napa extra','0','0','0'),(20,1,'Md Arif','2021-02-01',10,'pain killers','napa extra','90.0','5','350.0'),(21,2,'Md Mahmud','2021-02-01',20,'pain killers','napa','60.0','4','200.0'),(22,3,'Ariful islam','2021-02-03',30,'pain killers','napa','30','1','30.0'),(23,0,'0','0000-00-00',0,'pain killers','ointment','0','0','0'),(24,0,'0','0000-00-00',0,'first aid','quick bandage','0','0','0'),(26,0,'0','0000-00-00',0,'first aid','5ml Syringe','0','0','0'),(27,0,'0','0000-00-00',0,'cough syrup','alcolf','0','0','0');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`user_id`,`user_name`,`user_password`,`user_mobile`,`user_email`,`user_role`) values (1,'shafin','123','01875965178','mh@123','Admin'),(2,'Md Mustofa arif','4321','01854578102','mustofa@arif.mail','Staff-001');

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
