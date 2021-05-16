use case_study;
-- Task2 Hien thi thong tin cua tat ca nhan vien co trong he thong co ten bat dau la " H,K,T" va co toi da 15 ky tu
select *
from nhan_vien 
where (ho_ten like "h%" or ho_ten like "t%"  or ho_ten like "k%" ) and (length(ho_ten) <=15) ; 

-- Task 3 Hien thi thong tin cua tat ca khach hang co do tuoi tu 18 den 50 va co dia chi o Da Nang hoac Quang Tri
select *
from khach_hang
where (year(curdate()) - year(ngay_sinh) between 18 and 50) and (dia_chi in ("danang","quangtri"));

-- Task 4 Dem so lan dat phong
select kh.ho_ten, count(*) as so_lan
from khach_hang kh
join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang 
join loai_khach_hang lkh on lkh.id_loai_khach_hang = kh.id_loai_khach_hang 
where lkh.ten_loai_khach_hang ="Diamond" 
group by hd.id_khach_hang
order by so_lan asc;

-- Task 5 Hien thi cac thong tin cho tat ca khach hang da tung dat phong ( ke ca chua dat phong )
select kh.id_khach_hang, kh.ho_ten, lkh.ten_loai_khach_hang, hd.id_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong,  hd.ngay_ket_thuc,sum(dv.chi_phi_thue+hdct.so_luong* dvdk.gia) as tong_tien
from khach_hang kh
left join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang 
left join loai_khach_hang lkh  on kh.id_loai_khach_hang = lkh.id_loai_khach_hang
left join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
left join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by kh.id_khach_hang;