CREATE TABLE products(
  id 			int unsigned auto_increment,
  codigo       	varchar(10) not null,
  descricao    	varchar(53) not null,
  categoria_id 	int unsigned not null,
  NCM          	varchar(10) not null,
  CEST         	varchar(9),
  GTIN         	varchar(14),
  preco        	decimal(10,2) not null default 0,
  estoque      	decimal(10,2) not null default 0,
  unidade_id   	int unsigned not null,
  detalhes     	varchar(66),
  update_at    	date  not null,
  constraint FK_categories
  foreign key (categoria_id) references categories (id),
  constraint FK_units
  foreign key (unidade_id) references units (id),
  primary key (id)
) engine=InnoDB character set=utf8mb4;
