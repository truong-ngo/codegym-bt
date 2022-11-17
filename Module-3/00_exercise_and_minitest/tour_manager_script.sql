create database tour_manager;

create table country (
name varchar(30) primary key
);

insert into country (name) values
('Japan'),('Italy'),('Finland'),('England'),('Egypt');

create table location (
name varchar(30) primary key,
country varchar(30),
foreign key (country) references country (name)
);

insert into location (name, country) values
('Tokyo', 'Japan'),('Kyoto', 'Japan'),
('Venice', 'Italy'),('Rome', 'Italy'),
('Helsinki', 'Finland'),('Turku', 'Finland'),
('Manchester', 'England'),('Liverpool', 'England'),
('Cairo', 'Egypt'),('Alexandria', 'Egypt');

create table tour (
id int primary key auto_increment,
price int,
num_of_days int,
location varchar(30),
foreign key (location) references location (name)
);

insert into tour (price, num_of_days, location) values
(2300, 3, 'Tokyo'),(2200, 3, 'Kyoto'),
(2500, 3, 'Venice'),(2400, 3, 'Rome'),
(2200, 3, 'Helsinki'),(2300, 3, 'Turku'),
(2800, 3, 'Manchester'),(2800, 3, 'Liverpool'),
(2100, 3, 'Cairo'),(2100, 3, 'Alexandria');

create table customer (
id varchar(30) primary key,
name varchar(30),
age int check (age between 0 and 120),
address varchar(60)
);

insert into customer (id, name, age, address) values
('001', 'Truong', 29, 'Ha Noi'),
('002', 'Hung', 33, 'Nghe An'),
('003', 'Dien', 35, 'Thai Binh'),
('004', 'Tuan', 26, 'Thanh Hoa'),
('005', 'Linh', 27, 'Thai Nguyen');

create table employee (
id int primary key auto_increment,
name varchar(30),
age int check (age between 0 and 120),
salary int
);

insert into employee (name, age, salary) values
('Son', 25, 1200),
('Duc Anh', 26, 1300),
('Tung', 25, 1400),
('Ninh', 23, 1200),
('Nam', 25, 1100);

create table service (
tour_id int,
customer_id varchar(30),
employee_id int,
foreign key (tour_id) references tour (id),
foreign key (customer_id) references customer (id),
foreign key (employee_id) references employee (id),
primary key (tour_id, customer_id, employee_id)
);

insert into service (tour_id, customer_id, employee_id) values
(1, '001', 1),(2, '001', 1),
(2, '002', 2),(3, '002', 3),
(4, '003', 4),(5, '003', 5),
(6, '004', 1),(7, '004', 2),
(7, '005', 4),(10, '005', 5);

-- Display tour of any employee
-- Create procedure
delimiter //
create procedure tour_of_employee (in id int)
begin 
select employee.id, employee.name as employee, tour.location from employee
inner join service on employee.id = service.employee_id
inner join tour on service.tour_id = tour.id
where employee.id = id
order by tour.location;
end
// delimiter ;
-- Call
call tour_of_employee(1);

-- Display tour of any customer
-- Create procedure
delimiter //
create procedure tour_of_customer (in id varchar(30))
begin
select customer.id, customer.name as customer, tour.location from customer
inner join service on customer.id = service.customer_id
inner join tour on service.tour_id = tour.id
where customer.id = id
order by tour.location;
end
// delimiter ;
-- Call
call tour_of_customer('001');

-- Display tour of any city
-- Create procedure
delimiter //
create procedure tour_of_location (in location varchar(30))
begin
select tour.id as tour_id, customer.name as customer, employee.name as employee, tour.location from tour
inner join service on service.tour_id = tour.id
inner join customer on customer.id = service.customer_id
inner join employee on employee.id = service.employee_id
where tour.location = location
order by tour.id;
end
// delimiter ;
-- Call
call tour_of_location('Kyoto');

-- Display tour has max price
select * from tour
having price = (select max(price) from tour);