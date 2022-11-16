 insert into customers (name, age)
 values('Minh Quan', 10),
 ('Ngoc Oanh', 20),
 ('Hong Ha', 50);
 
 insert into orders (customer_id, date)
 values(1, '2006-3-21'),
 (2, '2006-3-23'),
 (1, '2006-3-16');
 
 insert into products (name, price)
 values('May Giat',3),
 ('Tu Lanh', 5),
 ('Dieu Hoa', 7),
 ('Quat', 1),
 ('Bep dien', 2);
 
 insert into order_details (order_id, product_id, quantity)
 values(1,1,3),
 (1,3,7),
 (1,4,2),
 (2,1,1),
 (3,1,8),
 (2,5,4),
 (2,3,3);
 
select orders.id, orders.date, products.name, sum(products.price * order_details.quantity) as total from orders
left join order_details on orders.id = order_details.order_id
inner join products on products.id = order_details.product_id
group by orders.id, products.name
order by orders.id;
 
select orders.id, customers.name as customer, products.name as product from customers 
inner join orders on customers.id = orders.customer_id
right join order_details on order_details.order_id = orders.id 
inner join products on order_details.product_id = products.id
order by orders.id;

select customers.id, customers.name as customer from customers
where customers.id not in (select customer_id from orders);

select orders.id, orders.date, sum(products.price * order_details.quantity) as total from orders
left join order_details on orders.id = order_details.order_id
inner join products on products.id = order_details.product_id
where orders.id = 1
order by orders.id;

select orders.id, orders.date, sum(products.price * order_details.quantity) as total from orders
left join order_details on orders.id = order_details.order_id
inner join products on products.id = order_details.product_id
where orders.id = 2
order by orders.id;

select orders.id, orders.date, sum(products.price * order_details.quantity) as total from orders
left join order_details on orders.id = order_details.order_id
inner join products on products.id = order_details.product_id
where orders.id = 3
order by orders.id;