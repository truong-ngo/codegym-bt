use student_manager;
select student.address, count(address) as number_of_student from student
group by student.address;

select student.student_id, student.student_name, avg(mark) as average from student
right join mark on student.student_id = mark.student_id
group by student.student_id
order by student.student_id;

select student.student_id, student.student_name, avg(mark) as average from student
right join mark on student.student_id = mark.student_id
group by student.student_id
having average > 15
order by student.student_id;

select student.student_id, student.student_name, avg(mark) as average from student
right join mark on student.student_id = mark.student_id
group by student.student_id
having average >= all (select avg(mark) from mark group by mark.student_id)
order by student.student_id;



