create table users (
    id 				int unsigned auto_increment,
	name 	        varchar(45) not null,
    email           varchar(64) not null,
    active          boolean,
	primary key (id)
) engine=InnoDB character set=utf8mb4;