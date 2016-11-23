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

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;