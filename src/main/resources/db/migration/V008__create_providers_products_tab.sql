CREATE TABLE provider_products(
  provider_id 		int unsigned not null,
  supplier_code 	varchar(20) not null,
  product_id 		int unsigned not null,
  price 			decimal(10,2) not null default 0,
  amount 			decimal(10,2) not null default 0,
  ask 				boolean,
  constraint FK_provider_products
  foreign key (provider_id) references providers (id),
  constraint FK_products_provider
  foreign key (product_id) references products (id),
  primary key (provider_id, product_id)
) engine=InnoDB character set=utf8mb4;