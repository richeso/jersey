set userid=root;
set passwd=password;
connect MySQL.//localhost:3306/jersey;
--create database jersey;
--Create Tables.

--drop table Users;
--drop table userRole;

commit;
-- MySQL has a system table called 'user', so that name cannot be used here.
CREATE TABLE Users (
  Id MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
  Name VARCHAR(50) BINARY UNIQUE NOT NULL, /* Binary needed to ensure case sensitive. */
  Password VARCHAR(50) BINARY NOT NULL, /* Binary needed to ensure case sensitive. Must hash the password. */
  Language VARCHAR(25) NOT NULL DEFAULT 'en',
  FormSourceId VARCHAR(100) BINARY,   /* Defends against CSRF attacks. */
  PRIMARY KEY (Id)
) TYPE=InnoDB;

-- In the style demanded by Tomcat 4 (not a normalized form).
-- Tomcat has the weird constraint that the column names must match between UserRole.Name and Users.Name.
CREATE TABLE UserRole (
  Name VARCHAR(50) BINARY NOT NULL,
  Role VARCHAR(50) BINARY NOT NULL,
  INDEX (Name),
  FOREIGN KEY (Name) REFERENCES Users(Name),
  PRIMARY KEY (Name, Role)
) TYPE=InnoDB;

-- Populate tables with some base data.
-- *** WARNING *** : this data is for development only, and must be DELETED from production environments.
-- The passwords are in hashed form, and have the cleartext value 'testtest'.
INSERT INTO Users (Id, Name, Password) VALUES(1, 'testeA', '51abb9636078defbf888d8457a7c76f85c8f114c');
INSERT INTO Users (Id, Name, Password) VALUES(2, 'testeB', '51abb9636078defbf888d8457a7c76f85c8f114c');
INSERT INTO Users (Id, Name, Password) VALUES(3, 'testeC', '51abb9636078defbf888d8457a7c76f85c8f114c');
INSERT INTO Users (Id, Name, Password) VALUES(4, 'testeD', '51abb9636078defbf888d8457a7c76f85c8f114c');
INSERT INTO Users (Id, Name, Password) VALUES(5, 'richard','51abb9636078defbf888d8457a7c76f85c8f114c');

INSERT INTO UserRole (Name, Role) VALUES('testeA', 'user-general');
INSERT INTO UserRole (Name, Role) VALUES('testeB', 'translator');
INSERT INTO UserRole (Name, Role) VALUES('testeC', 'webmaster');
INSERT INTO UserRole (Name, Role) VALUES('testeD', 'user-general');
INSERT INTO UserRole (Name, Role) VALUES('testeD', 'translator');
INSERT INTO UserRole (Name, Role) VALUES('testeD', 'webmaster');
INSERT INTO UserRole (Name, Role) VALUES('testeD', 'user-president');
INSERT INTO UserRole (Name, Role) VALUES('testeD', 'access-control');
INSERT INTO UserRole (Name, Role) VALUES('richard','user-general');
INSERT INTO UserRole (Name, Role) VALUES('richard','webmaster');
INSERT INTO UserRole (Name, Role) VALUES('richard','admin');
INSERT INTO UserRole (Name, Role) VALUES('richard','user');
commit;
