package on_tap_OOP.commons;

public class CanBoException extends Exception {
    public CanBoException(String message) {
        super(message);
    }
    //:  id(Tự tăng CB-001)  , Họ tên, năm sinh, giới tính, địa chỉ
    public static void kiemTraHoTen(String input) throws CanBoException {
        String regex = "^([A-Z][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]?)+$";
        if (input.matches(regex)==false){
            throw new CanBoException("nhap sai dinh dang!!!");
        }
    }
    public static void kiemTraNamSinh(String input) throws CanBoException {
        String regex = "^[1|2][0-9]{3}$";
        if (input.matches(regex)==false){
            throw new CanBoException("nhap sai dinh dang!!!");
        }
    }
    public static void kiemTraDiaChi(String input) throws CanBoException {
        String regex = "^([A-Z][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]?)+$";
        if (input.matches(regex)==false){
            throw new CanBoException("nhap sai dinh dang!!!");
        }
    }
    public static void kiemTraCapBac(String input) throws CanBoException {
        String regex = "^[1-7]/7$";
        if (input.matches(regex)==false){
            throw new CanBoException("nhap sai dinh dang!!!");
        }
    }

}