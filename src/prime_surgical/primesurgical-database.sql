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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `bank data` */

insert  into `bank data`(`sl_no`,`bank_date`,`bank_name`,`bank_account`,`bank_details`,`bank_status`,`bank_amount`) values (1,'2020-12-23','Jamuna bank','1222123233','Purchase','Withdraw','3000'),(3,'2020-12-23','sonali bank','12221','Purchase','Withdraw','200'),(4,'2020-12-23','Jamuna Bank','1222123233','Capital','Deposit','50000'),(5,'2020-12-25','Jamuna bank','1222123233','staff salary','Withdraw','1200.0'),(6,'2020-12-26','Jamuna bank','1222123233','Withdraw','Deposit','10000'),(7,'2020-12-26','Jamuna Bank','1222123233','From Cash','Deposit','104.0'),(8,'2020-12-31','Pubali Bank','989876767','From Cash','Deposit','30'),(9,'2020-12-31','Jamuna Bank','1222123233','From Cash','Deposit','60'),(10,'2020-12-31','Pubali Bank','989876767','From Cash','Deposit','270.3'),(11,'2021-12-01','Jamuna Bank','1222123233','Sales','Debit','1200');

/*Table structure for table `cash data` */

DROP TABLE IF EXISTS `cash data`;

CREATE TABLE `cash data` (
  `sl_no` int(100) NOT NULL auto_increment,
  `cash_date` date default NULL,
  `cash_details` varchar(100) default NULL,
  `cash_status` varchar(100) default NULL,
  `cash_amount` varchar(100) default NULL,
  PRIMARY KEY  (`sl_no`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Data for the table `cash data` */

insert  into `cash data`(`sl_no`,`cash_date`,`cash_details`,`cash_status`,`cash_amount`) values (1,'2020-12-23','Purchase','Debit','3000'),(2,'2020-12-23','Purchase','Debit','2000'),(3,'2020-12-23','Purchase','Debit','1500'),(4,'2020-12-23','Purchase','Debit','0.00'),(5,'2020-12-24','Capital','Credit','50000'),(6,'2020-12-24','Current bill','debit','1578'),(7,'2020-12-25','SR comission','Debit','300.0'),(8,'2020-12-25','Purchase','Debit','200'),(9,'2020-12-26','Purchase','Debit','130'),(10,'2020-12-30','sales','credit','500'),(11,'2020-12-30','Personal','credit','100'),(12,'2021-01-01','test','credit','100'),(13,'2020-12-31','Bank Deposited','Debit','60'),(14,'2020-12-31','Bank Deposited','Debit','270.3'),(15,'2021-01-01','Purchase','Debit','440'),(16,'2021-01-01','Purchase Due','Debit','1244'),(17,'2021-01-01','Purchase Due','Debit','1000'),(18,'2021-01-01','Purchase Due','Debit','2000'),(19,'2021-01-01','Purchase Due','Debit','1000'),(20,'2021-01-01','Purchase Due','Debit','2000'),(21,'2021-01-01','Purchase','Debit','500'),(22,'2021-01-02','Purchase Due','Debit','230');

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

insert  into `purchase accounts`(`bill_no`,`gr`,`date`,`company`,`items`,`total`,`payment`,`discount`,`paid`,`due`) values ('1','13','2021-01-01','Mamun Medical Supply',7,760,'Cash','30','500','230.0'),('1Mamun','Due Paid','2021-01-02','Mamun Medical Supply',0,230,'Cash','0','230','0.0');

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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

/*Data for the table `purchase entry` */

insert  into `purchase entry`(`purchase_id`,`bill_no`,`company_name`,`purchase_date`,`purchase_gr`,`category`,`product`,`price`,`quantity`,`total`) values (1,1,'Mamun Medical Supply','2021-01-01',10,'first aid','quick bandage','10','2','20.0'),(2,1,'Mamun Medical Supply','2021-01-01',11,'cough syrup','Alcolf','200','3','600.0'),(3,1,'Mamun Medical Supply','2021-01-01',12,'pain killers','napa extra','70','2','140.0');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `sales entry` */

insert  into `sales entry`(`sales_id`,`bill_no`,`customer_name`,`sales_date`,`sales_gr`,`category`,`product`,`price`,`quantity`,`total`) values (1,1,'md omuk','2021-01-01',100,'First Aid','quick bandage','10','2','20');

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

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

/*!50001 DROP VIEW IF EXISTS `products` */;
/*!50001 DROP TABLE IF EXISTS `products` */;

/*!50001 CREATE TABLE  `products`(
 `cateogory_id` int(100) ,
 `cateogory` varchar(100) ,
 `product_id` int(100) ,
 `product_name` varchar(100) 
)*/;

/*Table structure for table `purchase_items` */

DROP TABLE IF EXISTS `purchase_items`;

/*!50001 DROP VIEW IF EXISTS `purchase_items` */;
/*!50001 DROP TABLE IF EXISTS `purchase_items` */;

/*!50001 CREATE TABLE  `purchase_items`(
 `cateogory` varchar(100) ,
 `product` varchar(200) ,
 `total_purchase` double 
)*/;

/*Table structure for table `sales_items` */

DROP TABLE IF EXISTS `sales_items`;

/*!50001 DROP VIEW IF EXISTS `sales_items` */;
/*!50001 DROP TABLE IF EXISTS `sales_items` */;

/*!50001 CREATE TABLE  `sales_items`(
 `cateogory` varchar(100) ,
 `product` varchar(200) ,
 `total_sales` double 
)*/;

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

/*!50001 DROP VIEW IF EXISTS `stock` */;
/*!50001 DROP TABLE IF EXISTS `stock` */;

/*!50001 CREATE TABLE  `stock`(
 `cateogory` varchar(100) ,
 `product` varchar(200) ,
 `total_purchase` double ,
 `total_sales` double ,
 `total` double 
)*/;

/*View structure for view products */

/*!50001 DROP TABLE IF EXISTS `products` */;
/*!50001 DROP VIEW IF EXISTS `products` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `products` AS (select `product cateogory`.`cateogory_id` AS `cateogory_id`,`product cateogory`.`cateogory` AS `cateogory`,`product info`.`product_id` AS `product_id`,`product info`.`product_name` AS `product_name` from (`product cateogory` join `product info` on((`product cateogory`.`cateogory_id` = `product info`.`product_category_id`))) group by `product info`.`product_id`) */;

/*View structure for view purchase_items */

/*!50001 DROP TABLE IF EXISTS `purchase_items` */;
/*!50001 DROP VIEW IF EXISTS `purchase_items` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `purchase_items` AS (select `products`.`cateogory` AS `cateogory`,`purchase entry`.`product` AS `product`,sum(`purchase entry`.`quantity`) AS `total_purchase` from (`purchase entry` join `products` on((`purchase entry`.`product` = `products`.`product_name`))) group by `purchase entry`.`product`) */;

/*View structure for view sales_items */

/*!50001 DROP TABLE IF EXISTS `sales_items` */;
/*!50001 DROP VIEW IF EXISTS `sales_items` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sales_items` AS (select `products`.`cateogory` AS `cateogory`,`sales entry`.`product` AS `product`,sum(`sales entry`.`quantity`) AS `total_sales` from (`sales entry` join `products` on((`sales entry`.`product` = `products`.`product_name`))) group by `sales entry`.`product`) */;

/*View structure for view stock */

/*!50001 DROP TABLE IF EXISTS `stock` */;
/*!50001 DROP VIEW IF EXISTS `stock` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stock` AS (select `purchase_items`.`cateogory` AS `cateogory`,`purchase_items`.`product` AS `product`,`purchase_items`.`total_purchase` AS `total_purchase`,`sales_items`.`total_sales` AS `total_sales`,(`purchase_items`.`total_purchase` - `sales_items`.`total_sales`) AS `total` from ((`products` join `purchase_items`) left join `sales_items` on((`purchase_items`.`product` = `sales_items`.`product`))) group by `purchase_items`.`product` order by `purchase_items`.`product`) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
