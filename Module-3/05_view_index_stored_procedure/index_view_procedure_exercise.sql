create database view_procedure_index_demo;

create table products (
id int auto_increment primary key,
productCode varchar(20),
productName varchar(50),
productPrice int,
productAmount int,
productDescription varchar(100),
productStatus bit
);

create unique index idx_productCode on products(productCode);
create index idx_product on products(productName, productPrice);

alter table products
drop index idx_productCode,
drop index idx_product;

explain select * from products
where productName = 'Head First Java';
explain select * from products
where productCode = 'JAVA01';

create view products_view as
select productCode, productName, productPrice, productStatus from products;

select * from products_view;

set sql_safe_updates = 0;
update products_view
set productPrice = 90
where productCode = 'P02';
set sql_safe_updates = 1;

create or replace view products_view as
select productCode, productName, productPrice from products;

insert into products_view values('J03', 'Effective Java', 40, 1);

set sql_safe_updates = 0;
delete from products_view
where productCode = 'J03';
set sql_safe_updates = 1;

drop view products_view;

delimiter //
create procedure showAllProducts()
begin
select * from products;
end
// delimiter ;

call showAllProducts();

delimiter //
create function getPrice(id int) returns int deterministic
begin
declare price int;
select products.productPrice into price from products
where products.id = id;
return price;
end
// delimiter ;

select getPrice(1) as price;

-- sử dụng hàm thủ tục để thêm sản phẩm
delimiter //
create procedure addNewProduct(in code varchar(20), in name varchar(50), in price int, 
							   in amount int, in description varchar(100), in status bit)
begin
insert into products(productCode, productName, productPrice, productAmount, productDescription, productStatus)  
values(code, name, price, amount, description, status);
end
// delimiter ;
      
call addNewProduct('JAVA01', 'Head First Java', 60, 30, 'Java Book', 1);
call addNewProduct('JS01', 'Javascript the Definition', 50, 20, 'Javascript Book', 1);
call addNewProduct('P01', 'Clean Code', 55, 40, 'Programing Book', 0);
call addNewProduct('P02', 'Design Pattern', 40, 20, 'Programing Book', 0);
call addNewProduct('SQL01', 'SQL Cookbook', 45, 50, 'SQL Book', 1);

-- sử dụng hàm thủ tục để chỉnh sửa sản phẩm
delimiter //
create procedure updateProduct(in id int, in code varchar(20), in name varchar(50), in price int, 
							   in amount int, in description varchar(100), in status bit)
begin
update products
set productCode = code,
	productName = name,
	productPrice = price,
	productAmount = amount,
	productDescription = description,
	productStatus = status
where products.id = id;
end
// delimiter ;

call updateProduct(5, 'SQL01', 'SQL Cookbook', 60, 30, 'SQL Book', 1);

-- sử dụng hàm thủ tục để xóa sản phẩm
delimiter //
create procedure deleteProduct(in id int)
begin
delete from products where products.id = id;
end
// delimiter ;

call deleteProduct(5); 
