create database product_store;

create table product (
id int primary key auto_increment,
code varchar(20) unique,
name varchar(60),
price bigint,
date_create date,
amount int
);

insert into product (code, name, price, date_create, amount) values
('J01', 'Head First Java', '50', '2022-06-15', 70),
('J02', 'Effective Java', '40', '2022-05-20', 70),
('JS01', 'JavaScript The Definitive Guide', '45', '2022-08-25', 30),
('P01', 'Clean Code', '35', '2022-07-20', 30),
('DB01', 'Fundamentals of Database Systems', '55', '2022-07-20', 40),
('P02', 'Design Patterns for Dummies', '60', '2022-07-05', 35),
('PHP01', 'PHP & MySQL', '60', '2022-09-05', 40),
('CSS01', 'Mastering Bootstrap', '50', '2022-07-09', 20),
('PY01', 'A Byte of Python', '40', '2022-07-01', 10),
('C01', 'The C Programming Language', '30', '2022-08-09', 25);

create table customer (
id int primary key auto_increment,
name varchar(30),
age int check (age between 0 and 120),
address varchar(50)
);

insert into customer (name, age, address) values
('Truong', 29, 'Ha Noi'),
('Duc Anh', 26, 'Hai Phong'),
('Son', 25, 'Nghe An'),
('Hung', 33, 'Nghe An'),
('Trung', 29, 'Ha Tinh'),
('Ninh', 23, 'Thai Binh'),
('Thanh', 23, 'Dien Bien'),
('Dien', 35, 'Ha Noi'),
('Linh', 27, 'Ha Noi'),
('Nam', 25, 'Thai Nguyen');

create table orders (
id int primary key auto_increment,
date_create date,
customer_id int,
foreign key (customer_id) references customer (id)
);

insert into orders(date_create, customer_id) values
('2022-11-10', 1),
('2022-11-11', 2),
('2022-11-12', 3),
('2022-11-13', 4),
('2022-11-14', 5),
('2022-11-15', 6),
('2022-11-16', 7),
('2022-11-17', 8);

create table order_detail (
order_id int,
product_id int,
quantity int,
foreign key (order_id) references orders (id),
foreign key (product_id) references product (id),
primary key (order_id, product_id)
);

insert into order_detail (order_id, product_id, quantity) values
(1, 1, 5),(1, 2, 2),(1, 4, 1),
(2, 1, 3),(2, 7, 1),(2, 8, 2),
(3, 2, 5),(3, 6, 2),(3, 7, 5),
(4, 1, 2),(4, 10, 3),(4, 9, 2),
(5, 2, 3),(5, 4, 2),
(6, 5, 5),(6, 3, 4),
(7, 3, 3),(7, 6, 1),
(8, 4, 1),(8, 8, 2);

-- Max amount product
select * from product
where amount = (select max(amount) from product);

-- Sort descending price product
select * from product
order by price desc, name;

-- Product have date create before 10-07-2022
select * from product
group by id
having datediff('2022-07-10', date_create) > 0
order by id;

-- Sum price of order and order id
select orders.id as order_id, customer.name as customer, product.name as product, sum(product.price * order_detail.quantity) as total from orders
inner join customer on orders.customer_id = customer.id
left join order_detail on orders.id = order_detail.order_id
inner join product on product.id = order_detail.product_id
group by orders.id, product.name
order by orders.id;

-- Most bought product
select product.id as product_id, product.name as product_name, sum(order_detail.quantity) as number_of_purchases from product
inner join order_detail on product.id = order_detail.product_id
group by product.id
having number_of_purchases >= all (select sum(order_detail.quantity) from order_detail group by product_id)
order by product.id;


