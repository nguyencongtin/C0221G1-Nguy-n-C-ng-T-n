package baiThi.controllers;

import baiThi.commons.Exception;

import java.util.Scanner;

public class QuanLyNhapDuLieu {
    static Scanner scanner = new Scanner(System.in);
    public static String nhapSoDienThoai(){
        String soDienThoai = null;
        while (true){
            try{
                System.out.println("nhap so dien thoai");
                soDienThoai = scanner.nextLine();
                Exception.kiemTrasoDienThoai(soDienThoai);
                return soDienThoai;
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
    public static String nhapNhom(){
        String nhom = null;
        while (true){
            try{
                System.out.println("nhap nhom");
                nhom = scanner.nextLine();
                Exception.kiemTraNhom(nhom);
                return nhom;
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
    public static String nhapHoTen(){
        String hoTen = null;
        while (true){
            try{
                System.out.println("nhap ho ten");
                hoTen = scanner.nextLine();
                Exception.kiemTraHoTen(hoTen);
                return hoTen;
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
    public static String nhapGioiTinh(){
        boolean kiemTra = false;
        String chon = null;
        String gioiTinh = null;
        while (true){
            System.out.println("Chon gioi tinh\n" +
                    "1.nam\n" +
                    "2.nu");
            chon = scanner.nextLine();
            switch (chon){
                case "1":
                    gioiTinh = "Nam";
                    kiemTra = true;
                    break;
                case "2":
                    gioiTinh = "Nu";
                    kiemTra = true;
                    break;
                default:
                    System.out.println("vui long chon 1 hoac 2");
            }
            if (kiemTra){
                break;
            }
        }
        return gioiTinh;
    }
    public static String nhapDiaChi(){
        String diaChi = null;
        while (true){
            try{
                System.out.println("nhap dia chi");
                diaChi = scanner.nextLine();
                Exception.kiemTraDiaChi(diaChi);
                return diaChi;
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
    public static String nhapEmail(){
        String email = null;
        while (true){
            try{
                System.out.println("nhap email");
                email = scanner.nextLine();
                Exception.kiemTraEmail(email);
                return email;
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
    public static String nhapNgaySinh(){
        String ngaySinh = null;
        while (true){
            try{
                System.out.println("nhap ngay thang nam sinh");
                ngaySinh = scanner.nextLine();
                Exception.kiemTraNgaySinh(ngaySinh);
                return ngaySinh;
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}
