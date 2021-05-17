use case_study;
-- Task 13 Hien thi thong tin cac dich vu di kem duoc su dung nhieu nhat boi cac khach hang da dat phong
select dvdk.id_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem,dvdk.gia,dvdk.don_vi,dvdk.trang_thai_kha_dung, sum(hdct.so_luong) as 'so_lan_su_dung'
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by dvdk.ten_dich_vu_di_kem, dvdk.id_dich_vu_di_kem
having so_lan_su_dung >= all(select sum(hop_dong_chi_tiet.so_luong) from hop_dong_chi_tiet group by id_dich_vu_di_kem );

-- Task 14 Hien thi thong tin cac dich vu di kem chi moi duoc su dung 1 lan

select hd.id_hop_dong,ldv.ten_loai_dich_vu,dvdk.ten_dich_vu_di_kem,count(dvdk.id_dich_vu_di_kem) as "so_lan_su_dung"
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
join hop_dong hd on hdct.id_hop_dong = hd.id_hop_dong
join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
group by dvdk.ten_dich_vu_di_kem
having so_lan_su_dung = 1;

-- Task 15 Hien thi thong tin cua tat ca nhan vien moi chi lap duoc toi da 3 hop dong tu nam 2018 den nam 2019
select nv.id_nhan_vien,nv.ho_ten,nv.sdt,nv.dia_chi,td.trinh_do,bp.ten_bo_phan ,count(hd.id_nhan_vien) as 'so_luong_hop_dong'
from nhan_vien nv
join bo_phan bp on nv.id_bo_phan = bp.id_bo_phan
join trinh_do td on nv.id_trinh_do = td.id_trinh_do
join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien
where year(hd.ngay_lam_hop_dong) between 2018 and 2019
group by hd.id_nhan_vien
having so_luong_hop_dong < 4;
 