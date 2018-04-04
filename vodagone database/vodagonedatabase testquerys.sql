/*==============================================================*/
/*			TEST DATA VOOR VODAGONE DATABASE					*/
/*==============================================================*/



/*==============================================================*/
/* Table: AANBIEDER                                             */
/*==============================================================*/

INSERT INTO AANBIEDER(AANBIEDERNAAM)
VALUE ('Ziggo');
INSERT INTO AANBIEDER(AANBIEDERNAAM)
VALUE ('Vodafone');


/*==============================================================*/
/* Table: ABONNEE                                               */
/*==============================================================*/
INSERT INTO ABONNEE(NAAM, EMAIL)
VALUES ('Mariusz Blautzik', 'djmariioo@gmail.com');

INSERT INTO ABONNEE(NAAM, EMAIL)
VALUES ('Artur Kerkens', 'artur22@gmail.com');

INSERT INTO ABONNEE(NAAM, EMAIL)
VALUES ('Henk Bonats', 'HenkTank@live.com');

INSERT INTO ABONNEE(NAAM, EMAIL)
VALUES ('Lena del Ray', 'LenaLoveYu@live.com');

INSERT INTO ABONNEE(NAAM, EMAIL)
VALUES ('Tito Bino', 'titotitu@live.com');

INSERT INTO ABONNEE(NAAM, EMAIL)
VALUES ('Aang Avatar', 'avataraangisalive@hotmail.com');

INSERT INTO ABONNEE(NAAM, EMAIL)
VALUES ('Cees Groot', 'ceesgroot@gmail.com');

INSERT INTO ABONNEE(NAAM, EMAIL)
VALUES ('Robert Kares', 'r.kares@live.com');


/*==============================================================*/
/* Table: DIENST                                                */
/*==============================================================*/

INSERT INTO DIENST(NAAM,DEELBAAR, VERDUBBELBAAR, AANBIEDERNAAM)
VALUES ( 'Mobiele telefonie 100', 0, 0, 'vodafone');

INSERT INTO DIENST(NAAM,DEELBAAR, VERDUBBELBAAR, AANBIEDERNAAM)
VALUES ( 'Mobiele telefonie 250', 0, 1, 'vodafone');

INSERT INTO DIENST(NAAM,DEELBAAR, VERDUBBELBAAR, AANBIEDERNAAM)
VALUES ( 'Glasvezel-internet (download 500 Mbps)', 0, 1, 'vodafone');

INSERT INTO DIENST(NAAM,DEELBAAR, VERDUBBELBAAR, AANBIEDERNAAM)
VALUES ( 'Kabel-internet (download 300 Mbps)', 0, 0, 'ziggo');

INSERT INTO DIENST(NAAM,DEELBAAR, VERDUBBELBAAR, AANBIEDERNAAM)
VALUES ( 'Eredivisie Live 1,2,3,4 en 5', 1, 0, 'ziggo');

INSERT INTO DIENST(NAAM,DEELBAAR, VERDUBBELBAAR, AANBIEDERNAAM)
VALUES ( 'HBO Plus', 1, 0, 'ziggo');


/*==============================================================*/
/* Table: ABONNEMENTSTATUS                                      */
/*==============================================================*/

INSERT INTO ABONNEMENTSTATUS(ABONNEMENTSTATUS)
VALUES ( 'proef' );

INSERT INTO ABONNEMENTSTATUS(ABONNEMENTSTATUS)
VALUES ( 'actief' );

INSERT INTO ABONNEMENTSTATUS(ABONNEMENTSTATUS)
VALUES ( 'opgezegd' );


/*==============================================================*/
/* Table: ABONNEMENTENDUUR                                      */
/*==============================================================*/

INSERT INTO ABONNEMENTENDUUR(ABONNEMENTENDUUR)
VALUES ('maand');

INSERT INTO ABONNEMENTENDUUR(ABONNEMENTENDUUR)
VALUES ('half jaar');

INSERT INTO ABONNEMENTENDUUR(ABONNEMENTENDUUR)
VALUES ('jaar');


/*==============================================================*/
/* Table: ABONNEMENT                                            */
/*==============================================================*/

INSERT INTO ABONNEMENT( IDABONNEE, IDDIENST, ABONNEMENTENDUUR, ABONNEMENTSTATUS, VERDUBBELD, STARTDATUM, EINDDATUM)
VALUES( 1, 1, 'jaar', 'actief', 'standaard', '2018-03-01', NULL);

INSERT INTO ABONNEMENT( IDABONNEE, IDDIENST, ABONNEMENTENDUUR, ABONNEMENTSTATUS, VERDUBBELD, STARTDATUM, EINDDATUM)
VALUES( 1, 2, 'maand', 'proef', 'standaard', '2018-04-01', '2018-05-01');

INSERT INTO ABONNEMENT( IDABONNEE, IDDIENST, ABONNEMENTENDUUR, ABONNEMENTSTATUS, VERDUBBELD, STARTDATUM, EINDDATUM)
VALUES( 1, 3, 'half jaar', 'opgezegd', 'verdubbeld', '2017-07-01', '2018-05-01');

