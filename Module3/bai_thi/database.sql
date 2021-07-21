drop database if exists product;
create database if not exists product;
use product;

create table danh_muc(
id_danh_muc int auto_increment primary key,
ten_danh_muc varchar(45) not null
);

create table san_pham(
id_san_pham int auto_increment primary key,
ten_san_pham varchar(45) not null,
gia int not null,
so_luong int not null,
mau_sac varchar(45) not null,
mo_ta varchar(45) not null,
danh_muc int not null,
foreign key (danh_muc) references danh_muc(id_danh_muc) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into danh_muc(ten_danh_muc)
values ("phone"),("television");

insert into san_pham(ten_san_pham,gia,so_luong,mau_sac,mo_ta,danh_muc)
values ("Iphone","10000","1","red","ok","1"),
("Nokia","3000","1","black","ok","1"),
("Samsung","7000","1","white","ok","1"),
("SmartTV","100000","1","black","ok","2"),
("SmartTV2","100000","1","black","ok","2");

drop procedure if exists create_product;
delimiter //
create procedure create_product(
p_ten_san_pham varchar(45),
p_gia int ,
p_so_luong int ,
p_mau_sac varchar(45),
p_mo_ta varchar(45),
p_danh_muc int
)
begin
		insert into san_pham(ten_san_pham,gia,so_luong,mau_sac,mo_ta,danh_muc)
		value(
p_ten_san_pham,
p_gia,
p_so_luong,
p_mau_sac,
p_mo_ta ,
p_danh_muc);
end;
// delimiter ;

