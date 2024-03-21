--liquibase formatted sql
--changeset larajosed:01 context:test

INSERT INTO users (id, name, last_name, gender, birthdate, address, postal_code, location, province, email, password, role) 
VALUES (1, 'david', 'mdl', 1, '1990-10/14', 'lacy calle', 34567, 'madrid', 'madrid', 'david@gmail.com', '12345', 1);


