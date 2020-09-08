create table engine(
	id serial primary key,
	name varchar(200)
);

create table transmission(
	id serial primary key,
	name varchar(200)
);

create table carcase(
	id serial primary key,
	name varchar(200)
);

create table car(
	id serial primary key,
	name varchar(200),
	engine_id int references engine(id) not null,
	transmission_id int references transmission(id) not null,
	carcase_id int references carcase(id) not null
);

insert into engine(name) values('v6');

insert into engine(name) values('v8');

insert into engine(name) values('v10');

insert into transmission(name) values('4-gear');

insert into transmission(name) values('5-gear');

insert into transmission(name) values('6-gear');

insert into carcase(name) values('sedan');

insert into carcase(name) values('hachback');

insert into carcase(name) values('pick-up');

insert into car(name, engine_id, transmission_id, carcase_id) values('sedan', 1, 3, 1);

insert into car(name, engine_id, transmission_id, carcase_id) values('hach', 2, 2, 2);