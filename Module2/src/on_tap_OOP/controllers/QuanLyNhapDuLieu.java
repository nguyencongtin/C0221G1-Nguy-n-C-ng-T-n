package on_tap_OOP.controllers;


import on_tap_OOP.commons.CanBoException;
import on_tap_OOP.commons.GhiDocFile;
import on_tap_OOP.models.CanBo;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class QuanLyNhapDuLieu {
    static Scanner scanner = new Scanner(System.in);
    //:  id(Tự tăng CB-001)  , Họ tên, năm sinh, giới tính, địa chỉ
    public static String nhapID(){
        String id = null;
        List<CanBo> canBoList = GhiDocFile.docFile("canbo.csv");
        if (canBoList.isEmpty()){
            id = "CB-001";
        }else {
            id = "CB-00"+(canBoList.size()+1);
        }
        return id;
    }
    public static String nhapHoTen(){
        String hoTen = null;
        while (true){
            try{
                System.out.println("nhap ho ten");
                hoTen = scanner.nextLine();
                CanBoException.kiemTraHoTen(hoTen);
                return hoTen;
            }catch (CanBoException e){
                System.err.println(e.getMessage());
            }
        }
    }
    public static String nhapNamSinh(){
        String namSinh = null;
        while (true){
            try{
                System.out.println("nhap nam sinh");
                namSinh = scanner.nextLine();
                CanBoException.kiemTraNamSinh(namSinh);
                return namSinh;
            }catch (CanBoException e){
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
                CanBoException.kiemTraDiaChi(diaChi);
                return diaChi;
            }catch (CanBoException e){
                System.err.println(e.getMessage());
            }
        }
    }

    public static String nhapCapBac(){
        String bac = null;
        while (true){
            try{
                System.out.println("nhap cap bac");
                bac = scanner.nextLine();
                CanBoException.kiemTraCapBac(bac);
                return bac;
            }catch (CanBoException e){
                System.err.println(e.getMessage());
            }
        }
    }
    public static String nhapNganhDaoTao(){
        boolean kiemTra = false;
        String chon  = null;
        String nganh = null;
        while (true){
            List<String> stringList = GhiDocFile.docFileNganhDaoTao("nganhDaoTao.csv");
            for (int i = 0;i <stringList.size();i++){
                System.out.println((i+1)+" : "+stringList.get(i));
            }
            System.out.println("chon theo danh sach");
            chon = scanner.nextLine();
            for (int i =0 ;i < stringList.size();i++){
                if (i ==  Integer.parseInt(chon)-1){
                    nganh = stringList.get(i).split(",")[1];
                    kiemTra= true;
                    break;
                }
            }
            if (kiemTra){
                break;
            }else {
                System.out.println("vui long chon theo danh sach");
            }
        }
        return nganh;
    }
    public static String nhapCongViec(){
        String congViec = null;
        boolean kiemTra = false;
        String chon = null;
        while (true){
            System.out.println("Chon cong viec\n" +
                    "1.PV-Ngoài trời\n" +
                    "2.PV-Trong nhà");
            chon = scanner.nextLine();
            switch (chon){
                case "1":
                    congViec = "PV-Ngoài trời";
                    kiemTra = true;
                    break;
                case "2":
                    congViec = "PV-Trong nhà";
                    kiemTra = true;
                    break;
                default:
                    System.out.println("vui long chon 1 hoac 2");
            }
            if (kiemTra){
                break;
            }
        }
        return congViec;
    }



}