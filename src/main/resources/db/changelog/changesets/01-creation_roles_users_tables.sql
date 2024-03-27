--liquibase formatted sql
--changeset larajosed:01 context:main

CREATE TABLE province (
id INT NOT NULL,
name VARCHAR(150) NOT NULL,

PRIMARY KEY (id));

CREATE TABLE location (
id INT NOT NULL AUTO_INCREMENT,
id_province INT NOT NULL , 
id_location INT NOT NULL,
control_digit INT NOT NULL,
name VARCHAR(150) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY(id_province) REFERENCES province(id));

CREATE TABLE users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  gender INT NULL COMMENT '1 = Men\n2 = Woman\n3 = No binary',
  birthdate DATE NULL,
  address VARCHAR(250) NULL,
  postal_code INT NULL,
  id_location INT NULL,
  id_province INT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(45) NOT NULL,  
  role INT NULL COMMENT '1 = User\n2 = Admin', 
  PRIMARY KEY (id),
  FOREIGN KEY(id_province) REFERENCES province(id),
  FOREIGN KEY(id_location) REFERENCES location(id));
  
CREATE TABLE roles (
  id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));
  
INSERT INTO roles (id, name) VALUES (1, 'Usuario');
INSERT INTO roles (id, name) VALUES (2, 'Administrador');

