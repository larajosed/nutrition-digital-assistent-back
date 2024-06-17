--liquibase formatted sql
--changeset larajosed:01 context:main

  CREATE TABLE medicals_data(
id INT NOT NULL AUTO_INCREMENT,
id_user INT NULL, 
weight FLOAT NOT NULL , 
height FLOAT NOT NULL,
current_medical VARCHAR(150) NULL,
medical_information VARCHAR(150) NULL,
family_background VARCHAR(150) NULL,
allergies VARCHAR(150) NULL,
activity_level INT NULL COMMENT '1 = High\n2 = Half\n3 = Low',
PRIMARY KEY (id));


INSERT INTO medicals_data (id_user, weight, height, allergies) VALUE (1, 49.50, 1.85,'no');

