use classicmodels;

create view customers_view as
select customerNumber, customerName, phone from customers;

select * from customers_view;

create or replace view customers_view as
select customerNumber, customerName, contactFirstName, contactLastName, phone from customers
where city = 'Lyon';

drop view customers_view;