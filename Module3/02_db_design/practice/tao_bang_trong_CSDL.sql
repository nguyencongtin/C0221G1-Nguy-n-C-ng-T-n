CREATE DATABASE quan_ly_diem_thi;
use quan_ly_diem_thi;
CREATE TABLE hoc_sinh(
    ma_hs VARCHAR(20) PRIMARY KEY,
    ten_hs VARCHAR(50),
    ngay_sinh DATE,
    lop VARCHAR(20),
    gioi_tinh VARCHAR(20)
);
CREATE TABLE mon_hoc(
    ma_mh VARCHAR(20) PRIMARY KEY,
    ten_mh VARCHAR(50)
);
CREATE TABLE bang_diem(
    ma_hs VARCHAR(20),
    ma_mh VARCHAR(20),
    diem_thi INT,
    ngay_kt DATE,
    PRIMARY KEY (ma_hs, ma_mh),
    FOREIGN KEY (ma_hs) REFERENCES hoc_sinh(ma_hs),
    FOREIGN KEY (ma_mh) REFERENCES mon_hoc(ma_mh)
);
CREATE TABLE giao_vien(
    ma_gv VARCHAR(20) PRIMARY KEY,
    ten_gv VARCHAR(20),
    sdt VARCHAR(10)
);
ALTER TABLE mon_hoc ADD ma_gv VARCHAR(20);
ALTER TABLE mon_hoc ADD CONSTRAINT fk_magv FOREIGN KEY (ma_gv) REFERENCES giao_vien(ma_gv);
SELECT * from hoc_sinh;
INSERT into hoc_sinh
value("MS01","Tín","1997-05-15","C02","Nam");
SELECT * from giao_vien;
INSERT into giao_vien
value("1","Linh","0905123456");
SELECT * from mon_hoc;
INSERT into mon_hoc
value("1","toán","1");
SELECT * from bang_diem;
INSERT into bang_diem
value("MS01","1","8","2021-05-13");