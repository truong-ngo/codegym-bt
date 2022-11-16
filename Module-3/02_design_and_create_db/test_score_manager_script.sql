create database test_score_manager;

create table student (
id varchar(20) primary key,
name varchar(50),
birth_day datetime,
class varchar(20),
gender varchar(20)
);

create table subject (
id varchar(20) primary key,
name varchar(50)
);

create table score (
student_id varchar(20),
subject_id varchar(20),
score int,
date datetime,
primary key (student_id, subject_id),
foreign key (student_id) references student (id),
foreign key (subject_id) references subject (id)
);

create table teacher (
id varchar(20) primary key,
name varchar(20),
phone_number varchar(20)
);

alter table subject
add teacher_id varchar(20);

alter table subject
add constraint fk_teacher_id foreign key (teacher_id) references teacher (id);
