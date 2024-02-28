CREATE TABLE supplier_order(
  id				int unsigned auto_increment,
  date_ordered		datetime not null,
  provider_id 		int unsigned not null,
  constraint FK_supplier_order_to_providers
  foreign key (provider_id) references providers (id),
  primary key (id)
) engine=InnoDB character set=utf8mb4;