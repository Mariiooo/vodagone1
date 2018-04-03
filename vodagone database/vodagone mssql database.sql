/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     29-3-2018 20:52:59                           */
/*==============================================================*/


drop table if exists AANBIEDER;

drop table if exists ABONNEE;

drop table if exists ABONNEMENT;

drop table if exists ABONNEMENTENDUUR;

drop table if exists ABONNEMENTSTATUS;

drop table if exists DIENST;

drop table if exists DEELABO;

drop table if exists PRIJZEN;

drop table if exists TOKEN;

drop table if exists GEBRUIKER;

/*==============================================================*/
/* Table: AANBIEDER                                             */
/*==============================================================*/
create table AANBIEDER
(
   AANBIEDERNAAM        varchar(255) not null,
   primary key (AANBIEDERNAAM)
)

/*==============================================================*/
/* Table: ABONNEE                                               */
/*==============================================================*/
create table ABONNEE
(
   IDABONNEE            int not null IDENTITY(1,1),
   NAAM                 varchar(255) not null,
   EMAIL                varchar(255) not null,
   primary key (IDABONNEE)
)

/*==============================================================*/
/* Table: DIENST                                                */
/*==============================================================*/
create table DIENST
(
   IDDIENST             int not null IDENTITY(1,1),
   NAAM                 varchar(255) not null,
   DEELBAAR             smallint not null,
   VERDUBBELBAAR        smallint not null,
   AANBIEDERNAAM        varchar(255) not null,
   primary key (IDDIENST),
   constraint FK_REFERENCE_8 foreign key (AANBIEDERNAAM)
      references AANBIEDER (AANBIEDERNAAM) on delete NO ACTION  on update NO ACTION 
)

/*==============================================================*/
/* Table: ABONNEMENTSTATUS                                      */
/*==============================================================*/
create table ABONNEMENTSTATUS
(
   ABONNEMENTSTATUS     varchar(255) not null,
   primary key (ABONNEMENTSTATUS)
)

/*==============================================================*/
/* Table: ABONNEMENTENDUUR                                      */
/*==============================================================*/
create table ABONNEMENTENDUUR
(
   ABONNEMENTENDUUR     varchar(255) not null,
   primary key (ABONNEMENTENDUUR)
)

/*==============================================================*/
/* Table: ABONNEMENT                                            */
/*==============================================================*/
create table ABONNEMENT
(
   IDABONNEMENT         int not null IDENTITY(1,1),
   IDABONNEE            int not null,
   IDDIENST             int not null,
   ABONNEMENTENDUUR     varchar(255) not null,
   ABONNEMENTSTATUS     varchar(255) not null,
   VERDUBBELD           smallint not null,
   STARTDATUM           date not null,
   EINDDATUM            date,
   primary key (IDABONNEMENT),
   constraint FK_REFERENCE_3 foreign key (IDDIENST)
      references DIENST (IDDIENST) on delete NO ACTION  on update NO ACTION ,
   constraint FK_REFERENCE_4 foreign key (ABONNEMENTSTATUS)
      references ABONNEMENTSTATUS (ABONNEMENTSTATUS) on delete NO ACTION  on update NO ACTION ,
   constraint FK_REFERENCE_7 foreign key (ABONNEMENTENDUUR)
      references ABONNEMENTENDUUR (ABONNEMENTENDUUR) on delete NO ACTION  on update NO ACTION ,
   constraint FK_REFERENCE_11 foreign key (IDABONNEE)
      references ABONNEE (IDABONNEE) on delete NO ACTION  on update NO ACTION 
)

/*==============================================================*/
/* Table: DEELABO                                  */
/*==============================================================*/
create table DEELABO
(
   IDABONNEE            int not null,
   IDABONNEMENT         int not null,
   primary key (IDABONNEE, IDABONNEMENT),
   constraint FK_REFERENCE_5 foreign key (IDABONNEE)
      references ABONNEE (IDABONNEE) on delete NO ACTION  on update NO ACTION ,
   constraint FK_REFERENCE_6 foreign key (IDABONNEMENT)
      references ABONNEMENT (IDABONNEMENT) on delete NO ACTION  on update NO ACTION 
)

/*==============================================================*/
/* Table: PRIJZEN                                               */
/*==============================================================*/
create table PRIJZEN
(
   IDDIENST             int not null,
   ABONNEMENTENDUUR     varchar(255) not null,
   PRIJS                money not null,
   primary key (IDDIENST, ABONNEMENTENDUUR),
   constraint FK_REFERENCE_9 foreign key (IDDIENST)
      references DIENST (IDDIENST) on delete NO ACTION  on update NO ACTION ,
   constraint FK_REFERENCE_10 foreign key (ABONNEMENTENDUUR)
      references ABONNEMENTENDUUR (ABONNEMENTENDUUR) on delete NO ACTION  on update NO ACTION 
)

/*==============================================================*/
/* Table: TOKEN                                                 */
/*==============================================================*/
create table TOKEN
(
   TOKEN                varchar(20) not null,
   IDABONEE             int not null,
   VERLOOPDATUM         date not null,
   primary key (TOKEN),
   constraint FK_REFERENCE_2 foreign key (IDABONEE)
      references ABONNEE (IDABONNEE) on delete NO ACTION  on update NO ACTION 
)

/*==============================================================*/
/* Table: GEBRUIKER                                                  */
/*==============================================================*/
create table GEBRUIKER
(
   GEBRUIKERSNAAM             varchar(255) not null,
   IDABONEE             int not null,
   WACHTWOORD             varchar(255) not null,
   primary key (GEBRUIKERSNAAM),
   constraint FK_GEBRUIKER_AS_ABONNEE foreign key (IDABONEE)
      references ABONNEE (IDABONNEE)
)

