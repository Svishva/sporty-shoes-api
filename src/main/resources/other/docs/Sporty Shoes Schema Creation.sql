-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sporty_shoes
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sporty_shoes` ;

-- -----------------------------------------------------
-- Schema sporty_shoes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sporty_shoes` DEFAULT CHARACTER SET utf8 COLLATE utf8_estonian_ci ;
USE `sporty_shoes` ;

-- -----------------------------------------------------
-- Table `sporty_shoes`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sporty_shoes`.`users` ;

CREATE TABLE IF NOT EXISTS `sporty_shoes`.`users` (
  `user_id` VARCHAR(32) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) INVISIBLE,
  PRIMARY KEY (`user_id`));


-- -----------------------------------------------------
-- Table `sporty_shoes`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sporty_shoes`.`orders` ;

CREATE TABLE IF NOT EXISTS `sporty_shoes`.`orders` (
  `order_id` VARCHAR(21) NOT NULL,
  `quantity` INT(11) UNSIGNED NULL DEFAULT 1,
  `user_id` VARCHAR(255) NULL,
  `order_date` DATETIME NOT NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `product_id` VARCHAR(21) NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE INDEX `order_id_UNIQUE` USING BTREE (`order_id`) COMMENT 'Index for Primary KEY' VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sporty_shoes`.`admins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sporty_shoes`.`admins` ;

CREATE TABLE IF NOT EXISTS `sporty_shoes`.`admins` (
  `admin_id` VARCHAR(21) NOT NULL,
  `user_id` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE INDEX `admin_id_UNIQUE` (`admin_id` ASC) COMMENT 'Index for Primary KEY' INVISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sporty_shoes`.`products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sporty_shoes`.`products` ;

CREATE TABLE IF NOT EXISTS `sporty_shoes`.`products` (
  `product_id` VARCHAR(21) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `msrp` DECIMAL(10,2) NOT NULL,
  `quantity_in_stock` INT(11) UNSIGNED NOT NULL,
  `product_vendor` VARCHAR(255) NULL DEFAULT NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `product_id_UNIQUE` USING BTREE (`product_id`) INVISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
