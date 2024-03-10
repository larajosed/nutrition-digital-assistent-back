--liquibase formatted sql
--changeset larajosed:01 context:test

INSERT INTO users (id, name, last_name, email, password, gender, address, role, date) VALUES (1, 'david', 'mdl', 'david@gmail.com', '12345', 'm', 'lacy', 1, '1990-10/14');
INSERT INTO users (id, name, last_name, email, password, gender, address, role, date) VALUES (2, 'maria', 'mdl', 'maria@gmail.com', '12345', 'm', 'lacy', 2, '1990-10/14');