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
  `usr_id` INT(11) NOT NULL AUTO_INCREMENT,   -- Each field in users table is prefixed with 'usr'
  `usr_hash` VARCHAR(100) NOT NULL UNIQUE,    -- This hash will be part of web address, i.e www.smartfridge.com/webapp?u=Xs8w0jspC3pY
  `usr_name` VARCHAR(255),                    -- User name and surname, can be NULL if not provided
  `usr_email` VARCHAR(255) NULL UNIQUE,       -- Unique user email, can be NULL
  `usr_password` VARCHAR(255),                -- Encrypted password
  `usr_phone` VARCHAR(100),                   -- Telephone number
  `usr_language` VARCHAR(3),                  -- User selected language in format en, lv, ru
  PRIMARY KEY (`usr_id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;