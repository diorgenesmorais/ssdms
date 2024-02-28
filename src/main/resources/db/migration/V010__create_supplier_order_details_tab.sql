CREATE TABLE supplier_order_details (
  order_id 			int unsigned not null,
  product_id 		int unsigned not null,
  quantity 			decimal(10,2) not null default 0,
  price 			decimal(10,2) not null default 0,
  confirm 			boolean,
  constraint FK_supplier_order_details_id
  foreign key (order_id) references supplier_order (id),
  constraint FK_supplier_order_product_id
  foreign key (product_id) references products (id),
  primary key (order_id, product_id)
) engine=InnoDB character set=utf8mb4;