use case_study;
INSERT INTO vi_tri(ten_vi_tri)
VALUES ("le tan"),
("phuc vu"),
("chuyen vien"),
("giam sat"),
("quan ly"),
("giam doc");

insert into trinh_do(trinh_do)
values ("trung cap"),
("cao dang"),
("dai hoc"),
("sau dai hoc");
    
insert into bo_phan(ten_bo_phan)
values ("sale – marketing"),
("hanh chinh"),
("phuc vu"),
("quan ly");

insert into nhan_vien(ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,so_cmtnd,luong,sdt,email,dia_chi)
values ("Tin",1,1,1,"1997-05-15","123456789",15050,"0768585459","nguyencongtin@gmail.com","DN"),
("Linh",2,2,2,"1997-11-03","987654321",110300,"0935999999","mylinh@gmail.com","QN"),
("Khanh",3,3,3,"1993-02-04","000000001",80000,"0909555000","khanhphan@gmail.com","HN");

insert into loai_khach_hang(ten_loai_khach_hang)
values ("Diamond"),
("Platinium"),
("Gold"),
("Silver"),
("Member");

insert into khach_hang(id_loai_khach_hang,ho_ten,ngay_sinh,so_cmtnd,sdt,email,dia_chi)
values (1,"Oanh","1990-05-05","123321456","0900123456","oanh@gmail.com","danang"),
(2,"Chanh","1966-01-10","987412365","0999951159","chanh@gmail.com","quangtri"),
(3,"Long","1966-01-10","987412365","0989898989","long@gmail.com","quangtri"),
(3,"Nhan","1986-03-25","987412365","0903987369","nhan@gmail.com","quangtri"),
(4,"Trang","2000-01-15","563214789","0999999999","trang@gmail.com","hue");

insert into kieu_thue(ten_kieu_thue,gia)
values ("nam",1505),
("thang",150),
("ngay",10),
("gio",5);

insert into loai_dich_vu(ten_loai_dich_vu)
values ("room"),
("house"),
("villa");

insert into dich_vu(ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue,id_loai_dich_vu,trang_thai)
values ("room1",15,1,2,1000,1,1,"ok"),
("house1",50,2,5,3000,2,2,"ok"),
("villa1",150,3,15,8000,3,3,"ok");

insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung)
values ("massage",1500,5,"ok"),
("karaoke",1000,7,"ok"),
("thuc an",500,10,"ok"),
("nuoc uong",100,10,"ok"),
("thue xe",3000,10,"ok");

insert into hop_dong (id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc)
values (1,1,1,"2021-05-14","2021-06-01",1000),
(2,2,2,"2021-05-13","2021-05-20",1500);

insert into hop_dong_chi_tiet(id_hop_dong,id_dich_vu_di_kem,so_luong)
values (1,1,5),
(2,2,7);