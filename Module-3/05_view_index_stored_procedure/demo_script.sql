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

-- INDEX (CHỈ MỤC)
-- Là một mô hình bảng tra cứu được Database Search Engine sử dụng để tăng tốc độ và hiệu suất truy xuất dữ liệu
-- Các kiểu index: B-Tree, Hash, R-Tree
-- Cách sử dụng index
-- thêm index
create unique index idx_productCode on products(productCode);
create index idx_product on products(productName, productPrice);
alter table products add fulltext idx_desc (productDescription);

-- xóa index
alter table products
drop index idx_productCode,
drop index idx_product,
drop index idx_desc;

-- giải thích truy vấn
explain select * from products
where productName = 'Head First Java';
explain select * from products
where productCode = 'JAVA01';

-- Lưu ý: 
-- 1. không nên sử dụng ở các bảng nhỏ
-- 2. không nên sử dụng ở bảng thường xuyên có các hoạt động update và insert
-- 3. không nên sử dụng ở các cột chứa 1 số lượng lớn giá trị null

-- VIEW (KHUNG NHÌN)
-- Là các truy vấn SELECT được lưu lại như là một table và sau đó ta thể truy vấn dữ liệu từ view như với table
-- tạo view từ bảng
create view products_view as
select productCode, productName, productPrice, productStatus from products;

-- hiển thị view
select * from products_view;

-- chỉnh sửa view
set sql_safe_updates = 0;
update products_view
set productPrice = 90
where productCode = 'P02';
set sql_safe_updates = 1;

create or replace view products_view as
select productCode, productName, productPrice from products;

-- chèn hàng vào view
insert into products_view values('J03', 'Effective Java', 40, 1);

-- xóa hàng trong view
set sql_safe_updates = 0;
delete from products_view
where productCode = 'J03';
set sql_safe_updates = 1;

-- xóa view
drop view products_view;

-- Lưu ý khi update, insert và delete trong view
-- 1. view được định nghĩa từ 1 bảng cơ sở, các thành phần chọn trong select phải là các cột trong bảng cơ sở, không chứa biểu thức tính toán, hàm gộp
-- 2. ko chứa các từ khóa DISTINCT, TOP, GROUP BY, HAVING, ORDER_BY và UNION
-- 3. không chứa sub querry

-- PROCEDURE (HÀM THỦ TỤC)
-- Là một phân đoạn các câu lệnh SQL khai báo được lưu trữ bên trong danh mục cơ sở dữ liệu
-- Cú pháp:
-- DELIMITER //
-- CREATE PROCEDURE [procedure_name] ([param1, param2,…])
-- BEGIN
-- [sql_statements]
-- END
-- // DELIMITER ;

-- sử dụng hàm thủ tục để hiển thị bảng sản phẩm
delimiter //
create procedure showAllProducts()
begin
select * from products;
end
// delimiter ;

call showAllProducts();

-- hàm thủ tục với tham số đầu ra
delimiter //
create procedure findMax(out value int)
begin
set value = (select max(productPrice) from products);
end
// delimiter ;

call findMax(@max);
select @max;

-- hàm thủ tục với tham số inout

delimiter //
create procedure increase (inout num int)
begin
set num = num + 1;
end
// delimiter ;

set @num = 1;
call increase(@num);
call increase(@num);
select @num as number;

-- xóa procedure
drop procedure increase;

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

-- function trong MySQL
-- CREATE FUNCTION name ([parameterlist]) RETURNS datatype [options] sqlcode
