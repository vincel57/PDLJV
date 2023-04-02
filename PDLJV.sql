--------------------------------------------------------
--  Fichier créé - dimanche-avril-02-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ABSENCE
--------------------------------------------------------

  CREATE TABLE "C##BDD2_15"."ABSENCE" 
   (	"IDABSENCE" NUMBER(*,0), 
	"DURE" DATE, 
	"JOUR" DATE, 
	"IDSTUDENT" NUMBER(*,0), 
	"IDABSENCE_TYPE" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ABSENCE_TYPE
--------------------------------------------------------

  CREATE TABLE "C##BDD2_15"."ABSENCE_TYPE" 
   (	"IDABSENCE_TYPE" NUMBER(*,0), 
	"NOM" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table COURSE
--------------------------------------------------------

  CREATE TABLE "C##BDD2_15"."COURSE" 
   (	"IDCOURSE" NUMBER(*,0), 
	"NOM" VARCHAR2(50 BYTE), 
	"TOTALTIME" NUMBER(*,0), 
	"AMPHITIME" NUMBER(*,0), 
	"TDTIME" NUMBER(*,0), 
	"TPTIME" NUMBER(*,0), 
	"EXAMTIME" NUMBER(*,0), 
	"IDTEACHER" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table GESTIONNAIRE
--------------------------------------------------------

  CREATE TABLE "C##BDD2_15"."GESTIONNAIRE" 
   (	"IDGESTIONNAIRE" NUMBER(*,0), 
	"LASTNAME" VARCHAR2(20 BYTE), 
	"FIRSTNAME" VARCHAR2(20 BYTE), 
	"MAIL" VARCHAR2(50 BYTE), 
	"MDP" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table GROUPE
--------------------------------------------------------

  CREATE TABLE "C##BDD2_15"."GROUPE" 
   (	"GROUPE_NUMBER" NUMBER, 
	"CAPACITÉ" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SEANCE
--------------------------------------------------------

  CREATE TABLE "C##BDD2_15"."SEANCE" 
   (	"IDSEANCE" NUMBER(*,0), 
	"HORAIRE" DATE, 
	"ROOM" VARCHAR2(20 BYTE), 
	"IDCOURSE" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SECTOR
--------------------------------------------------------

  CREATE TABLE "C##BDD2_15"."SECTOR" 
   (	"IDSECTOR" NUMBER(*,0), 
	"NOM" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table STUDENT
--------------------------------------------------------

  CREATE TABLE "C##BDD2_15"."STUDENT" 
   (	"IDSTUDENT" NUMBER, 
	"LASTNAME" VARCHAR2(20 BYTE), 
	"FIRSTNAME" VARCHAR2(20 BYTE), 
	"FILIÈRE" VARCHAR2(20 BYTE), 
	"GROUPE_NUMBER" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TEACHER
--------------------------------------------------------

  CREATE TABLE "C##BDD2_15"."TEACHER" 
   (	"IDTEACHER" NUMBER(*,0), 
	"LASTNAME" VARCHAR2(20 BYTE), 
	"FIRSTNAME" VARCHAR2(20 BYTE), 
	"TEL" NUMBER(*,0), 
	"MAIL" VARCHAR2(50 BYTE), 
	"MDP" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into C##BDD2_15.ABSENCE
SET DEFINE OFF;
REM INSERTING into C##BDD2_15.ABSENCE_TYPE
SET DEFINE OFF;
REM INSERTING into C##BDD2_15.COURSE
SET DEFINE OFF;
REM INSERTING into C##BDD2_15.GESTIONNAIRE
SET DEFINE OFF;
REM INSERTING into C##BDD2_15.GROUPE
SET DEFINE OFF;
REM INSERTING into C##BDD2_15.SEANCE
SET DEFINE OFF;
REM INSERTING into C##BDD2_15.SECTOR
SET DEFINE OFF;
REM INSERTING into C##BDD2_15.STUDENT
SET DEFINE OFF;
REM INSERTING into C##BDD2_15.TEACHER
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PK_ABSENCE
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_ABSENCE" ON "C##BDD2_15"."ABSENCE" ("IDABSENCE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ABSENCE_TYPE
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_ABSENCE_TYPE" ON "C##BDD2_15"."ABSENCE_TYPE" ("IDABSENCE_TYPE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_COURSE
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_COURSE" ON "C##BDD2_15"."COURSE" ("IDCOURSE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_GROUPE
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_GROUPE" ON "C##BDD2_15"."GROUPE" ("GROUPE_NUMBER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PERSON
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_PERSON" ON "C##BDD2_15"."GESTIONNAIRE" ("IDGESTIONNAIRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_SEANCE
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_SEANCE" ON "C##BDD2_15"."SEANCE" ("IDSEANCE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_SECTOR
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_SECTOR" ON "C##BDD2_15"."SECTOR" ("IDSECTOR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_STUDENT
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_STUDENT" ON "C##BDD2_15"."STUDENT" ("IDSTUDENT") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_TEACHER
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_TEACHER" ON "C##BDD2_15"."TEACHER" ("IDTEACHER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ABSENCE
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_ABSENCE" ON "C##BDD2_15"."ABSENCE" ("IDABSENCE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ABSENCE_TYPE
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_ABSENCE_TYPE" ON "C##BDD2_15"."ABSENCE_TYPE" ("IDABSENCE_TYPE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_COURSE
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_COURSE" ON "C##BDD2_15"."COURSE" ("IDCOURSE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PERSON
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_PERSON" ON "C##BDD2_15"."GESTIONNAIRE" ("IDGESTIONNAIRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_GROUPE
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_GROUPE" ON "C##BDD2_15"."GROUPE" ("GROUPE_NUMBER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_SEANCE
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_SEANCE" ON "C##BDD2_15"."SEANCE" ("IDSEANCE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_SECTOR
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_SECTOR" ON "C##BDD2_15"."SECTOR" ("IDSECTOR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_STUDENT
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_STUDENT" ON "C##BDD2_15"."STUDENT" ("IDSTUDENT") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_TEACHER
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##BDD2_15"."PK_TEACHER" ON "C##BDD2_15"."TEACHER" ("IDTEACHER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table ABSENCE
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."ABSENCE" ADD CONSTRAINT "PK_ABSENCE" PRIMARY KEY ("IDABSENCE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ABSENCE_TYPE
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."ABSENCE_TYPE" MODIFY ("NOM" CONSTRAINT "NN_NOM" NOT NULL ENABLE);
  ALTER TABLE "C##BDD2_15"."ABSENCE_TYPE" ADD CONSTRAINT "PK_ABSENCE_TYPE" PRIMARY KEY ("IDABSENCE_TYPE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table COURSE
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."COURSE" ADD CONSTRAINT "PK_COURSE" PRIMARY KEY ("IDCOURSE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table GESTIONNAIRE
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."GESTIONNAIRE" ADD CONSTRAINT "PK_PERSON" PRIMARY KEY ("IDGESTIONNAIRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table GROUPE
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."GROUPE" ADD CONSTRAINT "PK_GROUPE" PRIMARY KEY ("GROUPE_NUMBER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SEANCE
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."SEANCE" ADD CONSTRAINT "PK_SEANCE" PRIMARY KEY ("IDSEANCE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SECTOR
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."SECTOR" ADD CONSTRAINT "PK_SECTOR" PRIMARY KEY ("IDSECTOR")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table STUDENT
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."STUDENT" ADD CONSTRAINT "PK_STUDENT" PRIMARY KEY ("IDSTUDENT")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TEACHER
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."TEACHER" ADD CONSTRAINT "PK_TEACHER" PRIMARY KEY ("IDTEACHER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ABSENCE
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."ABSENCE" ADD CONSTRAINT "FK_IDABSENCE_TYPE" FOREIGN KEY ("IDABSENCE_TYPE")
	  REFERENCES "C##BDD2_15"."ABSENCE_TYPE" ("IDABSENCE_TYPE") ON DELETE CASCADE ENABLE;
  ALTER TABLE "C##BDD2_15"."ABSENCE" ADD CONSTRAINT "FK_IDSTUDENT" FOREIGN KEY ("IDSTUDENT")
	  REFERENCES "C##BDD2_15"."STUDENT" ("IDSTUDENT") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table COURSE
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."COURSE" ADD CONSTRAINT "FK_IDTEACHER" FOREIGN KEY ("IDTEACHER")
	  REFERENCES "C##BDD2_15"."TEACHER" ("IDTEACHER") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SEANCE
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."SEANCE" ADD CONSTRAINT "FK_IDCOURSE" FOREIGN KEY ("IDCOURSE")
	  REFERENCES "C##BDD2_15"."COURSE" ("IDCOURSE") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table STUDENT
--------------------------------------------------------

  ALTER TABLE "C##BDD2_15"."STUDENT" ADD CONSTRAINT "FK_STUDENT_GROUPE_NUMBER" FOREIGN KEY ("GROUPE_NUMBER")
	  REFERENCES "C##BDD2_15"."GROUPE" ("GROUPE_NUMBER") ENABLE;
