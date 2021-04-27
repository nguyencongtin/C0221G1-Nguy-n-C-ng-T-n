package bai7.bai_tap.TrienKhaiInterfaceColorableChoCacLopHinhHoc;

import bai6.thuc_hanh.Shape;
import bai6.thuc_hanh.Square;

public class MainColorable {
    public static void main(String[] args) {
        Shape square= new Square(1,"white",false);
        square.howToColor();
        System.out.println(square);
    }
}
