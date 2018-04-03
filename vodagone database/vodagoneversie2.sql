-- MySQL Script generated by MySQL Workbench
-- Fri Mar 23 15:48:10 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering
/*
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema vodagonedb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema vodagonedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vodagonedb` DEFAULT CHARACTER SET utf8 ;
USE `vodagonedb` ;

*/

-- -----------------------------------------------------
-- Table `vodagonedb`.`Users`
-- -----------------------------------------------------
CREATE TABLE `Users` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `profilename` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUser`))
ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- -----------------------------------------------------
-- Table `vodagonedb`.`Abonnementen`
-- -----------------------------------------------------
CREATE TABLE `Abonnementen` (
  `idAbonnementen` INT NOT NULL AUTO_INCREMENT,
  `aanbieder` VARCHAR(45) NOT NULL,
  `dienst` VARCHAR(45) NOT NULL,
  `prijs` DOUBLE NOT NULL,
  `startDatum` DATE NOT NULL,
  `verdubbeling` VARCHAR(45) NOT NULL,
  `deelbaar` TINYINT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAbonnementen`))
ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- -----------------------------------------------------
-- Table `vodagonedb`.`Abonnees`
-- -----------------------------------------------------
CREATE TABLE `Abonnees` (
  `idAbonnees` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAbonnees`))
ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- -----------------------------------------------------
-- Table `vodagonedb`.`AbonneesAbonnement`
-- -----------------------------------------------------
CREATE TABLE `AbonneesAbonnement` (
  `idAbonneesAbonnement` INT NOT NULL,
  `idAbonnementen` INT NOT NULL,
  `idAbonnees` INT NOT NULL,
  `aanbieder` VARCHAR(45) NOT NULL,
  `dienst` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAbonneesAbonnement`, `idAbonnementen`, `idAbonnees`))
ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Token` (
  `idToken` INT NOT NULL,
  `idUser` INT NOT NULL,
  `token` INT NOT NULL,
  PRIMARY KEY (`idToken`, `idUser`, `token`))
ENGINE=InnoDB DEFAULT CHARSET=latin1;







/*
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

*/

INSERT INTO `token`(`idToken`, `idUser`,`token`) VALUES (1,1, '1234-1234-1234' )
INSERT INTO `token`(`idToken`, `idUser`,`token`) VALUES (2,2, '1234-1234-1234' )


INSERT INTO `users`(`idUser`, `name`, `password`, `profilename`) VALUES (1,'Mario','test','Mario Blautzik')
INSERT INTO `users`(`idUser`, `name`, `password`, `profilename`) VALUES (2,'Henk','test','Henk Brouwer')


INSERT INTO `abonnementen`(`idAbonnementen`, `aanbieder`, `dienst`, `prijs`, `startDatum`, `verdubbeling`, `deelbaar`, `status`) VALUES (1, 'vodafone', 'Mobiele telefonie 100', 5, '2017-01-01', 'standaard', 0, 'actief')
INSERT INTO `abonnementen`(`idAbonnementen`, `aanbieder`, `dienst`, `prijs`, `startDatum`, `verdubbeling`, `deelbaar`, `status`) VALUES (2, 'vodafone', 'Mobiele telefonie 250', 5, '2018-09-01', 'standaard', 0, 'opgezegd')
INSERT INTO `abonnementen`(`idAbonnementen`, `aanbieder`, `dienst`, `prijs`, `startDatum`, `verdubbeling`, `deelbaar`, `status`) VALUES (3, 'ziggo', 'Kabel-internet (download 300 Mbps)', 5, '2017-06-01', 'standaard', 1, 'proef')
INSERT INTO `abonnementen`(`idAbonnementen`, `aanbieder`, `dienst`, `prijs`, `startDatum`, `verdubbeling`, `deelbaar`, `status`) VALUES (4, 'ziggo', 'Kabel-internet (download 5000 Mbps)', 5, '2018-07-01', 'standaard', 1, 'actief')


INSERT INTO `abonnees`(`idAbonnees`, `name`, `email`) VALUES (1, 'Mariusz Blautzik', 'mariioo@gmail.com')
INSERT INTO `abonnees`(`idAbonnees`, `name`, `email`) VALUES (2, 'Tetris Boy', 'Tetris@han.nl')
INSERT INTO `abonnees`(`idAbonnees`, `name`, `email`) VALUES (3, 'Meron Brouwer', 'meron@meron.nl')


INSERT INTO `abonneesabonnement`(`idAbonneesAbonnement`, `idAbonnementen`, `idAbonnees`) VALUES (1,1,1)
INSERT INTO `abonneesabonnement`(`idAbonneesAbonnement`, `idAbonnementen`, `idAbonnees`) VALUES (2,1,2)
INSERT INTO `abonneesabonnement`(`idAbonneesAbonnement`, `idAbonnementen`, `idAbonnees`) VALUES (3,1,3)
INSERT INTO `abonneesabonnement`(`idAbonneesAbonnement`, `idAbonnementen`, `idAbonnees`) VALUES (4,2,1)
INSERT INTO `abonneesabonnement`(`idAbonneesAbonnement`, `idAbonnementen`, `idAbonnees`) VALUES (4,2,4)


//=========================================


INSERT INTO Users(userName, userPassword, profilename)
VALUES ( 'Mario', 'test', 'Mariusz Blautzik')
INSERT INTO Users(userName, userPassword, profilename)
VALUES ( 'Henk' , 'test', 'Meron Brouwer')
GO

INSERT INTO Abonnementen(aanbieder, dienst, prijs, startDatum, verdubbeling, deelbaar, aboStatus)
VALUES ( 'vodafone', 'Mobiele telefonie 100', 5, '2017-01-01', 'standaard', 0, 'actief')
INSERT INTO Abonnementen(aanbieder, dienst, prijs, startDatum, verdubbeling, deelbaar, aboStatus)
VALUES ( 'vodafone', 'Mobiele telefonie 250', 5, '2018-09-01', 'standaard', 0, 'opgezegd')
INSERT INTO Abonnementen(aanbieder, dienst, prijs, startDatum, verdubbeling, deelbaar, aboStatus)
VALUES ( 'ziggo', 'Kabel-internet (download 300 Mbps)', 5, '2017-06-01', 'standaard', 1, 'proef')
INSERT INTO Abonnementen(aanbieder, dienst, prijs, startDatum, verdubbeling, deelbaar, aboStatus)
VALUES ( 'ziggo', 'Kabel-internet (download 5000 Mbps)', 5, '2018-07-01', 'standaard', 1, 'actief')
GO

INSERT INTO Abonnees (aboName, email)
VALUES ( 'Mariusz Blautzik', 'mariioo@gmail.com')
INSERT INTO Abonnees (aboName, email)
VALUES ('Tetris Boy', 'Tetris@han.nl')
INSERT INTO Abonnees (aboName, email)
VALUES ( 'Meron Brouwer', 'meron@meron.nl')

GO

INSERT INTO AbonneesAbonnement (idAbonnementen, idAbonnees)
VALUES ( 1,1)
 INSERT INTO AbonneesAbonnement (idAbonnementen, idAbonnees)
VALUES ( 1,2)
INSERT INTO AbonneesAbonnement (idAbonnementen, idAbonnees)
VALUES ( 1,3)
INSERT INTO AbonneesAbonnement (idAbonnementen, idAbonnees)
VALUES ( 2,1)
INSERT INTO AbonneesAbonnement (idAbonnementen, idAbonnees)
VALUES ( 2,4)









