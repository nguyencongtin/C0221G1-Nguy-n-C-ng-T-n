package baiThi.commons;

import baiThi.commons.Exception;

public class Exception extends java.lang.Exception {
    public Exception(String message) {
        super(message);
    }
    public static void kiemTrasoDienThoai(String input) throws Exception {
        String regex = "^[\\(][0-9]{2}[\\)][\\-][\\(][0][0-9]{9}[\\)]$";
        if (input.matches(regex) == false) {
            throw new Exception("nhap sai dinh dang!!!");
        }
    }
    public static void kiemTraNhom(String input) throws Exception {
        String regex = "^[0-9]{1}$";
        if (input.matches(regex) == false) {
            throw new Exception("nhap sai dinh dang!!!");
        }
    }
    public static void kiemTraEmail(String input) throws Exception {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (input.matches(regex) == false) {
            throw new Exception("nhap sai dinh dang!!!");
        }
    }
    public static void kiemTraHoTen(String input) throws Exception {
        String regex = "^([A-Z][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]?)+$";
        if (input.matches(regex)==false){
            throw new Exception("nhap sai dinh dang!!!");
        }
    }
    public static void kiemTraNgaySinh(String input) throws Exception {
        String regex = "^[0-9]{2}/[0-9]{2}/[0-9]{4}";
        if (input.matches(regex)==false){
            throw new Exception("nhap sai dinh dang!!!");
        }
    }
    public static void kiemTraDiaChi(String input) throws Exception {
        String regex = "^([A-Z][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]?)+$";
        if (input.matches(regex)==false){
            throw new Exception("nhap sai dinh dang!!!");
        }
    }
}
