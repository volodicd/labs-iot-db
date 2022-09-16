-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema first_lab_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema first_lab_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `first_lab_db` DEFAULT CHARACTER SET utf8 ;
USE `first_lab_db` ;

-- -----------------------------------------------------
-- Table `first_lab_db`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `first_lab_db`.`country` (
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `first_lab_db`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `first_lab_db`.`city` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `country_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_city_country_idx` (`country_name` ASC) VISIBLE,
  CONSTRAINT `fk_city_country`
    FOREIGN KEY (`country_name`)
    REFERENCES `first_lab_db`.`country` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `first_lab_db`.`street`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `first_lab_db`.`street` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_street_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_street_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `first_lab_db`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `first_lab_db`.`hotels_branch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `first_lab_db`.`hotels_branch` (
  `name` VARCHAR(45) NOT NULL,
  `number_of_hotels` INT NULL,
  `country_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `fk_hotels_branch_country1_idx` (`country_name` ASC) VISIBLE,
  CONSTRAINT `fk_hotels_branch_country1`
    FOREIGN KEY (`country_name`)
    REFERENCES `first_lab_db`.`country` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `first_lab_db`.`hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `first_lab_db`.`hotel` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `number_of_stars` INT NOT NULL,
  `number_of_rooms` INT NULL,
  `street_id` INT NOT NULL,
  `hotels_branch_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hotel_street1_idx` (`street_id` ASC) VISIBLE,
  INDEX `fk_hotel_hotels_branch1_idx` (`hotels_branch_name` ASC) VISIBLE,
  CONSTRAINT `fk_hotel_street1`
    FOREIGN KEY (`street_id`)
    REFERENCES `first_lab_db`.`street` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hotel_hotels_branch1`
    FOREIGN KEY (`hotels_branch_name`)
    REFERENCES `first_lab_db`.`hotels_branch` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `first_lab_db`.`hotel_room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `first_lab_db`.`hotel_room` (
  `id` INT NOT NULL,
  `is_free` TINYBLOB NOT NULL,
  `price` INT NOT NULL,
  `hotel_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hotel_room_hotel1_idx` (`hotel_id` ASC) VISIBLE,
  CONSTRAINT `fk_hotel_room_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `first_lab_db`.`hotel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `first_lab_db`.`dates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `first_lab_db`.`dates` (
  `id` INT NOT NULL,
  `ariving` DATETIME NOT NULL,
  `check_out` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `first_lab_db`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `first_lab_db`.`reservation` (
  `id` INT NOT NULL,
  `is_paid` TINYINT NOT NULL,
  `duration` VARCHAR(45) NULL,
  `dates_id` INT NOT NULL,
  `hotel_room_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reservation_dates1_idx` (`dates_id` ASC) VISIBLE,
  INDEX `fk_reservation_hotel_room1_idx` (`hotel_room_id` ASC) VISIBLE,
  CONSTRAINT `fk_reservation_dates1`
    FOREIGN KEY (`dates_id`)
    REFERENCES `first_lab_db`.`dates` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservation_hotel_room1`
    FOREIGN KEY (`hotel_room_id`)
    REFERENCES `first_lab_db`.`hotel_room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `first_lab_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `first_lab_db`.`user` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `personal_card` VARCHAR(45) NULL,
  `reservation_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_reservation1_idx` (`reservation_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_reservation1`
    FOREIGN KEY (`reservation_id`)
    REFERENCES `first_lab_db`.`reservation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `first_lab_db`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `first_lab_db`.`review` (
  `id` INT NOT NULL,
  `coment` VARCHAR(250) NOT NULL,
  `stars` INT NOT NULL,
  `hotel_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_hotel1_idx` (`hotel_id` ASC) VISIBLE,
  INDEX `fk_review_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `first_lab_db`.`hotel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `first_lab_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
