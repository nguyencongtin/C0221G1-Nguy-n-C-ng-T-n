package bai7_AbstractClassInterface.bai_tap.TrienKhaiInterfaceColorableChoCacLopHinhHoc;

import bai6_Inheritance.thuc_hanh.Shape;
import bai6_Inheritance.thuc_hanh.Square;

public class MainColorable {
    public static void main(String[] args) {
        Shape square= new Square(1,"white",false);
        square.howToColor();
        System.out.println(square);
    }
}
