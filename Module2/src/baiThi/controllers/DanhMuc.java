package baiThi.controllers;

import baiThi.controllers.QuanLyChucNang;

import java.util.Scanner;

public class DanhMuc {
    static Scanner scanner = new Scanner(System.in);

    public DanhMuc(String soDienThoai, String hoTen, String nhom, String gioiTinh, String diaChi, String ngaySinh, String email) {
    }

    public static void danhMuc(){
        String chon;
        while (true){
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ:\n" +
                    "Chọn chức năng theo số (để tiếp tục):\n" +
                    "1 Xem danh sách\n" +
                    "2 Thêm mới\n" +
                    "3 Cập nhật\n" +
                    "4 Xóa\n" +
                    "5 Tìm kiếm\n" +
                    "6 Đọc từ file\n" +
                    "7 Ghi vào file\n" +
                    "8 Thoát\n");
            chon = scanner.nextLine();
            switch (chon){
                case "1":
                    QuanLyChucNang.xemDanhSach();
                    break;
                case "2":
                    QuanLyChucNang.themThongTinDanhBa();
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    System.exit(0);
                default:
                    System.out.println("vui long nhap theo danh muc , chon tu 1-8");
            }
        }
    }
    public void showInfo() {
    }
}