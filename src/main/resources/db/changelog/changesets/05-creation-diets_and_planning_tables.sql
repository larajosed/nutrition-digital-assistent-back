--liquibase formatted sql
--changeset larajosed:01 context:main

CREATE TABLE diets ( 
id INT NOT NULL AUTO_INCREMENT,
type INT  NULL COMMENT '1 = Lose\n2 = Gain\n3 = Keep',
id_user INT NULL,
date DATETIME NULL,
PRIMARY KEY (id),
FOREIGN KEY(id_user) REFERENCES users(id));

CREATE TABLE planning ( 
id INT NOT NULL AUTO_INCREMENT,
id_diet INT NULL,
id_day INT NULL,
id_meal INT NULL,
PRIMARY KEY (id),
FOREIGN KEY(id_diet) REFERENCES diets(id),
FOREIGN KEY(id_day) REFERENCES days(id),
FOREIGN KEY(id_meal) REFERENCES meals(id));

INSERT INTO diets (type, id_user, date) VALUES (1, 1, '2023-12-11');
INSERT INTO diets (type, id_user, date) VALUES (2, 3, '2023-06-02');
INSERT INTO diets (type, id_user, date) VALUES (3, 4, '2023-10-08');


INSERT INTO planning (id_diet, id_day, id_meal) VALUES (1,1,1);
INSERT INTO planning (id_diet, id_day, id_meal) VALUES (1,1,2);
INSERT INTO planning (id_diet, id_day, id_meal) VALUES (1,1,3);
INSERT INTO planning (id_diet, id_day, id_meal) VALUES (1,1,4);
INSERT INTO planning (id_diet, id_day, id_meal) VALUES (1,1,5);
INSERT INTO planning (id_diet, id_day, id_meal) VALUES (1,2,1);
INSERT INTO planning (id_diet, id_day, id_meal) VALUES (1,2,2);
INSERT INTO planning (id_diet, id_day, id_meal) VALUES (1,2,3);
INSERT INTO planning (id_diet, id_day, id_meal) VALUES (1,2,4);
INSERT INTO planning (id_diet, id_day, id_meal) VALUES (1,2,5);


