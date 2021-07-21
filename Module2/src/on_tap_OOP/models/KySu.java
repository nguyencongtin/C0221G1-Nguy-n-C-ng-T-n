package on_tap_OOP.models;

public class KySu extends CanBo {
    //Các kỹ sư cần quản lý: Ngành đào tạo.(Lưu ý mục 2).
    //    Cho phép người dùng chọn thông tin.
    private String nganhDT;

    public KySu() {
    }

    public KySu(String nganhDT) {
        this.nganhDT = nganhDT;
    }

    public KySu(String id, String hoTen, String namSinh, String gioiTinh, String diaChi, String nganhDT) {
        super(id, hoTen, namSinh, gioiTinh, diaChi);
        this.nganhDT = nganhDT;
    }

    public String getNganhDT() {
        return nganhDT;
    }

    public void setNganhDT(String nganhDT) {
        this.nganhDT = nganhDT;
    }



    @Override
    public void showInfo() {
        System.out.println("KySu{" +
                "nganhDT='" + nganhDT + '\'' +
                ", id='" + id + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}');
    }
    @Override
    public String toString() {
        return super.toString()+","+ nganhDT ;
    }
}