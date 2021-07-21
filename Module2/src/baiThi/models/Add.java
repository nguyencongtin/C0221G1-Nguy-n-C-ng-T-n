package baiThi.models;

public class Add extends QuanLyDanhBa {
    private String email;
    private String birthDay;
    public Add() {
    }



    public Add(String email, String birthDay) {
        this.email = email;
        this.birthDay = birthDay;
    }
   public Add(String soDienThoai, String nhom, String hoTen, String gioiTinh, String diaChi, String email, String birthDay) {
        super(soDienThoai, nhom, hoTen, gioiTinh, diaChi);
        this.email = email;
        this.birthDay = birthDay;
    }
    @Override
    public void showInfo() {
    }
}
