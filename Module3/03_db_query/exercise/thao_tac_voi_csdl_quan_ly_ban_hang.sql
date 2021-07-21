use quan_ly_ban_hang;
insert into customer(customer_name,customer_age)
values ("Minh Quan",10),
("Ngoc Oanh",20),
("Hong Ha",50);

insert into `order`(customer_id,order_date)
values (1,"2006-03-21"),
(2,"2006-03-23"),
(1,"2006-03-16");

insert into product(product_name,product_price)
values ("May Giat",3),
("Tu Lanh",5),
("Dieu Hoa",7),
("Quat",1),
("Bep Dien",2);

insert into order_detail(order_id,product_id,order_detail_quantity)
values (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

select o.order_id, o.order_date, p.product_price 
from `order` o join order_detail od on o.order_id = od.order_id join product p on od.product_id = p.product_id;

select c.customer_name,  p.product_name
from customer c join `order` o on c.customer_id = o.customer_id
join order_detail od on o.order_id = od.order_id 
join product p on od.product_id = p.product_id;


select  c.customer_name 
from  customer c
left join `order` o on c.customer_id =o.customer_id
where o.order_id is null;


select o.order_id,  o.order_date, sum(od.order_detail_quantity * p.product_price) as total_price
from  `order` o 
join order_detail od on  o.order_id = od.order_id
join product p on od.product_id = p.product_id 
group by o.order_id;