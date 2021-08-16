create table if not exists User(
	id bigint not null primary key auto_increment,
	username varchar(100),
	password varchar(100) not null,
	role varchar(13) not null
);

create table if not exists Project(
	id bigint not null primary key auto_increment,
	project_id varchar(100) ,
	project_name varchar(100),
	project_start_date varchar(100),
	project_end_date varchar(100),
	employee_id bigint

);



create table if not exists Employee(
	id bigint not null primary key auto_increment,
	name varchar(30),
	user_id bigint not null,
	gender varchar(6) not null,
	pet_name varchar(50) not null,
	job varchar(50) not null,
	band varchar(50) not null,
	age int not null,
	project_id bigint not null
);

alter table Employee
  add foreign key (project_id) references Project(id);


alter table Employee
  add foreign key (user_id) references User(id);


alter table Project
add foreign key (employee_id) references Employee(id);

--create table if not exists Role(
--	id bigint not null primary key auto_increment,
--	name varchar(100) not null
--);
--
--create table if not exists Band(
--	id bigint not null primary key auto_increment,
--	description varchar(100) not null
--);

--alter table Employee
--  add foreign key (role_id) references Role(id);
--
--alter table Employee
--  add foreign key (band_id) references Band(id);


--create table if not exists Skill(
--	id varchar(5) not null primary key,
--	name varchar(100) not null,
--	role_id bigint not null,
--	band_id bigint not null
--);
--
--alter table Skill
--  add foreign key (role_id) references Role(id);
--
--alter table Skill
--  add foreign key (band_id) references Band(id);