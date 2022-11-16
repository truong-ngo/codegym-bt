create database student_manager;

create table class (
class_id int auto_increment primary key,
class_name varchar(60),
start_date datetime,
status bit
);

create table student (
student_id int auto_increment primary key,
student_name varchar(30) not null,
address varchar(20),
status bit,
class_id int not null,
foreign key (class_id) references class (class_id)
);

create table subject (
sub_id int auto_increment primary key,
sub_name varchar(30) not null,
credit tinyint not null default 1 check (credit >= 1),
status bit default 1
);

create table mark (
mark_id int auto_increment primary key,
sub_id int not null,
student_id int not null,
mark float default 0 check (mark between 0 and 100),
exam_times tinyint default 1,
unique (sub_id, student_id),
foreign key (sub_id) references subject (sub_id),
foreign key (student_id) references student (student_id)
)

