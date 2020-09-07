CREATE DATABASE Items;
\c items;

CREATE TABLE users(
id serial PRIMARY KEY,
name varchar(2000)
);

CREATE TABLE role(
id serial PRIMARY KEY,
name varchar(2000)
);

ALTER TABLE users ADD COLUMN role_id int REFERENCES role(id);

CREATE TABLE rulles(
id serial PRIMARY KEY,
name varchar(2000)
);

CREATE TABLE role_rulles(
id serial PRIMARY KEY,
role_id int REFERENCES role(id),
rulles_id int REFERENCES rulles(id)
); 

CREATE TABLE category(
id serial PRIMARY KEY,
category varchar(2000)
);

CREATE TABLE states(
id serial PRIMARY KEY,
name varchar(2000)
);

CREATE TABLE item(
id serial PRIMARY KEY,
name varchar(2000),
users_id int REFERENCES users(id),
category_id int REFERENCES category(id),
states_id int REFERENCES states(id)
);

CREATE TABLE comments(
id serial PRIMARY KEY,
comments text,
item_id int REFERENCES item(id)
);

CREATE TABLE attachs(
id serial PRIMARY KEY,
attach varchar(2000),
item_id int REFERENCES item(id) 
);

INSERT INTO role(name) VALUES ('admin');
INSERT INTO role(name) VALUES ('user');

INSERT INTO rulles(name) VALUES ('admin rull');
INSERT INTO rulles(name) VALUES ('user rull');

INSERT INTO role_rulles(role_id, rulles_id) VALUES (1, 1);
INSERT INTO role_rulles(role_id, rulles_id) VALUES (2, 2);

INSERT INTO users(role_id, name) VALUES (1, 'admin');
INSERT INTO users(role_id, name) VALUES (2, 'user');

INSERT INTO category(category) VALUES ('bug');
INSERT INTO category(category) VALUES ('ex');

INSERT INTO states(name) VALUES ('run');
INSERT INTO states(name) VALUES ('complete');

INSERT INTO item(name, users_id, category_id, states_id) VALUES ('bug1', 2, 1, 1);
INSERT INTO item(name, users_id, category_id, states_id) VALUES ('ex1', 1, 1, 1);

INSERT INTO comments(comments, item_id) VALUES ('bug reported', 1);
INSERT INTO comments(comments, item_id) VALUES ('ex reported', 2);

INSERT INTO attachs(attach, item_id) VALUES ('c\asd\asd\asd.txt', 2);