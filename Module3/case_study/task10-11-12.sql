use case_study;
-- Task 10 Hien thi thong tin tuong ung voi tung hop dong thi su dung bao nhieu dich vu di kem ( tinh dua tren viec count cac id_hop_dong_chi_tiet )
select hd.id_hop_dong,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,hd.tien_dat_coc,
count(hdct.id_hop_dong_chi_tiet) as 'so_luong_DVDK'
from hop_dong hd
join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
group by hd.id_hop_dong;

-- Task 11 Hien thi thong tin cac dich vu di kem cua khach hang Diamond va co dia chi o Vinh hoac Quang Ngai
select dvdk.id_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem,
dvdk.gia,dvdk.don_vi,dvdk.trang_thai_kha_dung,
kh.ho_ten,kh.dia_chi
from dich_vu_di_kem dvdk 
join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
join hop_dong hd on hdct.id_hop_dong = hd.id_hop_dong
join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
where (kh.id_loai_khach_hang = 1) and (kh.dia_chi = "vinh"  or  kh.dia_chi = "quangngai");

-- Task 12 Hien thi thong tin cua tat ca cac dich vu tung duoc khach hang dat vao 3 thang cuoi nam 2019 nhung chua tung duoc khach hang dat vao 6 thang dau nam 2019
select hd.id_hop_dong,nv.ho_ten as 'ten_nhan_vien',kh.ho_ten as 'ten_khach_hang',kh.sdt,dv.ten_dich_vu,count(hdct.id_hop_dong_chi_tiet) as 'so_luong_dvdk',hd.ngay_lam_hop_dong,hd.tien_dat_coc
from hop_dong hd
join nhan_vien nv on hd.id_nhan_vien = nv.id_nhan_vien
join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
where ( (month(hd.ngay_lam_hop_dong) in (10,11,12)) and  year(hd.ngay_lam_hop_dong) = 2019 ) 
and not exists (
select hd.id_hop_dong
from hop_dong hd
where (month(ngay_lam_hop_dong) between 1 and 6)  
and year(hd.ngay_lam_hop_dong) = 2019
and hd.id_dich_vu = dv.id_dich_vu
)
group by hd.id_hop_dong;
 