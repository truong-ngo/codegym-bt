create database sales_manager;

create table customers (
id int auto_increment primary key,
name varchar(30),
age tinyint,
);

create table orders (
id int auto_increment primary key,
customer_id int not null,
unique (customer_id),
date datetime,
total_price int
);

create table products (
id int auto_increment primary key,
name varchar(30),
price int
);

create table order_details (
order_id int,
product_id int,
quantity int,
unique (order_id, product_id),
foreign key (order_id) references orders (id),
foreign key (product_id) references products (id)
);