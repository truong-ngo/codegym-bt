use student_manager;

select * from subject
having credit = (select max(credit) from subject)
order by sub_id;

select subject.sub_id, subject.sub_name, subject.credit, mark.mark from subject
inner join mark on subject.sub_id = mark.sub_id
having mark = (select max(mark) from mark);

select student.student_id, student.student_name, student.address, student.phone, avg(mark) as average from student
inner join mark on student.student_id = mark.student_id
group by student.student_id
order by average;