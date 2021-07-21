package baiThi.controllers;

import baiThi.commons.*;
import baiThi.models.*;
import baiThi.controllers.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLyChucNang {
    static Scanner scanner = new Scanner(System.in);

    public static void themThongTinDanhBa() {
        String chon;
        while (true) {
            System.out.println("Danh Muc:\n" +
                    "1 Them Danh Ba \n" +
                    "2 Tro ve Danh Muc \n" +
                    "3 Thoát khỏi chương trình.\n");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    Add();
                    break;
                case "2":
                    return;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("vui long nhap theo danh muc , chon tu 1-6");
            }
        }
    }

    public static void Add() {
        String soDienThoai = QuanLyNhapDuLieu.nhapSoDienThoai();
        String hoTen = QuanLyNhapDuLieu.nhapHoTen();
        String nhom = QuanLyNhapDuLieu.nhapNhom();
        String gioiTinh = QuanLyNhapDuLieu.nhapGioiTinh();
        String diaChi = QuanLyNhapDuLieu.nhapDiaChi();
        String ngaySinh= QuanLyNhapDuLieu.nhapNgaySinh();
        String email= QuanLyNhapDuLieu.nhapEmail();
        List<DanhMuc> danhMucList = new ArrayList<>();

        DanhMuc danhMuc = new DanhMuc(soDienThoai, hoTen, nhom, gioiTinh, diaChi, ngaySinh, email);
        danhMucList.add(danhMuc);
        GhiDocFile.ghiFile("danhmuc.csv", danhMucList, true);
    }

//    public static void xoaTheoDanhSach() {
//        boolean kiemTra = false;
//        String chon = null;
//        List<String> danhMucList = GhiDocFile.docFile("danhmuc.csv");
//        while (true) {
//            for (int i = 0; i < danhMucList.size(); i++) {
//                System.out.println((i + 1) + " : " + danhMucList.get(i));
//            }
//            System.out.println("chon danh ba can xoa");
//            chon = scanner.nextLine();
//            for (int i = 0; i < danhMucList.size(); i++) {
//                if (i == Integer.parseInt(chon) - 1) {
//                    danhMucList.remove(i);
//                    GhiDocFile.ghiFile("danhmuc.csv", danhMucList , false);
//                    kiemTra = true;
//                    break;
//                }
//            }
//            if (kiemTra) {
//                break;
//            } else {
//                System.out.println("vui long chon theo danh sach");
//            }
//
//        }
//    }

    public static void xemDanhSach() {
        String chon;
        while (true) {
            System.out.println("Danh Muc:\n" +
                    "1.Hien thi tat ca\n" +
                    "2. Tro ve Danh Muc \n" +
                    "3. Thoát khỏi chương trình.\n");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    hienThiTatCa();
                    break;
                case "2":
                    return;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui long nhap theo danh muc , chon tu 1-6");
            }
        }
    }

    public static void hienThiTatCa() {
        List<String> danhMucList = GhiDocFile.docFile("danhmuc.csv");
        for (String danhMuc : danhMucList) {
            danhMuc.toString();
        }
    }
}