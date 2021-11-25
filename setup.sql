CREATE DATABASE IF NOT EXISTS sal_eats;

CREATE TABLE IF NOT EXISTS `sal_eats`.`users` (
  `email` VARCHAR(45) NOT NULL UNIQUE,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`) 
)

CREATE TABLE IF NOT EXISTS `sal_eats`.`favorites` (
  `email` VARCHAR(45) NOT NULL,
  `restaurant` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`) 
);