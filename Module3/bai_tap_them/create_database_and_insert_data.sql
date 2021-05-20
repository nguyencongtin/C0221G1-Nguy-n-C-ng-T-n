create database internship;
use internship;
create table faculty (
faculty_id int not null primary key,
faculty_name varchar(50),
phone int(10)
);

create table instructor (
instructor_id int not null primary key,
instructor_name varchar(50),
salary double,
faculty_id int,
foreign key (faculty_id) references faculty(faculty_id) 
);

create table student (
student_id int not null primary key,
student_name varchar(50),
date_of_birth date,
place_of_birth varchar(50),
faculty_id int,
foreign key (faculty_id) references faculty(faculty_id) 
);

create table project(
project_id int not null primary key,
project_name varchar(50) not null,
expense int,
place_of_intern varchar(30)
);

create table instructor_student (
instructor_student_id int not null primary key,
student_id int,
project_id int,
instructor_id int,
grade double,
foreign key (student_id) references student(student_id),
foreign key (project_id) references project(project_id),
foreign key (instructor_id) references instructor(instructor_id)
);

insert into faculty
values (1,"Hoa",123456), 
(2,"Toan",7891011), 
(3,"Ly",777777);

insert into instructor
values (1,"Linh",7777,1),
(2,"My",9999,3),
(3,"Duong",4444,2);

insert into student
values (1,"Nguyen","1997-05-15","DaNang",1),
(2,"Cong","2002-02-02","QuangNam",2),
(3,"Tin","1997-03-11","Hue",3);

insert into project
values (1,"project1",1000,"HoiAn"),
(2,"project2",2000,"SaiGon"),
(3,"project3",3000,"HaNoi");

insert into instructor_student
values (1,1,1,1,9.5),
(2,2,3,3,5.5),
(3,3,2,2,1);