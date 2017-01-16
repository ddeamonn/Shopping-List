SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `java2` DEFAULT CHARACTER SET utf8 ;
USE `java2` ;

-- -----------------------------------------------------
-- Table `Java2_test`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
    `usr_id` INT(11) NOT NULL AUTO_INCREMENT,        -- Each field in users table is prefixed with 'usr'
    `usr_hash` VARCHAR(100) NOT NULL UNIQUE,         -- This hash will be part of web address, i.e www.smartfridge.com/webapp?u=Xs8w0jspC3pY
    `usr_name` VARCHAR(255),                         -- User name and surname, can be NULL if not provided
    `usr_email` VARCHAR(255) NULL UNIQUE,            -- Unique user email, can be NULL
    `usr_password` VARCHAR(255),                     -- Encrypted password
    `usr_phone` VARCHAR(100),                        -- Telephone number
    `usr_language` VARCHAR(3),                       -- User selected language in format en, lv, ru
     PRIMARY KEY (`usr_id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


DROP TABLE IF EXISTS `products` ;

CREATE TABLE IF NOT EXISTS `products` (              -- Each field in products table is prefixed with 'prd'
    `prd_name` VARCHAR(255) NOT NULL,                -- Product name is the primary key
    `prd_id` INT(11) NOT NULL UNIQUE AUTO_INCREMENT, -- Product id should be used to reference the product in other tables
    `prd_category` VARCHAR(255),                     -- Product category or group, for example "food", "bathroom", etc
    `prd_container` VARCHAR(255),                    -- Product container, for example "box", "bottle", "package", etc
    `prd_added_time` DATETIME,                       -- Date and time when the product was added
    `prd_added_ip` VARCHAR(255),                     -- IP address from which the product was added
    `prd_added_country` VARCHAR(23),                 -- Country from which the product was added
     PRIMARY KEY (`prd_name`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


DROP TABLE IF EXISTS `shops` ;

CREATE TABLE IF NOT EXISTS `shops` (
    `shp_id` INT(11) NOT NULL AUTO_INCREMENT,        -- Shop id
    `shp_short_name` VARCHAR(255),                   -- Shop short name
    `shp_full_name` VARCHAR(255),                    -- Shop full name
    `shp_address` VARCHAR(255),                      -- Address
    `shp_country` VARCHAR(3),                        -- Shop location country
    `shp_added_time` DATETIME,                       -- Date and time when the shop was added to the database by user
    `shp_added_ip` VARCHAR(255),                     -- IP address from which the shop was added
    `shp_added_country` VARCHAR(3),                  -- Country from which the shop was added
    PRIMARY KEY (`shp_id`)
);

DROP TABLE IF EXISTS `shopping_list_details` ;

CREATE TABLE IF NOT EXISTS `shopping_list_details`(
    `prd_id` INT(11),                                -- Product id which is added by user to the shopping list
    `lst_id` BIGINT(20),                             -- Shopping list item id
    `prd_quantity` INT(5),                           -- Quantity of how many items of the given product should be bought
    `prd_price` FLOAT(7),                            -- Price of the item
    `shp_id` INT(11),                                -- Shop id where the item can be bought
    PRIMARY KEY (`prd_id`, `lst_id`),
    FOREIGN KEY (`prd_id`) REFERENCES `products` (`prd_id`),
    FOREIGN KEY (`shp_id`) REFERENCES `shops` (`shp_id`),
    FOREIGN KEY (`lst_id`) REFERENCES `shopping_list` (`lst_id`)
);

DROP TABLE IF EXISTS `shopping_list` ;

CREATE TABLE IF NOT EXISTS `shopping_list`(
    `lst_id` BIGINT(20) NOT NULL AUTO_INCREMENT,     -- Shopping list item id
    `usr_id` INT(11),                                -- User id which created the shopping list. This field should be indexed
    `lst_quantity` INT(5),                           -- Quantity of how many items of the all products should be bought
    `lst_price` FLOAT(7),                            -- Total price of  all items
    `lst_added_time` DATETIME,
    `lst_added_ip` VARCHAR(255),
    `lst_added_country` VARCHAR(3),
    PRIMARY KEY (`lst_id`),
    FOREIGN KEY (`usr_id`) REFERENCES `users` (`usr_id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

/* changes 20170116*/
DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
    `order_id` bigint(11) NOT NULL AUTO_INCREMENT,
    `prd_id` bigint(11) DEFAULT NULL,
    `lst_id` bigint(20) DEFAULT NULL,
    `prd_quantity` int(5) DEFAULT NULL,
    `prd_price` decimal(7,2) DEFAULT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
    `prd_name` varchar(255) NOT NULL,
    `prd_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
    `prd_category` varchar(255) DEFAULT NULL,
    `prd_container` varchar(255) DEFAULT NULL,
    `prd_added_time` datetime DEFAULT NULL,
    `prd_added_ip` varchar(255) DEFAULT NULL,
    `prd_added_country` varchar(23) DEFAULT NULL,
    PRIMARY KEY (`prd_id`),
    UNIQUE KEY `prd_id` (`prd_id`),
    UNIQUE KEY `prd_name_UNIQUE` (`prd_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1019 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `shopping_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopping_list` (
    `lst_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `usr_id` bigint(11) unsigned DEFAULT NULL,
    `lst_quantity` int(5) DEFAULT NULL,
    `lst_price` decimal(10,0) DEFAULT NULL,
    `lst_added_time` datetime DEFAULT NULL,
    `lst_added_ip` varchar(255) DEFAULT NULL,
    `lst_added_country` varchar(3) DEFAULT NULL,
    `lst_name` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`lst_id`),
    KEY `usr_id` (`usr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `shopping_list_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopping_list_details` (
    `prd_id` bigint(11) unsigned NOT NULL DEFAULT '0',
    `lst_id` bigint(20) NOT NULL DEFAULT '0',
    `prd_quantity` int(5) DEFAULT NULL,
    `prd_price` decimal(10,0) DEFAULT NULL,
    `shp_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`prd_id`,`lst_id`),
    KEY `shp_id` (`shp_id`),
    KEY `lst_id` (`lst_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `shops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shops` (
    `shp_id` int(11) NOT NULL AUTO_INCREMENT,
    `shp_short_name` varchar(255) DEFAULT NULL,
    `shp_full_name` varchar(255) DEFAULT NULL,
    `shp_address` varchar(255) DEFAULT NULL,
    `shp_country` varchar(3) DEFAULT NULL,
    `shp_added_time` datetime DEFAULT NULL,
    `shp_added_ip` varchar(255) DEFAULT NULL,
    `shp_added_country` varchar(3) DEFAULT NULL,
    PRIMARY KEY (`shp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
    `usr_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
    `usr_hash` varchar(100) DEFAULT NULL,
    `usr_name` varchar(255) DEFAULT NULL,
    `usr_email` varchar(255) DEFAULT NULL,
    `usr_password` varchar(255) DEFAULT NULL,
    `usr_phone` varchar(100) DEFAULT NULL,
    `usr_language` varchar(3) DEFAULT NULL,
    PRIMARY KEY (`usr_id`),
    UNIQUE KEY `usr_hash` (`usr_hash`),
    UNIQUE KEY `usr_email` (`usr_email`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

DROP TABLE IF EXISTS `shopping_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopping_list` (
    `lst_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `usr_id` bigint(11) unsigned DEFAULT NULL,
    `lst_quantity` int(5) DEFAULT NULL,
    `lst_price` decimal(10,0) DEFAULT NULL,
    `lst_added_time` datetime DEFAULT NULL,
    `lst_added_ip` varchar(255) DEFAULT NULL,
    `lst_added_country` varchar(3) DEFAULT NULL,
    `lst_name` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`lst_id`),
    KEY `usr_id` (`usr_id`),
    CONSTRAINT `shopping_list_ibfk_1` FOREIGN KEY (`usr_id`) REFERENCES `users` (`usr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `shopping_list_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopping_list_details` (
    `prd_id` bigint(11) unsigned NOT NULL DEFAULT '0',
    `lst_id` bigint(20) NOT NULL DEFAULT '0',
    `prd_quantity` int(5) DEFAULT NULL,
    `prd_price` decimal(10,0) DEFAULT NULL,
    `shp_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`prd_id`,`lst_id`),
    KEY `shp_id` (`shp_id`),
    KEY `lst_id` (`lst_id`),
    CONSTRAINT `shopping_list_details_ibfk_2` FOREIGN KEY (`shp_id`) REFERENCES `shops` (`shp_id`),
    CONSTRAINT `shopping_list_details_ibfk_3` FOREIGN KEY (`lst_id`) REFERENCES `shopping_list` (`lst_id`),
    CONSTRAINT `shopping_list_details_ibfk_4` FOREIGN KEY (`prd_id`) REFERENCES `products` (`prd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;