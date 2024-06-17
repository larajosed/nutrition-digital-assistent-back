--liquibase formatted sql
--changeset larajosed:01 context:main

CREATE TABLE meals ( 
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(150) NOT NULL,
PRIMARY KEY (id));

CREATE TABLE days (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(150) NOT NULL,
PRIMARY KEY (id));

INSERT INTO meals (name) VALUES ('Desayuno');
INSERT INTO meals (name) VALUES ('Snack');
INSERT INTO meals (name) VALUES ('Comida');
INSERT INTO meals (name) VALUES ('Merienda');
INSERT INTO meals (name) VALUES ('Cena');


INSERT INTO days (name) VALUES ('Lunes');
INSERT INTO days (name) VALUES ('Martes');
INSERT INTO days (name) VALUES ('Miércoles');
INSERT INTO days (name) VALUES ('Jueves');
INSERT INTO days (name) VALUES ('Viernes');
INSERT INTO days (name) VALUES ('Sábado');
INSERT INTO days (name) VALUES ('Domingo');