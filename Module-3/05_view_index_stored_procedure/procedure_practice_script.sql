use classicmodels;

delimiter //
create procedure findAllCustomers()
begin
select * from customers;
end
// delimiter ;

call findAllCustomers();

delimiter //
create procedure findCustomerByNumber(in number int)
begin
select * from customers
where customerNumber = number;
end
// delimiter ;

call findCustomerByNumber(175);