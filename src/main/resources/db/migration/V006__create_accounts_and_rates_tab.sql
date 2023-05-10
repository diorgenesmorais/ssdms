create table accounts (
    id 				int unsigned auto_increment,
	name 	        varchar(30) not null,
	primary key (id)
) engine=InnoDB character set=utf8mb4;

create table rates (
    id 				int unsigned auto_increment,
	account_id 	    int unsigned not null,
    parcel          tinyint not null default 1,
    rate            decimal(5,4) not null default 0,
    deadline        tinyint not null default 0,
    constraint FK_accounts
    foreign key (account_id) references accounts (id),
	primary key (id)
) engine=InnoDB character set=utf8mb4;