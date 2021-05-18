use case_study;
-- Task 19 Cap nhat gia cho cac dich vu di kem duoc su dung tren 10 lan
-- trong nam 2019 len gap doi
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS= 0;
update dich_vu_di_kem
set gia = gia *2
where dich_vu_di_kem.id_dich_vu_di_kem = all (select temp.id_dich_vu_di_kem from(
select dvdk.id_dich_vu_di_kem from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
join hop_dong hd on hdct.id_hop_dong = hd.id_hop_dong
where year(ngay_lam_hop_dong) = 2019
group by dvdk.id_dich_vu_di_kem 
having sum(so_luong) > 10)temp);
SET FOREIGN_KEY_CHECKS= 1;

-- Task 20 Hien thi thong tin cua tat ca cac nhan vien va khach hang co trong he thong
select nv.id_nhan_vien 'id', nv.ho_ten 'ho_ten', nv.email'email', nv.sdt'so_dien_thoai', nv.ngay_sinh'ngay_sinh', nv.dia_chi'dia_chi' 
from nhan_vien nv
union all
select kh.id_khach_hang , kh.ho_ten, kh.email, kh.sdt, kh.ngay_sinh,kh.dia_chi  
from khach_hang kh;

