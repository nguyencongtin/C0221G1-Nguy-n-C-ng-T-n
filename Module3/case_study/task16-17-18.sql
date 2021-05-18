use case_study;
-- Task 16 Xoa nhung nhan vien chua tung lap duoc hop dong nao tu nam 2017 den nam 2019
select * from nhan_vien;
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS=0;
delete from nhan_vien
where nhan_vien.id_nhan_vien not in ( select id_nhan_vien 
									  from hop_dong
									  where year(ngay_lam_hop_dong) between 2017 and 2019);
 SET FOREIGN_KEY_CHECKS=1;
select * from nhan_vien;

-- Task 17 Cap nhat thong tin khach hang tu Platinium len Diamond voi tong tien thanh toan trong nam 2019 la lon hon 10.000.000 VND
select * from khach_hang;
select * from hop_dong;