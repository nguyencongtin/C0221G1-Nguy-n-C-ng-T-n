use case_study;
-- Task 21 Tao view lay thong tin cua nhan vien dua theo dieu kien de bai
create view v_nhan_vien as (
select nv.id_nhan_vien,nv.ho_ten,nv.dia_chi from nhan_vien nv
join hop_dong hd on nv.id_nhan_vien= hd.id_nhan_vien
where hd.ngay_lam_hop_dong = "2019-12-12" and nv.dia_chi="Haichau"
);
select * from v_nhan_vien ;