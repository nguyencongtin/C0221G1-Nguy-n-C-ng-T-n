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
select * from dich_vu_di_kem;
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS= 0;
update khach_hang
set id_loai_khach_hang = 1
where (id_loai_khach_hang = 2) and id_khach_hang in (select temp.id_khach_hang 
													 from ( select kh.id_khach_hang
															from khach_hang kh
															left join loai_khach_hang lkh on kh.id_loai_khach_hang = lkh.id_loai_khach_hang 
															left join hop_dong hd on  kh.id_khach_hang = hd.id_khach_hang
															left join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
															left join hop_dong_chi_tiet hdct on  hd.id_hop_dong = hdct.id_hop_dong
															left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
															group by kh.id_khach_hang
															having sum((dvdk.gia*hdct.so_luong)+dv.chi_phi_thue) > 10000000 )temp);
SET FOREIGN_KEY_CHECKS=1;
-- Task 18 Xoa nhung khach hang co hop dong truoc nam 2016 
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS=0;
delete from khach_hang 
where khach_hang.id_khach_hang in (select hop_dong.id_khach_hang 
								   from hop_dong 
								   where year(ngay_lam_hop_dong)<2016 );
SET FOREIGN_KEY_CHECKS=1;
