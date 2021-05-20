use case_study;
-- Task 22 Cap nhat dia chi cua tat ca nhan vien 
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS= 0;
update v_nhan_vien 
set v_nhan_vien.dia_chi = "Lienchieu";
SET FOREIGN_KEY_CHECKS= 1;

-- Task 23 store procedure de xoa thong tin cua khach hang 
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS= 0;
delimiter //
create procedure sp_1 (p_id int)
BEGIN
delete from khach_hang 
where id_khach_hang = p_id;
END; //
delimiter ;
call sp_1 (10);
SET FOREIGN_KEY_CHECKS= 1;
select * from khach_hang;

-- Task 24
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS= 0;
delimiter //
create procedure sp_2()
BEGIN

END; //
SET FOREIGN_KEY_CHECKS= 1;
