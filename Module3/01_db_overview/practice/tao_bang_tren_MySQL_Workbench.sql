CREATE Database if not exists `student-management`;

use `student-management`;
CREATE Table if not exists `student`(
`id` int auto_increment not null primary key,
`name` varchar(150) null,
`age` int null,
`country` varchar(150) null
);
