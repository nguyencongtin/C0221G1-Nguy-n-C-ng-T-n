create database case_study;
use case_study;
create table vi_tri(
id_vi_tri int auto_increment primary key,
ten_vi_tri varchar(45)
); 

create table trinh_do(
id_trinh_do int auto_increment primary key,
trinh_do varchar(45)
);

create table bo_phan(
id_bo_phan int auto_increment primary key,
ten_bo_phan varchar(45)
);

create table nhan_vien(
id_nhan_vien int auto_increment primary key,
ho_ten varchar(45),
id_vi_tri int not null,
id_trinh_do int not null,
id_bo_phan int not null,
ngay_sinh date,
so_cmtnd varchar(45),
luong double,
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (id_vi_tri) references vi_tri(id_vi_tri),
foreign key (id_trinh_do) references trinh_do(id_trinh_do),
foreign key (id_bo_phan) references bo_phan(id_bo_phan)
);

create table loai_khach_hang(
id_loai_khach_hang int auto_increment primary key,
ten_loai_khach_hang varchar(45)
);

create table khach_hang(
id_khach_hang int auto_increment primary key,
id_loai_khach_hang int not null,
ho_ten varchar(45),
ngay_sinh date ,
so_cmtnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (id_loai_khach_hang) references loai_khach_hang(id_loai_khach_hang)
);

create table kieu_thue(
id_kieu_thue int auto_increment primary key,
ten_kieu_thue varchar(45),
gia int
);

create table loai_dich_vu(
id_loai_dich_vu int auto_increment primary key,
ten_loai_dich_vu varchar(45)
);

create table dich_vu(
id_dich_vu int auto_increment primary key,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(45),
chi_phi_thue double,
id_kieu_thue int not null,
id_loai_dich_vu int not null,
trang_thai varchar(45),
foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue),
foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);

create table dich_vu_di_kem(
id_dich_vu_di_kem int auto_increment primary key,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45)
);

create table hop_dong(
id_hop_dong int auto_increment primary key,
id_nhan_vien int not null,
id_khach_hang int not null,
id_dich_vu int not null,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),
foreign key (id_khach_hang) references khach_hang(id_khach_hang),
foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int auto_increment primary key,
id_hop_dong int not null,
id_dich_vu_di_kem int not null,
so_luong int,
foreign key (id_hop_dong) references hop_dong(id_hop_dong),
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);

insert into vi_tri(ten_vi_tri)
values ("le tan"),
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
(1,"Hoang","2000-05-15","563214789","0999999999","hoang@gmail.com","quangngai"),
(4,"Quoc","2000-01-15","563214789","0999999999","quoc@gmail.com","hue"),
(1,"Bach","2000-01-15","563214789","0999999999","bach@gmail.com","vinh"),
(4,"Ly","2000-01-15","563214789","0999999999","ly@gmail.com","vinh"),
(2,"Quy","2000-01-15","563214789","0999999999","quy@gmail.com","hue");

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
(2,3,3,"2019-02-14","2019-06-01",1000),
(3,1,2,"2018-05-14","2018-05-27",1000),
(1,5,2,"2018-05-15","2018-06-01",1000),
(1,2,3,"2019-02-14","2019-03-01",1000),
(2,7,2,"2019-05-14","2019-06-01",1000),
(3,6,1,"2019-11-22","2019-12-05",1000),
(2,1,3,"2019-12-24","2019-12-29",1500);

insert into hop_dong_chi_tiet(id_hop_dong,id_dich_vu_di_kem,so_luong)
values (1,1,5),
(2,2,7),
(1,2,3),
(1,1,7),
(2,3,4),
(4,2,3),
(5,3,3),
(7,1,3)
;