drop database quan_ly_vat_tu;
create database quan_ly_vat_tu;
use quan_ly_vat_tu;

create table phieu_xuat(
ma_phieu_xuat int  primary key,
ngay_xuat date
);
create table vat_tu(
ma_vat_tu int primary key,
ten_vat_tu varchar(45)
);
create table phieu_nhap(
ma_phieu_nhap int primary key,
ngay_nhap date
);
create table phieu_xuat_chi_tiet(
don_gia_xuat int,
so_luong_xuat int,
ma_phieu_xuat int not null,
ma_vat_tu int not null,
primary key (ma_phieu_xuat,ma_vat_tu),
foreign key (ma_phieu_xuat) references phieu_xuat(ma_phieu_xuat),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);


create table phieu_nhap_chi_tiet(
don_gia_nhap int,
so_luong_nhap int,
ma_phieu_nhap int not null,
ma_vat_tu int not null,
foreign key (ma_phieu_nhap) references phieu_nhap(ma_phieu_nhap),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
create table so_dien_thoai(
id_sdt int  auto_increment primary key,
sdt varchar(30)
); 

create table nha_cung_cap(
ma_nha_cung_cap int auto_increment primary key,
ten_nha_cung_cap varchar(45),
dia_chi varchar(45),
sdt int,
foreign key (sdt) references so_dien_thoai(id_sdt)
);

create table don_dat_hang(
ma_don_dat_hang int auto_increment primary key,
ngay_dat_hang date,
ma_nha_cung_cap int not null,
foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);
create table don_dat_hang_chi_tiet(
ma_don_dat_hang int,
ma_vat_tu int,
primary key (ma_don_dat_hang,ma_vat_tu),
foreign key (ma_don_dat_hang) references don_dat_hang(ma_don_dat_hang),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
