Create database demo;
use demo;
create table products (
id int auto_increment primary key,
product_code varchar(50),
product_name varchar(50),
product_price int, 
product_amount int,
product_description varchar(50),
product_status varchar(50)
);

insert into products (product_code,product_name,product_price,product_amount,product_description,product_status)
values ("Car1","Mercedes","5000","10","Black","New"),
("Car2","Audi","3000","10","White","New"),
("Car3","Limousine","10000","10","Blue","New"),
("Car4","Ferrari","25000","10","Red","New"),
("Car5","Lamborghini","150500","10","Yellow","New");

-- create index
create unique index index_code on products (product_code);

create unique index index_name_price on products (product_name,product_price);

explain select * from products where product_code = "Car5";
explain select * from products where product_name = "Lamborghini" or product_price = "5000";

-- create view
create view get_information as
select product_code,product_name,product_price,product_status
from products;

-- update view
update get_information
set product_price = 3500, product_status = "LikeNew"
where product_name = "Audi";

-- drop view
drop view get_information;

-- create store procedure to get information
delimiter //
create procedure get_information()
BEGIN
select * from products;
END; //
delimiter ;

call get_information();

-- create store procedure to insert product
delimiter //
create procedure sp_insert_product(p_code varchar(50),p_name varchar(50),p_price int,
p_amount int,p_description varchar(50),p_status varchar(50))
BEGIN
insert into products(product_code,product_name,product_price,product_amount,
product_description,product_status)
values (p_code,p_name,p_price,p_amount,p_description,p_status);
END; //
delimiter ;

call sp_insert_product("Car6","VinFast","9999","10","Silver","New");

-- create store procedure to update product
delimiter //
create procedure sp_update_product(p_id int,p_code varchar(50),p_name varchar(50) ,p_price int,p_amount int,p_description varchar(50),p_status varchar(50))
BEGIN
update products
set product_code = p_code,product_name = p_name,product_price = p_price,product_amount = p_amount,product_description = p_description,product_status = p_status
where id = p_id;
END; //
delimiter ;

call sp_update_product(1,"Car001","Mercedess","5005","10","Black","New");

-- create store procedure to delete
delimiter //
create procedure sp_delete_product(p_id int)
BEGIN
delete from products 
where id = p_id;
END; //
delimiter ;

call sp_delete_product (6);
