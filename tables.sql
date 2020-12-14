create table items (
	item_id int auto_increment,
	primary key (item_id),
	item_code varchar(10) not null unique,
	description varchar(50),
	price decimal(13,2) default 0,
	inventory int default 0
)

create table orders (
	order_id int auto_increment,
	primary key(order_id),
	item_code varchar(10) not null,
	foreign key (item_code) references items(item_code),
	quantity int not null,
	order_timestamp timestamp default current_timestamp
)