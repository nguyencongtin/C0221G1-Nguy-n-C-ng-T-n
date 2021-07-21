CREATE DATABASE demo;
USE demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

select * from users;

DELIMITER $$

CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.name, users.email, users.country

    FROM users

    where users.id = user_id;

    END$$

DELIMITER ; 

DELIMITER $$

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);

    END$$

DELIMITER ;

create table Permision(

id int(11) primary key,

name varchar(50)

);

create table User_Permision(

permision_id int(11),

user_id int(11)

);

insert into Permision(id, name) values(1, 'add');

insert into Permision(id, name) values(2, 'edit');

insert into Permision(id, name) values(3, 'delete');

insert into Permision(id, name) values(4, 'view');

select * from User_Permision;
select * from users;
select * from Permision;
select * from Employee;

delimiter //
create procedure get_information()
BEGIN
select * from users;
END; //
delimiter ;

delimiter //
create procedure sp_update(p_id int,p_name varchar(50),p_email varchar(50) ,p_country varchar(50))
BEGIN
update users
set name = p_name, email= p_email, country= p_country
where id = p_id;
END; //
delimiter ;
call sp_update(3,"vvvv","12312","vn");
delimiter //
create procedure sp_delete(p_id int)
BEGIN
delete from users
where id = p_id;
END; //
delimiter ;

call sp_delete(3);