INSERT INTO ABONNEMENT( IDABONNEE, IDDIENST, ABONNEMENTENDUUR, ABONNEMENTSTATUS, VERDUBBELD, STARTDATUM, EINDDATUM)
VALUES( 2, 4, 'jaar', 'actief', 'standaard', '2018-02-01', NULL);

INSERT INTO ABONNEMENT( IDABONNEE, IDDIENST, ABONNEMENTENDUUR, ABONNEMENTSTATUS, VERDUBBELD, STARTDATUM, EINDDATUM)
VALUES( 2, 5, 'jaar', 'actief', 'standaard', '2018-01-01', NULL);

INSERT INTO ABONNEMENT( IDABONNEE, IDDIENST, ABONNEMENTENDUUR, ABONNEMENTSTATUS, VERDUBBELD, STARTDATUM, EINDDATUM)
VALUES( 3, 6, 'jaar', 'actief', 'standaard', '2018-01-01', NULL);





/*==============================================================*/
/* Table: DEELABO                                  */
/*==============================================================*/






/*==============================================================*/
/* Table: PRIJZEN                                               */
/*==============================================================*/

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (1, 'maand', 5.00);

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (1, 'half jaar', 25.00);

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (1, 'jaar', 45.00);


INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (2, 'maand', 10.00);

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (2, 'half jaar', 50.00);

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (2, 'jaar', 90.00);


INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (3, 'maand', 40.00);

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (3, 'half jaar', 200.00);

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (3, 'jaar', 360.00);


INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (4, 'maand', 30.00);

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (4, 'half jaar', 150.00);

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (4, 'jaar', 270.00);


INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (5, 'maand', 10.00);

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (5, 'half jaar', 50.00);

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (5, 'jaar', 90.00);


INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (6, 'maand', 15.00);

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (6, 'half jaar', 75.00);

INSERT INTO PRIJZEN(IDDIENST, ABONNEMENTENDUUR, PRIJS)
VALUES (6, 'jaar', 135.00);


/*==============================================================*/
/* Table: TOKEN                                                 */
/*==============================================================*/

INSERT INTO TOKEN ( TOKEN,IDABONEE, VERLOOPDATUM) 
VALUES ('1234-1234-1234', 1, '2018-05-01');

INSERT INTO TOKEN ( TOKEN,IDABONEE, VERLOOPDATUM) 
VALUES ('3232-2323-2323', 2, '2018-04-12');

INSERT INTO TOKEN ( TOKEN,IDABONEE, VERLOOPDATUM) 
VALUES ('6564-33332333-13', 3, '2018-03-31');

INSERT INTO TOKEN ( TOKEN,IDABONEE, VERLOOPDATUM) 
VALUES ('1444-414124-5513', 4, '2018-04-05');

INSERT INTO TOKEN ( TOKEN,IDABONEE, VERLOOPDATUM) 
VALUES ('5151435053', 5, '2018-01-01');

INSERT INTO TOKEN ( TOKEN,IDABONEE, VERLOOPDATUM) 
VALUES ('145415-2343-24', 6, '2018-01-05');

INSERT INTO TOKEN ( TOKEN,IDABONEE, VERLOOPDATUM) 
VALUES ('5553-4443-4432', 7, '2018-01-05');

INSERT INTO TOKEN ( TOKEN,IDABONEE, VERLOOPDATUM) 
VALUES ('1666-234343', 8, '2018-09-05');

/*==============================================================*/
/* Table: GEBRUIKER                                                  */
/*==============================================================*/

INSERT INTO GEBRUIKER( GEBRUIKERSNAAM, IDABONEE, WACHTWOORD)
VALUES( 'Mario', 1, 'test');

INSERT INTO GEBRUIKER( GEBRUIKERSNAAM, IDABONEE, WACHTWOORD)
VALUES( 'Artur', 2, 'Artur');

INSERT INTO GEBRUIKER( GEBRUIKERSNAAM, IDABONEE, WACHTWOORD)
VALUES( 'Henk', 3, 'tank');

INSERT INTO GEBRUIKER( GEBRUIKERSNAAM, IDABONEE, WACHTWOORD)
VALUES( 'Lena', 4, 'iloveit');

INSERT INTO GEBRUIKER( GEBRUIKERSNAAM, IDABONEE, WACHTWOORD)
VALUES ('Tito Bino', 5, 'titotitu');

INSERT INTO GEBRUIKER( GEBRUIKERSNAAM, IDABONEE, WACHTWOORD)
VALUES ('Aang Avatar', 6, 'avataraangisalive');

INSERT INTO GEBRUIKER( GEBRUIKERSNAAM, IDABONEE, WACHTWOORD)
VALUES ('Cees Groot', 7, 'ceesgroot');

INSERT INTO GEBRUIKER( GEBRUIKERSNAAM, IDABONEE, WACHTWOORD)
VALUES ('Robert Kares', 8, 'r.kares');