drop database if exists practice;
create database if not exists practice;
use practice;

create table nhan_vien(
id_nhan_vien int auto_increment primary key,
ten_nhan_vien varchar(45) not null,
ngay_sinh date not null
);

insert into nhan_vien (ten_nhan_vien,ngay_sinh)
values ("Tin","1997-05-15"),
("Nam","1999-05-05"),
("Toan","1995-10-15"),
("Khanh","1990-05-01"),
("Hau","1997-03-03");

drop procedure if exists create_employee;
delimiter //
create procedure create_employee(
p_ten_nhan_vien varchar(45),
p_ngay_sinh varchar(45)
)
begin
		insert into nhan_vien(ten_nhan_vien,ngay_sinh)
		value(
            p_ten_nhan_vien ,
p_ngay_sinh
);
end;
// delimiter ;