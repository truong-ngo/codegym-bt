use classicmodels;

drop procedure getCusById;

 -- in parameter
delimiter //
create procedure getCusById (in cusNum int)
begin
select * from customers
where customerNumber = cusNum;
end
// delimiter ;

call getCusById(202);

-- out parameter
delimiter //
create procedure getCustomerCountByCity(in in_city varchar(30), out total int)
begin
select count(customerNumber) into total from customers
where city = in_city;
end
// delimiter ;

call getCustomerCountByCity('NYC', @total);
select @total;

-- inout parameter
delimiter //
create procedure setCounter(inout counter int, in inc int)
begin
set counter = counter + inc;
end
// delimiter ;

set @counter = 1;
call setCounter(@counter, 5);
select @counter;

