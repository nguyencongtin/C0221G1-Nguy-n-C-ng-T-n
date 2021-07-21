use case_study;
-- Task 6 Hien thi cac thong tin lien quan toi tat ca cac loai dich vu chua tung duoc khach hang dat trong quy 1 cua nam 2019
select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, hd.ngay_lam_hop_dong, ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
join hop_dong hd on hd.id_dich_vu = dv.id_dich_vu
where dv.id_dich_vu not in (
select hop_dong.id_dich_vu
from hop_dong 
where (year(ngay_lam_hop_dong)=2019) and (month(ngay_lam_hop_dong) in (1,2,3)));   
-- Task 7 Hien thi cac thong tin lien quan toi tat ca cac loai dich vu da tung duoc khach hang dat trong nam 2018 nhung chua duoc dat trong nam 2019
select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, dv.so_nguoi_toi_da, ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
join hop_dong hd on hd.id_dich_vu = dv.id_dich_vu
where year(ngay_lam_hop_dong) = 2018
and dv.id_dich_vu not in (
select id_dich_vu 
from hop_dong
where year(ngay_lam_hop_dong) = 2019);

-- Task 8 Hien thi thong tin ho ten khach hang trong he thong khong trung lap ve ho ten
-- Cach 1:
select kh.ho_ten
from khach_hang kh
group by ho_ten;

-- Cach 2:
select distinct kh.ho_ten
from khach_hang kh;

-- Cach 3:
select distinctrow kh.ho_ten
from khach_hang kh;

-- Task 9 Thong ke doanh thu theo thang trong nam 2019
select month(hd.ngay_lam_hop_dong) as thang,count(month(hd.ngay_lam_hop_dong)) as so_lan_dat_phong
from hop_dong hd
where year(ngay_lam_hop_dong) = 2019
group by month(ngay_lam_hop_dong);

