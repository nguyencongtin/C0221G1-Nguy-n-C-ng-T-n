package baiThi.models;

public abstract class QuanLyDanhBa {
    protected String soDienThoai;
    protected String nhom;
    protected String hoTen;
    protected String gioiTinh;
    protected String diaChi;
    public QuanLyDanhBa() {
    }

    public QuanLyDanhBa(String soDienThoai, String nhom, String hoTen, String gioiTinh, String diaChi) {
        this.soDienThoai = soDienThoai;
        this.nhom = nhom;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public abstract void showInfo();

    @Override
    public String toString() {
        return  soDienThoai +
                "," + nhom +
                "," + hoTen +
                "," + gioiTinh +
                "," + diaChi
                ;
    }
}
