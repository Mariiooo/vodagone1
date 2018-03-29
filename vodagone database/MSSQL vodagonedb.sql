create database vodagonedb

-- -----------------------------------------------------
-- Table `vodagonedb`.`Users`
-- -----------------------------------------------------
CREATE TABLE Users (
 idUser INT NOT NULL IDENTITY(1,1),
  userName VARCHAR(45) NOT NULL,
  userPassword VARCHAR(45) NOT NULL,
 profilename VARCHAR(45) NOT NULL,
  PRIMARY KEY (idUser)
 )


-- -----------------------------------------------------
-- Table `vodagonedb`.`Abonnementen`
-- -----------------------------------------------------
CREATE TABLE Abonnementen (
  idAbonnementen INT NOT NULL IDENTITY(1,1),
  aanbieder VARCHAR(45) NOT NULL,
  dienst VARCHAR(45) NOT NULL,
  prijs MONEY NOT NULL,
  startDatum DATE NOT NULL,
  verdubbeling VARCHAR(45) NOT NULL,
  deelbaar TINYINT NOT NULL,
  aboStatus VARCHAR(45) NOT NULL,
  PRIMARY KEY (idAbonnementen)
  )


-- -----------------------------------------------------
-- Table `vodagonedb`.`Abonnees`
-- -----------------------------------------------------
CREATE TABLE Abonnees (
  idAbonnees INT NOT NULL IDENTITY(1,1),
  aboName VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL
  PRIMARY KEY (idAbonnees)
  )


-- -----------------------------------------------------
-- Table `vodagonedb`.`AbonneesAbonnement`
-- -----------------------------------------------------
CREATE TABLE AbonneesAbonnement (
  idAbonneesAbonnement INT NOT NULL IDENTITY(1,1),
  idAbonnementen INT NOT NULL,
  idAbonnees INT NOT NULL
  PRIMARY KEY (idAbonneesAbonnement,idAbonnementen,idAbonnees  )
)

GO


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





