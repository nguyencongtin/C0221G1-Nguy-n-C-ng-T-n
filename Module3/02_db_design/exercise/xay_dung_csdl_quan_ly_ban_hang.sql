drop database quan_ly_ban_hang;
create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
customer_id int auto_increment primary key,
customer_name varchar(45),
customer_age int
);
create table `order`(
order_id int auto_increment primary key,
customer_id int,
order_date date,
order_total_price int,
foreign key (customer_id) references customer(customer_id)
);
create table product(
product_id int auto_increment primary key,
product_name varchar(45),
product_price int
);
create table order_detail(
order_id int,
product_id int,
order_detail_quantity int,
primary key (order_id,product_id),
foreign key (order_id) references `order`(order_id),
foreign key (product_id) references product(product_id)
);