use `student-management`;
CREATE table if not exists `Class`(
`id` int auto_increment not null primary key,
`name` varchar(150) null
);
CREATE table if not exists `Teacher`(
`id` int auto_increment not null primary key,
`name` varchar(150) null,
`age` int null,
`country` varchar(150)
);
select * from `Class`;
insert into `Class`(id,`name`)
value(1,"Tin"),(3,"Anh");
select * from `Class`;
insert into `Teacher`(`name`,`age`,`country`)
value("Linh",24,"Da Nang");
select * from `Teacher`;
