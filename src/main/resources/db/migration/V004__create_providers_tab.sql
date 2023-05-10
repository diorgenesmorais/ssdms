CREATE TABLE providers(
  id 					int unsigned auto_increment,
  cnpj 					varchar(14) not null,
  corporate_name 		varchar(100) not null,
  fantasy_name 			varchar(40) not null,
  uf 					char(2) not null,
  sales_representative 	varchar(20),
  phone_number 			varchar(11),
  email 				varchar(100),
  site 					varchar(100),
  comments 				varchar(255),
  primary key (id)
) engine=InnoDB character set=utf8mb4;
