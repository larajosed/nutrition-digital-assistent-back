--liquibase formatted sql
--changeset larajosed:01 context:main

CREATE TABLE users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(45) NOT NULL,
  gender INT NULL COMMENT '1 = Men\n2 = Woman\n3 = No binary',
  address VARCHAR(250) NULL,
  role INT NULL COMMENT '1 = User\n2 = Admin',
  date DATE NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE roles (
  id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO roles (id, name) VALUES (1, 'Usuario');
INSERT INTO roles (id, name) VALUES (2, 'Administrador');
